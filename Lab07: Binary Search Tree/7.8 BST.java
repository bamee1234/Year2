public class BST<T extends Comparable<T>> extends BT<T> {
	/** Create an empty binary tree */
	public BST() {

	}

	/** Create a binary tree from an object */
	public BST(T object) {
		root.element = object;
	}

	/** Create a binary tree from an array of objects */
	public BST(T[] objects) {
		for (int i = 0; i < objects.length; i++)
			insert(objects[i]);
	}

	// ----------------------------------------------
	/**
	 * Insert newdata into the binary search tree
	 */
	public void insert(T newdata) {
		// Ex1: Complete this program
		if (root == null) {
			root = new BTNode<>(newdata);
		} else {
			// Locate the parent node
			BTNode<T> parent = null;
			BTNode<T> current = root;
			// insert your code
			while (current != null) {
				if (newdata.compareTo(current.element) < 0) {
					parent = current;
					current = current.left;
				}
				else if (newdata.compareTo(current.element) > 0) {
					parent = current;
					current = current.right;
				}
			}
			if (newdata.compareTo(parent.element) < 0) {
				parent.left = new BTNode<>(newdata);
			}
			else if (newdata.compareTo(parent.element) > 0) {
				parent.right = new BTNode<>(newdata);
			}
		}

		size++;
	}

	// ----------------------------------------------
	/**
	 * Delete data from the binary search tree
	 */
	// Ex2. Complete This Program
	public T delete(T item) {
		// Locate the node to be deleted and also locate its parent node
		BTNode<T> parent = null;
		BTNode<T> current = root;

		boolean currentIsLeftChild = true;

		while (current != null) {
			if (item.compareTo(current.element) < 0) {
				parent = current;
				current = current.left;
				currentIsLeftChild = true;
			}
			else if (item.compareTo(current.element) > 0) {
				parent = current;
				current = current.right;
				currentIsLeftChild = false;
			}
			else {
				break;
			}
		}

		// Case 0: item is not in the tree
		if (current == null) {
			return null;
		}

		T temp = current.element;
		// Case 1: current is the leave

		if (current.left == null && current.right == null) {
			// insert your code
			if (parent == null) {
				root = null;
			}
			else {
				if (currentIsLeftChild) {
					parent.left = null;
				}
				else {
					parent.right = null;
				}
			}
		}

		// Case 2: If the deleted node has one child
		// Case 2.1: if its child node is on the right
		if ((current.left == null)) { // If only has one right child or no children.
			if (parent == null) {
				root = current.right;
			}
			else {
				if (currentIsLeftChild) {
					parent.left = current.right;
					current.right = null;
				} else {
					parent.right = current.left;
					current.left = null;
				}
			}
		}
		// Case 2.2: If its child node is on the left
		else if ((current.right == null)) { // Only one left child
			if (currentIsLeftChild) {
				parent.left = current.left;
				current.left = null;
			} else {
				parent.right = current.left;
				current.left = null;
			}
		} else { // Case 3: Have both children
			BTNode<T> maxleft = current.left;
			BTNode<T> maxleftParent = current;
			while (maxleft.right != null) {
				maxleftParent = maxleft;
				maxleft = maxleft.right;
			}
			current.element = maxleft.element;
			if (maxleft.left == null && maxleft.right == null) { // Case 3.1 if maxleft is a leave, then ..
				root.element = maxleft.element;
				maxleftParent.right = null;
			} 
			else if (maxleft.left != null) { // Case 3.2 if maxleft has a left child, then .
				root.element = maxleft.element;
				maxleftParent.right = maxleft.left;
				maxleft.left = null;
			} 
			else if (maxleftParent == current) { // Case 3.3 if maxleft is leftchild of current, then ..
				root.element = maxleft.element;
				maxleftParent.left = null;
			}
		}
		size--;
		return temp;
	}
	// ---------------------------------------------------------

	// Search for the data returns true if it finds the data or otherwise false
	public boolean search(T data) { 
		// Ex 3: Complete this section.
		
		//replace the following line with your code
		BTNode<T> parent = null;
		BTNode<T> current = root;

		while (current != null) {
			if (data.compareTo(current.element) < 0) {
				parent = current;
				current = current.left;
			}
			else if (data.compareTo(current.element) > 0) {
				parent = current;
				current = current.right;
			}
			else {
				return true;
			}
		}
		return false;
	}

	// ---------------------------------------------------------

	BTNode<T> findSmallest() {
		return findSmallest(root);
	}

	// ----------------------------------------------
	BTNode<T> findSmallest(BTNode<T> start) {
		// Ex 4: Complete this section.
		BTNode<T> parent = null;
		BTNode<T> current = root;
		if (current.left == null) {
			return current;
		}
		else {
			while (current != null) {
				parent = current;
				current = current.left;
			}
		}
		return parent;
	}

	// ----------------------------------------------
	BTNode<T> findLargest() {
		return findLargest(root);
	}

	// ----------------------------------------------
	BTNode<T> findLargest(BTNode<T> start) { 
		// Ex 5: Complete this section.
		
		BTNode<T> parent = null;
		BTNode<T> current = root;
		if (current.right == null) {
			return current;
		}
		else {
			while (current != null) {
				parent = current;
				current = current.right;
			}
		}
		return parent;
	}

	/** Get the number of nodes in the tree */
	public int getSize() {
		return size;
	}

	/** Returns the root of the tree */
	public BTNode getRoot() {
		return root;
	}

	/** Returns a path from the root leading to the specified element */
	public java.util.ArrayList<BTNode<T>> path(T e) {
		java.util.ArrayList<BTNode<T>> list = new java.util.ArrayList<BTNode<T>>();
		BTNode<T> current = root; // Start from the root

		while (current != null) {
			list.add(current); // Add the node to the list
			if (e.compareTo(current.element) < 0) {
				current = current.left;
			} else if (e.compareTo(current.element) > 0) {
				current = current.right;
			} else
				break;
		}

		return list; // Return an array of nodes
	}

}
