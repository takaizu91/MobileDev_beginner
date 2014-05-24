package org.corruptor;

/******************************************************************************
* Filename    : Booking.java
* Author      : Fazwan (025)
* Date        : 22-05-2014
* Description : Contains the functions required for Customer maintenance.
* T/L Notes   : Freshly done src to avoid conflicting code. Some may not work
******************************************************************************/

//some I have commented out to check code functionality
//only un-comment when it can be use
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.sql.Statement;
import java.util.Scanner;
import java.text.DateFormat;

public class Booking {
	
	//Customer cust = new Customer();
	//Car car = new Car();
	
	private int counter;
	private int bookingId;
	private java.sql.Date startDate;
	private java.sql.Date endDate;
	private int paymentStatus;
	private Scanner sScan;
	private Scanner eScan;
	
	public Booking() {
		//intentionally left blank
		//bookingId = ++counter;
		//counter = 1000;
		bookingId = counter;
		counter++;
		paymentStatus = 0;
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
	
	private boolean checkDuplicateBookId(int bookingId, Connection con){
    	try{
    		Statement stmt = con.createStatement();
    		stmt.executeQuery("Select BOOKING_ID from cars");
    		ResultSet rs = stmt.getResultSet();
    		while(rs.next()){
    			if (bookingId == (rs.getInt(1))){
    				return true;
    			}
    		}
    	}
    	catch (SQLException ex){
    		ex.printStackTrace();
    	}
    	return false;
    }
	
	public void viewBookCar(Connection con) {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("\t\tCar Details");
    	System.out.println("\t\t==================\n");
    	System.out.println("\tPlate No.\tModel Name\tCapacity\tRate");
    	System.out.println("\t===============\t===============\t===============\t===============");
    	try {
    		Statement stmt = con.createStatement();
    		ResultSet rs = stmt.executeQuery("select PLATE_NO, CAR_MODEL, CAR_CAPACITY, CAR_RATE from cars");
    		while (rs.next()) {
    			System.out.println("\t"+rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"
                                +rs.getInt(3)+"\t\t"+rs.getFloat(4));
    		}
    	} catch (SQLException ex) {
    		ex.printStackTrace();
    	}
    	System.out.println("\tPress ENTER to continue...");
    	scanner.nextLine();
    }

	public void addBooking (Connection con,Scanner scanner) throws SQLException {
		//for add new booking
		
		Customer jic = new Customer();
		//Car cars = new Car();
		
		System.out.println("Enter Start Date (MM-DD-YYYY): ");
		sScan = new Scanner(System.in);
		String input = sScan.nextLine();
		DateFormat sDf = new SimpleDateFormat("MM-dd-yyyy");
		//Date startDate;
		//java.sql.Date startDate;
		
		try {
			//input = sScan.next();
			//startDate = (Date) sDf.parse(input);
			Date sDate = sDf.parse(input);
			String newDateString = sDf.format(sDate);
			System.out.println(newDateString);
			
			startDate = new java.sql.Date(sDate.getTime());
			//System.out.println("utilDate:" + sDate);
			//System.out.println("sqlDate:" + startDate);
		}
		
		catch (ParseException e){
			e.printStackTrace();
		}
		//System.out.println("out sqlDate:" + startDate);
		
		System.out.println("Enter End Date (MM-DD-YYYY) : ");
		eScan = new Scanner(System.in);
		String eInput = eScan.nextLine();
		DateFormat eDf = new SimpleDateFormat("MM-dd-yyyy");
		
		
		try {
			Date eDate = eDf.parse(eInput);
			String neweDateString = eDf.format(eDate);
			System.out.println(neweDateString);
			
			endDate = new java.sql.Date(eDate.getTime());
		    //System.out.println("utilDate:" + eDate);
		    //System.out.println("sqlDate:" + endDate);
		}
		
		catch (ParseException e){
			e.printStackTrace();
		}
		//System.out.println("out sqlDate:" + endDate);
		
		//display car
		//to be retune afterwards to follow scheme
		viewBookCar(con);
		
		System.out.print("Enter Plate Number : ");
		String plate = scanner.next();
		scanner.nextLine();
		//cars.setPlateNumber(scanner.next());
		
		//trying to compare input
		//wargh
		if (!checkDuplicatePlate(plate, con)){
        	System.out.println("\t\tCar plate number entered is not exists..");
                return;
        }else{
        	//*******************************************
		
        	System.out.print("Enter IC No : ");
        	jic.setIcNo(scanner.next());
							
        	//trial and error  code for bookingId
        	if (bookingId == counter) {
        		System.out.println("Booking Id duplicate. Please re-check program");
        	}
        	else {
        		System.out.println("Booking Id inserted automatically (auto-incremented)");
        	}
        	//******
		
        	try {
        		PreparedStatement pstmt = con.prepareStatement("INSERT INTO booking VALUES(?,?,?,?,?)");
        		pstmt.setString(1, jic.getIcNo());
        		pstmt.setInt(2, bookingId);
        		pstmt.setDate(3, startDate);
        		pstmt.setDate(4, endDate);
        		pstmt.setInt(5, paymentStatus);
			
        		pstmt.executeUpdate();
			
        		Statement stmt = con.createStatement();
        		ResultSet rs = stmt.executeQuery("Select BOOKING_ID from booking where IC_NO='"+jic.getIcNo()+"'");
        		rs.next();
        		System.out.println("Booking Id in database : "+rs.getInt(1));
            
        		int bId = rs.getInt(1);
        		System.out.println("Value of bId = " + bId);
			
        		PreparedStatement pstmt2 = con.prepareStatement("UPDATE cars SET BOOKING_ID = ? WHERE PLATE_NO = ?");
        		pstmt2.setInt(1, bId);
        		pstmt2.setString(2, plate);
			
        		pstmt2.executeUpdate();
		}
		catch (SQLException ex){
			ex.printStackTrace();
		}
		
		System.out.println("Update Successful");
		System.out.println("\tPress ENTER to continue...");
        scanner.nextLine();
        }
	}
	
	public void updateBookingDate(Connection con,Scanner scanner) {
		//for updating booking date 
		
		System.out.println("\t\tUpdate Booking Date");
    	System.out.println("\t\t=================\n");
        //System.out.print("\t\tEnter the Car plate number :");
    	System.out.print("\t\tEnter Booking ID :");
        bookingId = scanner.nextInt();
        scanner.nextLine();
        if (!checkDuplicateBookId(bookingId, con)){
        	System.out.println("\t\tBooking ID entered is not exists..");
                return;
        }else{
        try {
            Statement stmt = con.createStatement();
            
            System.out.print("\t\tEnter new start date (MM-DD-YYYY):");
            sScan = new Scanner(System.in);
    		String input = sScan.nextLine();
    		DateFormat sDf = new SimpleDateFormat("MM-dd-yyyy");
    		
    		try {
    			Date sDate = sDf.parse(input);
    			String newDateString = sDf.format(sDate);
    			System.out.println(newDateString);
    			
    			startDate = new java.sql.Date(sDate.getTime());
    		}
    		
    		catch (ParseException e){
    			e.printStackTrace();
    		}
    		
    		System.out.print("\t\tEnter new end date (MM-DD-YYYY):");
            eScan = new Scanner(System.in);
    		String eInput = eScan.nextLine();
    		DateFormat eDf = new SimpleDateFormat("MM-dd-yyyy");
    		
    		try {
    			Date eDate = eDf.parse(eInput);
    			String neweDateString = eDf.format(eDate);
    			System.out.println(neweDateString);
    			
    			endDate = new java.sql.Date(eDate.getTime());
    		}
    		
    		catch (ParseException e){
    			e.printStackTrace();
    		}
    		
            int count = stmt.executeUpdate("UPDATE booking SET START_DATE = '"+startDate+"' , END_DATE = '" +endDate+ "' where BOOKING_ID = "+bookingId);
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
	
	public void updateBookingCar(Connection con,Scanner scanner) {
		//for updating booked car
		
		System.out.println("\t\tUpdate Booking Car");
    	System.out.println("\t\t=================\n");
    	System.out.print("\t\tEnter Booking ID :");
        bookingId = scanner.nextInt();
        scanner.nextLine();
        if (!checkDuplicateBookId(bookingId, con)){
        	System.out.println("\t\tBooking ID entered is not exists..");
                return;
        }else{
        try {
            Statement stmt = con.createStatement();
            
            System.out.print("\t\tEnter new plate number :");
            String plate = scanner.next();
            
            int count = stmt.executeUpdate("UPDATE cars SET PLATE_NO = '"+plate+"' where BOOKING_ID = " + bookingId);
        	if (count == 0){
            	System.out.println("Update failed...Try again");
            	return;
            }
        	else{
            	System.out.println("\t\t"+count+" Record updated...");
            	System.out.println("\t\tBooking Successfully updated");
            }
            
            
            }  catch (SQLException ex) {
            ex.printStackTrace();
        }
        }
	}
	
	public void updateBookingPayment(Connection con,Scanner scanner) {
		//for updating booking payment
		
		System.out.println("\t\tUpdate Booking Payment");
    	System.out.println("\t\t=================\n");
    	System.out.print("\t\tEnter Booking ID :");
        bookingId = scanner.nextInt();
        scanner.nextLine();
        if (!checkDuplicateBookId(bookingId, con)){
        	System.out.println("\t\tBooking ID entered is not exists..");
                return;
        }else{
        try {
            Statement stmt = con.createStatement();
            int index = 0;
            
            
            System.out.print("\t\tEnter new payment status (Y/N) :");
            String p = scanner.next();
            char ch = p.charAt(index);
            
            
            if (ch == 'Y' || ch == 'y') {
            	System.out.println("\t\tPayment Status : Yes");
            	int count = stmt.executeUpdate("UPDATE booking SET PAYMENT_STATUS = "+ 1 +" where BOOKING_ID = " + bookingId);
            	if (count == 0){
                	System.out.println("Update failed...Try again");
                	return;
                }
            	else{
                	System.out.println("\t\t"+count+" Record updated...");
                	System.out.println("\t\tBooking Successfully updated\n\n");
                }
            }
            else if (ch == 'N' || ch == 'n'){
            	System.out.println("\t\tPayment Status : No");
            	int count = stmt.executeUpdate("UPDATE booking SET PAYMENT_STATUS = "+ 0 +" where BOOKING_ID = " + bookingId);
            	if (count == 0){
                	System.out.println("Update failed...Try again");
                	return;
            	}
                	
                
            	else{
                	System.out.println("\t\t"+count+" Record updated...");
                	System.out.println("\t\tBooking Successfully updated");
                }
            }
            
            else {
            	System.out.println("\t\tInvalid input. Re-enter input (Y or N)");
            	return;
            }
            
            /*
            int count = stmt.executeUpdate("UPDATE booking SET PAYMENT_STATUS = '"+ch+"' where BOOKING_ID = " + bookingId);
        	if (count == 0){
            	System.out.println("Update failed...Try again");
            	return;
            }
        	else{
            	System.out.println("\t\t"+count+" Record updated...");
            	System.out.println("\t\tBooking Successfully updated");
            }
            */
            
            }  catch (SQLException ex) {
            ex.printStackTrace(); 
        } 
        }
	}

	
}


/******************************************************************************
* End of Booking.java
******************************************************************************/
