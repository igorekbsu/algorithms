package license_key_format;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().licenseKeyFormatting("2-4A0r7-4k", 4));
        System.out.println(new Solution().licenseKeyFormatting("2-4A0r7-4k", 3));
        System.out.println(new Solution().licenseKeyFormatting("2-4A0r7-4k", 2));
        System.out.println(new Solution().licenseKeyFormatting("2-4A0r7-4k", 1));
    }

    public String licenseKeyFormatting(String S, int K) {
        StringBuilder b = new StringBuilder();
        char[] a = S.toCharArray();
        for (int i = a.length - 1; i >= 0; i--)
            if (a[i] != '-') {
                char c = a[i];
                if (Character.isLowerCase(c))
                    c = Character.toUpperCase(c);
                if (b.length() % (K + 1) == K)
                    b.append('-');
                b.append(c);
            }
        return b.reverse().toString();
    }
}