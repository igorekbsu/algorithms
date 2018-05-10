package merge_sorted_iterators;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        List<Iterator<Integer>> its = Arrays.asList(
            Arrays.asList(1, 5, 9).iterator(),
            Arrays.asList(1, 2, 4).iterator(),
            Arrays.asList(3).iterator(),
            Arrays.<Integer>asList().iterator()
        );
        SortedIntIterator it = new SortedIntIterator(its);
        while (it.hasNext())
            System.out.println(it.next());
    }

    static class SortedIntIterator implements Iterator<Integer> {
        final List<Iterator<Integer>> its;
        final PriorityQueue<Item> q = new PriorityQueue<>(Comparator.comparingInt(e -> e.val));

        SortedIntIterator(List<Iterator<Integer>> its) {
            this.its = its;
            its.stream().filter(Iterator::hasNext).forEach(e -> q.offer(new Item(e.next(), e)));
        }

        @Override public boolean hasNext() { return !q.isEmpty();}

        @Override public Integer next() {
            Item item = q.poll();
            if (item.it.hasNext())
                q.offer(new Item(item.it.next(), item.it));
            return item.val;
        }

        static class Item {
            final Integer val;
            final Iterator<Integer> it;

            Item(Integer val, Iterator<Integer> it) { this.val = val; this.it = it;}
        }
    }
}
