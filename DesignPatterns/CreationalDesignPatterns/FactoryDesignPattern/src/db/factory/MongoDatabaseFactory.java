package db.factory;

import db.DatabaseConnection;
import db.MongoDbConnection;

public class MongoDatabaseFactory extends DatabaseFactory {
    @Override
    DatabaseConnection createConnection() {
        return new MongoDbConnection();
    }
}
