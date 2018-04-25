package word_ladder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("cog");
        System.out.println(new Solution().ladderLength("cig", "cog", words));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        words.remove(beginWord);
        int d = 1;
        while (!q.isEmpty()) {
            d++;
            for (int size = q.size(); size > 0; size--) {
                char[] word = q.poll().toCharArray();
                for (int i = 0; i < word.length; i++) {
                    char old = word[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        word[i] = c;
                        String next = new String(word);
                        if (next.equals(endWord)) return d;
                        if (words.remove(next))
                            q.add(next);
                    }
                    word[i] = old;
                }
            }
        }
        return 0;
    }
}
