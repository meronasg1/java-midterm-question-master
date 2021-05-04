package math.problems;
import databases.ConnectToSqlDB;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {

    public static void main(String[] args) {
        /*
         * Find list of Prime numbers from number 2 to 1 million.
         * Try the best solution as possible.Which will take less CPU life cycle.
         * Out put number of Prime numbers on the given range.
         *
         *
         * Use MySql Database to store data and retrieve data.
         *
         */
        int maxNumber = 1000000;

        ArrayList<Integer> primeNumber = findPrimeNumber(maxNumber);
        System.out.println(primeNumber);


        int [] primeNumberArray = new int [primeNumber.size()];

        for (int i =0; i<primeNumber.size(); i++){
            primeNumberArray[i]= primeNumber.get(i);
        }
        System.out.println(primeNumberArray);

        ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
        connectToSqlDB.insertDataFromArrayToSqlTable(primeNumberArray, "Prime_Numbers", "SortingNumbers");

        List<String> primeNumbersFromDB = null;
        try {
            primeNumbersFromDB = connectToSqlDB.readDataBase("Prime_Numbers", "SortingNumbers");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(primeNumbersFromDB);




    }

    //method to check if a number is prime
    public static ArrayList<Integer> findPrimeNumber(int maxNumber) {

        ArrayList<Integer> primeNumbers = new ArrayList<>();


        for (int i = 2; i < maxNumber; i++) {

            if (isPrime(i)) {
                primeNumbers.add(i);
            }

        }
        return primeNumbers;
    }

    private static boolean isPrime(int number) {
        int remainder;
        for (int i = number - 1; i > 1; i--) {
            remainder = number % i;
            if (remainder == 0) {
                return false;
            }
        }
        return true;
    }

}

