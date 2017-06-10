package fs_path;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    }

    public int lengthLongestPath(String input) {
        String[] parts = input.split("\n");
        int[] lengths = new int[parts.length + 1];
        int maxLen = 0;
        for (String p : parts) {
            int tabsCount = p.lastIndexOf('\t') + 1;
            int len = lengths[tabsCount] + p.length() - tabsCount + 1;
            lengths[tabsCount + 1] = len;
            if (p.contains("."))
                maxLen = Math.max(maxLen, len - 1);
        }
        return maxLen;
    }
}