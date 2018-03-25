package complex_number_multiplication;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().complexNumberMultiply("1+1i", "2+-3i"));
    }

    public String complexNumberMultiply(String a, String b) {
        int[] n1 = parse(a), n2 = parse(b);
        return String.format("%s+%si", n1[0] * n2[0] - n1[1] * n2[1], n1[0] * n2[1] + n1[1] * n2[0]);
    }

    int[] parse(String a) {
        int i = a.indexOf('+');
        return new int[]{Integer.parseInt(a.substring(0, i)), Integer.parseInt(a.substring(i + 1, a.length() - 1))};
    }
}
