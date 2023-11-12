/**
 * A generic queue implementation using a singly linked list.
 *
 * @param <T> the type of elements stored in the queue
 */
public class Queue<T> {
	/** The underlying singly linked list for the queue. */
	SList<T> list = new SList<T>();

	/** Default constructor to initialize an empty queue. */
	Queue() {
	}

	/**
	 * Enqueues an element into the queue.
	 *
	 * @param element the element to enqueue
	 */
	void enqueue(T element) {
		list.addLast(element);
		// Exercise 1a
	}

	/**
	 * Dequeues an element from the queue.
	 *
	 * @return the dequeued element
	 */
	T dequeue() {
		return list.removeFirst(); // Exercise 1b
	}

	/**
	 * Gets the element at the front of the queue without removing it.
	 *
	 * @return the element at the front of the queue
	 */
	T queuefront() {
		return list.first.element; // Exercise 1c
	}

	/**
	 * Gets the element at the rear of the queue without removing it.
	 *
	 * @return the element at the rear of the queue
	 */
	T queuerear() {
		return list.last.element; // Exercise 1d
	}

	/**
	 * Checks if the queue is empty.
	 *
	 * @return true if the queue is empty, false otherwise
	 */
	boolean isEmpty() {
		return list.isEmpty();
	}

	/**
	 * Creates a copy of this queue.
	 *
	 * @return a new queue containing the same elements as this queue
	 */
	Queue<T> copyQueue() { // Exercise 2
		Queue<T> Q2 = new Queue<T>();
		Node<T> temp = list.first;
		Q2.enqueue(temp.element);
		while (temp.next != null) {
			Q2.enqueue(temp.next.element);
			temp = temp.next;
		}
		// Add your code here
		return Q2;
	}

	/**
	 * Checks if this queue is identical to another queue in terms of content and
	 * sequence.
	 *
	 * @param Q2 the queue to compare with
	 * @return true if the queues are identical, false otherwise
	 */
	boolean isIdentical(Queue<T> Q2) {
		Node<T> temp = list.first;
		Node<T> temp2 = Q2.list.first;
		if (list.size != Q2.list.size) {
			return false;
		}
		while (temp.next != null && temp2.next != null) {
			if (temp.element != temp2.element) {
				return false;
			}
			temp = temp.next;
			temp2 = temp2.next;
		}
		return true; // Exercise 3
	}

	/**
	 * Prints the elements of the queue horizontally. Handles potential
	 * 
	 */
	void printHorizontal() {
		Node<T> walker = list.first;
		while (walker != null) {
			System.out.print(walker.element + " ");
			walker = walker.next;
		}

	}

}
