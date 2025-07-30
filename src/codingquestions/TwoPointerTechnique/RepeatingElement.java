package codingquestions.TwoPointerTechnique;

public class RepeatingElement {

    public static void main(String[] args) {
        System.out.println(findRepeat(new int[]{1,2,2,3,4,5}));   
    }

    public static int findRepeat(int[] arr){
        int slow = arr[0], fast = arr[0];
        do {
            slow = arr[slow];       // move by 1 step
            fast = arr[arr[fast]]; // move by 2 steps
        } while (slow != fast);
        slow = arr[0];
        while (slow != fast) {
            slow = arr[slow]; // move by 1 step
            fast = arr[fast]; // move by 1 step
        }
        return slow;
    }
    
}
