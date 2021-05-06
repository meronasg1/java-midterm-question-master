package datastructure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class UseQueue {

    public static void main(String[] args) {
        /*
         * Demonstrate how to use Queue that includes add,peek,remove,pool elements.
         * Use For Each loop and while loop with Iterator to retrieve data.
         *
         */
        Queue<String> waitingList = new LinkedList<>();


        waitingList.add("John");
        waitingList.add("Smith");
        waitingList.add("Scott");
        waitingList.add("Alex");
        waitingList.add("Andy");
        waitingList.add("Jim");
        waitingList.add("Micheal");

        System.out.println(waitingList.peek());

        waitingList.remove("Scott");
        System.out.println(waitingList);

        System.out.println(waitingList.poll());
        System.out.println(waitingList);


        for (String listOfNames : waitingList) {
            System.out.println(listOfNames);
        }


        Iterator iterator = waitingList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
