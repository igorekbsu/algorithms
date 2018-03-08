package account_merge;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        List<List<String>> acts = new ArrayList<>();
        acts.add(Arrays.asList("J", "1", "2", "3"));
        acts.add(Arrays.asList("J", "3", "4"));
        acts.add(Arrays.asList("J", "7"));
        acts.add(Arrays.asList("J", "7", "1"));
        System.out.println(new Solution().accountsMerge(acts));
    }

    public List<List<String>> accountsMerge(List<List<String>> acts) {
        Map<String, String> owner = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        Map<String, TreeSet<String>> unions = new HashMap<>();
        for (List<String> a : acts)
            for (int i = 1; i < a.size(); i++) {
                parents.put(a.get(i), a.get(i));
                owner.put(a.get(i), a.get(0));
            }
        for (List<String> a : acts) {
            String p = find(a.get(1), parents);
            for (int i = 2; i < a.size(); i++)
                parents.put(find(a.get(i), parents), p);
        }
        for (List<String> a : acts) {
            String p = find(a.get(1), parents);
            if (!unions.containsKey(p))
                unions.put(p, new TreeSet<>());
            TreeSet<String> set = unions.get(p);
            for (int i = 1; i < a.size(); i++)
                set.add(a.get(i));
        }
        List<List<String>> res = new LinkedList<>();
        for (String p : unions.keySet()) {
            TreeSet<String> set = unions.get(p);
            List<String> emails = new ArrayList<>(set.size() + 1);
            emails.add(owner.get(p));
            emails.addAll(set);
            res.add(emails);
        }
        return res;
    }

    String find(String p, Map<String, String> parents) {
        while (!p.equals(parents.get(p))) {
            parents.put(p, parents.get(parents.get(p)));
            p = parents.get(p);
        }
        return p;
    }
}
