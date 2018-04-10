package wildcard_matching;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("igor", "*or"));
    }

    public boolean isMatch(String s, String p) {
        boolean[][] m = new boolean[s.length() + 1][p.length() + 1];
        m[0][0] = true;
        for (int i = 0; i < p.length(); i++)
            if (p.charAt(i) == '*')
                m[0][i + 1] = m[0][i];
        for (int i = 0; i < s.length(); i++)
            for (int j = 0; j < p.length(); j++)
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
                    m[i + 1][j + 1] = m[i][j];
                else if (p.charAt(j) == '*')
                    m[i + 1][j + 1] = m[i + 1][j] || m[i][j + 1];
                else m[i + 1][j + 1] = false;
        return m[s.length()][p.length()];

    }
}
