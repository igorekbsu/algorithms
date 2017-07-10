package excel_column_title;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().convertToTitle(1336));
    }

    public String convertToTitle(int n) {
        StringBuilder title = new StringBuilder();
        while (n > 0) {
            title.append((char) ((n - 1) % 26 + 'A'));
            n = (n - 1) / 26;
        }
        return title.reverse().toString();
    }
}
