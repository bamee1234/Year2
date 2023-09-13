public class Sorting {

	static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	static void printArray(int[] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}

	static int findIndexSmallest(int[] A, int start, int end) {
		int minIndex = start; // Index of smallest remaining value.
		for (int j = start; j < end; j++) {
			if (A[minIndex] > A[j])
				minIndex = j; // Remember index of new minimum
		}
		return minIndex;
	}

	static void SelectionSort(int[] A) { // Ex 1a Complete the method SelectionSort
		for (int i = 0; i < A.length - 1; i++) {
			int minIndex = i; // Index of smallest remaining value.
			minIndex = findIndexSmallest(A, i, A.length);
			// Complete this method. Note that the method swap is provided.
			swap(A, i, minIndex);
			if (i != minIndex) {
				printArray(A);
			}
		}
	}

	static void InsertionSort(int[] A) { // Ex 1b Complete the method InsertionSort
		for (int i = 1; i < A.length; i++) {
			int temp = A[i];
			for (int j = i - 1; j >= 0 && A[j] > temp; j--) {
				// Complete this method. Note the method swap is provided.
				swap(A, j, j + 1);
				printArray(A);
			}
		}
	}

	private static void RecursiveMergeSort(int[] A) { // Ex3 Complete method RecursiveMergeSort
		int inputLength = A.length;
		if (inputLength < 2)
			return;

		int midIndex = inputLength / 2;
		int[] leftHalf = new int[midIndex];
		int[] rightHalf = new int[inputLength - midIndex];

		for (int i = 0; i < midIndex; i++) {
			leftHalf[i] = A[i];
		}
		for (int i = midIndex; i < inputLength; i++) {
			rightHalf[i - midIndex] = A[i];
		}

		RecursiveMergeSort(leftHalf);
		RecursiveMergeSort(rightHalf);
		merge(A, leftHalf, rightHalf);

	}
	
	private static void merge(int[] A, int[] leftHalf, int[] rightHalf) {
		int leftSize = leftHalf.length;
		int rightSize = rightHalf.length;
		int i = 0, j = 0, k = 0;

		while (i < leftSize && j < rightSize) {
			if (leftHalf[i] < rightHalf[j]) {
				A[k] = leftHalf[i];
				i++;
				k++;
			} else {
				A[k] = rightHalf[j];
				j++;
				k++;
			}
		}
		while (i < leftSize) {
			A[k] = leftHalf[i];
			i++;
			k++;
		}
		while (j < rightSize) {
			A[k] = rightHalf[j];
			j++;
			k++;
		}
	}

	static void RecursiveQuickSort(int[] A, int start, int end) { // Ex4. Complete the method RecursiveQuickSort
		if (start < end) {
			int pivot = A[end];
			int[] L = new int[A.length];
			int[] R = new int[A.length];
			int l_count = 0;
			int r_count = 0;
			for (int i = start; i < end; i++) {
				if (A[i] < pivot) {
					L[l_count] = A[i];
					l_count++;
				} else {
					R[r_count] = A[i];
					r_count++;
				}
			}

			for (int i = 0; i < l_count; i++) {
				A[start + i] = L[i];
			}
			A[l_count + start] = pivot;
			for (int i = 0; i < r_count; i++) {
				A[l_count + start + i + 1] = R[i];
			}
			RecursiveQuickSort(A, start, start + l_count - 1);
			RecursiveQuickSort(A, start + l_count + 1, end);
		}

	}

	public static void main(String[] args) {

//		/**
//		 * The correct answer for a Selection Sort is
//		 * 
//		 * 9 12 89 36 64 22 75 51 45	
//		 * 9 12 22 36 64 89 75 51 45	
//		 * 9 12 22 36 45 89 75 51 64	
//		 * 9 12 22 36 45 51 75 89 64	
//		 * 9 12 22 36 45 51 64 89 75	
//		 * 9 12 22 36 45 51 64 75 89	
//		 */
		System.out.println("Selection Sort");
		int[] A = { 45, 12, 89, 36, 64, 22, 75, 51, 9 };
		printArray(A);
		System.out.println("Your Solution is ");
		SelectionSort(A);

		/**
		 * The correct answer for an Insertion Sort is
		 * 
		 * 12 45 89 36 64 22 75 51 9	
		 * 12 45 36 89 64 22 75 51 9 	
		 * 12 36 45 89 64 22 75 51 9 	
		 * 12 36 45 64 89 22 75 51 9 	
		 * 12 36 45 64 22 89 75 51 9 	
		 * 12 36 45 22 64 89 75 51 9 	
		 * 12 36 22 45 64 89 75 51 9 	
		 * 12 22 36 45 64 89 75 51 9 	
		 * 12 22 36 45 64 75 89 51 9 	
		 * 12 22 36 45 64 75 51 89 9 	
		 * 12 22 36 45 64 51 75 89 9 	
		 * 12 22 36 45 51 64 75 89 9 	
		 * 12 22 36 45 51 64 75 9 89 	
		 * 12 22 36 45 51 64 9 75 89 	
		 * 12 22 36 45 51 9 64 75 89 	
		 * 12 22 36 45 9 51 64 75 89 	
		 * 12 22 36 9 45 51 64 75 89 	
		 * 12 22 9 36 45 51 64 75 89 	
		 * 12 9 22 36 45 51 64 75 89 	
		 * 9 12 22 36 45 51 64 75 89 		
		 */
		System.out.println("\nInsertion Sort");
		int[] B = { 45, 12, 89, 36, 64, 22, 75, 51, 9 };
		printArray(B);
		System.out.println("Your Solution is ");
		InsertionSort(B);

//		/**
//		 * The correct answer for a Merge Sort is
//		 * 
//		 * 9 12 22 36 45 51 64 75 89	
//		 */
		System.out.println("\nMerge Sort");
		int[] C = { 45, 12, 89, 36, 64, 22, 75, 51, 9 };
		printArray(C);
		System.out.println("Your Solution is ");
		RecursiveMergeSort(C);
		printArray(C);

//		/**
//		 * The correct answer for a Quick Sort is
//		 * 
//		 * 9 12 22 36 45 51 64 75 89	
//		 */
		System.out.println("\nQuick Sort");
		int[] D = { 45, 12, 89, 36, 64, 22, 75, 51, 9 };
		printArray(D);
		System.out.println("Your Solution is ");
		RecursiveQuickSort(D, 0, D.length - 1);
		printArray(D);
	}

}
