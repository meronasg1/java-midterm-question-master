package datastructure;

import databases.ConnectToSqlDB;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Class;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ServiceLoader;

import java.sql.*;
import java.util.Stack;

public class DataReader {

    public static void main(String[] args) {
        /*
         * User API to read the below textFile and print to console.
         * Use BufferedReader class.
         * Use try....catch block to handle Exception.
         *
         * Use MySql Database to store data and retrieve data.
         *
         * After reading from file using BufferedReader API, store each word into Stack and LinkedList. So each word
         * should construct a node in LinkedList.Then iterate/traverse through the list to retrieve as FIFO
         * order from LinkedList and retrieve as FILO order from Stack.
         *
         * Demonstrate how to use Stack that includes push,peek,search,pop elements.
         * Use For Each loop/while loop/Iterator to retrieve data.
         */


//// src/data/self-driving-car
//        String textFile = System.getProperty("user.dir") + "/src/data/self-driving-car.txt";

        String tempContainer;
        String finalContainer="";


        try {
           FileReader fileReader= new FileReader("src/data/self-driving-car");
            BufferedReader bufferedReader= new BufferedReader(fileReader);

            while ((tempContainer=bufferedReader.readLine())!=null){
                String space = " ";
                finalContainer = finalContainer+ "\n"  + tempContainer;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(finalContainer);


       ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
       connectToSqlDB.insertDataFromStringToSqlTable(finalContainer, "self_driving_car", "text" );


        Stack<String> words = new Stack<>();
        String[] arrayOfSeparateWords1= finalContainer.replace(".", "").replace(",", "").split(" ");
        for (String separateWords1 : arrayOfSeparateWords1) {
            words.add(separateWords1);
        }

        LinkedList<String> listOfWordsInLinkedList = new LinkedList<>();
        String[] arrayOfSeparateWords= finalContainer.replace(".", "").replace(",", "").split(" ");
        for (String separateWords : arrayOfSeparateWords) {
            listOfWordsInLinkedList.add(separateWords);
        }

        System.out.println(listOfWordsInLinkedList);

        //push
        words.push("self ");
        words.push("driving ");
        words.push("cars ");

        //peek. shows the last item in this stack
        System.out.println(words.peek());

        //pop. removes the last item in the stack
        System.out.println(words.pop());

        //search
        System.out.println(words.search("driving"));
        System.out.println(words.search("self"));

       // for loop

        for (int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i));
        }

        // for each
        System.out.println("++++++++++++++++++++++++++");
        String allData = " ";
        for (String data : words){
           allData = data + allData;
        }
        System.out.println(allData);

        Iterator iterator = words.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }



    }






}
