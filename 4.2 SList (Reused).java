public class SList<T> {
	int size;
	Node<T> first;
	Node<T> last;

	
	SList() {
		size = 0;
		first = null;
		last = null;
	}

	void addFirst(T element) {
		Node<T> newNode = new Node<T>(element);
		newNode.next = first;
		first = newNode;
		size++;
		if (last == null)
			last = first;
	}

	void addLast(T element) {
		Node<T> newNode = new Node<T>(element);
		last.next = newNode;
		last = newNode;
		size++;
		if (first == null)
			first = last;
	}

	void addAtIndex(int index, T element) {
		if (index == 0) {
			addFirst(element);
		}
		else if (index >= size) {
			addLast(element);
		}
		else {
			Node<T> temp = first;
			for (int i = 0; i < index - 1; i++) {
				temp = temp.next;
			}
			Node<T> newNode = new Node<T>(element);
			newNode.next = temp.next;
			temp.next = newNode;
			size++;
		}
	}

	T removeFirst() {
		if (size == 0)
			return null;
		else {
			Node<T> tmp = first;
			first = first.next;
			size--;
			if (first == null)
				last = null;
			return tmp.element;
		}
	}

	T removeLast() {
		if (size == 0)
			return null;
		else {
			Node<T> temp = first;
			for (int i = 0; i < size - 1; i ++) {
				temp = temp.next;
			}
			temp.next = null;
			last = temp;
			size--;
			if (first == null) {
				last = null;
			}
			return temp.element;
		}
	}

	T removeAtIndex(int index) {
		if (size == 0) {
			return null;
		}
		else if (index == 0) {
			removeFirst();
		}
		else if (index >= size - 1) {
			removeLast();
		}
		else {
			Node<T> temp = first;
			for (int i = 0; i < index - 1; i ++) {
				temp = temp.next;
			}
			Node<T> removed = temp.next;
			temp.next = null;
			temp.next = removed.next;
			removed.next = null;
			size--;
			if (first == null) {
				last = null;
			}
		}
		return null;
	}

	int search(T item) {
		Node<T> temp = first;
		int i = 0;
		while (temp.next != null) {
			if (temp.element == item) {
				return i;
			}
			else {
				temp = temp.next;
				i++;
			}
		}
		return -1;
	}

	boolean isEmpty() {
		if (size == 0)
			return true;
		else
			return false;
	}

	int getSize() {
		return size;
	}

	void printHorizontal() {
		Node<T> walker = first;
		for (int i = 0; i < size; i++) {
			System.out.print(walker.element);
			System.out.print(" ");
			walker = walker.next;
		}
		System.out.println("\n-----");
	}
}
