package peeking_iterator;
import java.util.Iterator;

public class Solution {
    class PeekingIterator implements Iterator<Integer> {
        final Iterator<Integer> it;
        Integer next;

        public PeekingIterator(Iterator<Integer> iterator) {
            this.it = iterator;
            if (it.hasNext())
                next = it.next();
        }

        public Integer peek() {
            return next;
        }

        @Override public Integer next() {
            Integer r = next;
            next = it.hasNext() ? it.next() : null;
            return r;
        }

        @Override public boolean hasNext() {
            return next != null;
        }
    }
}
