public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.addBinary("1", "11"));
    }

    public String addBinary(String a, String b) {
        StringBuilder sum = new StringBuilder();
        int aEnd = a.length() - 1, bEnd = b.length() - 1, carry = 0;
        while (aEnd >= 0 || bEnd >= 0) {
            int r = carry;
            if (aEnd >= 0) r += a.charAt(aEnd--) - '0';
            if (bEnd >= 0) r += b.charAt(bEnd--) - '0';
            sum.append(r % 2);
            carry = r / 2;
        }
        if (carry != 0) sum.append(carry);
        return sum.reverse().toString();
    }
}
