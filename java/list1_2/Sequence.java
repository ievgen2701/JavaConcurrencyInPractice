package list1_2;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public final class Sequence {
    
    @GuardedBy("this") private int value;
    
    public synchronized int getNext() {
        return value++;
    }

    public static void main(String[] args) {
        final Sequence sequence = new Sequence();

        final Thread t1 = new Thread(() -> getNextForever(sequence, "Thread1 "));
        final Thread t2 = new Thread(() -> getNextForever(sequence, "Thread2 "));

        t1.start();
        t2.start();
    }

    private static void getNextForever(final Sequence sequence, final String threadPrefix) {
        while (true) {
            System.out.println(threadPrefix + sequence.getNext());
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
