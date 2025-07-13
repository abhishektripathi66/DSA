

import java.util.ArrayList;
import java.util.List;

public class subset {
    
        public static void main(String[] args) {
            subset s = new subset();
          System.out.println(s.wordSubsets(new String[]{"amazon","apple","facebook","google","leetcode"}, new String[]{"e","o"}));  
        }

        public List<String> wordSubsets(String[] A, String[] B) {
        
            List<String> result=new ArrayList<>();
                 int[] target=new int[26];
                 
                 for(String word:B){
                     int[] temp=new int[26];
                     for(char ch:word.toCharArray()){
                         temp[ch-'a']++;
                         target[ch-'a']=Math.max(target[ch-'a'],temp[ch-'a']);
                     }
                 }
                 
                 for(String word:A){
                     int[] source=new int[26];
                     for(char ch:word.toCharArray()){
                         source[ch-'a']++;
                     }
                     
                     if(subsets(source,target)){
                         result.add(word);
                     }
                 }
                 
                 return result;
             }
             
             private boolean subsets(int[] parent,int[] child){
                 for(int i=0;i<26;i++){
                     if(parent[i]<child[i]) return false;
                 }
                 return true;
             }
}
