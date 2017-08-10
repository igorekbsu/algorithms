package keyboard_row;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public String[] findWords(String[] words) {
        String[] rows = {"QWERTYUIOPqwertyuiop", "ASDFGHJKLasdfghjkl", "ZXCVBNMzxcvbnm"};
        List<String> res = new ArrayList<>();
        for (String w : words) {
            String row = null;
            boolean valid = true;
            for (String r : rows)
                if (r.contains(w.charAt(0) + ""))
                    row = r;
            for (int i = 1; i < w.length(); i++) {
                if (!row.contains(w.charAt(i) + "")) {
                    valid = false;
                    break;
                }
            }
            if (valid)
                res.add(w);
        }
        String[] a = new String[res.size()];
        for (int i = 0; i < res.size(); i++)
            a[i] = res.get(i);
        return a;
    }
}
                                                                                        