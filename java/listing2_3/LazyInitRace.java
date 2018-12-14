package listing2_3;

import net.jcip.annotations.NotThreadSafe;

@NotThreadSafe
public final class LazyInitRace {

    private LazyInitRace.ExpensiveObject instance;

    public LazyInitRace.ExpensiveObject getInstance() {
        if (this.instance == null) {
            this.instance = new LazyInitRace.ExpensiveObject();
        }
        return this.instance;
    }

    private static final class ExpensiveObject {}
}
