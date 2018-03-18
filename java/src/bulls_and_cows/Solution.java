package bulls_and_cows;
public class Solution {
    public String getHint(String secret, String guess) {
        int counts[] = new int[10], bulls = 0, cows = 0;
        for (int i = 0; i < secret.length(); i++)
            if (secret.charAt(i) == guess.charAt(i))
                bulls++;
            else {
                int s = secret.charAt(i) - '0', g = guess.charAt(i) - '0';
                if (counts[s] < 0) cows++;
                if (counts[g] > 0) cows++;
                counts[s]++;
                counts[g]--;
            }
        return String.format("%sA%sB", bulls, cows);
    }
}
