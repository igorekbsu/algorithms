package jcp;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Interrupted {
    static class Producer extends Thread {
        final BlockingQueue<Integer> q;

        Producer(BlockingQueue<Integer> q) {this.q = q;}

        void cancel() {interrupt();}

        @Override public void run() {
            int i = 0;
            try {
                while (!Thread.currentThread().isInterrupted())
                    q.put(i++);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
                Thread.interrupted();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> q = new ArrayBlockingQueue<>(3);
        Producer producer = new Producer(q);
        producer.start();
        System.out.println(q.take());
        System.out.println(q.take());
        System.out.println(q.take());
        producer.cancel();
        System.out.println(Thread.currentThread().isInterrupted());
        System.out.println(q);
        System.out.println(producer.isInterrupted());
    }
}
