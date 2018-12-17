package listing3_2;

import net.jcip.annotations.NotThreadSafe;

@NotThreadSafe
public final class MutableInteger {

    private int value;

    public int get() {
        return this.value;
    }

    public void set(final int value) {
        this.value = value;
    }

    public static void main(final String[] args) {
        final MutableInteger mutableInteger = new MutableInteger();
        new Thread(() -> {
            while (mutableInteger.get() != 5) {
                int get = mutableInteger.get();
                System.out.println("thread1 -> " + get);
                mutableInteger.set(++get);
            }
        }).start();
        new Thread(() -> {
            while (mutableInteger.get() != 10) {
                int get = mutableInteger.get();
                System.out.println("thread2 -> " + get);
                mutableInteger.set(++get);
            }
        }).start();
    }

}
