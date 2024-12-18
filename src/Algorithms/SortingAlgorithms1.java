/*Algorithms for Quick sort and Merge sort using recursive approach*/ 

public class SortingAlgorithms1 {

	public static void main(String[] args) {
		int array[] = { 5, 8, 9, 1, 2, 6, 4 };

		sort(array, 0, array.length - 1);

		System.out.println("Implementing Quick sort");
		for (int i : array)
		System.out.print(i);
		System.out.println();

		divide(array);

		System.out.println("Implementing Merge sort");
		for (int i : array)
		System.out.print(i);
		System.out.println();

	}

	// Merge sort methods divide & conquer
	public static void divide(int[] array) {

		int length = array.length;

		int mid = length / 2;

		if (length <= 1)
			return;

		// Subarrays
		int[] LeftArray = new int[mid];
		int[] RightArray = new int[length - mid];

		int i = 0, j = 0;

		// populating subarrays
		for (; i < length; i++) {
			if (i < mid) {
				LeftArray[i] = array[i];

			} else {
				RightArray[j] = array[i];
				j++;
			}

		}

		divide(LeftArray);
		divide(RightArray);
		conquer(LeftArray, RightArray, array);

	}

	private static void conquer(int[] leftArray, int[] rightArray, int[] array) {
		int length = array.length;
		int leftsize = length / 2;
		int rightsize = length - leftsize;

		int l = 0, r = 0, i = 0;

		// populating the sorted array back
		while (l < leftsize && r < rightsize) {
			if (leftArray[l] < rightArray[r]) {
				array[i] = leftArray[l];
				i++;
				l++;
			} else {
				array[i] = rightArray[r];
				i++;
				r++;
			}

		}

		while (l < leftsize) {
			array[i] = leftArray[l];
			i++;
			l++;
		}

		while (r < rightsize) {
			array[i] = rightArray[r];
			i++;
			r++;
		}

	}

	// Quick Sort methods sort and partition
	private static void sort(int[] array, int start, int end) {
		if (end <= start)
			return;

		int pivot = partition(array, start, end);
		sort(array, start, pivot - 1);
		sort(array, pivot + 1, end);

	}

	private static int partition(int[] array, int start, int end) {
		
		int pivot = array[end];
		int j = start-1;
		
		for (int i=start; i<array.length; i++) {
			if(array[i]<pivot) {
				j++;
				int temp;
				
				temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		
		j++;
		
		int temp = array[j];
		array[j]  = array[end];
		array[end] =temp;
		
		return j;
	}
}
