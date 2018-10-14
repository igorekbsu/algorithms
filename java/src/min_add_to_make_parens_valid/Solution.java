package min_add_to_make_parens_valid;
public class Solution {
    public int minAddToMakeValid(String s) {
        int min = 0, bal = 0;
        for (char c : s.toCharArray())
            if (c == '(')
                bal++;
            else if (bal == 0)
                min++;
            else bal--;
        return min + bal;
    }
}
