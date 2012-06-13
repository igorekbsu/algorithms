package concurrency;

import java.nio.file.Watchable;
import java.util.concurrent.CountDownLatch;

/**
 * @author igor
 */
public class LatchExample {
    public static void main(String[] args) throws InterruptedException {
        int N = 10;
        final CountDownLatch startGate = new CountDownLatch(1), endGate = new CountDownLatch(N);
        for (int i = 0; i < N; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        startGate.await();
                        //do something
                        endGate.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        startGate.countDown();
        endGate.await();

    }
}
