package rm_dup_letters;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(new Solution1().removeDuplicateLetters("cbacdcbc"));
    }

    public String removeDuplicateLetters(String s) {
        E[] e = new E[26];
        for (int i = 0; i < e.length; i++)
            e[i] = new E();
        for (int i = 0; i < s.length(); i++)
            e[s.charAt(i) - 'a'].index.add(i);
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (!e[i].index.isEmpty()) {
                boolean valid = true;
                for (int j = 0; j < 26; j++)
                    if (j != i && !e[j].index.isEmpty() && e[i].index.first() > e[j].index.last()) {
                        valid = false;
                        break;
                    }
                if (valid) {
                    r.append((char) (i + 'a'));
                    int remove = e[i].index.first();
                    for (int k = 0; k < 26; k++)
                        if (!e[k].index.isEmpty()) {
                            e[k].index = e[k].index.subSet(remove, e[k].index.last() + 1);
                        }
                    e[i].index.clear();
                    i = -1;
                }
            }
        }
        return r.toString();
    }

    class E {
        SortedSet<Integer> index = new TreeSet<>();

        @Override public String toString() {
            return index.toString();
        }
    }
}
