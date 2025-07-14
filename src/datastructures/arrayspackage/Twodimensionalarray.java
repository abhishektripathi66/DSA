package datastructures.arrayspackage;

public class Twodimensionalarray {
    int arr[][] = null;

    public Twodimensionalarray(int numberOfRows, int numberOfColumns) {
        arr = new int[numberOfRows][numberOfColumns];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.MIN_VALUE;
            }
        }
    }

    public void insertelementinarray(int rowindex, int colindex, int value) {
        try {
            if (arr[rowindex][colindex] == Integer.MIN_VALUE) {
                arr[rowindex][colindex] = value;
                System.out.println(value + " is inserted");
                return;
            }
            System.out.println("The cell is already occupied");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Invalid index for array");
        }
    }

    public void accesscell(int rowindex, int colindex) {
        try {
            System.out.println("Accessing row " + rowindex + " and column " + colindex);
            System.out.println("cell value is " + arr[rowindex][colindex]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index");
        }
    }

    public void traverseArray() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void searchValue(int valueToBeSearched) {
        try {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] == valueToBeSearched) {
                        System.out.println(valueToBeSearched + " is present at row " + i + " and column " + j);
                        return;
                    }
                }
            }
            System.out.println(valueToBeSearched + " is not found in the array");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deletevalue(int rowindex, int colindex) {
        try {
            arr[rowindex][colindex] = Integer.MIN_VALUE;
            System.out.println("value deleted successfully at row " + rowindex + " and col " + colindex);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Invalid index");
        }
    }
}
