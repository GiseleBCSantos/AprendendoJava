package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection get_connection(){
        try{
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/reservaCRUD?user=postgres&password=postgres");
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
