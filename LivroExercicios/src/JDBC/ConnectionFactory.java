package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection(){
        try{
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc?user=postgres&password=postgres");
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
