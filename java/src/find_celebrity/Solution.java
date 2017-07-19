package find_celebrity;
public class Solution {
    public int findCelebrity(int n) {
        int celebrity = 0;
        for (int i = 1; i < n; i++)
            if (!knows(i, celebrity))
                celebrity = i;
        for (int i = 0; i < n; i++)
            if (i != celebrity && (!knows(i, celebrity) || knows(celebrity, i)))
                return -1;
        return celebrity;
    }

    boolean knows(int a, int b) {
        return true;
    }
}
