package concurrency;

/**
 * @author igor
 */
public class Practise {
    public static void main(String[] args) {
        System.out.println("hello");
    }

    private static class Person {
        private volatile String name;

        public String getName() {
            String name = this.name;
            if (name == null) {
                synchronized (this) {
                    name = this.name;
                    if (name == null) {
                        name = "Igor";
                    }
                }
            }
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
