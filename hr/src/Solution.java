import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        OrderBook book = new OrderBook();
        long id = 1;
        while (in.hasNext()) {
            String str = in.nextLine();
            String[] s = str.split(" ");
            book.process(id++, s[0], s[1], Long.parseLong(s[2]), Double.parseDouble(s[3]));
        }
    }

    static class OrderBook {
        static final Map<String, String> opposingSides = new HashMap<>();
        static final Map<String, ExecutionStrategy> executionStrategies = new HashMap<>();
        static final Map<String, CancelStrategy> cancelStrategies = new HashMap<>();
        static final Map<String, TriggerStrategy> triggers = new HashMap<>();
        final Map<Long, Order> allOrders = new HashMap<>();
        final Map<String, SortedSet<Order>> outstandingOrders = new HashMap<>();
        final List<Order> stopOrders = new ArrayList<>();

        OrderBook() {
            opposingSides.put("buy", "sell");
            opposingSides.put("sell", "buy");
            executionStrategies.put("buy", new Buy());
            executionStrategies.put("sell", new Sell());
            cancelStrategies.put("limit", (order, book) -> book.outstandingOrders.get(order.side).remove(order));
            cancelStrategies.put("stop", (order, book) -> stopOrders.remove(order));
            triggers.put("sell", (order, prices) -> order.price >= prices.first());
            triggers.put("buy", (order, prices) -> order.price <= prices.last());
            outstandingOrders.put("buy", new TreeSet<>());
            outstandingOrders.put("sell", new TreeSet<>());
        }

        SortedSet<Double> execute(Order order) {
            SortedSet<Double> executionPrices = new TreeSet<>();
            SortedSet<Order> opposingOrders = outstandingOrders.get(opposingSides.get(order.side));
            ExecutionStrategy executionStrategy = executionStrategies.get(order.side);
            while (!opposingOrders.isEmpty()) {
                Order maker = executionStrategy.maker(opposingOrders);
                if (!executionStrategy.canExecute(order, maker.price)) break;
                long volume = Math.min(order.size, maker.size);
                print(order, maker, volume, maker.price);
                executionPrices.add(maker.price);
                maker.size -= volume;
                order.size -= volume;
                if (maker.size == 0) {
                    opposingOrders.remove(maker);
                    allOrders.remove(maker.id);
                }
                if (order.size == 0) break;
            }
            return executionPrices;
        }

        void process(long orderId, String type, String side, long v1, double v2) {
            if (type.equals("cancel")) {
                Order order = allOrders.get(v1);
                if (order != null) {
                    CancelStrategy cancelStrategy = cancelStrategies.get(order.type);
                    cancelStrategy.cancel(order, this);
                    allOrders.remove(v1);
                }
            } else if (type.equals("stop")) {
                stopOrders.add(new Order(orderId, type, side, v1, v2));
            } else {
                Order order = new Order(orderId, type, side, v1, v2);
                SortedSet<Double> executionPrices = execute(order);
                if (!executionPrices.isEmpty()) {
                    for (int i = 0; i < stopOrders.size(); i++) {
                        Order stopOrder = stopOrders.get(i);
                        if (triggers.get(stopOrder.side).triggered(stopOrder, executionPrices)) {
                            executionPrices.addAll(execute(stopOrder));
                            allOrders.remove(stopOrder.id);
                            stopOrders.remove(i);
                            i = -1;
                        }
                    }
                }
                if (order.type.equals("limit") && order.size > 0) {//book unfilled limit order for subsequent executions
                    outstandingOrders.get(order.side).add(order);
                    allOrders.put(order.id, order);
                }
            }
        }

        void print(Order taker, Order maker, long volume, double price) {
            System.out.println(String.format("match %s %s %s %.2f", taker.id, maker.id, volume, price));
        }
    }

    static class Order implements Comparable<Order> {
        final long id;
        final String side, type;
        long size;
        double price;

        Order(long id, String type, String side, long size, double price) {
            this.id = id;
            this.type = type;
            this.side = side;
            this.size = size;
            this.price = price;
        }

        @Override public int compareTo(Order o) {
            int compare = Double.compare(price, o.price);
            if (compare == 0) compare = Long.compare(id, o.id);
            return compare;
        }
    }

    interface ExecutionStrategy {
        Order maker(SortedSet<Order> opposingOrders);

        boolean canExecute(Order order, double price);
    }

    @FunctionalInterface interface CancelStrategy {
        void cancel(Order order, OrderBook book);
    }

    @FunctionalInterface interface TriggerStrategy {
        boolean triggered(Order order, SortedSet<Double> prices);
    }

    static class Buy implements ExecutionStrategy {
        @Override public Order maker(SortedSet<Order> opposingOrders) { return opposingOrders.first(); }

        @Override public boolean canExecute(Order order, double price) {
            if (order.type.equals("limit")) return order.price >= price;
            return true;
        }
    }

    static class Sell implements ExecutionStrategy {
        @Override public Order maker(SortedSet<Order> opposingOrders) { return opposingOrders.last(); }

        @Override public boolean canExecute(Order order, double price) {
            if (order.type.equals("limit")) return order.price <= price;
            return true;
        }
    }
}
