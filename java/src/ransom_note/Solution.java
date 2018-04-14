package ransom_note;
public class Solution {
    public boolean canConstruct(String note, String magazine) {
        if (note.length() == 0) return true;
        int f[] = new int[26], count = 0;
        for (char c : note.toCharArray())
            if (++f[c - 'a'] == 1)
                count++;
        for (int i = 0; i < magazine.length(); i++)
            if (--f[magazine.charAt(i) - 'a'] == 0) {
                count--;
                if (count == 0)
                    return true;
            }
        return false;
    }
}
