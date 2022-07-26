package arrayspackage;

public class singledimensionarray {
    int arr[] =null;

    public int[] getarray() {
        return arr;
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
}
