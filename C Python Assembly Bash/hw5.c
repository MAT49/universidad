#include<stdio.h>
//http://www.tutorialspoint.com/c_standard_library/c_function_sqrt.htm
#include<math.h>
//solution: 142913828922
//King's book, pg 250
#define N 2000000
//from class lecture
unsigned long sum = 0;

int main()
{	
	unsigned int  i, j, arr[N];
	//makes array arr of size N, and puts value of i to each cell arr[i] from 2 - (N-1)
	for (i=2; i < N; i++)
	{
		arr[i] = i;		
	}
	//loops through the array
	for (i=2; i < N; i++)
	{
		//if the value arr[i] is not zero (i.e. is not false)
		if (arr[i])
		{			
			//then sets values of every multiples of arr[i] to zero
			//Sieve of Eratosthenes
			for (j = 2; (i*j) < N; j++)
			{
				arr[i*j] = 0;
			}
			sum += arr[i];			
		}
	}
	//prints the sum of prime numbers under N
	printf("\nThe sum of prime numbers from 1 to 2000000 are : %ld\n\n", sum);	
	
}