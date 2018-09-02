package max_frequency_stack;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        new Solution().doIt();
    }

    void doIt() {
        FreqStack s = new FreqStack();
        s.push(5);
        s.push(7);
        s.push(5);
        s.push(7);
        s.push(4);
        s.push(5);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }

    class FreqStack {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Stack<Integer>> m = new HashMap<>();
        int maxFreq = 0;

        public void push(int x) {
            int newFreq = freq.getOrDefault(x, 0) + 1;
            freq.put(x, newFreq);
            maxFreq = Math.max(maxFreq, newFreq);
            m.putIfAbsent(newFreq, new Stack<>());
            m.get(newFreq).push(x);
        }

        public int pop() {
            int x = m.get(maxFreq).pop();
            freq.put(x, freq.get(x) - 1);
            if (m.get(maxFreq).isEmpty())
                maxFreq--;

            return x;
        }
    }
}
