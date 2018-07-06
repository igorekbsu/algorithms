package crack_safe;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().crackSafe(3, 3));
    }

    public String crackSafe(int n, int k) {
        Set<String> visited = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; i++)
            sb.append('0');
        int total = (int) Math.pow(k, n);
        for (int i = 0; i < total; i++) {
            String prev = n > 1 ? sb.substring(sb.length() - n + 1, sb.length()) : "";
            for (int j = k - 1; j >= 0; j--) {
                String cur = prev + j;
                if (visited.add(cur)) {
                    sb.append(j);
                    break;
                }
            }
        }
        return sb.toString();
    }
}
