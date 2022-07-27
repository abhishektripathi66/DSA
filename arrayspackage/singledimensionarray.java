package arrayspackage;

public class singledimensionarray {
    int arr[] =null;

    public int[] getarray() {
        return arr;
    }
    public int getElement(int index){
        int value = Integer.MIN_VALUE;
        try{
            value = arr[index];
        }
        catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Index is not present, please enter the valid index.");
        }
        return value;
    }
    
    public void init(int sizeOfArray) {
        arr = new int[sizeOfArray];
        for(int i=0;i<sizeOfArray;i++){
            arr[i]=Integer.MIN_VALUE;
        }
    }

    public void insert(int location, int valueToBeInserted) {
        try{
        if(arr[location] == Integer.MIN_VALUE){
            arr[location]=valueToBeInserted;
            System.out.println("Successfully inserted");
        }
        else System.out.println("This cell is already occupied.");
    }catch(ArrayIndexOutOfBoundsException e){
        System.out.println("Invalid index to access array");
    }
    }
//Traverse method
    public void traversal(){
        //the name of arr should be correct
        try{
            for(int i=0;i<arr.length;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println("");
        }
        catch(Exception e){
            System.out.println("Array no longer exists");
        }
    }

    public void searchinarray(int valuetosaerch){
        for (int i=0;i<arr.length;i++) {
            if(arr[i]==valuetosaerch) {System.out.println("The Value " +valuetosaerch+ " is found at index "+i);
            return;}
        }
        System.out.println(valuetosaerch+" is not found in the array");
    }

    public void deletevalue(int index){
        try {
            arr[index]=Integer.MIN_VALUE;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("The index "+index+" is not present in the array");
        }
    }
}
