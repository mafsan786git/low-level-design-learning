package db.factory;

import db.DatabaseConnection;
import db.MySQLConnection;

public class MySqlDatabaseFactory extends DatabaseFactory {
    @Override
    DatabaseConnection createConnection() {
        return new MySQLConnection();
    }
}
