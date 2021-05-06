package string.problems;

import java.util.HashMap;

public class Anagram {

    public static void main(String[] args) {
        //Write a Java Program to check if the two String are Anagram. Two String are called Anagram when there is
        //same character but in different order.For example,"CAT" and "ACT", "ARMY" and "MARY".
        System.out.println(isAnagram("CAT", "ACT"));
        System.out.println(isAnagram("CAT", "ADT"));
        System.out.println(isAnagram("CATTEL", "CATEL"));

    }

    private static boolean isAnagram(String firstString, String secondString){
        HashMap<Character,Integer> letterCount1 = getLetterCount(firstString);
        HashMap<Character,Integer> letterCount2 = getLetterCount(secondString);
        if(letterCount1.size() != letterCount2.size()){
            return false;
        }
        for(Character character : letterCount1.keySet()){
            if(letterCount1.get(character) != letterCount2.get(character)){
                return false;
            }
        }
        return true;
    }

    private static HashMap<Character, Integer> getLetterCount(String word) {
        HashMap<Character,Integer> letterCount = new HashMap<>();
        for(char character : word.toCharArray()){
            if(letterCount.get(character) == null){
                letterCount.put(character, 1);
            }
            else {
                letterCount.put(character,letterCount.get(character)+1);
            }
        }
        return letterCount;
    }
}
