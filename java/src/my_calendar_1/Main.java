package my_calendar_1;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyCalendar cal = new MyCalendar();
        System.out.println(cal.book(10, 20)); // returns true
        System.out.println(cal.book(15, 25)); // returns false
        System.out.println(cal.book(20, 30)); // returns true
    }

    static class MyCalendar {
        List<int[]> events = new ArrayList<>();

        public MyCalendar() {}

        public boolean book(int start, int end) {
            for (int[] event : events) {
                if (!(event[0] >= end || event[1] <= start)) {
                    return false;
                }
            }
            events.add(new int[]{start, end});
            return true;
        }
    }
}
