package implement_magic_dict;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    class MagicDictionary {
        Set<String> s = new HashSet<>();

        public void buildDict(String[] dict) {
            Collections.addAll(s, dict);
        }

        public boolean search(String word) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++)
                for (char c = 'a'; c <= 'z'; c++) {
                    if (chars[i] != c) {
                        char old = chars[i];
                        chars[i] = c;
                        if (s.contains(new String(chars)))
                            return true;
                        chars[i] = old;
                    }
                }
            return false;
        }
    }
}
