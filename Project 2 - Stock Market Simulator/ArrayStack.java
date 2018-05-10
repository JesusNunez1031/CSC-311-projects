public class ArrayStack<E> implements BareBonesStack<E> {

	private E[] theData; // Storage for the stack
	private int topOfStack = -1; // Top of stack, indicating nothing is there
	private static final int INITIAL_CAPACITY = 10; // Default capacity

	// default constructor, creates a stack of default capacity
	public ArrayStack() {
		this.theData = (E[]) new Object[INITIAL_CAPACITY];
	}

	// Overloaded constructor creates the stack of user defined size
	public ArrayStack(int size) {
		this.theData = (E[]) new Object[size];
	}

	@Override
	public E push(E obj) {
		// this method adds elements to the stack if there is space
		// first check if the array(stack) is full
		if (this.topOfStack == this.theData.length - 1) {
			System.out.println("Stack Overflow!");
			// can also call reallocate() method, and do similar [Similar to
			// ArrayList]
			return null;

		}
		// else, there is space on the stack, insert the data
		topOfStack++;
		this.theData[topOfStack] = obj;
		return obj;
		// return this.theData[++topOfStack] = obj;
	}

	@Override
	public E pop() {
		// This method removes the element from the top of stack
		// Make sure the stack is not empty
		if (this.empty()) {
			System.out.println("Stack Underflow");
			return null;
		}
		//
		return this.theData[topOfStack--];
	}

	@Override
	public E peek() {
		// look at the top value of the stack but don't remove
		if (this.empty()) { // if theres nothing on the stack
			System.out.println("Stack Empty!");
			return null;
		}
		return this.theData[topOfStack]; // Return the top element
	}

	@Override
	public boolean empty() {
		// check if the array is empty
		return (this.topOfStack == -1);
	}

	// Display the elements of the stack
	public void display() {
		// System.out.print("Stack: ");
		for (int i = 0; i <= topOfStack; i++) {
			System.out.print(this.theData[i] + " | ");
		}
		System.out.println();

	}

	public int StackSize() {
		return this.theData.length;
	}

}