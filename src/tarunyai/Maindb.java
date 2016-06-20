package tarunyai;

import java.sql.Connection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dhairya
 */
public class Maindb  {
    
       public void connection (DBConnection conn)
               
       {
           System.out.println("it is coming here");
               DatabaseConnectivity dbconnectivity = new DatabaseConnectivity();
               dbconnectivity.setConnectionName(conn.getConnectionName().toString());
               System.out.println(dbconnectivity.getConnectionName());
                //Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
		String dbURL2 = "jdbc:derby://localhost:1527/sample;";
                String user = "root";
                String password = dbconnectivity.getConnectionName();
                System.out.println(password);
                Connection conn2 = null;
                
}
}