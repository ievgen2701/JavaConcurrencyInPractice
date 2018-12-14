package list1_1;


import net.jcip.annotations.NotThreadSafe;

@NotThreadSafe
public final class UnsafeSequence {

    private int value;

    public int getNext() {
        return value++;
    }

    public static void main(String[] args) {
        final UnsafeSequence unsafeSequence = new UnsafeSequence();

        final Thread t1 = new Thread(() -> getNextForever(unsafeSequence, "Thread1 "));
        final Thread t2 = new Thread(() -> getNextForever(unsafeSequence, "Thread2 "));

        t1.start();
        t2.start();
    }

    private static void getNextForever(final UnsafeSequence unsafeSequence, final String threadPrefix) {
        while (true) {
            System.out.println(threadPrefix + unsafeSequence.getNext());
            sleep(1_000);
        }
    }

    private static void sleep(final long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
