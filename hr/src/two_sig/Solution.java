package two_sig;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Solution {
    /**
     * Iterate through all students in the class and do BFS on each one of them. If such student is not in any circles yet, increment
     * circle count before doing BFS for this student.
     */
    static int friendCircles(String[] friends) {
        int circlesCount = 0;
        //true if i student is in any circle; be default, no one belongs to any circles (all false)
        boolean[] inCircle = new boolean[friends.length];
        for (int i = 0; i < friends.length; i++)
            if (!inCircle[i]) {
                circlesCount++;
                Queue<Integer> q = new ArrayDeque<>();
                q.add(i);
                inCircle[i] = true;
                while (!q.isEmpty()) {
                    Integer student = q.remove();
                    for (int j = 0; j < friends.length; j++) {
                        if (friends[student].charAt(j) == 'Y' && !inCircle[j]) {
                            inCircle[j] = true;
                            q.add(j);
                        }
                    }
                }
            }
        return circlesCount;
    }

    static int longestChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));//sort words by length, shortest first
        Map<String, Integer> chains = new HashMap<>();//save previously calculated max chains for each word (dynamic programming)
        int minLen = words[0].length();//min length word is the first one (array is sorted)
        for (String word : words) {
            if (!chains.containsKey(word)) {//don't calculate max chain if it is already calculated (in case we have duplicate words)
                if (word.length() == minLen)
                    chains.put(word, 1);//max chain for min length words is 1 by definition
                else {
                    //remove each character from the word at position i, forming shorter word, word_i.
                    //maxChain(word)=max(1 + maxChain(word_i)), for i=0..word.length-1 if word_i is in the dictionary
                    int maxChain = 0;
                    for (int i = 0; i < word.length(); i++) {
                        String s = new StringBuilder(word).deleteCharAt(i).toString();
                        Integer prevChain = chains.get(s);
                        if (prevChain != null)//prev chain is null when word_i is not in a dictionary
                            maxChain = Math.max(1 + prevChain, maxChain);

                    }
                    chains.put(word, maxChain);
                }
            }
        }
        return chains.values().stream().max(Comparator.naturalOrder()).get();
    }
}
