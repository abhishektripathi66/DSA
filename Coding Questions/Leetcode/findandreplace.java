package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class findandreplace {

    public static void main(String[] args) {
        findandreplace far = new findandreplace();
        String arr[] = {"abc","deq","mee","aqq","dkd","ccc"};
        List<String> op = far.findAndReplacePattern(arr, "abb");
        System.out.println(op);
    }
    
        public List<String> findAndReplacePattern(String[] words, String pattern) {
            
       List<String> res = new ArrayList<String>();
            
            for(String str: words){
                if(match(str, pattern)){
                    res.add(str);
                }
            }
            return res;
        }
        
        public Boolean match(String str, String pattern){
            
            HashMap<Character, Character> hm = new HashMap<>();
            for(int i = 0; i < str.length(); i++){
                if(!hm.containsKey(pattern.charAt(i))){
                    if(hm.containsValue(str.charAt(i))){
                        return false;
                    }
                    hm.put(pattern.charAt(i), str.charAt(i));
                } else if(hm.get(pattern.charAt(i)) != str.charAt(i)){
                    return false;
                }
            }
            return true;
        }
    }
