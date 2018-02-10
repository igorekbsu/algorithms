package remove_comments;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().removeComments(new String[]{"main() {", "/* here is commments", "  // still comments */", "   double s = 33;", "   cout << s;", "}"}));
    }

    public List<String> removeComments(String[] source) {
        List<String> result = new LinkedList<>();
        boolean blockComment = false, lineComment = false;
        StringBuilder newLine = new StringBuilder();
        for (String line : source) {
            for (int i = 0; i < line.length(); i++)
                if (!lineComment) {
                    char a = line.charAt(i);
                    if (i < line.length() - 1) {
                        char b = line.charAt(i + 1);
                        if (blockComment && a == '*' && b == '/') {
                            i++;
                            blockComment = false;
                            continue;
                        }
                        if (!blockComment && a == '/' && b == '*') {
                            blockComment = true;
                            i++;
                            continue;
                        }
                        if (!blockComment && a == '/' && b == '/') {
                            lineComment = true;
                            continue;
                        }
                    }
                    if (!blockComment)
                        newLine.append(a);
                }
            if (!blockComment && newLine.length() > 0) {
                result.add(newLine.toString());
                newLine.setLength(0);
            }
            lineComment = false;
        }
        return result;
    }
}