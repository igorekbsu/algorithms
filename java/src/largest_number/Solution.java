package largest_number;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] a = {3, 30, 34, 5, 9};
        System.out.println(new Solution().largestNumber(a));
    }

    public String largestNumber(int[] a) {
        String[] str = new String[a.length];
        for (int i = 0; i < a.length; i++)
            str[i] = String.valueOf(a[i]);
        Arrays.sort(str, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        if (str[0].charAt(0) == '0')
            return "0";
        StringBuilder r = new StringBuilder();
        for (String s : str)
            r.append(s);
        return r.toString();
    }
}
