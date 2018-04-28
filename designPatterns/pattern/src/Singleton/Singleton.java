package Singleton;

/**
 * @author jamie
 * @date 18-4-24
 */
public class Singleton {
    private static Singleton mInstance = null;

    private Singleton() {}

    public static Singleton getInstance() {
        if (mInstance == null) {
            mInstance = new Singleton();
        }
        return mInstance;
    }
}
