package math.problems;

public class Factorial {

    public static void main(String[] args) {
        /*
         * Factorial of 5! = 5 x 4 X 3 X 2 X 1 = 120.
         * Write a java program to find Factorial of a given number using Recursion as well as Iteration.
         *
         */

        Factorial factorial= new Factorial();
        int x= factorial.factorialCalculationWithIteration(5);
        System.out.println(x);

        int y =factorial.factorialCalculationWithRecursion(5);
        System.out.println(y);

    }
        public int factorialCalculationWithIteration (int number){

        int factorial=1 ;
        int finalFactorial=1;
        for(int i=number; i>1; i--) {
            factorial = i;
            finalFactorial = factorial *finalFactorial;
        }
        return finalFactorial;
        }

        public int factorialCalculationWithRecursion(int number){
        if (number >= 1){
            return number*factorialCalculationWithRecursion(number-1);
        }
        else
            return 1;
        }
    }

