package design_circular_deque;
public class Solution {
    public static void main(String[] args) {
        MyCircularDeque d = new MyCircularDeque(2);
        d.insertFront(7);
        d.deleteLast();
        System.out.println(d.getFront());
        d.insertLast(5);
        d.insertFront(0);
        System.out.println(d.getFront());
        System.out.println(d.getRear());

    }

    static class MyCircularDeque {
        int len = 0, front, rear;
        final int[] a;

        public MyCircularDeque(int k) {
            a = new int[k];
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if (!isFull()) {
                if (!isEmpty())
                    front = (front + 1) % a.length;
                a[front] = value;
                len++;
                return true;
            } else return false;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if (!isFull()) {
                if (!isEmpty())
                    rear = rear == 0 ? a.length - 1 : rear - 1;
                a[rear] = value;
                len++;
                return true;
            } else return false;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if (!isEmpty()) {
                front = front == 0 ? a.length - 1 : front - 1;
                len--;
                if (len == 0) {
                    front = 0; rear = 0;
                }
                return true;
            } return false;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if (!isEmpty()) {
                rear = (rear + 1) % a.length;
                len--;
                if (len == 0) {
                    front = 0; rear = 0;
                }
                return true;
            } else return false;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            return isEmpty() ? -1 : a[front];
        }

        /** Get the last item from the deque. */
        public int getRear() {
            return isEmpty() ? -1 : a[rear];
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return len == 0;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return len == a.length;
        }
    }
}
