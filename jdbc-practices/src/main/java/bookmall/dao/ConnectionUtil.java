package bookmall.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    private static Connection connection;

    private ConnectionUtil() {}

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                String url = "jdbc:mariadb://192.168.0.178:3307/bookmall?charset=utf8";
                connection = DriverManager.getConnection(url, "bookmall", "bookmall");
            } catch (ClassNotFoundException e) {
                System.out.println("드라이버 로딩 실패:" + e);
            }
        }
        return connection;
    }
}