import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class connect {
    private static final SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy' 'HH:mm:ss.SSS");
    protected static Connection connectToDatabase() throws SQLException, ClassNotFoundException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(sdf2.format(timestamp) + " " + " " + "Connecting to database");
        //Verbindung herstellen

/*
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql.//localhost/geheimeszeug", "root", "");
        System.out.println("Xampp connnected");
*/
        String dbDriver = "com.mysql.cj.jdbc.Driver";
        String dbURL = "jdbc:mysql://10.4.69.152:443/";
        // Database name to access
        String dbName = "geheim";
        String dbUsername = "root";
        String dbPassword = "5m&s&@FyA3";

        Class.forName(dbDriver);
        Connection con = DriverManager.getConnection(dbURL + dbName,
                dbUsername,
                dbPassword);



        return con;
    }
}
