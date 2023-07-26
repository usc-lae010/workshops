
import java.util.HashSet;


import java.util.Set;



public class AllPossibleStrings {



    public static void generateStrings(String characters, String currentString, Set<String> result) {

        if (characters.length() == 0) {

            result.add(currentString);

        } else {

            for (int i = 0; i < characters.length(); i++) {

                char ch = characters.charAt(i);

                String remainingChars = characters.substring(0, i) + characters.substring(i + 1);

                generateStrings(remainingChars, currentString + ch, result);

            }

        }

    }



    public static void main(String[] args) {

        String characters = "catdog";

        Set<String> result = new HashSet<>();

        generateStrings(characters, "", result);



        System.out.println("All possible strings and their counts:");

        for (String str : result) {

            System.out.println(str);

        }



        System.out.println("Total count of distinct strings: " + result.size());

    }

}
