package verify_preorder_serialization_of_a_bt;
public class Solution {
    public boolean isValidSerialization(String s) {
        int count = 1;
        for (String val : s.split(",")) {
            if (--count < 0) return false;
            if (!val.equals("#"))
                count += 2;
        }
        return count == 0;
    }
}
