package org.corruptor;

/******************************************************************************
* Filename    : Customer.java
* Author      : Fazwan (025)
* Date        : 22-05-2014
* Description : Contains the functions required for Customer maintenance.
* T/L Notes   : Source code copy from cars.java and edited to function properly
******************************************************************************/

//some I have commented out to check code functionality
//only uncomment when it can be use

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Customer {

    private String custName;
    private String icNo;
    private String driverLicence;
    private String custAddrs;
    private String poscode;
    private String city;
    private String state;
    private String phoneNo;
    
    public Customer(){
    	//this.capacity = 1;
    	//this.phoneNo = 0;
    }

    public Customer(String custName, String icNo, String driverLicence, String custAddrs, String poscode, String city, String state, String phoneNo){
        this.custName =  custName;
    	this.setIcNo(icNo);
    	this.driverLicence = driverLicence;
        this.custAddrs = custAddrs;
        this.poscode = poscode;
        this.city = city;
        this.state = state;
        this.phoneNo = phoneNo;
    }
    
    public String getIcNo() {
		return icNo;
	}

	public void setIcNo(String icNo) {
		this.icNo = icNo;
	}

    private boolean checkDuplicateIcNo(String icNo, Connection con){
    	try{
    		Statement stmt = con.createStatement();
    		stmt.executeQuery("Select IC_NO from customer");
    		ResultSet rs = stmt.getResultSet();
    		while(rs.next()){
    			if (icNo.compareToIgnoreCase(rs.getString(1)) == 0){
    				return true;
    			}
    		}
    	}
    	catch (SQLException ex){
    		ex.printStackTrace();
    	}
    	return false;
    }
    

   
   
    public void addCustomer(Connection con,Scanner scanner) {
    	boolean flag = true;
        while(flag){
        	System.out.print("\t\tEnter the new Customer name :");
        	custName = scanner.next();
                scanner.nextLine();
                
        	flag = false;
        }
        flag = true;
               
        while(flag){
        	System.out.print("\t\tEnter the Customer IC Number :");
        	setIcNo(scanner.next());

        	if (checkDuplicateIcNo(getIcNo(), con)){
        		System.out.println("\t\tCustomer already exists.. Please Re-enter");
        		continue;
        	}
        	
        	flag = false;
        }
        
        flag = true;
        
        while(flag){
        	System.out.print("\t\tEnter customer's Driver Licence :");
        	driverLicence = scanner.next();
        	//if(rate < 0){
        	//	System.out.println("\t\tDriver licence is invalid.. Please Re-enter");
        	//	continue;
        	//}
        	flag = false;
        }
        
        flag = true;
        
        while(flag){
        	System.out.print("\t\tEnter customer Address (House No, Road and Residential Name) :");
        	custAddrs = scanner.next();
                scanner.nextLine();
        
        	flag = false;
        }
        
        flag = true;
        
        while(flag){
        	System.out.print("\t\tEnter customer's postcode :");
        	poscode = scanner.next();
        	
        	flag = false;
        }
        flag = true;
        
        while(flag){
        	System.out.print("\t\tEnter customer's city :");
        	city = scanner.next();
        	scanner.nextLine();
        	
        	flag = false;
        }
        flag = true;
        
        while(flag){
        	System.out.print("\t\tEnter customer's state :");
        	state = scanner.next();
        	scanner.nextLine();
        	
        	flag = false;
        }
        flag = true;
        
        while(flag){
        	System.out.print("\t\tEnter customer's phone number :");
        	phoneNo = scanner.next();
        	
        	flag = false;
        }
        //flag = true;

        System.out.println("\t\tCustomer name    :"+custName);
        System.out.println("\t\tCustomer IC No   :"+getIcNo());
        System.out.println("\t\tCustomer driver licence no :"+driverLicence);
    	System.out.println("\t\tCustomer address :"+custAddrs);
    	System.out.println("\t\t                  "+poscode);
    	System.out.println("\t\t                  "+city);
    	System.out.println("\t\t                  "+state);
    	System.out.println("\t\tCustomer phone number :"+phoneNo);
        
    	try {
    		PreparedStatement pstmt = con.prepareStatement("INSERT INTO customer VALUES(?,?,?,?,?,?,?,?)");
    			pstmt.setString(1, custName);
    			pstmt.setString(2, getIcNo());
                pstmt.setString(3, driverLicence);
                pstmt.setString(4, custAddrs);
                pstmt.setString(5, poscode);
                pstmt.setString(6, city);
                pstmt.setString(7, state);
                pstmt.setString(8, phoneNo);
    		pstmt.executeUpdate();
    		//con.commit();
    		//pstmt.close();

    	} catch (SQLException ex) {
    		ex.printStackTrace();
    	}
    	System.out.println("\t\tCustomer info added successfully..");
        System.out.println("\tPress ENTER to continue...");
        scanner.nextLine();
    }
    
    public void updateCustomer(Connection con,Scanner scanner) {
    	System.out.println("\t\tUpdate Customer Info");
    	System.out.println("\t\t=================\n");
        System.out.print("\t\tEnter the Customer IC Number :");
        setIcNo(scanner.next());
        if (!checkDuplicateIcNo(getIcNo(), con)){
        	System.out.println("\t\tCustomer does not exists..");
                return;
        }else{
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select CUST_NAME, IC_NO, DRIVER_LICENSE from customer where IC_NO='"+getIcNo()+"'");
            rs.next();
            System.out.println("\t\tCustomer Name           : "+rs.getString(1));
            System.out.println("\t\tCustomer IC No          : "+rs.getString(2));
            System.out.println("\t\tCustomer Driver Licence : "+rs.getString(3));
            System.out.print("\n\t\tEnter new customer name :");
            String newCustName = scanner.next();
            int count = stmt.executeUpdate("Update customer SET CUST_NAME = '"+newCustName+"' where IC_NO = '"+getIcNo()+"'");
        	if (count == 0){
            	System.out.println("Update failed...Try again");
            	return;
            }
        	else{
            	System.out.println("\t\t"+count+" Record updated...");
            }
            //con.commit();
            //stmt.close();
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }
        }
    }

    public void viewCustomer(Connection con) {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("\t\tCustomer Details");
    	System.out.println("\t\t==================\n");
    	System.out.println("\tCustomer Name\tCustomer IC\t\tDriver Licence\tState\t\tPhone No");
    	System.out.println("\t===============\t=====================\t===============\t===============\t===============");
    	try {
    		Statement stmt = con.createStatement();
    		ResultSet rs = stmt.executeQuery("select CUST_NAME, IC_NO, DRIVER_LICENSE, STATE, PHONE_NO from customer");
    		while (rs.next()) {
    			System.out.println("\t"+rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"
                                +rs.getString(3)+"\t"+rs.getString(4)+"\t\t"+rs.getString(5));
    		}
    	} catch (SQLException ex) {
    		ex.printStackTrace();
    	}
    	System.out.println("\tPress ENTER to continue...");
    	scanner.nextLine();
    }

	
    
}

/******************************************************************************
* End of Customer.java
******************************************************************************/
