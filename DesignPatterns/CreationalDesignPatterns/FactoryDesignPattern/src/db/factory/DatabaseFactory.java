package db.factory;

import db.DatabaseConnection;

public abstract class DatabaseFactory {
    abstract DatabaseConnection createConnection();

    public void executeDatabase(String query){
        DatabaseConnection connection = createConnection();
        connection.connect();
        connection.executeQuery(query);
        connection.disconnect();
    }
}
