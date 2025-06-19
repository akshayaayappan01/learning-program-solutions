public class Singleton {
    // Private static final instance
    private static final Singleton INSTANCE = new Singleton();

    // Private constructor to block direct instantiation
    private Singleton() {
        System.out.println("Singleton initialized");
    }

    // Static factory method (not named getInstance)
    public static Singleton globalAccess() {
        return INSTANCE;
    }

    public void doWork() {
        System.out.println("Doing singleton work");
    }

    // Main demo
    public static void main(String[] args) {
        Singleton obj1 = Singleton.globalAccess();
        Singleton obj2 = Singleton.globalAccess();

        obj1.doWork();
        System.out.println("Same instance? " + (obj1 == obj2));
    }
}