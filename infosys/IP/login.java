package org.corruptor;

/******************************************************************************
* Filename    : Login.java
* Author      : Ali
* Date        : 
* Description : Contains the functions to validate the login credentials.
******************************************************************************/

import java.sql.Connection;
//import java.io.Console;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class Login {
	private String login_id;
	private String password;

	public Login() {
		login_id="";
		password="";
	}

	public String getLogin_id() {
		return login_id;
	}

	public String getPassword() {
		return password;
	}

	public void getInput(Scanner scanner){
		String inp;
		System.out.println("\t\t     =============");
		System.out.println("\t\t     |\b WELCOME \b| \t");
		System.out.println("\t\t+=====================+");
		System.out.println("\t\t | CAR RENTAL SYSTEM |");
		System.out.println("\t\t+=====================+\n\n");
				System.out.println("\t\t==============");
                System.out.println("\t\t| Login Page |");
                System.out.println("\t\t==============");
		System.out.print("\t\tLogin id : ");
		inp = scanner.next();
		setLogin_id(inp);
		System.out.print("\t\tPassword : ");
		inp = scanner.next();
		setPassword(inp);
	}

	public boolean checkCredentials(Connection con){
		ResultSet rs;
		try{
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * from LOGIN");
                        //TODO: code tuning here
			while (rs.next()){
				if (rs.getString(1).compareToIgnoreCase(login_id) == 0 && rs.getString(2).compareTo(password) == 0)
					return true;
			}
		}
		catch (SQLException ex){
			//System.out.println("Enable to read Login_table!!");
			ex.printStackTrace();
                       
		}
		return false;
	}

	private void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	private void setPassword(String password) {
		this.password = password;
	}
}


/******************************************************************************
* End of Login.java
******************************************************************************/
