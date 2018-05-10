package jump_game;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().jump(new int[]{2,3,1,1,4}));
    }
    public int jump(int[] A) {
        int stepCount = 0, lastJumpMax = 0, currJumpMax = 0;
        for (int i = 0; i < A.length - 1; i++) {
            currJumpMax = Math.max(currJumpMax, i + A[i]);
            if (i == lastJumpMax) {
                stepCount++;
                lastJumpMax = currJumpMax;
            }
        }
        return stepCount;
    }
}
