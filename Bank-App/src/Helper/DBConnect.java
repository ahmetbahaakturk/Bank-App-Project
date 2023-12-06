package Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    private Connection connect = null;

    public DBConnect() {
        connectDB();
    }

    public void connectDB() {
        try {
            this.connect = DriverManager.getConnection(Config.DB_URL, Config.DB_NAME, Config.DB_PASSWORD);
            System.out.println("Connection Accomplished!");
        } catch (SQLException e) {
            System.out.println("Connection Failed!");
        }
    }

    public static Connection getInstance() {
        DBConnect db = new DBConnect();
        return db.connect;
    }
}