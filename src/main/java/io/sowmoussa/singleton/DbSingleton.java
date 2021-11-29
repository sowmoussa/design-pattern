package io.sowmoussa.singleton;

public class DbSingleton {
    // volatile ensure that instance will remain a singleton through any of the changes inside  of the JVM
    private static volatile DbSingleton instance = null;

    private DbSingleton() {
        // ensure that nobody will use Reflection
        if(instance != null) {
            throw new RuntimeException("Use getInstance() method to create");
        }
    }

    public static DbSingleton getInstance() {
        // Lazy Loading will help your app to come up quicker
        if (instance == null) {
            synchronized (DbSingleton.class) {
                if(instance == null) {
                    instance = new DbSingleton();
                }
            }
        }
        return instance;
    }
}
