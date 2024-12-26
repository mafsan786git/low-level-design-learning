package db;

public class MongoDbConnection implements DatabaseConnection {
    @Override
    public void connect() {
        System.out.println("Connected to Mongo database");
    }

    @Override
    public void disconnect() {
        System.out.println("Disconnected from Mongo database");
    }

    @Override
    public void executeQuery(String query) {
        System.out.println("Executing Mongo query: " + query);
    }
}
