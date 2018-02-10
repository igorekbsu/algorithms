package number_of_atoms;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().countOfAtoms("K4(ON(SO3)2)2"));
    }

    public String countOfAtoms(String f) {
        Map<String, Long> counts = new TreeMap<>();
        count(f, 0, counts);
        StringBuilder r = new StringBuilder();
        for (Map.Entry<String, Long> entry : counts.entrySet()) {
            if (entry.getValue() == 1)
                r.append(entry.getKey());
            else r.append(entry.getKey()).append(entry.getValue());
        }
        return r.toString();
    }

    int count(String f, int p, Map<String, Long> counts) {
        StringBuilder token = new StringBuilder();
        long count = 0;
        for (int i = p; i < f.length(); i++) {
            char c = f.charAt(i);
            if (c == ')') {
                updateCounts(counts, token.toString(), count);
                i++;
                count = 0;
                while (i < f.length() && Character.isDigit(f.charAt(i)))
                    count = 10 * count + Character.getNumericValue(f.charAt(i++));
                for (String s : counts.keySet())
                    counts.put(s, counts.get(s) * count);
                return i - 1;
            } else if (c == '(') {
                updateCounts(counts, token.toString(), count);
                Map<String, Long> m = new TreeMap<>();
                i = count(f, i + 1, m);
                for (String element : m.keySet())
                    counts.put(element, counts.getOrDefault(element, 0L) + m.get(element));
                token.setLength(0);
                continue;
            }
            if (Character.isUpperCase(c)) {
                if (token.length() > 0)
                    updateCounts(counts, token.toString(), count);
                token.setLength(0);
                count = 0;
                token.append(c);
            } else if (Character.isDigit(c))
                count = 10 * count + Character.getNumericValue(c);
            else token.append(c);
        }
        updateCounts(counts, token.toString(), count);
        return f.length();
    }

    void updateCounts(Map<String, Long> counts, String element, long count) {
        if (element.length() > 0) {
            count = count == 0 ? 1 : count;
            counts.put(element, counts.getOrDefault(element, 0L) + count);
        }
    }
}
