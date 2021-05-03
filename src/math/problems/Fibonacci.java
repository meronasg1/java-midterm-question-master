package math.problems;

import java.util.HashMap;
import java.util.Iterator;

public class Fibonacci {

    public static void main(String[] args) {
         /*
          Write 40 Fibonacci numbers with java.
          0,1,1,2,3,5,8,13
         */

       Fibonacci fibonacci = new Fibonacci();
       fibonacci.fibonacciCalculation(40);


    }

    public void fibonacciCalculation  (int number) {
        int fold1 = 1;
        int fold2 = 0;
        int foldnew = 1;
        int number1 = number;
        HashMap<Integer , Integer> fibonacciList= new HashMap<Integer, Integer>();
        for (int i = 0; i <= number1; i++) {
            foldnew = fold1 + fold2;
            fold2 = fold1;
            fold1 = foldnew;
            fibonacciList.put(i, foldnew);
        }
        System.out.println(fibonacciList);

    }
}
