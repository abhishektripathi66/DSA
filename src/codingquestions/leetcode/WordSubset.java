package codingquestions.leetcode.ds;

import java.util.ArrayList;
import java.util.List;

public class WordSubset {

    public static void main(String[] args) {
        WordSubset wordsubset = new WordSubset();
        List<String> output = wordsubset.wordSubsets(new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"lo", "eo"});
        System.out.println(output);
    }

    public List<String> wordSubsets(String[] A, String[] B) {

        List<String> result = new ArrayList<>();
        int[] target = new int[26];

        for (String word : B) {
            int[] temp = new int[26];
            for (char ch : word.toCharArray()) {
                temp[ch - 'a']++;
                target[ch - 'a'] = Math.max(target[ch - 'a'], temp[ch - 'a']);
            }
        }

        for (String word : A) {
            int[] source = new int[26];
            for (char ch : word.toCharArray()) {
                source[ch - 'a']++;
            }

            if (subset(source, target)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean subset(int[] parent, int[] child) {
        for (int i = 0; i < 26; i++) {
            if (parent[i] < child[i]) return false;
        }
        return true;
    }

}