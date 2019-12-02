package jumble;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
        Set<String> dict = new HashSet<>(Files.readAllLines(Paths.get("/usr/share/dict/american-english")));
        Set<String> words = solve("trufho");
        for (String w : words)
            if (dict.contains(w))
                System.out.println(w);
    }

    static Set<String> solve(String s) {
        Set<String> r = new HashSet<>();
        solve("", s, r);
        return r;
    }

    static void solve(String pre, String s, Set<String> words) {
        if (s.isEmpty())
            words.add(pre);
        for (int i = 0; i < s.length(); i++)
            solve(pre + s.charAt(i), s.substring(0, i) + s.substring(i + 1), words);
    }
}
