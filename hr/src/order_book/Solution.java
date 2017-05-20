package order_book;
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(new FileInputStream("hr/src/in"));
        OrderBook book = new OrderBook();
        long id = 1;
        while (in.hasNext()) {
            String str = in.nextLine();
            String[] s = str.split(" ");
            Order order = new Order(id++, s[0], s[1], Long.parseLong(s[2]), Double.parseDouble(s[3]));
            book.process(order);
        }
    }

    static class OrderBook {
        final Map<Long, Order> allOrders = new HashMap<>();
        final Map<Side, SortedSet<Order>> orders = new HashMap<>();
        final List<Order> stopOrders = new ArrayList<>();

        public OrderBook() {
            orders.put(Side.buy, new TreeSet<>((o1, o2) -> {
                int compare = Double.compare(o2.value2, o1.value2);
                if (compare == 0) compare = Double.compare(o1.id, o2.id);
                return compare;
            }));
            orders.put(Side.sell, new TreeSet<>((o1, o2) -> {
                int compare = Double.compare(o1.value2, o2.value2);
                if (compare == 0) compare = Double.compare(o1.id, o2.id);
                return compare;
            }));
        }

        SortedSet<Double> execute(Order order) {
            SortedSet<Double> executionPrices = new TreeSet<>();
            SortedSet<Order> opposingOrders = this.orders.get(order.side.opposing());
            while (!opposingOrders.isEmpty()) {
                Order maker = opposingOrders.first();
                if (order.type == OrderType.limit && !order.side.canExecute(order.value2, maker.value2)) break;
                long volume = Math.min(order.value1, maker.value1);
                print(order, maker, volume, maker.value2);
                executionPrices.add(maker.value2);
                maker.value1 -= volume;
                if (maker.value1 == 0) {
                    allOrders.remove(maker.id);
                    opposingOrders.remove(maker);
                }
                order.value1 -= volume;
                if (order.value1 == 0) break;
            }
            if (order.type == OrderType.limit && order.value1 > 0) {
                this.orders.get(order.side).add(order);
                allOrders.put(order.id, order);
            }
            return executionPrices;
        }

        void print(Order taker, Order maker, long volume, double price) {
            System.out.println(String.format("match %s %s %s %.2f", taker.id, maker.id, volume, price));
        }

        public void process(Order order) {
            if (order.type == OrderType.cancel) {
                Order existing = allOrders.get(order.value1);
                if (existing != null) {
                    allOrders.remove(existing.id);
                    if (existing.type == OrderType.limit)
                        orders.get(existing.side).remove(existing);
                    else if (existing.type == OrderType.stop)
                        stopOrders.remove(existing);
                }
            } else if (order.type == OrderType.stop) {
                allOrders.put(order.id, order);
                stopOrders.add(order);
            } else {
                SortedSet<Double> executionPrices = execute(order);
                if (order.value1 == 0) {
                    orders.get(order.side).remove(order);
                    allOrders.remove(order.id);
                }
                if (!executionPrices.isEmpty()) {
                    for (int i = 0; i < stopOrders.size(); i++) {
                        Order stopOrder = stopOrders.get(i);
                        if ((stopOrder.side == Side.sell && executionPrices.first() <= stopOrder.value2) || (stopOrder.side == Side.buy && executionPrices.last() >= stopOrder.value2)) {
                            executionPrices.addAll(execute(stopOrder));
                            allOrders.remove(stopOrder.id);
                            stopOrders.remove(i);
                            i = 0;
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
        },
        na;

        boolean canExecute(double orderPrice, double price) {return false;}

        Side opposing() {return null;}
    }

    static class Order implements Comparable<Order> {
        final long id;
        final OrderType type;
        final Side side;
        long value1;
        double value2;

        Order(long id, String type, String side, long value1, double value2) {
            this.id = id;
            this.type = OrderType.valueOf(type);
            this.side = Side.valueOf(side);
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

        @Override public int compareTo(Order o) { return Long.compare(id, o.id); }
    }
}
