package currency_convert;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        List<String> tickers = Arrays.asList(
            "a:b:1.2",
            "a:c:2",
            "b:c:3"
        );
    }

    public List<Double> rates(String a, String b, List<String> tickers) {
        Map<String, Map<String, Double>> m = new HashMap<>();
        for (String t : tickers) {
            String[] s = t.split(":");
            m.putIfAbsent(s[0], new HashMap<>());
            m.get(s[0]).put(s[1], Double.parseDouble(s[2]));
            m.putIfAbsent(s[1], new HashMap<>());
            m.get(s[1]).put(s[0], 1 / Double.parseDouble(s[2]));
        }
        List<Double> rates = new LinkedList<>();
        dfs(a, b, m, new HashSet<>(), rates);
        return rates;

    }

    void dfs(String a, String b, Map<String, Map<String, Double>> m, HashSet<String> seen, List<Double> r) {
        
    }
}
