package org.corruptor;

/*********************************************************************
* Filename: MyMain.java
* Description: Main function to create objects, calls each module
*			   and closes the database connection.
* Author:   Fazwan (025)
* Date:     21/5/14
*********************************************************************/

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;


public class MyMain {

    static Connection con;
    static Scanner scanner;
    static int currCarCode;
    static int currEmpId;

    public static void main(String args[]) throws SQLException {
    // Class.forName("com.mysql.jdbc.Driver").newInstance();
        
        
        MyConnection myConObj = new MyConnection();
        
        
        con = myConObj.getConnection();
        MyScanner myScanObj = new MyScanner();
        scanner = myScanObj.getScanner();
        Login myLogin = new Login();
        Car car = new Car();
        Customer cust = new Customer();
        Booking book = new Booking();
        Reports report = new Reports();
        int iChoice, iCarChoice, iCustChoice, iBookingChoice, iReportChoice;
        int iTries = 0;

        while (iTries!=3){
	        myLogin.getInput(scanner);
	        if (!myLogin.checkCredentials(con)){
	        	System.out.println("Invalid User");
	        	iTries++;
	        } else
	        	break;
        }
        if (iTries==3){
        	System.out.println("No of tries exhuasted");
        	System.out.println("Press any key to quit");
        	scanner.next();
        	System.exit(0);
        }

        /*
         * Code for Displaying Menu Goes Here
         */
        while(true){
        	/*
        	 * Display Main Menu
        	 */
        	iChoice = Menu.fnMainMenu();
        	/*
        	 * Based on the users choice display the Sub Menu
        	 */
        	switch (iChoice){
        	case 1:
        		/*
        		 * Call Car Info Menu
        		 */
        		iCarChoice = 0;
        		while (5 != iCarChoice){
        			iCarChoice = Menu.fnCarMaintMenu();
        			switch (iCarChoice){
        			case 1:
        				/*
        				 * Call Add Car Module
        				 */
        		      
        				car.addCar(con, scanner);
        				break;
                                        

        			case 2:
        				/*
        				 * Call Update Car Rate Module
        				 * */
        				car.updateCarRate(con, scanner);
        				break;
                                        
                                case 3:
        				/*
        				 * Call Update Car Status Module
        				 * */
        				car.updateCarStatus(con, scanner);
        				break;
                                    
        			case 4:
        				/*
        				 * Call List All Car Module
        				 * */
        				car.viewCar(con);
        				break;
                                        

        			case 5:
        				break;

        			default :
        				System.out.println("\t\t\tInvalid Choice.. Please Reenter");
        			}
        		}
        		break;

        	case 2:
        		/*
        		 * Call Customer Info Menu
        		 */
        		iCustChoice = 0;
        		while (4 != iCustChoice){
        			iCustChoice = Menu.fnCustMaintMenu();
        			switch (iCustChoice){
        			case 1:
        				/*
        				 * Call Add Customer Module
        				*/
                                    
        				cust.addCustomer(con, scanner);
        				break;
        			case 2:
        				/*
        				 * Call Update Customer Module
        				 */
        			
        				cust.updateCustomer(con, scanner);
        				break;

        			case 3:
        				/*
        				 * Call List All Customer Module
        				 * */
        			
        				cust.viewCustomer(con);
        				break;

        			case 4:
        				break;

        			default :
        				System.out.println("\t\t\tInvalid Choice.. Please Reenter");
        			}
        		}
        		break;

        	case 3:
        		/*
        		 * Call Booking Info Menu
        		 */
        		iBookingChoice = 0;
        		while (5 != iBookingChoice){
        			iBookingChoice = Menu.fnBookingMaintMenu();
        			switch (iBookingChoice){
        			case 1:
        				/*
        				 * Call Add Booking Module
        				 */
                                    //your code here
        				book.addBooking(con, scanner);        				
        				break;

        			case 2:
                                        /*
        				 * Call Update Booking Date Module
        				 */
                                    //your code here
        				book.updateBookingDate(con, scanner);
        				break;
                                
                                case 3:
        				/*
        				 * Call Update Booking Car Module
        				 */
                                    //your code here
                                	book.updateBookingCar(con, scanner);
        				break;
                                case 4:
        				/*
        				 * Call Update Booking Payment Module
        				 */
                                    //your code here
                                	book.updateBookingPayment(con, scanner);
        				break;
                                case 5:
        				break;


        			default :
        				System.out.println("\t\t\tInvalid Choice.. Please Reenter");
        			}
        		}
        		break;

        	case 4:
        		/*
        		 * Display Reports Menu
        		 */
        		iReportChoice = 0;
        		while (4 != iReportChoice){
        			iReportChoice = Menu.fnReportsMenu();
            		switch (iReportChoice){
            		case 1:
            			/*
            			 * Call Car Report Module
            			 */
            		//to be implemented
            			report.CarReport(con);
            			break;

            		case 2:
            			/*
            			 * Call Customer Report Module
            			 */
            		//to be implemented
            			report.CustomerReport(con);
            			break;

            		case 3:
            			/*
            			 * Call Income Report Module
            			 */
            		//to be implemented
            			report.IncomeReports(con, scanner);
            			break;

            		case 4:
            			break;

            		default :
            			System.out.println("\t\t\tInvalid Choice.. Please Reenter");
            		}
        		}
        		break;

        	case 5:
        		System.out.println("Thank you for using Car Rental System");
        		System.out.println("Press ENTER to exit");
        		scanner.nextLine();
        		System.exit(0);

        	default :
        		System.out.println("Invalid Choice.. Please Re-enter");
        }

        if (con == null) {
            try {
                con.close();//Closing the connection

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }
    }
}

/*********************************************************************
* End of main
*********************************************************************/
