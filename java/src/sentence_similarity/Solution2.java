package sentence_similarity;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public static void main(String[] args) {
        String[] s1 = {"igor"}, s2 = {"vasil"};
        String[][] pairs = {{"igor", "katie"}, {"katie", "erin"}, {"vasil", "leha"}, {"leha", "erin"}};
        System.out.println(new Solution2().areSentencesSimilarTwo(s1, s2, pairs));
    }

    public boolean areSentencesSimilarTwo(String[] a, String[] b, String[][] pairs) {
        if (a.length != b.length) return false;
        Map<String, String> m = new HashMap<>();
        for (String[] pair : pairs) {
            String p1 = find(m, pair[0]), p2 = find(m, pair[1]);
            if (!p1.equals(p2)) m.put(p1, p2);
        }
        for (int i = 0; i < a.length; i++)
            if (!a[i].equals(b[i]) && !find(m, a[i]).equals(find(m, b[i])))
                return false;
        return true;
    }

    String find(Map<String, String> m, String w) {
        m.putIfAbsent(w, w);
        String p = m.get(w);
        while (!p.equals(m.get(p))) {
            m.put(p, m.get(p));
            p = m.get(p);
        }
        return p;
    }
}
