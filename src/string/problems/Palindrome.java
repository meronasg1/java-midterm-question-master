package string.problems;

public class Palindrome {

    public static void main(String[] args) {
        /*
          If a String is reversed and it remains unchanged, that is called Palindrome. For example, MOM,DAD,MADAM are
          Palindrome. So write java code to check if a given String is Palindrome or not.
         */

        System.out.println(isPalindrome("MOM"));
        System.out.println(isPalindrome("FOR"));
    }

    private static boolean isPalindrome(String string){
        return string.equals(reverse(string));
    }

    private static String reverse(String string){
        String reversedString = "";
        for(int i = string.length()-1; i>=0; i--){
            reversedString += string.charAt(i);
        }
        return reversedString;
    }
}
