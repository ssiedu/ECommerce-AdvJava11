package mypkg;

import java.sql.Connection;
import java.sql.DriverManager;

public class Data {
    public static Connection connect() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/ecomdata";
        Connection con=DriverManager.getConnection(url, "root","root");
        return con;
    }
}
