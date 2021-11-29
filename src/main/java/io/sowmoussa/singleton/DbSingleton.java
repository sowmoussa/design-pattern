package io.sowmoussa.singleton;

public class DbSingleton {
    private static DbSingleton instance = null;

    private DbSingleton() {}

    public static DbSingleton getInstance() {
        // Lazy Loading will help your app to come up quicker
        if (instance == null) {
            instance = new DbSingleton();
        }
        return instance;
    }
}
