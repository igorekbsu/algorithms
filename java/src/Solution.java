public class Solution {
    public static void main(String[] args) {
        StringIterator it = new StringIterator("L1e2t1C1o1d1e1");
        while (it.hasNext())
            System.out.print(it.next());
        System.out.println(it.hasNext() + " " + it.next());
    }

    static class StringIterator {
        final String s;
        char c;
        int n, i;

        public StringIterator(String compressedString) {
            s = compressedString;
        }

        public char next() {
            if (n > 0) {
                n--;
                return c;
            }
            if (i < s.length()) {
                c = s.charAt(i++);
                while (i < s.length() && Character.isDigit(s.charAt(i)))
                    n = 10 * n + s.charAt(i++) - '0';
                n--;
                return c;
            }
            return ' ';
        }

        public boolean hasNext() {
            return i < s.length();
        }
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */