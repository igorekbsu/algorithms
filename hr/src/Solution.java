public class Solution {
    public static void main(String[] args) {
        int T = 5, start = 4;
        StringBuilder b = new StringBuilder("-1 0 1");
        System.out.println(T);
        for (int t = 0, next = -1; t < T; t++, next *= -1)
            System.out.println((start + t) + " " + (start + t - 1) + "\n" + b.append(" ").append(next));
    }
}
