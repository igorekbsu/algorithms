package concurrency;

/**
 * @author igor
 */
public class Deadlock {
    static class Player {
        public synchronized void pass(Player player) {
            System.out.format("Passing... to " + player);
            player.passBack(this);
        }

        public synchronized void passBack(Player player) {
            System.out.println("Passing back to " + player);
        }
    }

    public static void main(String[] args) {
        final Player igor = new Player(), vasil = new Player();
        new Thread(new Runnable() {
            @Override
            public void run() {
                igor.pass(vasil);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                vasil.pass(igor);
            }
        }).start();
    }
}
