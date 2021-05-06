package datastructure;

import databases.ConnectToSqlDB;

import java.util.*;

public class UseMap {

    public static void main(String[] args) {
        /*
         * Demonstrate how to use Map that includes storing and retrieving elements.
         * Add List<String> into a Map. Like, Map<String, List<string>> list = new HashMap<String, List<String>>();
         * Use For Each loop and while loop with Iterator to retrieve data.
         *
         * Use MySql Database to store data and retrieve data.
         */
        HashMap<String, String> names = new HashMap<>();


        names.put("John", "Smith");
        names.put("William", "Johnson");
        names.put("Scott", "Turner");


        System.out.println(names.get("John"));


        List<String> virginiaCities = new ArrayList<>();
        virginiaCities.add("Herndon");
        virginiaCities.add("Reston");
        virginiaCities.add("Haymarket");
        virginiaCities.add("Mclean");
        virginiaCities.add("Charlottesvile");

        List<String> marylandCities = new ArrayList<>();
        marylandCities.add("Rockville");
        marylandCities.add("Baltimore");
        marylandCities.add("Annapolis");
        marylandCities.add("colomibia");

        HashMap<String, List<String>> listOfCities = new HashMap<>();
        listOfCities.put("Virginia", virginiaCities);
        listOfCities.put("Maryland", marylandCities);


        for (String cityNames : listOfCities.keySet()) {
            System.out.println(listOfCities.get(cityNames));
        }

        Iterator<Map.Entry<String, List<String>>> iterator = listOfCities.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<String>> setOfList = iterator.next();
            System.out.println(setOfList.getKey() + setOfList.getValue());

        }

        ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
        connectToSqlDB.insertDataFromMapToSqlTable(listOfCities,"city", "State", "City");

    }
}
