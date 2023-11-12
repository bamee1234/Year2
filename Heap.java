/**
 * The `Heap` class represents a simple heap data structure.
 * A heap is a specialized tree-based data structure that satisfies the heap property.
 * In this implementation, the heap is represented as an array.
 * The class provides methods for insertion, deletion, and heap sort.
 *
 */
public class Heap {
	
	/** The current number of elements in the heap. */
	int load = 0;
	
	/** The array representing the heap. */
	int[] hArray = new int[100];

	/**
     * Constructs an empty heap.
     */
	Heap() {
	}

	/**
     * Performs the reheapUp operation to maintain the heap property after insertion.
     *
     * @param currentIndex The index of the current element.
     */
	void reheapUp(int currentIndex) {
		 // Exercise 1
		//  add your code here
		int i = currentIndex;
		int parent = Math.floorDiv(i - 1, 2);
		while (hArray[i] > hArray[parent]) {
			swap(hArray, i, parent);
			i = Math.floorDiv(i - 1, 2);
			parent = Math.floorDiv(i - 1, 2);
			if (parent < 0) {
				break;
			}
		}
	}

	/**
     * Inserts a new element into the heap and performs the necessary reheapUp operation.
     *
     * @param data The data to be inserted into the heap.
     */
	void insert(int data) {
		// Exercise 2
		// add your code here
		hArray[load] = data;
		if (load > 0) {
			reheapUp(load);
		}
		load++;
	}

	 /**
     * Performs the reheapDown operation to maintain the heap property after deletion.
     *
     * @param currentIndex The index of the current element.
     */
	void reheapDown(int currentIndex) {
		// Exercise 3
		// add your code here
		int i = currentIndex;
		int leftChild = i * 2 + 1;
		int rightChild = i * 2 + 2;
		while ((hArray[i] < hArray[leftChild] || hArray[i] < hArray[rightChild]) && (leftChild < load - 1 || rightChild < load - 1)) {
			// System.out.println(i);
			// System.out.println(leftChild);
			// System.out.println(rightChild);
			// System.out.println("\n");
			if (hArray[leftChild] >= hArray[rightChild]) {
				swap(hArray, i, leftChild);
				i = leftChild;
				leftChild = i * 2 + 1;
				rightChild = i * 2 + 2;
			}
			else {
				swap(hArray, i, rightChild);
				i = rightChild;
				leftChild = i * 2 + 1;
				rightChild = i * 2 + 2;
			}
			// System.out.println(i);
			// System.out.println(leftChild);
			// System.out.println(rightChild);
			// System.out.println("\n");
		}
		printHeapArray();
	}

	/**
     * Deletes the root element of the heap and performs the necessary reheapDown operation.
     *
     * @return The value of the root element that was deleted.
     */
	int deleteRoot() {
		// Exercise 4
		// add your code here
		swap(hArray, 0, load - 1);
		printHeapArray();
		hArray[load - 1] = 0;
		load--;
		printHeapArray();
		reheapDown(0);
		return -1;
	}

	/**
     * Sorts the heap in ascending order.
     */
	void makeHeapSort() {
		// Exercise 5
		// add your code here
		for (int i = 0; i < load; i++) {
			int max = hArray[i];
			int maxindex = i;
			for (int j = i + 1; j < load; j++) {
				if (hArray[j] > max) {
					max = hArray[j];
					maxindex = j;
				}
			}
			if (hArray[i] != max) {
				swap(hArray, i, maxindex);
			}
		}
	}

	/**
     * Finds the level of a given node in the heap.
     *
     * @param nodeIndex The index of the node.
     * @return The level of the node in the heap.
     */
	int findLevel(int nodeindex) {
		int parent = (nodeindex - 1) / 2;
		int level = 0;

		if (parent > 0)
			level++;

		while (parent > 0) {
			parent = (parent - 1) / 2;
			level++;
		}
		return level;
	}

	/**
     * Swaps two elements in the heap array.
     *
     * @param A The heap array.
     * @param ind1 The index of the first element to be swapped.
     * @param ind2 The index of the second element to be swapped.
     */
	void swap(int[] A, int ind1, int ind2) {
		int temp = A[ind1];
		A[ind1] = A[ind2];
		A[ind2] = temp;
	}

	/**
     * Prints the elements of the heap array.
     */
	void printHeapArray() {
		for (int i = 0; i < load; i++)
			System.out.print(hArray[i] + " ");
		System.out.println();
	}

}