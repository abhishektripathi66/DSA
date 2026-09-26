package codingquestions.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// problem link: https://leetcode.com/problems/word-ladder-ii/

/*
Description:
Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

Note:
Return an empty list if there is no such transformation sequence.
 */

// example 1:
// Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
// Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
// Explanation: There are 2 shortest transformation sequences:
// "hit" -> "hot" -> "dot" -> "dog" -> "cog"
// "hit" -> "hot" -> "lot" -> "log" -> "cog"    

public class WordLadder_II {
    public List<List<String>> findSequences(String beginWord, String endWord, List<String> wordList) {

        Set<String> s = new HashSet<>(wordList);

        Queue<List<String>> q = new LinkedList<>();
        q.add(new ArrayList<>(Arrays.asList(beginWord)));

        List<String> level = new ArrayList<>();
        level.add(beginWord);

        int l = 0;

        List<List<String>> ans = new ArrayList<>();

        while (!q.isEmpty()) {

            List<String> li = q.poll();

            if (li.size() > l) {
                l++;
                for (String used : level) {
                    s.remove(used);
                }
            }

            String word = li.get(li.size() - 1);

            if (word.equals(endWord)) {

                if (ans.isEmpty()) {
                    ans.add(new ArrayList<>(li));

                } else if (ans.get(0).size() == li.size()) {
                    ans.add(new ArrayList<>(li));
                }
            }

            char[] wordArr = word.toCharArray();

            for (int i = 0; i < wordArr.length; i++) {

                char ori = wordArr[i];

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    wordArr[i] = ch;

                    String newWord = new String(wordArr);

                    if (s.contains(newWord)) {
                        li.add(newWord);
                        q.add(new ArrayList<>(li));
                        level.add(newWord);
                        li.remove(li.size() - 1);
                    }
                }

                wordArr[i] = ori;
            }

        }

        return ans;

    }
}
