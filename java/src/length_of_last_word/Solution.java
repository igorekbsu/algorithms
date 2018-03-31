package length_of_last_word;
public class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0, i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') i--;
        while(i >=0 && s.charAt(i--) != ' '){
            i--;
            len++;
        }
        return len;
    }
}
