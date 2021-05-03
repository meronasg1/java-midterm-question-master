package datastructure;

import java.util.HashMap;

public class CollectionView {

    public static void main(String[] args) {
        /*
         Map is created and inserted some data.Retrieve the Collection view of values present in map
         */
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "NYC");
        map.put(2, "LA");
        map.put(3, "Denver");
        map.put(4, "Boston");
        map.put(5, "San Jose");
        map.put(6, "Seattle");

        //prints the hashmap
        System.out.println(map);


        //prints the value associated with each key
        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(3));
        System.out.println(map.get(4));
        System.out.println(map.get(5));
        System.out.println(map.get(6));

        //prints the number of key value pairs in the map
        System.out.println(map.size());

        // next two print statements should return true. The map contains said key and value
        System.out.println(map.containsKey(1));
        System.out.println(map.containsValue("LA"));

        //next two print statements should return false. The map doesnot contain said key and value
        System.out.println(map.containsKey(10));
        System.out.println(map.containsValue("Dallas"));

    }

}
