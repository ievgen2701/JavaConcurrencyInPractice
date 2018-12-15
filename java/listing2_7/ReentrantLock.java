package listing2_7;

public final class ReentrantLock {

    public static void main(final String[] args) {

    }

    private class Widget {

        public synchronized void doSmth() {
        }

    }

    private class LoggingWidget extends ReentrantLock.Widget {

        @Override
        public synchronized void doSmth() {
            System.out.println("LoggingWidget.doSmth");
            super.doSmth(); // deadlock !!!
        }

    }
}
