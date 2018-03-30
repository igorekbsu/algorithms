package flatten_2d_vector;
import java.util.Iterator;
import java.util.List;

public class Solution {
    public class Vector2D implements Iterator<Integer> {
        final Iterator<List<Integer>> it;
        Iterator<Integer> cursor;

        public Vector2D(List<List<Integer>> vec2d) {
            it = vec2d.iterator();
        }

        @Override public Integer next() {
            hasNext();
            return cursor.next();
        }

        @Override public boolean hasNext() {
            if (cursor == null || !cursor.hasNext())
                while (it.hasNext()) {
                    cursor = it.next().iterator();
                    if (cursor.hasNext()) return true;
                }
            return cursor != null && cursor.hasNext();
        }
    }
}
