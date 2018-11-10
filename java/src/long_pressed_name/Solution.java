package long_pressed_name;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isLongPressedName("ee", "e"));
    }

    public boolean isLongPressedName(String nameStr, String typeStr) {
        char[] name = nameStr.toCharArray(), typed = typeStr.toCharArray();
        int n = 0, t = 0;
        while (n < name.length && t < typed.length) {
            int need = 1;
            char c = name[n++];
            while (n < name.length && c == name[n]) {
                n++;
                need++;
            }
            while (t < typed.length && typed[t] == c) {
                need--;
                t++;
            }
            if (need > 0)
                return false;
        }
        return n == name.length && t == typed.length;
    }
}
