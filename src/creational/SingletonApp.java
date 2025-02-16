package creational;

/*
 * Singleton ensures that one ne instance of a class is loaded.
 * Pros:
 * - Keep one instance of shared resources
 * - Memory efficiency
 * - Global access to instances anywhere in the code
 * Cons:
 * - Hard to extend
 * - Hard to test
 *
 */
class EagerSingleton {
    private static EagerSingleton INSTANCE = new EagerSingleton();

    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return INSTANCE;
    }
}


class LazySingleton {
    private static LazySingleton INSTANCE;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (INSTANCE == null)
            INSTANCE = new LazySingleton();

        return INSTANCE;
    }
}


class ThreadSafeSingleton {
    private static ThreadSafeSingleton INSTANCE;

    private ThreadSafeSingleton() {
    }

    public static synchronized ThreadSafeSingleton getInstance() {
        if (INSTANCE == null)
            INSTANCE = new ThreadSafeSingleton();

        return INSTANCE;
    }
}


class DoubleCheckThreadSafeSingleton {
    private static DoubleCheckThreadSafeSingleton INSTANCE;

    private DoubleCheckThreadSafeSingleton() {
    }

    public static DoubleCheckThreadSafeSingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (DoubleCheckThreadSafeSingleton.class) {
                if (INSTANCE == null)
                    INSTANCE = new DoubleCheckThreadSafeSingleton();
            }

        }

        return INSTANCE;
    }
}

class BillPugbSingleton {

    private BillPugbSingleton() {
    }

    private static class SingletonHelper {
        private static final BillPugbSingleton INSTANCE = new BillPugbSingleton();
    }

    public static BillPugbSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

}


/*
 * This is the most simplest and most effective singleton. However, It has two cons:
 * 1. Cannot be extended
 * 2. Cannot extends other classes
 *
 */
enum Singleton {
    INSTANCE;

    public void doSomething() {
        System.out.println("Doing something");
    }
}


public class SingletonApp {
    public static void main(String[] args) {
        BillPugbSingleton s1 = BillPugbSingleton.getInstance();
        BillPugbSingleton s2 = BillPugbSingleton.getInstance();

        System.out.println(s1 == s2);
    }
}

