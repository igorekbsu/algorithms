package goat_latin;
public class Solution {
    public String toGoatLatin(String S) {
        String parts[] = S.split(" "), vowels = "AaEeIiOouU";
        StringBuilder r = new StringBuilder(), A = new StringBuilder();
        for (String w : parts) {
            if (vowels.contains(w.charAt(0) + ""))
                r.append(" ").append(w);
            else r.append(" ").append(w.substring(1)).append(w.charAt(0));
            r.append("ma").append(A.append("a"));
        }
        return r.substring(1);
    }
}
