package db;

public interface DatabaseConnection {
    void connect();
    void disconnect();
    void executeQuery(String query);
}
