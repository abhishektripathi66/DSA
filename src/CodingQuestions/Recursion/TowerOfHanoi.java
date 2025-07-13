public class TowerOfHanoi {

    public static void main(String[] args) {
        towerOfHanoi(2, "A", "B", "C");
    }
    
    //time complexity: O(2^n)
    //space complexity: O(n)
    public static void towerOfHanoi(int n, String A,String B, String C){
        if(n==1){
            System.out.println("move disk 1 from "+A+" to "+C);
            return;
        }
        towerOfHanoi(n-1, A, C, B);
        System.out.println("move disk "+n+" from "+A+" to "+C);
        towerOfHanoi(n-1, B, A, C);
    }
}
