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
        Set<String> wordsSet = new HashSet<>(wordList);
        if (!wordsSet.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int d = 2;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int t = 0; t < size; t++) {
                String word = q.poll();
                char[] chars = word.toCharArray();
                for (int i = 0; i < word.length(); i++) {
                    char old = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String nextWord = String.valueOf(chars);
                        if (nextWord.equals(endWord)) return d;
                        else if (wordsSet.contains(nextWord)) {
                            wordsSet.remove(nextWord);
                            q.add(nextWord);
                        }
                    }
                    chars[i] = old;
                }
            }
            d++;
        }
        return 0;
    }
}
