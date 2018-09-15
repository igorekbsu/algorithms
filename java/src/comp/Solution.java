package comp;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        StockSpanner s = new StockSpanner();
        System.out.println(s.next(100));
        System.out.println(s.next(80));
        System.out.println(s.next(60));
        System.out.println(s.next(70));
        System.out.println(s.next(60));
        System.out.println(s.next(75));
        System.out.println(s.next(85));

    }

    static
    class RLEIterator {
        int i;
        int[] a;

        public RLEIterator(int[] a) {
            this.a = a;
        }

        public int next(int n) {
            int next = -1;
            while (i < a.length) {
                if (n <= a[i] && a[i] > 0) {
                    a[i] -= n;
                    return a[i + 1];
                } else {
                    n -= a[i];
                    i += 2;
                }
            }
            return next;
        }
    }

    static
    class StockSpanner {
        Stack<Item> s = new Stack<>();

        public int next(int price) {
            int lessOrEqual = 1;
            while (!s.isEmpty() && s.peek().price <= price)
                lessOrEqual += s.pop().lessOrEqual;
            s.push(new Item(lessOrEqual, price));
            return s.peek().lessOrEqual;
        }

        class Item {
            int lessOrEqual, price;

            public Item(int lessCount, int val) {
                this.lessOrEqual = lessCount;
                this.price = val;
            }
        }
    }
}