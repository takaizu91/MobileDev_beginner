package org.corruptor;

/******************************************************************************
* Filename    : MyScanner.java
* Author      : 
* Date        : 
* Description : Function to accept input from the user.
******************************************************************************/

 import java.util.Scanner ;

public class MyScanner {


    private Scanner scanner;

    public Scanner getScanner() {
        scanner = new Scanner(System.in);
        return scanner;
    }
}

/******************************************************************************
* End of MyScanner.java
******************************************************************************/
