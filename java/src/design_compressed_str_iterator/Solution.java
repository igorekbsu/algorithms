package design_compressed_str_iterator;
public class Solution {
    public static void main(String[] args) {
        StringIterator it = new StringIterator("i2");
        while (it.hasNext())
            System.out.println(it.next());
    }

    static class StringIterator {
        final char[] a;
        char c;
        int n, i;

        public StringIterator(String s) {
            this.a = s.toCharArray();
        }

        public char next() {
            if (n > 0) {
                n--;
                return c;
            } else if (i < a.length) {
                c = a[i++];
                while (i < a.length && Character.isDigit(a[i]))
                    n = 10 * n + a[i++] - '0';
                n--;
                return c;
            }
            return ' ';
        }

        public boolean hasNext() {
            return n > 0 || i < a.length;
        }
    }
}
