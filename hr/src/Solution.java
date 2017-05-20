import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        //Scanner in = new Scanner(new FileInputStream("hr/src/in"));
        OrderBook book = new OrderBook();
        int id = 1;
        while (in.hasNext()) {
            String str = in.nextLine();
            String[] s = str.split(" ");
            Order order = new Order(id++, s[0], s[1], Integer.parseInt(s[2]), Double.parseDouble(s[3]));
            book.process(order);
        }
    }

    static class OrderBook {
        final Map<Integer, Order> allOrders = new HashMap<>();
        final Map<Side, SortedSet<Order>> limitOrders = new HashMap<>();
        final SortedSet<Order> stopOrders = new TreeSet<>();

        public OrderBook() {
            limitOrders.put(Side.buy, new TreeSet<>((o1, o2) -> {
                int compare = Double.compare(o2.value2, o1.value2);
                if (compare == 0) compare = o1.compareTo(o2);
                return compare;
            }));
            limitOrders.put(Side.sell, new TreeSet<>((o1, o2) -> {
                int compare = Double.compare(o1.value2, o2.value2);
                if (compare == 0) compare = o1.compareTo(o2);
                return compare;
            }));
        }

        SortedSet<Double> execute(Order order) {
            SortedSet<Order> orders = limitOrders.get(order.side.opposing());
            SortedSet<Double> executionPrices = new TreeSet<>();
            while (!orders.isEmpty()) {
                Order maker = orders.first();
                if (order.type == OrderType.limit && !order.side.canExecute(order.value2, maker.value2)) break;
                int volume = Math.min(order.value1, maker.value1);
                print(order, maker, volume, maker.value2);
                executionPrices.add(maker.value2);
                maker.value1 -= volume;
                if (maker.value1 == 0) {
                    allOrders.remove(maker.id);
                    orders.remove(maker);
                }
                order.value1 -= volume;
                if (order.value1 == 0) break;
            }
            if (order.type == OrderType.limit && order.value1 > 0) {
                limitOrders.get(order.side).add(order);
                allOrders.put(order.id, order);
            }
            return executionPrices;
        }

        void print(Order taker, Order maker, int volume, double price) {
            System.out.println(String.format("match %s %s %s %.2f", taker.id, maker.id, volume, price));
        }

        public void process(Order order) {
            if (order.type == OrderType.cancel) {
                Order existing = allOrders.get(order.value1);
                if (existing != null) {
                    allOrders.remove(existing.id);
                    if (existing.type == OrderType.limit)
                        limitOrders.get(existing.side).remove(existing);
                    else if (existing.type == OrderType.stop)
                        stopOrders.remove(existing);
                }
            } else if (order.type == OrderType.stop) {
                allOrders.put(order.id, order);
                stopOrders.add(order);
            } else {
                SortedSet<Double> executionPrices = execute(order);
                if (order.value1 <= 0) {
                    limitOrders.get(order.side).remove(order);
                    allOrders.remove(order.id);
                }
                if (!executionPrices.isEmpty()) {
                    for (Iterator<Order> it = stopOrders.iterator(); it.hasNext(); ) {
                        Order stopOrder = it.next();
                        if ((stopOrder.side == Side.sell && executionPrices.first() <= stopOrder.value2) || (stopOrder.side == Side.buy && executionPrices.last() >= stopOrder.value2)) {
                            execute(stopOrder);
                            allOrders.remove(stopOrder.id);
                            it.remove();
                        }
                    }
                }
            }
        }
    }

    enum OrderType {limit, stop, cancel, market}

    enum Side {
        buy {
            @Override boolean canExecute(double orderPrice, double price) { return orderPrice >= price; }

            @Override Side opposing() { return sell; }
        },
        sell {
            @Override boolean canExecute(double orderPrice, double price) { return orderPrice <= price; }

            @Override Side opposing() { return buy; }
        };

        static Side of(String s) {
            if (s.equals("buy")) return buy;
            if (s.equals("sell")) return sell;
            return null;
        }

        boolean canExecute(double orderPrice, double price) {return false;}

        Side opposing() {return null;}
    }

    static class Order implements Comparable<Order> {
        final int id;
        final OrderType type;
        final Side side;
        int value1;
        double value2;

        Order(int id, String type, String side, int value1, double value2) {
            this.id = id;
            this.type = OrderType.valueOf(type);
            this.side = Side.of(side);
            this.value1 = value1;
            this.value2 = value2;
        }

        @Override public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("Order");
            sb.append("{id=").append(id);
            sb.append(", type=").append(type);
            sb.append(", side=").append(side);
            sb.append(", value1=").append(value1);
            sb.append(", value2=").append(value2);
            sb.append('}');
            return sb.toString();
        }

        @Override public int compareTo(Order o) { return Integer.compare(id, o.id); }
    }
}
