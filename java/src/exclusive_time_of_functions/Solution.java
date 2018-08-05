package exclusive_time_of_functions;
import read_n_chars_given_read4.Reader4;

public class Solution extends Reader4 {
    char[] tmpBuf = new char[4];
    int len, i;

    public int read(char[] buf, int n) {
        int j = 0;
        while (j < n) {
            if (i == 0)
                len = read4(tmpBuf);
            if (len == 0) break;
            for (; i < len && j < n; i++, j++)
                buf[j] = tmpBuf[i];
            i = i == len ? 0 : i;
        }
        return j;
    }
}