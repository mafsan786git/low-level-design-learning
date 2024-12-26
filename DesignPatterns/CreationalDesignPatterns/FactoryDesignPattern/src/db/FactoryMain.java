package db;

import db.factory.DatabaseFactory;
import db.factory.MySqlDatabaseFactory;
import db.factory.PostgreSqlDatabaseFactory;

public class FactoryMain {
    public static void main(String[] args) {
        DatabaseFactory mySqlDatabaseFactory = new MySqlDatabaseFactory();
        DatabaseFactory postgreSqlDatabaseFactory = new PostgreSqlDatabaseFactory();
        // Use the connection...

        mySqlDatabaseFactory.executeDatabase("SELECT * FROM information_schema");
        postgreSqlDatabaseFactory.executeDatabase("SELECT * FROM customers");
    }
}
