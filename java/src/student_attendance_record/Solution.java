package student_attendance_record;
public class Solution {
    public boolean checkRecord(String s) {
        for (int i = 0, aCount = 0, lCount = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                aCount++;
                lCount = 0;
            } else if (s.charAt(i) == 'L')
                lCount++;
            else lCount = 0;
            if (aCount > 1 || lCount > 2)
                return false;
        }
        return true;
    }
}
