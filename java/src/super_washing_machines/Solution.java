package super_washing_machines;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findMinMoves(new int[]{9, 1, 8, 8, 9}));
    }
    public int findMinMoves(int[] machines) {
        int total = 0;
        for (int i : machines)
            total += i;
        if (total % machines.length != 0)
            return -1;
        int avr = total / machines.length, count = 0, max = 0;
        for (int load : machines) {
            count += load - avr;
            max = Math.max(Math.max(max, Math.abs(count)), load - avr);
        }
        return max;
    }
}
