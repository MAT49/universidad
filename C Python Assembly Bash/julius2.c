/*	this is a simple implementation of a Caesar cipher
	decryption, as long as 'e' is the most used letter
	in encrypted message.
	
	Ha K Hwang
	CS3320
	4/2/2015
	
*/
#include <stdio.h>
#include <ctype.h>

int main( int argc, char **argv) {

	char buffer[1000];
	char arr[27] = {0};	//each letter of alphabet
	char max = 0;
	int key;

	if( argc < 1) {
		fprintf(stderr, "Usage is \n julius < encrypted file > decrypted file \n");
		return(1);
	}
	
	while(fgets( buffer, sizeof(buffer), stdin) != (char *) 0) {
		int i,j; /* legal here and scoped to the end of the while loop */
			char t;

		for( i=0; i< 1000; i++) {  /* the two possible conditions for end of line */
			if( buffer[i] == '\n') break;
			if( buffer[i] == '\0') break;
			
			t = tolower(buffer[i]);
			
			if( t < 'a' || t > 'z') continue;
			//cycles through alphabet and records each letter's occurrence
			//inefficient, not elegant...but works
			if (t == 'a')
			{
				arr[0] += 1;
			}
			if (t == 'b')
			{
				arr[1] += 1;
			}
			if (t == 'c')
			{
				arr[2] += 1;
			}
			if (t == 'd')
			{
				arr[3] += 1;
			}
			if (t == 'e')
			{
				arr[4] += 1;
			}
			if (t == 'f')
			{
				arr[5] += 1;
			}
			if (t == 'g')
			{
				arr[6] += 1;
			}
			if (t == 'h')
			{
				arr[7] += 1;
			}
			if (t == 'i')
			{
				arr[8] += 1;
			}
			if (t == 'j')
			{
				arr[9] += 1;
			}
			if (t == 'k')
			{
				arr[10] += 1;
			}
			if (t == 'l')
			{
				arr[11] += 1;
			}
			if (t == 'm')
			{
				arr[12] += 1;
			}
			if (t == 'n')
			{
				arr[13] += 1;
			}
			if (t == 'o')
			{
				arr[14] += 1;
			}
			if (t == 'p')
			{
				arr[15] += 1;
			}
			if (t == 'q')
			{
				arr[16] += 1;
			}
			if (t == 'r')
			{
				arr[17] += 1;
			}
			if (t == 's')
			{
				arr[18] += 1;
			}
			if (t == 't')
			{
				arr[19] += 1;
			}
			if (t == 'u')
			{
				arr[20] += 1;
			}
			if (t == 'v')
			{
				arr[21] += 1;
			}
			if (t == 'w')
			{
				arr[22] += 1;
			}
			if (t == 'x')
			{
				arr[23] += 1;
			}
			if (t == 'y')
			{
				arr[24] += 1;
			}
			if (t == 'z')
			{
				arr[25] += 1;
			}
		}
	}
	//find most frequent letter, and save that as var "key"
	int k;
	for ( k = 0; k < 26; k++) 
	{
		if (arr[k] > max)
		{
			max = arr[k];
			key = k;
		}		
	}
	printf("The most frequent key value is	%d\n", key);
	//4 is 'e' so, find distance from 'e' to the most frequent letter
	if (key < 4)
	{
		key = 26 + key;
	} else
		key = key - 4;	//4 is 'e'
	printf("The encryption key value is	%d", key);
	
	//it wouldn't read file twice, and from random Internet searching
	//there was rewind() function...it works
	//http://www.tutorialspoint.com/c_standard_library/c_function_rewind.htm
	rewind(stdin);		//read file one more time!
	while(fgets( buffer, sizeof(buffer), stdin) != (char *) 0) {
		int i,j; /* legal here and scoped to the end of the while loop */
			char t;

		for( i=0; i< 1000; i++) {  /* the two possible conditions for end of line */
			if( buffer[i] == '\n') break;
			if( buffer[i] == '\0') break;
			
			t = tolower(buffer[i]);
			
			if( t < 'a' || t > 'z') continue;
			
			//---------------------decryption mechanism code-----------------------------------------------
			//I used about 3 pages worth of calculations and 3 letters were always incorrect, so
			//I approached it more mathematically, and reversed the encryption operations
			//then figured out the sample space of all outcomes under % operation,
			//which was "greater than key", "less than key", or "equal to zero".
			//the "wheels" of alphabet cycle resets at 26, which is zero
			
			//tested using various encrypted messages from below site.  Works 100%!!!
			//http://www.dcode.fr/caesar-cipher
			j = t - 'a';
			if (j > key)
			{
				j = (j-key)%26;
			} else if (j == key)
			{
				j = 0;
			} else
			{
				j = (26 + j - key)%26;
			}
			t = j + 'a';
			
			
			putchar(t);
		}
		putchar('\n');

	}

	return 0;
}