package reorder_log_files;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> lex = new LinkedList<>(), digits = new LinkedList<>();
        for (String log : logs) {
            String[] parts = log.split(" ", 2);
            if (Character.isDigit(parts[1].charAt(0)))
                digits.add(log);
            else lex.add(parts[1] + " " + parts[0]);
        }
        Collections.sort(lex);
        String[] r = new String[logs.length];
        int i = 0;
        for (String s : lex) {
            int idx = s.lastIndexOf(" ");
            r[i++] = s.substring(idx + 1) + " " + s.substring(0, idx);
        }
        for(String s: digits)
            r[i++] = s;
        return r;
    }
}
