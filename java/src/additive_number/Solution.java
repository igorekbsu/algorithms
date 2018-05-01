package additive_number;
import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isAdditiveNumber("011235"));
    }

    public boolean isAdditiveNumber(String s) {
        if (s.length() == 0) return false;
        for (int i = 1; i <= s.length() / 2; i++) {
            String s1 = s.substring(0, i);
            if (s1.charAt(0) == '0' && s1.length() > 1) break;
            BigInteger n = new BigInteger(s1);
            for (int j = i + 1; j <= s.length() - 1; j++) {
                String sub = s.substring(i, j);
                if (sub.charAt(0) == '0' && sub.length() > 1) break;
                BigInteger B = new BigInteger(sub), A = n;
                int k = j;
                while (k < s.length()) {
                    BigInteger C = A.add(B);
                    String str = C.toString();
                    int indexOf = s.indexOf(str, k);
                    if (indexOf == -1 || indexOf != k)
                        break;
                    k = indexOf + str.length();
                    A = B;
                    B = C;
                }
                if (k == s.length())
                    return true;
            }
        }
        return false;
    }
}
