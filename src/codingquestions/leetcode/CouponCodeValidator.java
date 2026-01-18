/*
3606. Coupon Code Validator
Solved
Easy
Topics
premium lock icon
Companies
Hint
You are given three arrays of length n that describe the properties of n coupons: code, businessLine, and isActive. The ith coupon has:

code[i]: a string representing the coupon identifier.
businessLine[i]: a string denoting the business category of the coupon.
isActive[i]: a boolean indicating whether the coupon is currently active.
A coupon is considered valid if all of the following conditions hold:

code[i] is non-empty and consists only of alphanumeric characters (a-z, A-Z, 0-9) and underscores (_).
businessLine[i] is one of the following four categories: "electronics", "grocery", "pharmacy", "restaurant".
isActive[i] is true.
Return an array of the codes of all valid coupons, sorted first by their businessLine in the order: "electronics", "grocery", "pharmacy", "restaurant", and then by code in lexicographical (ascending) order within each category.

 

Example 1:

Input: code = ["SAVE20","","PHARMA5","SAVE@20"], businessLine = ["restaurant","grocery","pharmacy","restaurant"], isActive = [true,true,true,true]

Output: ["PHARMA5","SAVE20"]

Explanation:

First coupon is valid.
Second coupon has empty code (invalid).
Third coupon is valid.
Fourth coupon has special character @ (invalid).
Example 2:

Input: code = ["GROCERY15","ELECTRONICS_50","DISCOUNT10"], businessLine = ["grocery","electronics","invalid"], isActive = [false,true,true]

Output: ["ELECTRONICS_50"]

Explanation:

First coupon is inactive (invalid).
Second coupon is valid.
Third coupon has invalid business line (invalid).
 

Constraints:

n == code.length == businessLine.length == isActive.length
1 <= n <= 100
0 <= code[i].length, businessLine[i].length <= 100
code[i] and businessLine[i] consist of printable ASCII characters.
isActive[i] is either true or false.
*/
class Coupon implements Comparable<Coupon>{
    String code;
    String businessLine;

    public Coupon(String code, String businessLine){
        this.code = code; this.businessLine = businessLine;
    }

    public int compareTo(Coupon oth){
        if(!businessLine.equals(oth.businessLine)){
            return businessLine.compareTo(oth.businessLine);
        }

        return code.compareTo(oth.code);
    }
}

class Solution {
    private boolean isValidCode(String s){
        if(s.length() == 0)
            return false;
        
        for(char c: s.toCharArray()){
            if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') || c == '_')
                continue;
            
            return false;
        }
        return true;
    }

    private boolean isValidLine(String s){
        return (s.equals("electronics") || s.equals("grocery") || s.equals("pharmacy") || s.equals("restaurant"));
    }

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<Coupon> list = new ArrayList<>();

        for(int i = 0; i < code.length; i++){
            if(isValidCode(code[i]) && isValidLine(businessLine[i]) && isActive[i])
                list.add(new Coupon(code[i], businessLine[i]));
        }

        Collections.sort(list);
        List<String> res = new ArrayList<>();
        for(Coupon i : list)
            res.add(i.code);
        
        return res;
    }
}
