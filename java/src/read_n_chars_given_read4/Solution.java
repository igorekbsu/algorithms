package read_n_chars_given_read4;
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] tmpBuf = new char[4];
        int i = 0, len;
        while (i < n && (len = read4(tmpBuf)) > 0)
            for (int j = 0; j < len && i < n; i++, j++)
                buf[i] = tmpBuf[j];
        return i;
    }
}
