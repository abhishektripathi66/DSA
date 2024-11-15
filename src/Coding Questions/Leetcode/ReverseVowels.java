/**

Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

 

Example 1:

Input: s = "hello"
Output: "holle"
Example 2:

Input: s = "leetcode"
Output: "leotcede"

**/

public class ReverseVowels {
    public String reverseVowels(String s) {
        
        String vowels = "aeiouAEIOU";
        StringBuffer buffer = new StringBuffer();
        StringBuilder string = new StringBuilder(s);
        
        // replace the vowels with _ and add vowels in a buffer
        for(int i=0;i<s.length();i++){
            if(vowels.contains(s.charAt(i)+"")){
                buffer.append(s.charAt(i));
                string.setCharAt(i, '_');
            }
        }

        // reverse the vowels
        buffer.reverse();
        int j=0;
        s = string.toString();
        //replace back _ with the vowels
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='_'){
                string.setCharAt(i,buffer.charAt(j));
                j++;
            }
        }
        return string.toString();

    }
}
