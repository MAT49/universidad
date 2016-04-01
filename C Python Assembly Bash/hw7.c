#include<stdio.h>

int sumProperDivisors(int number)
{
	int amicableNum = 0;
	int i;
	for(i=1; i<number; i++)
	{
		if (number % i == 0)
			amicableNum = amicableNum + i;
	}
	return amicableNum;
}
    
void sumAmicableNums(int max)
{
	int sumOfAmicableNums = 0;
	int j;
	for (j=1; j<max; j++)
	{
		int num1 = sumProperDivisors(j);
		int num2 = sumProperDivisors(num1);
		if (j != num1 && j == num2)
			sumOfAmicableNums = sumOfAmicableNums + num1;   
	}
	printf("Sum of Amicable numbers under %d is %d\n", max , sumOfAmicableNums );
}


int main()
{
	int max = 10000;
	sumAmicableNums(max);
	return 0;
}