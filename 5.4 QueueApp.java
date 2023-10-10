public class QueueApp {
	/**
	 * Checks if a given string represents an integer.
	 *
	 * @param s The string to be checked.
	 * @return True if the string is an integer, false otherwise.
	 */
	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	/**
	 * Checks if the given strings form a prefix expression (operator followed by
	 * two integers).
	 *
	 * @param x The first string.
	 * @param y The second string.
	 * @param z The third string.
	 * @return True if the strings form a prefix expression, false otherwise.
	 */
	static boolean isPrefix(String x, String y, String z) {
		if (!isInteger(x) && isInteger(y) && isInteger(z))
			return true;
		else
			return false;
	}

	/**
	 * Evaluates a binary operation represented by two integers and an operator.
	 *
	 * @param opt The operator ('+', '-', '*', '/', or '%') to perform the
	 *            operation.
	 * @param x   The first operand as a string.
	 * @param y   The second operand as a string.
	 * @return The result of the binary operation as a string, or "can't be
	 *         evaluated" if the operator is invalid or the operands are not valid
	 *         integers.
	 */
	static String evalPrefixString(String opt, String x, String y) {
		if (opt.equals("+"))
			return "" + (Integer.parseInt(x) + Integer.parseInt(y));
		else if (opt.equals("-"))
			return "" + (Integer.parseInt(x) - Integer.parseInt(y));
		else if (opt.equals("*"))
			return "" + Integer.parseInt(x) * Integer.parseInt(y);
		else if (opt.equals("/"))
			return "" + Integer.parseInt(x) / Integer.parseInt(y);
		else if (opt.equals("%"))
			return "" + Integer.parseInt(x) % Integer.parseInt(y);
		else
			return "can't be evaluated";
	}

	/**
	 * Evaluates a prefix expression represented by an array of strings.
	 *
	 * @param input The array of strings representing the prefix expression.
	 * @return The result of the evaluated prefix expression.
	 */
	static String prefixEval(String[] input) {
		Queue<String> Q = new Queue<String>();
		for (int i = 0; i < input.length; i++) {
			Q.enqueue(input[i]);
		}
		while (Q.list.size > 1) {
			Node<String> temp1 = Q.list.first;
			Node<String> temp2 = temp1.next;
			Node<String> temp3 = temp2.next;
			if (isPrefix(temp1.element, temp2.element, temp3.element) == true) {
				Q.enqueue(evalPrefixString(temp1.element, temp2.element, temp3.element));
					for (int i = 0; i < 3; i++) {
						if (temp3.next != null && Q.list.size > 1) {
							Q.dequeue();
						}
					}
			}
			else {
				if (Q.list.size == 3) {
					return "0";
				}
				temp3 = temp3.next;
				temp2 = temp2.next;
				temp1 = temp1.next;
				Q.enqueue(Q.list.first.element);
				Q.dequeue();
			}
		// Exercise 4
		// add your code here
		}	
	return Q.list.first.element;
	}

	/**
	 * Simulates the Round Robin scheduling algorithm with given queues of tasks and
	 * their execution times, and a specified resource limit.
	 *
	 * @param Q           The queue of task execution times.
	 * @param P           The queue of task names.
	 * @param limit       The resource limit.
	 * @param resourceAmt The remaining resource amount.
	 */
	static void makeRoundRobin(Queue<Integer> Q, Queue<String> P, int limit, int resourceAmt) { // Exercise 5
		printRoundRobin(Q, P, resourceAmt);
		while (!Q.isEmpty() && resourceAmt != 0) {
			int temp = Q.dequeue();
			String name = P.dequeue();
			if (limit <= resourceAmt) {
				if (temp >= limit) {
					if (temp - limit != 0) {
						Q.enqueue(temp - limit);
						P.enqueue(name);
					}
					resourceAmt -= limit;
					// add your codes here
					printRoundRobin(Q, P, resourceAmt);
				} else {
					resourceAmt -= temp;
					// add your code here
					printRoundRobin(Q, P, resourceAmt);
				}
			} else {
				if (temp > resourceAmt) {
					Q.enqueue(temp -= resourceAmt);
					P.enqueue(name);
					resourceAmt = 0;
					// add your code here
				} else {
					resourceAmt -= temp;
					// add your code here
				}
				printRoundRobin(Q, P, resourceAmt);
			}
		}
	}

	/**
	 * Prints the Round Robin scheduling status, including remaining resource amount
	 * and tasks.
	 *
	 * @param Q      The queue of task execution times.
	 * @param N      The queue of task names.
	 * @param remain The remaining resource amount.
	 */
	static void printRoundRobin(Queue<Integer> Q, Queue<String> N, int remain) {
		System.out.print(remain + ": ");
		for (int i = 0; i < Q.list.size; i++) {
			String name = N.dequeue();
			Integer need = Q.dequeue();
			System.out.print(name + "-" + need + " ");
			N.enqueue(name);
			Q.enqueue(need);
		}
		System.out.println();
	}

}
