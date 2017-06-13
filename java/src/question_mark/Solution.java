package question_mark;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(comb("???"));
    }

    static List<String> comb(String s) {
        LinkedList<String> r = new LinkedList<>();
        r.add(s);
        int i = s.indexOf("?");
        while (i != -1) {
            int size = r.size();
            for (int j = 0; j < size; j++) {
                String e = r.remove();
                r.add(e.substring(0, i) + "1" + e.substring(i + 1));
                r.add(e.substring(0, i) + "0" + e.substring(i + 1));
            }
            i = s.indexOf("?", i + 1);
        }
        return r;
    }
}
