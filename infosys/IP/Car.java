package org.corruptor;

/******************************************************************************
* Filename    : Car.java
* Author      : Ali
* Date        : 
* Description : Contains the functions required for Car maintenance.
******************************************************************************/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Car {

    private String model;
    private float rate;
    private int capacity;
    private String status;
    private String plateNumber;
    
    public Car(){
    	this.capacity = 1;
    	this.status = "available";
    }

    public Car(String plateNumber, String model, int capacity, float rate){
        this.plateNumber =  plateNumber;
    	this.capacity = 1;
    	this.model = model;
        this.rate = rate;
        this.status = "unavailable";
    }

    private boolean validModel(String name){
    	int index = 0;
    	char ch = ' ';
    	int len = name.length();
    	if (len < 3 || len>10){
    		return false;
    	} else {
    		while(index != len){
    			ch = name.charAt(index);
    			if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch == ' ') || (ch == '-') || (ch == '&')){
    				index++;
    			}
    			else
    				return false;
    		}
    	}
    	return true;
    }
    
    private boolean validPlate(String plateNo){
    	int index = 0;
    	char ch = ' ';
    	int len = plateNo.length();

    	if (len < 3 || len>6){
    		return false;
    	}else if((plateNo.charAt(0) < 'A' || plateNo.charAt(0) > 'Z') && (plateNo.charAt(1) < 'A' || plateNo.charAt(1) > 'Z')){
               return false;
        }else {
            index = 2;
    		while(index != len){
    			ch = plateNo.charAt(index);
    			if ((ch >= '0' && ch <= '9')){
    				index++;
    			}
    			else
    				return false;
    		}
    	}
    	return true;
    }
    
    private boolean validStatus(String stat){
    	if ("available".equals(stat) || "unavailable".equals(stat) || "maintenance".equals(stat))
        {
    	  return true;
        }
        return false;
    }

    private boolean checkDuplicatePlate(String plateNo, Connection con){
    	try{
    		Statement stmt = con.createStatement();
    		stmt.executeQuery("Select PLATE_NO from cars");
    		ResultSet rs = stmt.getResultSet();
    		while(rs.next()){
    			if (plateNo.compareToIgnoreCase(rs.getString(1)) == 0){
    				return true;
    			}
    		}
    	}
    	catch (SQLException ex){
    		ex.printStackTrace();
    	}
    	return false;
    }

   
   
    public void addCar(Connection con,Scanner scanner) {
    	boolean flag = true;
        while(flag){
        	System.out.print("\t\tEnter the new Car plate number :");
        	plateNumber = scanner.next();
                scanner.nextLine();
                if (!validPlate(plateNumber)){
        		System.out.println("\t\tCar plate number is invalid.. Please Re-enter");
        		continue;
        	}
        	if (checkDuplicatePlate(plateNumber, con)){
        		System.out.println("\t\tCar plate number already exists.. Please Re-enter");
        		continue;
        	}
                
        	flag = false;
        }
        flag = true;
               
        while(flag){
        	System.out.print("\t\tEnter the Car model name :");
        	model = scanner.next();
                scanner.nextLine();
        	if(!validModel(model)){
        		System.out.println("\t\tCar model name is invalid.. Please Re-enter");
        		continue;
        	}
        	flag = false;
        }
        
        flag = true;
        
        while(flag){
        	System.out.print("\t\tEnter the Car rate :");
        	rate = scanner.nextFloat();
                scanner.nextLine();
        	if(rate < 0){
        		System.out.println("\t\tCar rate is invalid.. Please Re-enter");
        		continue;
        	}
        	flag = false;
        }
        
         flag = true;
        
        while(flag){
        	System.out.print("\t\tEnter the Car capacity :");
        	capacity = scanner.nextInt();
                scanner.nextLine();
        	if(capacity < 0){
        		System.out.println("\t\tCar capacity is invalid.. Please Re-enter");
        		continue;
        	}
        	flag = false;
        }

        System.out.println("\t\tCar plate number :"+plateNumber);
        System.out.println("\t\tCar model name :"+model);
        System.out.println("\t\tCar rate :"+rate);
    	System.out.println("\t\tCar capacity :"+capacity);
        
    	try {
    		PreparedStatement pstmt = con.prepareStatement("INSERT INTO cars (PLATE_NO, CAR_MODEL, CAR_CAPACITY, CAR_RATE, STATUS) VALUES(?,?,?,?,?)");
    		pstmt.setString(1, plateNumber);
    		pstmt.setString(2, model);
                pstmt.setFloat(4, rate);
                pstmt.setInt(3, capacity);
                pstmt.setString(5, status);
    		pstmt.executeUpdate();
    		//con.commit();
    		//pstmt.close();

    	} catch (SQLException ex) {
    		ex.printStackTrace();
    	}
    	System.out.println("\t\tCar added successfully..");
        System.out.println("\tPress ENTER to continue...");
        scanner.nextLine();
    }
    
    public void updateCarRate(Connection con,Scanner scanner) {
    	System.out.println("\t\tUpdate Car Rate");
    	System.out.println("\t\t=================\n");
        System.out.print("\t\tEnter the Car plate number :");
        String plate = scanner.next();
        scanner.nextLine();
        if (!checkDuplicatePlate(plate, con)){
        	System.out.println("\t\tCar plate number entered is not exists..");
                return;
        }else{
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select PLATE_NO, CAR_MODEL, CAR_RATE from cars where PLATE_NO='"+plate+"'");
            rs.next();
            System.out.println("\t\tCar plate no : "+rs.getString(1));
            System.out.println("\t\tCar model : "+rs.getString(2));
            System.out.println("\t\tCar current rate : "+rs.getString(3));
            System.out.print("\t\tEnter new rate :");
            float newrate = scanner.nextFloat();
            int count = stmt.executeUpdate("Update cars set CAR_RATE ="+newrate+" where PLATE_NO = '"+plate+"'");
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
    
    public void updateCarStatus(Connection con,Scanner scanner) {
    	System.out.println("\t\tUpdate Car Rate");
    	System.out.println("\t\t=================\n");
        System.out.print("\t\tEnter the Car plate number :");
        String plate = scanner.next();
        scanner.nextLine();
        if (!checkDuplicatePlate(plate, con)){
        	System.out.println("\t\tCar plate number entered is not exists..");
                return;
        }else{
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select PLATE_NO, CAR_MODEL, STATUS from cars where PLATE_NO='"+plate+"'");
            rs.next();
            System.out.println("\t\tCar plate no : "+rs.getString(1));
            System.out.println("\t\tCar model : "+rs.getString(2));
            System.out.println("\t\tCar current status : "+rs.getString(3));
            
            String newstat = "";
            do{
                System.out.print("\t\tEnter the new status (available, unavailable, maintenance):");
                newstat = scanner.nextLine();               
            }while(!validStatus(newstat));
            
            int count = stmt.executeUpdate("Update cars set STATUS ='"+newstat+"' where PLATE_NO = '"+plate+"'");
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

    public void viewCar(Connection con) {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("\t\tCar Details");
    	System.out.println("\t\t==================\n");
    	System.out.println("\tPlate No.\tModel Name\tCapacity\tRate\t\tStatus");
    	System.out.println("\t===============\t===============\t===============\t===============\t===============");
    	try {
    		Statement stmt = con.createStatement();
    		ResultSet rs = stmt.executeQuery("select PLATE_NO, CAR_MODEL, CAR_CAPACITY, CAR_RATE, STATUS from cars");
    		while (rs.next()) {
    			System.out.println("\t"+rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"
                                +rs.getInt(3)+"\t\t"+rs.getFloat(4)+"\t\t"+rs.getString(5));
    		}
    	} catch (SQLException ex) {
    		ex.printStackTrace();
    	}
    	System.out.println("\tPress ENTER to continue...");
    	scanner.nextLine();
    }
    
}

/******************************************************************************
* End of Car.java
******************************************************************************/
