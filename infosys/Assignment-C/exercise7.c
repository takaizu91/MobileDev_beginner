/**********************************************************
* File			: Exercise 7 (login.c)
* Description	: Usage of string handling functions
* Author		: 025 (Group 8)
* Version		: 1.01
* Date			: 6rd May 2014
* Log			: -
***********************************************************/

#include <stdio.h>
#include <conio.h>
#include <string.h>

int main(int argc, char **argv)
{
	//Declared variables here
	char cLogname[10];
	char cUser[3][10] = {"User-1","User-2","User-3"};
	char cPwd[10], c = ' ';
	char cSetpwd[10] = "Infosys";
	int x = 0;
	int y = 0;
	int p = 0;

	/***QUICK NOTE***********************************
	* Password code intentionally set as hidden		*
	*************************************************/

	
	//give 3 retries to enter username
	while (x<3) {

		//Accept a user name
		printf("Enter user name [max length 10]: ");
		gets(cLogname);

		//Check if username character below 10. If no, print error
		if (strlen(cLogname) <= 10) {

			

			//check if entered username is valid
			if (strcmpi (cLogname, cUser[0]) == 0 || strcmpi (cLogname, cUser[1]) == 0 || strcmpi (cLogname, cUser[2]) == 0) {
		
				//give 3 retries to enter password
				while (y<3) {
					
					//Accept password
					printf("Enter password [max length 10]: ");
					while (p<=9) {
						cPwd[p]=getch();
						c=cPwd[p];
						if(c==13) {
							break; }
						else {
							printf("*"); }
						p++;
					}

					cPwd[p]='\0';
					p=0;
	
					//Check if password character below 10. If no, print error
					if (strlen(cPwd) <= 10) {
	
						if (strcmp (cSetpwd, cPwd) == 0) {

							//Login successful
							printf("\nLogin successful!\n");
							return 0;
						}

						else {
							printf("\nError! Password incorrect!");
							printf("\nKill program!\n");
							y++;
						}
					}
		

					else {
						printf("\nError! Password exceed 10 characters limit!");
						printf("\nKill program!\n");
						return 0;
					}
				}
			}

			else {
				printf("\nError! Invalid user!");
				printf("\nKill program!\n");
				x++;
			}
		}
	

		else {
			printf("\nError! Username exceed 10 characters limit!");
			printf("\nKill program!\n");
			return 0;
		}
	}

	return 0;
}

/*****************************************************************
*		END OF CODE
*****************************************************************/

/***********************************
*	ARCHIVE CAB
************************************
*	printf("\nError! Username exceed 10 characters limit!");
		printf("\nKill program!\n");
		return 0;

  //check user
	printf("Username 1: %s\n", cUser[0]);
	printf("Username 2: %s\n", cUser[1]);
	printf("Username 3: %s\n", cUser[2]);

  //Check username entered
			printf("Username entered: ");
			printf(cLogname);
			printf("\n\n");

  //Check password entered
							printf("\n");
							printf("Password is: %s\n", cPwd);
*************************************/
