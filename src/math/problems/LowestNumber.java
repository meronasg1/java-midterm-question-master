package math.problems;

import databases.ConnectToSqlDB;

import java.util.ArrayList;
import java.util.List;

public class LowestNumber {

    public static void main(String[] args) {
        /*
         * Write java solution to find the lowest number from this array.
         * Use MySql Database to store and to retrieve.
         */
        int[] array = new int[]{211, 110, 99, 34, 67, 89, 67, 456, 321, 456, 78, 90, 45, 32, 56, 78, 90, 54, 32, 123, 67, 5, 679, 54, 32, 65};

        //find lowest number from the array
        int n = array.length;

        int smallNumber=array[0];
        for(int i=0; i<n; i++){
            if (array[i]<=smallNumber){
                smallNumber=array[i];}
        }
        System.out.println(smallNumber);

        int [] smallestNumber = {smallNumber};

        ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
        connectToSqlDB.insertDataFromArrayToSqlTable2(smallestNumber,"lowest", "lowestNumber");



    }

}
