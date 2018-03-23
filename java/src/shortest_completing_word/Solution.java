package shortest_completing_word;
public class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int plate[] = new int[26], count = 0;
        for (char c : licensePlate.toCharArray())
            if (Character.isLetter(c)) {
                count++;
                plate[Character.toLowerCase(c) - 'a']++;
            }
        String shortest = null;
        for (String w : words) {
            int word[] = new int[26], currCount = 0;
            for (char c : w.toCharArray())
                if (word[c - 'a'] < plate[c - 'a']) {
                    word[c - 'a']++;
                    currCount++;
                    if (currCount == count) {
                        if (shortest == null || shortest.length() > w.length())
                            shortest = w;
                        break;
                    }
                }
        }
        return shortest;
    }
}
