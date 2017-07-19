package read4;
public class Solution {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] tmp = new char[4];
        int i = 0, tmpPos = 0, tmpCount = 0;
        while (i < n) {
            if (tmpPos == 0)
                tmpCount = read4(tmp);
            if (tmpCount == 0) break;
            while (i < n && tmpPos < tmpCount)
                buf[i++] = tmp[tmpPos++];
            if (tmpPos == tmpCount) tmpPos = 0;
        }
        return i;
    }

    int read4(char[] buf) {
        return 0;
    }
}
