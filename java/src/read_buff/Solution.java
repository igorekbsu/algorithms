package read_buff;/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return The number of characters read
     */
    private int p = 0, count = 0;
    private char[] tmp = new char[4];

    public int read(char[] buf, int n) {
        int total = 0;
        while (total < n) {
            if (p == 0)
                count = read4(tmp);
            if (count == 0) break;
            while (total < n && p < count)
                buf[total++] = tmp[p++];
            p = p % count;
        }
        return total;
    }

    int read4(char[] buf) {
        return 0;
    }
}