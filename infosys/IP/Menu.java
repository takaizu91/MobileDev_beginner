package org.corruptor;

/******************************************************************************
* Filename    : Menu.java
* Author      : E&R
* Date        : 18-Nov-2011
* Description : Displays the main menu.
******************************************************************************/



import java.util.Scanner;


public class Menu {

	/**
	 *
	 */
	private static int choice;
	private static Scanner scanner = new Scanner(System.in) ;

	public Menu() {
		choice = 0;
	}

	public static int fnMainMenu(){
		fnDrawBanner();
		System.out.println("\t\t\tMain Menu");
		System.out.println("\t\t\t=========");
		/*
		 * Display Main Menu Options
		 */
		System.out.println("\t\t1. Car Info");
		System.out.println("\t\t2. Customer Info");
		System.out.println("\t\t3. Booking Info");
		System.out.println("\t\t4. Reports");
		System.out.println("\t\t5. Exit");
		System.out.println("\t\t   Enter Choice (1-5)");
		choice = scanner.nextInt();
		return choice;
	}

	public static int fnCarMaintMenu(){
		fnDrawBanner();
		System.out.println("\t\tCar Info Menu");
		System.out.println("\t\t===========================");
		/*
		 * Display Car Info Menu Options
		 */
		System.out.println("\t\t1. Add Car");
		System.out.println("\t\t2. Update Car Rate");
		System.out.println("\t\t3. Update Car Status");
		System.out.println("\t\t4. List All Cars");
		System.out.println("\t\t5. Goto Main Menu");
		System.out.println("\t\t   Enter Choice (1-5)");
		choice = scanner.nextInt();
		return choice;
	}

	public static int fnCustMaintMenu(){
		fnDrawBanner();
		System.out.println("\t\tCustomer Info Menu");
		System.out.println("\t\t=========================");
		/*
		 * Display Customer Info Menu Options
		 */
		System.out.println("\t\t1. Add Customer");
		System.out.println("\t\t2. Update Customer");
		System.out.println("\t\t3. List All Customers");
		System.out.println("\t\t4. Goto Main Menu");
		System.out.println("\t\t   Enter Choice (1-4)");
		choice = scanner.nextInt();
		return choice;
	}

	public static int fnBookingMaintMenu(){
		fnDrawBanner();
		System.out.println("\t\tBooking Info Menu");
		System.out.println("\t\t====================================");
		/*
		 * Display Booking Info Menu Options
		 */
		System.out.println("\t\t1. Add Booking");
		System.out.println("\t\t2. Update Booking Date");
                System.out.println("\t\t3. Update Booking Car");
                System.out.println("\t\t4. Update Booking Payment");
                System.out.println("\t\t5. Goto Main Menu");
		System.out.println("\t\t   Enter Choice (1-5)");
		choice = scanner.nextInt();
		return choice;
	}

	public static int fnReportsMenu(){
		fnDrawBanner();
		System.out.println("\t\tReports Menu");
		System.out.println("\t\t===========================");
		/*
		 * Display Reports Menu Options
		 */
		System.out.println("\t\t1. Car Report");
		System.out.println("\t\t2. Customer Report");
		System.out.println("\t\t3. Income Reports");
		System.out.println("\t\t4. Goto Main Menu");
		System.out.println("\t\t   Enter Choice (1-4)");
		choice = scanner.nextInt();
		return choice;
	}

	private static void fnDrawBanner(){
		System.out.println("\n\n\t\t    +==================+");
		System.out.println("\t\t   | Car Rental System |");
		System.out.println("\t\t    +==================+");
	}
}


/******************************************************************************
* End of Menu.java
******************************************************************************/
