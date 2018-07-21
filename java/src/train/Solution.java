package train;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        char[] from = {'u', 'r'};
        char[] to = {'r', 'j'};
        double[] rate = {9, 2};
        System.out.println(new Solution().rate('u', 'j', from, to, rate));
    }

    double rate(char from, char to, char[] allFrom, char[] allTo, double[] rate) {
        Map<Character, Map<Character, Double>> m = new HashMap<>();
        for (int i = 0; i < allTo.length; i++) {
            m.putIfAbsent(allFrom[i], new HashMap<>());
            m.get(allFrom[i]).put(allTo[i], rate[i]);
            m.putIfAbsent(allTo[i], new HashMap<>());
            m.get(allTo[i]).put(allFrom[i], 1 / rate[i]);
        }
        return find(from, to, 1, m, new HashSet<>());
    }

    double find(char from, char to, double rate, Map<Character, Map<Character, Double>> m, Set<Character> seen) {
        if (!seen.add(from) || !m.containsKey(from)) return -1;
        if (from == to) return rate;
        Map<Character, Double> next = m.get(from);
        for (Character s : next.keySet()) {
            double r = find(s, to, rate * next.get(s), m, seen);
            if (r != -1)
                return r;
        }
        return -1;
    }
}
