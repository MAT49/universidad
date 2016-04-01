//package Assembly;

public class ProjEuler21 {
    public static void main(String args[] )
    {
        int max = 10000;
        //System.out.println(sumProperDivisors(220) );
        sumAmicableNums(max);
    }
    
    private static int sumProperDivisors(int number)
    {
        int amicableNum = 0;
        for(int i=1; i<number; i++)
        {
            if (number % i == 0)
                amicableNum = amicableNum + i;
        }
        return amicableNum;
    }
    
    private static void sumAmicableNums(int max)
    {
        int sumOfAmicableNums = 0;
        
        for (int j=1; j<max; j++)
        {
            int num1 = sumProperDivisors(j);
            int num2 = sumProperDivisors(num1);
            if (j != num1 && j == num2)
                sumOfAmicableNums = sumOfAmicableNums + num1;   
        }
        System.out.println("Sum of Amicable numbers under " + max + " is " + sumOfAmicableNums);
    }
     
}
