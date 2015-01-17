package iterators;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class PeekingIteratorTest {
    List<String> names = Arrays.asList("Igor", "Katie", "Ivan");

    @Test public void testPeek() {
        PeekingIterator<String> iterator = new PeekingIterator<String>(names.iterator());
        assertEquals("Igor", iterator.peek());
        assertEquals("Igor", iterator.peek());
        iterator.next();
        assertEquals("Katie", iterator.peek());
        assertEquals("Katie", iterator.peek());
    }

    @Test public void testBasics() {
        names = Arrays.asList("Igor");
        PeekingIterator<String> iterator = new PeekingIterator<String>(names.iterator());
        assertTrue(iterator.hasNext());
        assertEquals("Igor", iterator.peek());
        assertTrue(iterator.hasNext());
        assertEquals("Igor", iterator.next());
        assertFalse(iterator.hasNext());
        try {
            assertEquals(null, iterator.peek());
            fail();
        } catch (NoSuchElementException e) {}
        assertFalse(null, iterator.hasNext());
    }
}