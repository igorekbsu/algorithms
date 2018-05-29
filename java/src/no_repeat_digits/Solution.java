package no_repeat_digits;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(findAll(1000));
    }

    public static List<Long> findAll(long max) {
        List<Long> r = new LinkedList<>();
        Digit zero = new Digit(null, 0), one = zero.next;
        for (int length = 1; length <= 10; length++)
            if (find(one, zero, length, 0, max, r))
                return r;
        return r;
    }

    static boolean find(Digit start, Digit head, int len, long value, long max, List<Long> r) {
        for (Digit current = start; current != null; current = current.next) {
            long newValue = value + current.value;
            if (len == 1) {
                if (newValue > max) return true;
                r.add(newValue);
            } else {
                current.use();
                Digit newHead = (current == head) ? head.next : head;
                if (find(newHead, newHead, len - 1, newValue * 10, max, r))
                    return true;
                current.yield();
            }
        }
        return false;
    }

    static class Digit {
        final int value;
        Digit previous, next;

        Digit(Digit previous, int value) {
            this.value = value;
            this.previous = previous;
            if (value < 9) next = new Digit(this, value + 1);
        }

        void use() {
            if (previous != null) previous.next = next;
            if (next != null) next.previous = previous;
        }

        void yield() {
            if (previous != null) previous.next = this;
            if (next != null) next.previous = this;
        }
    }
}
