package tag_validator;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("</DI"));
    }

    public boolean isValid(String code) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < code.length(); ) {
            if (i > 0 && stack.isEmpty())
                return false;
            if (code.startsWith("<![CDATA[", i)) {
                i = code.indexOf("]]>", i + 9);
                if (i < 0)
                    return false;
                i += 3;
            } else if (code.startsWith("</", i)) {
                int j = i + 2;
                i = code.indexOf('>', j);
                String s = code.substring(j, i++);
                if (stack.isEmpty() || !stack.pop().equals(s))
                    return false;
            } else if (code.startsWith("<", i)) {
                int j = i + 1;
                i = code.indexOf('>', j);
                if (i < 0 || i == j || i - j > 9)
                    return false;
                for (int k = j; k < i; k++)
                    if (!Character.isUpperCase(code.charAt(k)))
                        return false;
                stack.push(code.substring(j, i++));
            } else i++;
        }
        return stack.isEmpty();
    }
}
