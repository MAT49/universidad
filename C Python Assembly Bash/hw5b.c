#include<stdio.h>
//author @ Ha K Hwang
//solution: 142913828922
//King's book, pg 250
#define N 2000000
//from class lecture
unsigned long sum = 5;		//counts initial prime numbers, 2 + 3

int main()
{	
	unsigned int  i, j, arr[N];		//maximize integer range
	
	//Sieve of Sundaram
	//https://plus.maths.org/content/sundarams-sieve	
	//makes 2D array of Sundaram numbers
	for (i=1; i < (N/2); i++)
	{
		//each column increments by 2, starting from 3 steps from row, i
		//column length gets smaller as row increases
		//(N-i) / (2*i + 1) is total amount of column sequence per column
		//(2*i + 1) is the column increment value at that column (3+2+2+2...)
		for (j=1; j < ((N-i) / (2*i + 1)); j++)
		{
			//creates Sundaram's matrix, 2D
			//http://en.wikipedia.org/wiki/Sieve_of_Sundaram
			arr[i+j + 2*i*j] = i+j + 2*i*j;		
			//printf("%d\t", arr[i+j + 2*i*j]);		//visualize 2D array			
		}
		//printf("\n");		//space for visualizing 2D array
	}
	
	//loops through the array from second row to avoid redundancy
	//row 1 is same as column 1
	for (i=2; i < (N/2); i++)
	{
		//if the value arr[i] is zero (i.e. array does not contain the above values)
		if (!arr[i])
		{
			//sum starts at 5 initially, as explained above
			sum += 2*i + 1;		//then 2i+1 is prime number
		}
	}	
		
	//prints the sum of prime numbers under N
	printf("\nThe sum of prime numbers from 1 to 2000000 are : %ld\n\n", sum);	
		
}