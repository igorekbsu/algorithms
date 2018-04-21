package valid_number;
public class Solution {
    public static void main(String[] args) {
        System.out.println(2e+2);
    }
    public boolean isNumber(String s) {
        char[] a = s.trim().toCharArray();
        boolean pointSeen = false, eSeen = false, numberSeen = false;
        for (int i = 0; i < a.length; i++) {
            if (Character.isDigit(a[i]))
                numberSeen = true;
            else if (a[i] == '.') {
                if (eSeen || pointSeen)
                    return false;
                pointSeen = true;
            } else if (a[i] == 'e') {
                if (eSeen || !numberSeen)
                    return false;
                numberSeen = false;
                eSeen = true;
            } else if (a[i] == '-' || a[i] == '+') {
                if (i != 0 && a[i - 1] != 'e')
                    return false;
            } else return false;
        }
        return numberSeen;
    }
}
