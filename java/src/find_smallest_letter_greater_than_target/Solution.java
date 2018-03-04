package find_smallest_letter_greater_than_target;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().nextGreatestLetter(new char[]{'c', 'f'}, 'c'));
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int lo = 0, hi = letters.length - 1;
        if (target < letters[lo] || target >= letters[hi])
            return letters[lo];
        target++;
        while (lo < hi) {
            int mid = (hi + lo) / 2;
            if (letters[mid] == target) return letters[mid];
            if (letters[mid] < target)
                lo = mid + 1;
            else hi = mid;
        }
        return letters[hi];
    }
}
