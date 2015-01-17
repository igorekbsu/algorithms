package iterators;

import javax.annotation.Nonnull;
import java.util.Iterator;

/**
 * @author igor
 */
public class PeekingIterator<T> implements Iterator<T> {
    final Iterator<T> iterator;
    boolean peeked = false;
    T item;

    public PeekingIterator(@Nonnull Iterator<T> iterator) {
        this.iterator = iterator;
    }

    public T peek() {
        if (!peeked) {
            item = iterator.next();
            peeked = true;
        }
        return item;
    }

    @Override public boolean hasNext() {
        return peeked || iterator.hasNext();
    }

    @Override public T next() {
        if (peeked) {
            peeked = false;
            return item;
        }
        return iterator.next();
    }

    @Override public void remove() {
        iterator.remove();
    }
}
