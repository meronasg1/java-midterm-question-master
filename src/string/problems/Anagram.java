package string.problems;

import java.util.HashMap;

public class Anagram {

    public static void main(String[] args) {
        //Write a Java Program to check if the two String are Anagram. Two String are called Anagram when there is
        //same character but in different order.For example,"CAT" and "ACT", "ARMY" and "MARY".
        System.out.println(isAnagram("CAT", "ACT"));
        System.out.println(isAnagram("ARMY", "MARY"));
        System.out.println(isAnagram("CATS", "ACT"));


    }

    public static boolean isAnagram (String word1, String word2 ){
        HashMap<Character,Integer> word1LetterCount = getLetterCount(word1);
        HashMap<Character,Integer> word2LetterCount = getLetterCount(word2);

        //return false if size of string different
        if (word1LetterCount.size()!= word2LetterCount.size()){
            return false;
        }
        //return false there are different characters
        for (Character character: word1LetterCount.keySet()){
            if(word1LetterCount.get(character) != word2LetterCount.get(character)){
                return false;
            }
        }
        return true;





    }

    //a method that return key value pairs. Array of characters and the number of characters in that array
    public static HashMap<Character,Integer>getLetterCount(String word ){
        HashMap<Character, Integer>letterCount = new HashMap<>();

        for (char character: word.toCharArray() ){
            if (letterCount.get(character)==null){
                letterCount.put(character, 1);
            }
            else
                letterCount.put(character, letterCount.get(character)+1);
        }
        return letterCount;
    }

}
