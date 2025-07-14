package codingquestions.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 * <p>
 * Each letter in magazine can only be used once in ransomNote.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 * <p>
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 * <p>
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 */
public class RansomeCode {

    public static void main(String[] args) {
        var rc = new RansomeCode();
        System.out.println(rc.canConstruct("aa", "aab"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        List<String> sample = new ArrayList<String>(Arrays.asList(ransomNote.split("")));
        List<String> complete = new ArrayList<String>(Arrays.asList(magazine.split("")));
        Set<String> distinct = new HashSet<>(sample);
        for (String s : distinct) {
            int completefrequ = Collections.frequency(complete, s);
            int samplefrequ = Collections.frequency(sample, s);
            if (completefrequ >= 0 && samplefrequ > completefrequ) {
                return false;
            }
        }
        return true;
    }
}
