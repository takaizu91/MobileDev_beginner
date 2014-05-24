package org.corruptor;

/******************************************************************************
* Filename    : MyConnection.java
* Author      : Ali
* Date        : 
* Description : Establishes the database connection.
******************************************************************************/


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MyConnection {

    Connection con;
   // private String user="infy";
    //private String pass="infy2014";
    private String user="root";
    private String pass="";

    MyConnection() {
    }

    public Connection getConnection() {

        try {
       
        	
        	
           Class.forName("com.mysql.jdbc.Driver");
          con = DriverManager.getConnection("jdbc:mysql://localhost/carrental?user="+user+"&password="+pass);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return con;
    }

    public void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }
}

/******************************************************************************
* End of MyConnection.java
******************************************************************************/
