package shifting_letters;
public class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        char[] r = new char[s.length()];
        for (int i = r.length - 1, prev = 0; i >= 0; i--) {
            int shift = (shifts[i] + prev) % 26;
            r[i] = (char) (((s.charAt(i) - 'a') + shift) % 26 + 'a');
            prev = shift;
        }
        return new String(r);
    }
}
