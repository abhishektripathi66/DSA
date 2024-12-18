package in.smartprogramming.corejava;

public class SortingAlgorithms2 {

	public static void main(String[] args) {
		// Bubble Sort

		int ar1[] = { 5, 8, 9, 1, 2, 6, 4 };

		for (int i = 0; i < ar1.length; i++) {
			for (int j = 0; j < ar1.length - i - 1; j++) {
				if (ar1[j] > ar1[j + 1]) {
					int temp = ar1[j];
					ar1[j] = ar1[j + 1];
					ar1[j + 1] = temp;

				}
			}

		}
		System.out.println("Implementing Bubble sort");
		for (int i : ar1)
			System.out.print(i);

		// Selection sort
		int ar2[] = { 5, 8, 9, 1, 2, 6, 4 };

		int temp, min;

		for (int i = 0; i < ar2.length; i++) {
			min = i;
			for (int j = i + 1; j < ar2.length; j++) {
				if (ar2[min] > ar2[j]) {
					min = j;

				}

			}
			temp = ar2[i];
			ar2[i] = ar2[min];
			ar2[min] = temp;
		}

		System.out.println();
		System.out.println("Implementing Selection sort");
		for (int i : ar2)
			System.out.print(i);

		// Insertion sort

		int ar3[] = { 5, 8, 9, 1, 2, 6, 4 };

		for (int i = 1; i < ar3.length; i++) {

			int temp1 = ar3[i];

			int j = i - 1;

			while (j >= 0 && ar3[j] > temp1) {

				ar3[j + 1] = ar3[j];
				j--;
			}
			ar3[j + 1] = temp1;
		}

		System.out.println();
		System.out.println("Implementing Insertion sort");
		for (int i : ar3)
			System.out.print(i);

	}

}
