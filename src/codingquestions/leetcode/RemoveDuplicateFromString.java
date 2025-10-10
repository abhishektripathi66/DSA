import java.util.*;

class RemoveDuplicateFromString{

    public static String removeDuplicate(String s, int idx, StringBuilder str, boolean[] map){
        //base case
        if(idx == s.length()-1){
            return str.toString();
        }
        char ch = s.charAt(idx);
        if(map[ch-'a'] == true){
            removeDuplicate(s, idx+1, str, map);
        } else {
            map[ch-'a'] = true;
            removeDuplicate(s, idx+1, str.append(ch), map);
        }
        return str.toString();
    }

    public static void main(String[] args){

        String s = "appnacollege";
        //Solution 1 using recursion
        System.err.println(removeDuplicate(s, 0, new StringBuilder(""), new boolean[26]));


        //Solution 2 using Hashset
        HashSet<Character> ch = new HashSet<>();
        StringBuilder unique = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char letter = s.charAt(i);
            if(!ch.contains(letter)){
                ch.add(letter);
                unique.append(letter);
            }
        }
        String ans = unique.toString();
        System.err.println(ans);
    }
}