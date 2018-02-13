package basic_calculator_3;
import java.util.LinkedList;

public class Solution {
    int calc(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        int sign = 1;
        Character currOp = ' ', prevOp = ' ';
        StringBuilder token = new StringBuilder();
        boolean tokenReady = false;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length()) {
                char c = s.charAt(i);
                if (c == '(') {

                }
                if (c == '*' || c == '/') {
                    currOp = c;
                    tokenReady = true;
                } else if (c == '-') {
                    sign = -1;
                    tokenReady = true;
                } else if (c == '+' || c == ' ')
                    tokenReady = true;
                else {
                    token.append(c);
                    tokenReady = i + 1 == s.length();
                }
            }
            if (tokenReady) {
                if (token.length() > 0) {
                    int number = Integer.parseInt(token.toString()) * sign;
                    if (prevOp == '/') {
                        number = stack.pop() / number;
                        prevOp = ' ';
                    } else if (prevOp == '*') {
                        number = stack.pop() * number;
                        prevOp = ' ';
                    }
                    stack.push(number);
                    sign = 1;
                    token.setLength(0);
                }
                if (currOp != ' ') {
                    prevOp = currOp;
                    currOp = ' ';
                }
                tokenReady = false;
            }
        }
        int r = 0;
        while (!stack.isEmpty())
            r += stack.pop();
        return r;
    }
}
