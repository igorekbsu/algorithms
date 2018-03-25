package design_log_storage_system;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        LogSystem s = new LogSystem();
        s.put(1,"2017:01:01:23:59:59");
        s.put(2,"2017:01:02:23:59:59");
        System.out.println(s.retrieve("2017:01:01:23:59:59","2017:01:02:23:59:59","Second"));
    }

    static class LogSystem {
        Map<Integer, TreeMap<String, List<Integer>>> storage = new HashMap<>();
        Map<String, int[]> conf = new HashMap<>();

        public LogSystem() {
            conf.put("Year", new int[]{4, 0});
            conf.put("Month", new int[]{7, 1});
            conf.put("Day", new int[]{10, 2});
            conf.put("Hour", new int[]{13, 3});
            conf.put("Minute", new int[]{16, 4});
            conf.put("Second", new int[]{19, 5});
            for (int i = 0; i < conf.size(); i++)
                storage.put(i, new TreeMap<>());
        }

        public void put(int id, String timestamp) {
            int depth = 0;
            int i = timestamp.indexOf(":");
            while (true) {
                Map<String, List<Integer>> m = storage.get(depth++);
                String pre = i != -1 ? timestamp.substring(0, i) : timestamp;
                m.putIfAbsent(pre, new LinkedList<>());
                m.get(pre).add(id);
                if (i == -1) break;
                i = timestamp.indexOf(":", i + 1);
            }
        }

        public List<Integer> retrieve(String s, String e, String gra) {
            int[] item = conf.get(gra);
            s = s.substring(0, item[0]);
            e = e.substring(0, item[0]);
            TreeMap<String, List<Integer>> m = storage.get(item[1]);
            List<Integer> r = new LinkedList<>();
            for (List<Integer> list : m.subMap(s, true, e, true).values())
                r.addAll(list);
            return r;
        }
    }
}