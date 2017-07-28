package flatten_2d_vector;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<List<Integer>> v2d = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3), Arrays.asList(4, 5, 6));
        Vector2D it = new Vector2D(v2d);
        while (it.hasNext())
            System.out.print(it.next() + " ");
    }

    public static class Vector2D implements Iterator<Integer> {
        final Iterator<List<Integer>> it;
        Iterator<Integer> cursor;

        public Vector2D(List<List<Integer>> vec2d) {
            it = vec2d.iterator();
            setCursor();
        }

        void setCursor() {
            if (cursor == null || !cursor.hasNext()) {
                while (it.hasNext()) {
                    cursor = it.next().iterator();
                    if (cursor.hasNext())
                        break;
                }
            }
        }

        @Override
        public Integer next() {
            Integer next = cursor.next();
            setCursor();
            return next;
        }

        @Override
        public boolean hasNext() {
            return cursor != null && cursor.hasNext();
        }
    }
}
