/**********************************************************
* File			: Exercise 2b (student-ex2b.c)
* Description	: Reuse existing code and modularize it
* Author		: 025 (Group 8)
* Version		: 1.04
* Date			: 7rd May 2014
* Log			: - fine tune student.c code
*				  - add new function fnCourseRegister
***********************************************************/

#include <stdio.h>

//Add Functions
int fnCourseRegister();


//Global variables
int iNumco = 0;									//number of courses
int iaCoud[2][5] = {{0,0,0,0,0},{0,0,0,0,0}};	//for array of course1 and course2
int iaStud[2][5] = {{0,0,0,0,0},{0,0,0,0,0}};	//1st row iStu_id 2nd row iNumco

int main (int argc, char **argv)
{
	//local variables
	int i,k;										//temp var
	int iStu_id;									//student id
	int iSems;										//semester
	char iaName[26];								//storing student name
	

	//Loop this 5 times for 5 students
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

						if (iStu_id == iaStud[0][k]) {
							printf("\nError! You have registered already");
							printf("\nKill Program!\n");
							return(0);	}
				
					}
			
					//if no student ID match, then insert current student id into array
					printf("no data yet. ok!\n");
					iaStud[i][0] = iStu_id;


					//Check number of courses
					printf("\nCurrent Number of Courses: %d\n", iaCoud[1][i]);

					//Accept student name
					printf("Enter students first name: ");
					scanf(" %[^\n]", iaName);			//for some reason gets() do not work

					//print student name
					printf("Hello, ");
					printf(" %s", iaName);

					//Check for zero. If not, call out error
					if (iaStud[1][i] == 0) {

						//added function here
						fnCourseRegister(i, iStu_id);
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

	


	
	return 0;
}

int fnCourseRegister(int m, int iStu_id2)
{
	//local variables
	int iCo_id;	
	int j;		//tempvar

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
					printf("\nEx: Course ID %d is allocated with ID %d\n", iCo_id, iStu_id2);
					iNumco++;

					//save courses in iaCoud array
					iaCoud[j][m] = iCo_id;

					//checking new number of courses
					printf("\nCurrent number of courses: %d\n", iNumco);

					if (iaCoud[0][m] != iaCoud[1][m])
						continue;

					else {
						printf("\nError! Course cannot be match!");
						printf("\nBack to Main Menu!\n");

						//reset course id array
						iaCoud[0][m] = 0;
						iaCoud[1][m] = 0;
						iNumco = 0;
						iaStud[0][m] = 0;
						return(0);	}
				}

				else {
					printf("\nError! Course ID invalid!");
					printf("\nExiting Program!\n");
					return(0);	}
			}
		}

		//save number of courses to iaStud array
		printf("\nCourses registration successful!\n");
		iaStud[1][m] = iNumco;
		iNumco = 0;


	return(0);
	
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

  for (k=0;k<5;k++) {
		printf("Course %d = %s\n", k, iaProg[k]); 
	}

  scanf(" %[^\n]", iaName[i])

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
*************************************/
