package db.factory;

import db.DatabaseConnection;
import db.PostgreSQLConnection;

public class PostgreSqlDatabaseFactory extends DatabaseFactory {
    @Override
    DatabaseConnection createConnection() {
        return new PostgreSQLConnection();
    }
}
