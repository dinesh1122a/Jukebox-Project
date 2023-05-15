package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionUtil {
    public  Connection connectToDatabase(){
        Connection connection=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukeboxdb", "root", "Mechanical@10#");
        }catch ( ClassNotFoundException |SQLException e){
            System.out.println(e);
        }
        return connection;

    }



}
