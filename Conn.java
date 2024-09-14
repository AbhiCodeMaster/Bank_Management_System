package bank.management.system;
import java.sql.*;
public class Conn {
    
    Connection c;
    Statement s;
    public Conn(){
        try{           
            // Class.forName(com.mysql.cj.jdbc.Driver);
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root" , "sanjeev@12");// here jdbc:mysql:/// after this you have put database name in sql and bydefault folder name is root and the its password
            s = c.createStatement();
        } catch (Exception e){
        System.out.println(e);
    }
    }
    
}
