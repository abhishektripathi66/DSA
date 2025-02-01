import java.util.*;

/**
 * Backtracking algorithm to solve problems like getting all permutations
 */
public class Backtracking {
    //Stores the list of word permutations
    public static Set<String> words = new HashSet<>();

    //Stores the characters we visited so far
    public static Stack<String> visitedCharacters = new Stack<>();

    public static void main(String[] args) {
        //All characters available to us
        String[] letters = new String[]{ "a", "b", "c" };

        backtrack(letters);

        System.out.println(words);
    }

    /**
     * Recursively goes through each element in letters and finds all permutations
     * @param letters The letters available for permutation
     */
    public static void backtrack(String[] letters) {
        //if the visited characters is the same size as the total number of letters then we add it as a permutation
        if(visitedCharacters.size() == letters.length) {
            words.add(String.join("", visitedCharacters));
            return;
        }

        for(String letter : letters) {
            //if the character has already been visited then it is not part of the permutation so we just continue
            if (visitedCharacters.contains(letter)) continue;

            //add the character to the stack to indicate that we have visited it
            visitedCharacters.add(letter);

            //recursively call backtrack to go through each character
            backtrack(letters);

            //pop off the top of the stack since we are now done with that character
            visitedCharacters.pop();
        }
    }
}
