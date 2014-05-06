/**********************************************************
* File			: Exercise 4 (student.c)
* Description	: To identify the appropriate data type,
*					declare variables and perform validation
* Author		: 025 (Group 8)
* Version		: 1.00
* Date			: 3rd May 2014
***********************************************************/

#include <stdio.h>

int main ()
{
	//Declared variables here
	int stu_id;			//for student id
	int sems;			//for semester
	int numco;			//for number or courses
	int co_id;			//for courses id

	//Accept Student ID
	printf("Enter student ID: ");
	scanf("%d", &stu_id);

	//Range acceptable (1001~1005), otherwise call error
	if (stu_id > 1000 && stu_id <= 1005) {

		//Accept semester which student belong
		printf("\nEnter current semester: ");
		scanf("%d", &sems);

		//Must be 5th semester, otherwise call error
		if (sems == 5) {

			//Initialize number of courses to zero
			numco = 0;
			printf("\nCurrent Number of Courses: %d\n", numco);

			//Check for zero. If not, call out error
			if (numco == 0) {

				//Repeat allocation process twice using while loop
				while (numco < 2) {

					//Accept Course ID
					printf("\nEnter Course ID: ");
					scanf("%d", &co_id);

					//Range acceptable (5001~5005), otherwise call error
					if (co_id > 5000 && co_id <= 5005) {
						printf("\nEx: Course ID %d is allocated with ID %d\n", co_id, stu_id);
						numco++;

						//checking new number of courses
						printf("\nCurrent number of courses: %d\n", numco);	}
			

					else {
						printf("\nError! Course ID invalid!");
						printf("\nExiting Program!\n");	}
				}
			}

			else {
				printf("\nError! Your courses must be zero to proceed");
				printf("\nExiting Program!\n");	}
		}
		else {
			printf ("\nError! Your current semester is not applicable\n");
			printf("\nExiting Program!\n");	}
	
		
	
	}
	else {
		printf("\nError! Your Student ID is not applicable\n"); 
		printf("\nExiting Program!\n");	}

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

*************************************/
