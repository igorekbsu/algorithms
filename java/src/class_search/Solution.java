package class_search;
import java.util.LinkedList;
import java.util.List;
import static java.lang.Character.isUpperCase;

public class Solution {

    static List<String> find(String input, String[] names) {
        List<String> r = new LinkedList<>();
        char[] in = input.toCharArray();
        if (input.isEmpty() || !isUpperCase(in[0])) return r;
        for (String s : names) {
            boolean match = true;
            char[] name = s.toCharArray();
            for (int i = 0, j = 0; i < in.length && j < name.length; i++, j++) {
                if (!isUpperCase(name[j]) && isUpperCase(in[i]))
                    while (j < name.length && !isUpperCase(name[j]))
                        j++;
                if (j == name.length || name[j] != in[i]) {
                    match = false;
                    break;
                }
            }
            if (match)
                r.add(s);
        }
        return r;
    }
}