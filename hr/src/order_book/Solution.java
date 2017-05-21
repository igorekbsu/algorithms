package order_book;
import java.util.*;

/**
 * Notes:
 * - Code is formatted with 200 right margin, better viewed on the wider screen
 * - Stop orders execution could probably be done more efficiently at the cost of simplicity. Since all test cases are passing pretty quickly,
 * and with no additional requirements, simplicity is chosen over more complex but perhaps more efficient approach
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        OrderBook book = new OrderBook();
        long id = 1;
        while (in.hasNext()) {
            String[] s = in.nextLine().split(" ");
            book.process(id++, s[0], s[1], Long.parseLong(s[2]), Double.parseDouble(s[3]));
        }
        in.close();
    }

    static class OrderBook {
        static final Map<String, String> opposingSides = newHashMap("buy", "sell", "sell", "buy");
        static final Map<String, MatchingStrategy> matchingStrategies = newHashMap(
                "buy", (buyOrder, sellOrder) -> {
                    if (buyOrder.isLimit() && buyOrder.price < sellOrder.price) return false;
                    return true;
                },
                "sell", (sellOrder, buyOrder) -> {
                    if (sellOrder.isLimit() && buyOrder.price < sellOrder.price) return false;
                    return true;
                });
        /**Since limit and stop orders are kept separately, they are cancelled differently. Market orders are not stored (they executed immediately)*/
        static final Map<String, CancelStrategy> cancelStrategies = newHashMap(
                "limit", (order, book) -> book.limitOrders.get(order.side).remove(order),
                "stop", (order, book) -> book.stopOrders.remove(order));
        static final Map<String, TriggerStrategy> triggers = newHashMap(
                "buy", (threshold, prices) -> prices.last() >= threshold,//a buy-side stop order triggers if the largest price is at or above the threshold
                "sell", (threshold, prices) -> prices.first() <= threshold);//a sell-side stop order triggers if the smallest price is at or below the threshold
        final Map<Long, Order> allOrders = new HashMap<>();
        /**Keep 'buy' and 'sell' limit orders separately sorted by price (highest first for buy, lowest first for sell), and then id (oldest first)*/
        final Map<String, SortedSet<Order>> limitOrders = newHashMap(
                "buy", new TreeSet<>((Comparator<Order>) (o1, o2) -> {
                    int compare = Double.compare(o2.price, o1.price);
                    if (compare == 0) compare = Long.compare(o1.id, o2.id);
                    return compare;
                }),
                "sell", new TreeSet<>((Comparator<Order>) (o1, o2) -> {
                    int compare = Double.compare(o1.price, o2.price);
                    if (compare == 0) compare = Long.compare(o1.id, o2.id);
                    return compare;
                }));
        /**Stop orders need to be removed quickly and iterated in order of insertion, hence linked hash set is used*/
        final LinkedHashSet<Order> stopOrders = new LinkedHashSet<>();

        /**If execution happens, the prices are recorded and returned. Prices are sorted (lowest first). Empty set is returned if there was no execution*/
        SortedSet<Double> execute(Order order) {
            SortedSet<Double> executionPrices = new TreeSet<>();
            SortedSet<Order> opposingOrders = limitOrders.get(opposingSides.get(order.side));
            MatchingStrategy matchingStrategy = matchingStrategies.get(order.side);
            while (!opposingOrders.isEmpty()) {
                Order maker = opposingOrders.first();//best match for either buy or sell
                if (!matchingStrategy.matches(order, maker)) break;//if order can not be matched with the best opposing order, no need to check others
                long volume = Math.min(order.size, maker.size);
                print(order, maker, volume, maker.price);
                executionPrices.add(maker.price);
                maker.size -= volume;
                order.size -= volume;
                if (maker.size == 0) {//remove maker if it was filled entirely
                    opposingOrders.remove(maker);
                    allOrders.remove(maker.id);
                }
                if (order.size == 0) break;//order is filled entirely, quit
            }
            return executionPrices;
        }

        void process(long orderId, String type, String side, long v1, double v2) {
            if (type.equals("cancel")) {
                long cancelOrderId = v1;
                Order order = allOrders.get(cancelOrderId);
                if (order != null) {
                    CancelStrategy cancelStrategy = cancelStrategies.get(order.type);
                    cancelStrategy.cancel(order, this);
                    allOrders.remove(cancelOrderId);
                }
            } else if (type.equals("stop")) {
                stopOrders.add(new Order(orderId, type, side, v1, v2));
            } else {//'market' or 'limit'
                Order order = new Order(orderId, type, side, v1, v2);
                SortedSet<Double> executionPrices = execute(order);
                if (!executionPrices.isEmpty()) {//if execution happens, check stop orders in order
                    Iterator<Order> it = stopOrders.iterator();
                    while (it.hasNext()) {
                        Order stopOrder = it.next();
                        if (triggers.get(stopOrder.side).triggered(stopOrder.price, executionPrices)) {
                            executionPrices.addAll(execute(stopOrder));//make sure to update execution prices because execution of stop order may trigger other stop orders
                            allOrders.remove(stopOrder.id);
                            it.remove();//stop order is executed as market order, so it is simply removed once executed even if it was not entirely filled
                            it = stopOrders.iterator();//reset stop orders iteration, so older stop orders are executed first
                        }
                    }
                }
                if (order.isLimit() && order.size > 0) {//book unfilled limit order for subsequent executions
                    limitOrders.get(order.side).add(order);
                    allOrders.put(order.id, order);
                }
            }
        }

        void print(Order taker, Order maker, long volume, double price) {
            System.out.println(String.format("match %s %s %s %.2f", taker.id, maker.id, volume, price));
        }

        static <V> Map<String, V> newHashMap(String k1, V v1, String k2, V v2) {
            Map<String, V> map = new HashMap<>(2);
            map.put(k1, v1);
            map.put(k2, v2);
            return map;
        }
    }

    static class Order {
        final long id;
        final String side, type;
        final double price;
        long size;//size can change after successful execution(s)

        Order(long id, String type, String side, long size, double price) {
            this.id = id;
            this.type = type;
            this.side = side;
            this.size = size;
            this.price = price;
        }

        boolean isLimit() { return this.type.equals("limit"); }
    }

    @FunctionalInterface interface MatchingStrategy {
        /**Returns false if orders can not be match (e.g. limit price is not satisfied for limit orders)*/
        boolean matches(Order order, Order opposingOrder);
    }

    @FunctionalInterface interface CancelStrategy {
        void cancel(Order order, OrderBook book);
    }

    @FunctionalInterface interface TriggerStrategy {
        boolean triggered(double threshold, SortedSet<Double> prices);
    }
}