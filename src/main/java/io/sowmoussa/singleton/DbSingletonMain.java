package io.sowmoussa.singleton;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DbSingletonMain {
    public static void main(String[] args) {
        DbSingleton instance = DbSingleton.getInstance();
        long beforeCreated = 0;
        long afterCreated = 0;
        System.out.println(instance);

        beforeCreated = System.currentTimeMillis();
        Connection conn = instance.getConnection();
        afterCreated = System.currentTimeMillis();
        System.out.println(afterCreated - beforeCreated);

        Statement statement;
        try {
            statement = conn.createStatement();
            int count = statement.executeUpdate("CREATE TABLE Address (ID INT, STreetName VARCHAR(20), City VARCHAR (20))");
            System.out.println("Table Address created");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        beforeCreated = System.currentTimeMillis();
        conn = instance.getConnection();
        afterCreated = System.currentTimeMillis();
        System.out.println(afterCreated - beforeCreated);
    }
}
