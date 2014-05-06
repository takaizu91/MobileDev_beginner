/**********************************************************
* File			: Exercise 5 (ex5.c)
* Description	: Use a two dimentional array for storing
*				  and manipulating related data
* Author		: 025 (Group 8)
* Version		: 1.00
* Date			: 5rd May 2014
***********************************************************/

#include <stdio.h>
//#include <string.h>

int main (int argc, char **argv)
{
	//Declared variables here
	int iStu_id;										//for student id
	int iSems;											//for semester
	int iNumco = 0;										//for number of courses
	int iCo_id;											//for courses id
	int iaStud[5][2] = {{0,0},{0,0},{0,0},{0,0},{0,0}};	//for array of student id and number of courses
	int iaCoud[5][2] = {{0,0},{0,0},{0,0},{0,0},{0,0}};	//for array of course1 and course2
	int i,j,k;											//for labeling the 2d arrays
	char cStu_name[100];								//for student name in 1D array

	/* QUICK NOTE *
	i stands for 1st array
	j stands for 2nd array
	k stands for temporary array checking
	***************/

	for (i=0; i<5; i++) {

			//Accept Student ID
			printf("\nEnter student ID: ");
			scanf("%d", &iStu_id);

			//Range acceptable (1001~1005), otherwise call error
			if (iStu_id > 1000 && iStu_id <= 1005) {

				//Accept semester which student belong
				printf("\nEnter current semester: ");
				scanf("%d", &iSems);

				//Must be 5th semester, otherwise call error
				if (iSems == 5) {

					printf("Checking if your student ID is in system...");

					//check student id for existing id in array
					for (k=0; k<5; k++) {

						if (iStu_id == iaStud[k][0]) {
							printf("\nError! You have registered already");
							printf("\nKill Program!\n");
							return(0);	}
				
					}
			
					//if no student ID match, then insert current student id into array
					printf("no data yet. ok!\n");
					iaStud[i][0] = iStu_id;


					//Check number of courses
					printf("\nCurrent Number of Courses: %d\n", iaCoud[i][1]);

					//Accept student name
					printf("Enter students first name: ");
					scanf("%s", cStu_name);					//for some reason gets() do not work

					//print student name
					printf("Hello, ");
					printf("%s", cStu_name);

					//Check for zero. If not, call out error
					if (iaStud[i][1] == 0) {

						//initialize to zero
						iNumco = 0;

						//Repeat allocation process twice using while loop
						while (iNumco < 2) {

							for (j=0; j<2; j++) {

							//Accept Course ID
							printf("\nEnter Course ID: ");
							scanf("%d", &iCo_id);
							
								//Range acceptable (5001~5005), otherwise call error
								if (iCo_id > 5000 && iCo_id <= 5005) {
									printf("\nEx: Course ID %d is allocated with ID %d\n", iCo_id, iStu_id);
									iNumco++;

									//save courses in iaCoud array
									iaCoud[i][j] = iCo_id;

									//checking new number of courses
									printf("\nCurrent number of courses: %d\n", iNumco);	}
			

								else {
									printf("\nError! Course ID invalid!");
									printf("\nExiting Program!\n");
									return(0);	}
							}
						}

						//save number of courses to iaStud array
						iaStud[i][1] = iNumco;
						iNumco = 0;
					}

					else {
						printf("\nError! Your courses must be zero to proceed");
						printf("\nExiting Program!\n");
						return(0);	}
			
				}

				else {
					printf ("\nError! Your current semester is not applicable\n");
					printf("\nExiting Program!\n");
					return(0);	}
	
		
	
			}
			else {
				printf("\nError! Your Student ID is not applicable\n"); 
				printf("\nExiting Program!\n");
				return(0);	}
		
	}

	//checking array for value
	printf("\n\n");
	for (i=0; i<5; i++) {
		for (j=0; j<2; j++) {

			printf("iaStud[%d][%d] = %d\n", i,j, iaStud[i][j]);	}
	}
	printf("\n\n");

	for (i=0; i<5; i++) {
		for (j=0; j<2; j++) {

			printf("iaCoud[%d][%d] = %d\n", i,j, iaCoud[i][j]);	}
	}

	//Success message
	printf("\nThank you for using this program!");
	printf("\nHave a nice day!\n");

	


	return 0;
}

/*****************************************************************
*		END OF CODE
*****************************************************************/

/***********************************
*	ARCHIVE CAB
************************************

  printf("\nGood Day!\n");


  for (i=0; i<5; i++) {
		for (j=0; j<2; j++) {

			printf("iaStud[%d][%d] = %d\n", i,j, iaStud[i][j]);	}
	}

  fgets(cStu_name, 50, stdin);		//using fgets instead


  else {
		printf("\nError! Your ID is already present!");
		printf("\nExiting Program!\n");	}
*************************************/
