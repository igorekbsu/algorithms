package license_key_format;
public class Solution2 {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder r = new StringBuilder();
        char[] a = S.toCharArray();
        for (int i = a.length - 1; i >= 0; i--)
            if (a[i] != '-') {
                if (r.length() % (K + 1) == K)
                    r.append('-');
                r.append(Character.toUpperCase(a[i]));
            }
        return r.reverse().toString();
    }
}
