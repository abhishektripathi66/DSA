/**
 * 2490. Circular Sentence
 * Solved
 * Easy
 * Topics
 * Companies
 * Hint
 * A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
 * <p>
 * For example, "Hello World", "HELLO", "hello world hello world" are all sentences.
 * Words consist of only uppercase and lowercase English letters. Uppercase and lowercase English letters are considered different.
 * <p>
 * A sentence is circular if:
 * <p>
 * The last character of a word is equal to the first character of the next word.
 * The last character of the last word is equal to the first character of the first word.
 * For example, "leetcode exercises sound delightful", "eetcode", "leetcode eats soul" are all circular sentences. However, "Leetcode is cool", "happy Leetcode", "Leetcode" and "I like Leetcode" are not circular sentences.
 * <p>
 * Given a string sentence, return true if it is circular. Otherwise, return false.
 **/
public class CircularSentence {
    public boolean isCircularSentence(String sentence) {
        if (sentence == null) {
            return false;
        }
        String[] a = sentence.split(" ");
        if (a.length == 1) {
            if (a[0].charAt(0) == a[0].charAt(a[0].length() - 1)) return true;
            return false;
        } else {

            if (a[0].charAt(0) == a[a.length - 1].charAt(a[a.length - 1].length() - 1)) {

                for (int i = 0; i < a.length - 1; i++) {
                    if (a[i].charAt(a[i].length() - 1) != a[i + 1].charAt(0)) return false;
                }
                return true;
            } else {
                return false;
            }

        }
    }
}
