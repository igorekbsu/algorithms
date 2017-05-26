public class ShortUrl {
    static final String CHARS = "23456789bcdfghjkmnopqrstvwxyzABCDFGHJKLMNPQSTVWXYZ";
    static final int BASE = CHARS.length();

    public static void main(String[] args) {
        System.out.println(encode(1234345234) + " " + decode("vG"));
    }

    public static String encode(int n) {
        StringBuilder b = new StringBuilder();
        while (n > 0) {
            b.insert(0, CHARS.charAt(n % BASE));
            n /= BASE;
        }
        return b.toString();
    }

    public static int decode(String url) {
        int n = 0;
        for (int i = 0; i < url.length(); i++)
            n = n * BASE + CHARS.indexOf(url.charAt(i));
        return n;
    }
}
