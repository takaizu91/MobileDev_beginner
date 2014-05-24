package org.corruptor;

/******************************************************************************
* Filename    : Reports.java
* Author      : Fazwan (025)
* Date        : 22-05-2014
* Description : Contains the functions required for displaying Reports.
* T/L Notes   : Freshly done src to avoid conflicting code. Some may not work
******************************************************************************/

//some I have commented out to check code functionality
//only un-comment when it can be use
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Date;
//import java.text.SimpleDateFormat;
//import java.text.ParseException;

public class Reports {

	private java.util.Date startDateC;
	private java.util.Date endDateC;
	private long diff;
	private long diffDays;
	private double cRate;
	private double totalPay;
	private String carRate;
	
	public Reports() {
		
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
	
	public void CarReport(Connection con) {
		//Display car detail by status
		Scanner scanner = new Scanner(System.in);
    	System.out.println("\t\tCar Reports");
    	System.out.println("\t\t==================\n");
    	System.out.println("\tPlate No.\tModel Name\tCapacity\tRate\t\tStatus");
    	System.out.println("\t===============\t===============\t===============\t===============\t===============");
    	try {
    		Statement stmt = con.createStatement();
    		ResultSet rs = stmt.executeQuery("select PLATE_NO, CAR_MODEL, CAR_CAPACITY, CAR_RATE, STATUS from cars ORDER BY STATUS");
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
	
	public void CustomerReport(Connection con) {
		//Should display customer details with the number of previous booking
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
	
	public void IncomeReports(Connection con, Scanner scanner) {
		//Should accept car plate number and display car details with the total payment received
		//Scanner scanner = new Scanner(System.in);
		//int bookingId;
		
		
		System.out.println("\t\tIncome Reports");
		System.out.println("\t\t===================\n\n");
		System.out.print("\t\tEnter car plate number : ");
		String plate = scanner.next();
		
		if (!checkDuplicatePlate(plate, con)){
        	System.out.println("\t\tPlate number does not exists..");
                return;
        }else{
        	
        	//System.out.println("\tPlate No.\tModel Name\tCapacity\tRate\t\tStatus");
        	//System.out.println("\t===============\t===============\t===============\t===============\t===============");
        	try {
        		Statement stmt = con.createStatement();
        		ResultSet rs = stmt.executeQuery("select PLATE_NO, CAR_MODEL, CAR_RATE from cars WHERE PLATE_NO = '" +plate+ "'");       		
        		while (rs.next()) {
        			carRate = rs.getString(3);
        			System.out.println("\t\tCar Plate No            : "+rs.getString(1));
                    System.out.println("\t\tCar Model               : "+rs.getString(2));
                    System.out.println("\t\tCar Rate                : "+rs.getString(3));                   
                     }
        		ResultSet rs3 = stmt.executeQuery("select BOOKING_ID from cars WHERE PLATE_NO = '" +plate+ "'");
        		rs3.next();
        		int bookingId = +rs3.getInt(1);
        		
        		System.out.println("\n\t\tBooking ID : " + bookingId);
        		ResultSet rs2 = stmt.executeQuery("select START_DATE, END_DATE from booking WHERE BOOKING_ID = '" +bookingId+ "'");
        		while (rs2.next()) {
        			java.sql.Date startDate = rs2.getDate(1);
            		java.sql.Date endDate = rs2.getDate(2);
        			System.out.println("\t\tStart Date              : "+ startDate);
        			System.out.println("\t\tEnd Date                : "+ endDate);
        			System.out.println("\n");
        			
        			startDateC = new java.util.Date(startDate.getTime());
        			endDateC = new java.util.Date(endDate.getTime());
        			//System.out.println("\t\t" + startDateC);
        			//System.out.println("\t\t" + endDateC);
        		}
        		
        			try {
        		         
                		//HH converts hour in 24 hours format (0-23), day calculation
                		//SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                		
                		Date d1 = startDateC;
                		Date d2 = endDateC;
                		
            			//d1 = format.parse(startDate);
            			//d2 = format.parse(endDate);
             
            			//in milliseconds
                		if (d1 != null)
                		{
            			diff = d2.getTime() - d1.getTime();
                		
             
            			//long diffSeconds = diff / 1000 % 60;
            			//long diffMinutes = diff / (60 * 1000) % 60;
            			//long diffHours = diff / (60 * 60 * 1000) % 24;
            			diffDays = diff / (24 * 60 * 60 * 1000);
             
            			System.out.println("\t\tDays : " + diffDays + " days, ");
            			//System.out.print(diffHours + " hours, ");
            			//System.out.print(diffMinutes + " minutes, ");
            			//System.out.print(diffSeconds + " seconds.");
            			//System.out.println("\n\n");
                		}
             
            		} catch (Exception e) {
            			e.printStackTrace();
            			System.out.println("\t\tSystem cannot get date from booking as it does not exist!");
            		}
        		}
        	 catch (SQLException ex) {
        		ex.printStackTrace();
        	}
        	
        	if (startDateC != null) {
            //converting string to double
            String str1 = carRate;
            cRate = Double.valueOf(str1);
            System.out.println("\t\tCar Rate : " + cRate);           
        	
        	totalPay = diffDays * cRate;
        	
        	System.out.println("\t\tTotal Payment : " + totalPay);
        	System.out.println("\n\n");
        	}
        	                	
        }
		
		//reset income reports once done
		startDateC = null;
		endDateC = null;
    	diff = 0;
    	diffDays = 0;
    	totalPay = 0;
    	cRate = 0;
	}
}

//System.out.println("\n\n");

/******************************************************************************
* End of Reports.java
******************************************************************************/
