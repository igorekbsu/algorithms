import java.io.*;
import java.util.concurrent.*;

public class Solution {
    static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);

    public static void main(String[] args) throws FileNotFoundException {
        Thread t = new Thread(() -> {
            getNextTask(queue);
            System.out.println(Thread.currentThread().isInterrupted());
        });
        t.start();
        t.interrupt();
    }

    static Integer getNextTask(BlockingQueue<Integer> queue) {
        boolean interrupted = false;
        try {
            while (!interrupted) {
                try {
                    return queue.take();
                } catch (InterruptedException e) {
                    interrupted = true;
                }
            }
        } finally {
            if (interrupted) {
                System.out.println(Thread.currentThread().isInterrupted());
                Thread.currentThread().interrupt();
                System.out.println(Thread.currentThread().isInterrupted());
            }
        }
        return 0;
    }
}
