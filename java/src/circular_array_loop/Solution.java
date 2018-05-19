package circular_array_loop;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().circularArrayLoop(new int[]{-1, -2, -3, -4, -5}));
    }

        public boolean circularArrayLoop(int[] a) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] == 0) continue;
                int slow = i, fast = getIndex(i, a);
                while (a[fast] * a[i] > 0 && a[getIndex(fast, a)] * a[i] > 0) {
                    if (slow == fast) {
                        if (slow == getIndex(slow, a))
                            break;
                        return true;
                    }
                    slow = getIndex(slow, a);
                    fast = getIndex(getIndex(fast, a), a);
                }
                slow = i;
                while (a[slow] * a[i] > 0) {
                    int next = getIndex(slow, a);
                    a[slow] = 0;
                    slow = next;
                }
            }
            return false;
        }

        int getIndex(int i, int[] a) { return i + a[i] >= 0 ? (i + a[i]) % a.length : a.length + ((i + a[i]) % a.length);}
}
