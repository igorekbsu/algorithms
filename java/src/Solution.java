public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.decompress("a3[b2[c1[d]]]e"));
    }

    public String decompress(String s) {
        int i = s.indexOf("["), j = s.lastIndexOf("]");
        if (i == -1) return s;
        int f = Character.digit(s.charAt(i - 1), 10);
        String part = decompress(s.substring(i + 1, j));
        StringBuilder whole = new StringBuilder();
        for (int k = 0; k < f; k++)
            whole.append(part);
        return s.substring(0, i - 1) + whole + s.substring(j + 1);
    }
}
