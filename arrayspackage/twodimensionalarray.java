package arrayspackage;

public class twodimensionalarray {
    int arr[][] =null;
    public twodimensionalarray(int numberOfRows,int numberOfColumns){
        arr =new int[numberOfRows][numberOfColumns];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                arr[i][j]=Integer.MIN_VALUE;
            }
        }
    }

    public void insertelementinarray(int rowindex,int colindex, int value){
        try {
            if(arr[rowindex][colindex]==Integer.MIN_VALUE){
                arr[rowindex][colindex]=value;
                System.out.println(value+" is inserted");
                return;
            }
            System.out.println("The cell is already occupied");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Invalid index for array");
        }
    }
}
