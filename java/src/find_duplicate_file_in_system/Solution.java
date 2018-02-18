package find_duplicate_file_in_system;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findDuplicate(new String[]{
            "root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"
        }));
    }

    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] parts = path.split(" ");
            for (int i = 1; i < parts.length; i++) {
                int k = parts[i].indexOf("(");
                String content = parts[i].substring(k, parts[i].length() - 1);
                map.putIfAbsent(content, new LinkedList<>());
                map.get(content).add(parts[0] + "/" + parts[i].substring(0, k));
            }
        }
        List<List<String>> r = new LinkedList<>();
        for (List<String> list : map.values())
            if (list.size() > 1)
                r.add(list);
        return r;
    }
}
