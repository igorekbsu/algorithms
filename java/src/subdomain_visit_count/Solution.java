package subdomain_visit_count;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
    }

    public List<String> subdomainVisits(String[] domains) {
        Map<String, Integer> counts = new HashMap<>();
        for (String cd : domains) {
            String parts[] = cd.split(" "), domain = parts[1];
            int i = -1, count = Integer.parseInt(parts[0]);
            do {
                String sub = domain.substring(i + 1);
                counts.put(sub, counts.getOrDefault(sub, 0) + count);
            } while ((i = domain.indexOf('.', i + 1)) != -1);
        }
        return counts.keySet().stream().map(k -> counts.get(k) + " " + k).collect(Collectors.toList());
    }
}
