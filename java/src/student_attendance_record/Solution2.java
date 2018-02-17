package student_attendance_record;
public class Solution2 {
    public static void main(String[] args) {
        System.out.println(new Solution2().checkRecord(100));
    }

    public int checkRecord(int n) {
        long A0L2 = 0, A1L2 = 0, A1L1 = 0, A0L1 = 1, A1L0 = 1, A0L0 = 1, M = 1000000007;
        for (int i = 2; i <= n; i++) {
            long nA0L2 = A0L1;
            long nA1L2 = A1L1;
            long nA1L1 = A1L0;
            long nA0L1 = A0L0;
            long nA1L0 = (A0L2 + A1L2 + A1L1 + A0L1 + A1L0 + A0L0) % M;
            long nA0L0 = (A0L2 + A0L1 + A0L0) % M;
            A0L2 = nA0L2; A1L2 = nA1L2; A1L1 = nA1L1; A0L1 = nA0L1; A1L0 = nA1L0; A0L0 = nA0L0;
        }
        return (int) ((A0L2 + A1L2 + A1L1 + A0L1 + A1L0 + A0L0) % M);
    }
}
