package ransom_note;
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] f = new int[26];
        for (char c : magazine.toCharArray())
            f[c - 'a']++;
        for (char c : ransomNote.toCharArray())
            if (--f[c - 'a'] < 0)
                return false;
        return true;
    }
}
