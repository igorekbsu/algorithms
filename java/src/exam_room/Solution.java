package exam_room;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        ExamRoom r = new ExamRoom(4);
        r.seat();
        r.seat();
        r.seat();
        r.seat();
        r.leave(1);
        r.leave(3);
        System.out.println(r.seat());
    }

    static class ExamRoom {
        final int N;
        final TreeSet<Integer> seats = new TreeSet<>();

        public ExamRoom(int n) { N = n;}

        public int seat() {
            int seat = 0;
            if (!seats.isEmpty()) {
                Integer dist = seats.first(), prev = null;
                for (Integer s : seats) {
                    if (prev != null) {
                        int d = (s - prev) / 2;
                        if (d > dist) {
                            dist = d;
                            seat = prev + d;
                        }
                    }
                    prev = s;
                }
                if (N - 1 - seats.last() > dist)
                    seat = N - 1;
            }
            seats.add(seat);
            return seat;
        }

        public void leave(int p) {
            seats.remove(p);
        }
    }
}
