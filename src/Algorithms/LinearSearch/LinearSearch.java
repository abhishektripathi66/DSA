/*
Linear search is one of the simplest searching algorithms. 
It works by sequentially checking each element of a list (or array) until the desired element is found or the list is exhausted.

#Algorithm:
-> Start from the first element of the list.
-> Compare the current element with the target element.
-> If the element is found, return its index.
-> If the element is not found, move to the next element and repeat the comparison.
->If the end of the list is reached without finding the element, return a value indicating that the element is not in the list (commonly -1).

#Time Complexity:
Best Case: O(1) (if the element is the first one)
Worst Case: O(n) (if the element is the last one or not found at all)

#Space Complexity: O(1) (since no extra space is used apart from variables)

#Pros:
-> Simple and easy to implement.
-> No need for sorting the array.

#Cons:
-> Inefficient for large datasets because it checks each element one by one.


*/

class LinearSearch{
    public static void main(String[] args){
        int[] arr = {11,54,34,78,33,100,543,76,3,889,56};
        int target = 33;
        boolean flag = false;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == target){
                System.out.println("Element found at index: "+i);
                flag = true;
            }
        }
        if(flag == false){
            System.out.println("Element not found");
        }
    }
}
