package listing3_1;

public final class NoVisibility {

    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(final String[] args) {
        new NoVisibility.ReaderThread().start();
        number = 42;
        ready = true;
    }

}
