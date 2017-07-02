package zig_zag_it;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        List<Integer> v1 = Arrays.asList(1, 2);
        List<Integer> v2 = Arrays.asList(3, 4, 5, 6);
        ZigzagIterator z = new ZigzagIterator(v1, v2);
        while (z.hasNext())
            System.out.println(z.next());
    }

    static class ZigzagIterator {
        Queue<Iterator<Integer>> q = new LinkedList<>();

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            if (v1.iterator().hasNext()) q.add(v1.iterator());
            if (v2.iterator().hasNext()) q.add(v2.iterator());
        }

        public int next() {
            Iterator<Integer> it = q.remove();
            Integer next = it.next();
            if (it.hasNext()) q.add(it);
            return next;
        }

        public boolean hasNext() {
            return !q.isEmpty();
        }
    }
}