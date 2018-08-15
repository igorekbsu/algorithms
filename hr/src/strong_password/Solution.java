package strong_password;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(minimumNumber(3, "Ab1"));
    }

    static int minimumNumber(int n, String pass) {
        int d = 1, a = 1, A = 1, special = 1;
        Set<Character> s = new HashSet<>();
        for (Character c : "!@#$%^&*()-+".toCharArray())
            s.add(c);
        for (char c : pass.toCharArray())
            if (Character.isDigit(c))
                d = 0;
            else if (Character.isLowerCase(c))
                a = 0;
            else if (Character.isUpperCase(c))
                A = 0;
            else if (s.contains(c))
                special = 0;
        return Math.max(d + a + A + special, 6 - pass.length());
    }
}
