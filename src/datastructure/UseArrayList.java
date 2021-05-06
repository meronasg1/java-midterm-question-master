package datastructure;

import databases.ConnectToSqlDB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class UseArrayList {
    static ArrayList<String> states = new ArrayList<>();
    public static void main(String[] args) {
        /*
         * Demonstrate how to use ArrayList that includes add,peek,remove,retrieve elements.
         * Use For Each loop and while loop with Iterator to retrieve data.
         * Store all the sorted data into one of the databases.
         *
         */



         states.add("Virgina");
         states.add("Maryland");
         states.add("Pennsylvania");
         states.add("Minnestoa");
         states.add("Washington");
         states.add("Indiana");


         states.remove("Maryland");

        System.out.println(states.get(1));

        for (String stateList : states) {
            System.out.println(stateList);
        }


        Iterator iterator = states.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


        ArrayList<String> sortedData = sortedStates();
        System.out.println(sortedData);

        ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
        connectToSqlDB.insertDataFromArrayListToSqlTableSortedData(sortedData, "useArrayList", "sortedData");

    }

    public static ArrayList<String> sortedStates() {
        Collections.sort(states);
        return states;
    }


}
