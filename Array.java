/**
 * The Array class represents a dynamic array that can store integers. It
 * provides methods for adding, removing, and accessing elements in the array.
 */
public class Array {
	final int size;
	int[] A;
	int load = 0;
	/*
	 * Constructs a new Array with the specified maximum size.
	 * @param n The maximum size of the array.
	 */
	Array(int n) {
		size = n;
		A = new int[size];
	}

	/*
	 * Adds an element to the beginning of the array. In summary, it start from the
	 * last element and shift elements to the right. Then, it increment the load
	 * count, and place the new element at the beginning.
	 * @param e The element to be added.
	 */
	void addFirst(int e) { // Ex3 a
		int i;
		int[] B = new int[A.length];
		B[0] = e;
		for (i = 0; i < size - 1; i += 1) {
			B[i + 1] = A[i];
		}
		load += 1;
		A = B;
	}

	/*
	 * Adds an element to the end of the array.
	 * @param e The element to add.
	 */
	void addLast(int e) { // Ex3 b
		A[load] = e;
		load += 1;
	}

	/*
	 * Adds an element at a specified index in the array.
	 * @param e     The element to add.
	 * @param index The index at which to add the element.
	 */
	void addAtIndex(int e, int index) { // Ex3 c
		int i;
		int[] B = new int[A.length];
		for (i = 0; i < index; i += 1) {
			B[i] = A[i];
		}
		B[index] = e;
		for (i = index; i < size - 1; i += 1) {
			B[i + 1] = A[i];
		}
		load += 1;
		A = B;
	}

	/*
	 * Removes the first element from the array and returns it.
	 * @return The removed element, or 0 if the array is empty.
	 */
	void removeFirst() { // Ex4 a
		int i;
		int[] B = new int[A.length];
		for (i = 0; i < size - 1; i += 1) {
			B[i] = A[i + 1];
		}
		load -= 1;
		A = B;
	}

	/*
	 * Removes the last element from the array and returns it.
	 * @return The removed element, or 0 if the array is empty.
	 */
	void removeLast() { // Ex4 b
		A[load] = 0;
		load -= 1;
	}

	/*
	 * Removes an element at a specified index from the array and returns it.
	 * @param index The index of the element to remove.
	 * @return The removed element, or 0 if the array is empty.
	 */
	void removeAtIndex(int index) { // Ex4 c
		int i;
		int[] B = new int[A.length];
		for (i = 0; i < index; i += 1) {
			B[i] = A[i];
		}
		B[index] = 0;
		for (i = index; i < size - 1; i += 1) {
			B[i] = A[i + 1];
		}
		load -= 1;
		A = B;
	}

	/*
	 * Gets the element at a specified index in the array.
	 * @param index The index of the element to retrieve.
	 * @return The element at the specified index.
	 */
	int getElementAtIndex(int index) { // Ex5 a
		return A[index];
	}

	/*
	 * Sets the element at a specified index in the array to a new value.
	 * @param val   The new value to set.
	 * @param index The index at which to set the new value.
	 */
	void setElementAtIndex(int val, int index) { // Ex5 b
		A[index] = val;
	}

	/*
	 * Prints the elements in the array and the current load.
	 */
	void printArray() {
		for (int i = 0; i < load; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println("\nArray load is " + load);
	}

	public static void main(String[] args) {
		Array A = new Array(10);

		// Uncomment this section to test Ex3 a

		A.addFirst(9);
		A.addFirst(1);
		A.addFirst(4);
		System.out.println("After addFirst 9, 1, and 4 to A");
		System.out.println("Your Answer is");
		A.printArray();
		System.out.println("Correct Answer is\n4 1 9 \nArray load is 3");

		// Uncomment this section to test Ex3 b
		System.out.println("----------------------------------");
		A.addLast(2);
		A.addLast(5);
		A.addLast(8);
		System.out.println("After addLast 2, 5, and 8 to A");
		System.out.println("Your Answer is");
		A.printArray();
		System.out.println("Correct Answer is\n4 1 9 2 5 8 \nArray load is 6");

		// Uncomment this section to test Ex3 c

		System.out.println("----------------------------------");
		A.addAtIndex(6, 2);
		A.addAtIndex(3, 4);
		System.out.println("After add 6 at index 2, and add 3 at index 4 to A ");
		System.out.println("Your Answer is");
		A.printArray();
		System.out.println("Correct Answer is\n4 1 6 9 3 2 5 8 \nArray load is 8");

		// Uncomment this section to test Ex4 a

		System.out.println("----------------------------------");
		A.removeFirst();
		A.removeFirst();
		System.out.println("After removeFirst twice ");
		System.out.println("Your Answer is");
		A.printArray();
		System.out.println("Correct Answer is\n6 9 3 2 5 8 \nArray load is 6");

		// Uncomment this section to test Ex4 b

		System.out.println("----------------------------------");
		A.removeLast();
		A.removeLast();
		System.out.println("After removeLast twice ");
		System.out.println("Your Answer is");
		A.printArray();
		System.out.println("Correct Answer is\n6 9 3 2 \nArray load is 4");

		// Uncomment this section to test Ex4 c

		System.out.println("----------------------------------");
		A.removeAtIndex(1);
		A.removeAtIndex(1);
		System.out.println("After removeAtIndex 1 twice ");
		System.out.println("Your Answer is");
		A.printArray();
		System.out.println("Correct Answer is\n6 2 \nArray load is 2");

		// Uncomment this section to test Ex5 a

		System.out.println("----------------------------------");
		A.setElementAtIndex(7, 1);
		System.out.println("After set value at index 1 to 7 ");
		System.out.println("Your Answer is");
		A.printArray();
		System.out.println("Correct Answer is\n6 7 \nArray load is 2");

		// Uncomment this section to test Ex5 b

		System.out.println("----------------------------------");
		System.out.println("Your Answer is");
		System.out.println("Value at A[1]= " + A.getElementAtIndex(1));
		System.out.println("Correct Answer is\nValue at A[1]= 7");

	}

}
