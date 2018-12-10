//Help to implement Binary Tree class obtained from:
//http://algorithms.tutorialhorizon.com/binary-search-tree-complete-implementation/

public class BinaryTree {
	private Node root; // Node object

	// Overloaded constructor
	public BinaryTree() {
		this.root = null;
	}

	// Method to get root
	public Node getRoot() {
		return root;
	}

	// Method to check if tree is empty
	public boolean isEmpty() {
		if (root == null) {
			return true;
		} else
			return false;
	}

	// Method to insert score to tree
	public void insert(int score) {
		Node newNode = new Node(score);
		if (root == null) {
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = null;
		while (true) {
			parent = current;
			if (score < current.data) {
				current = current.left;
				if (current == null) {
					parent.left = newNode;
					return;
				}
			} else {
				current = current.right;
				if (current == null) {
					parent.right = newNode;
					return;
				}
			}
		}
	}

	// Methods to search for a value
	public boolean search(Node n, int value) {
		if (n.getScore() == value)
			return true;
		if (n.getLeft() != null)
			if (search(n.getLeft(), value))
				return true;
		if (n.getRight() != null)
			if (search(n.getRight(), value))
				return true;
		return false;
	}

	public boolean search(int val) {
		return search(root, val);
	}

	// unused search method
	/*public boolean search(int value) {
		Node current = root;
		while (current != root) {
			if (current.data == value) {
				return true;
			} else if (current.data > value) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return false;
	}*/

	public Node getMin(Node n) {
		// start at the root of the tree
		Node st = n;

		// go to node farthest to the left
		while (st.getLeft() != null) {
			// move to left child
			st = st.getLeft();
		}
		return st;
	}

	// Methods to delete given node
	public Node delete(Node n, int value) {
		// Check if tree is empty
		if (n == null) {
			return null;
		}
		// Check for desired value in left subtree
		if (value < n.getScore()) {
			// make a call to the function on the left subtree
			n.setLeft(delete(n.getLeft(), value));
		}
		// Check for desired value in right sub tree
		else if (value > n.getScore()) {
			// make a call to the function on the right subtree
			n.setRight(delete(n.getRight(), value));
		}
		// if node we want is found
		else {
			// Left child not present
			if (n.getLeft() == null) {
				return n.getRight();
			}
			// Right child not present
			else if (n.getRight() == null) {
				return n.getLeft();
			}
			// if no child is present get the node with the minimum value
			Node obj = getMin(n.getRight());

			// The value of inorder successor will become this value
			n.setScore(obj.getScore());

			// remove inorder successor
			n.setRight(delete(n.getRight(), obj.getScore()));
		}
		return n;
	}

	Node deleteValue(int value) {
		return delete(root, value);
	}

	// Method to print the top 10 scores using an inorder traversal
	public void printTop10() {
		int[] array = new int[1];
		inorder(root, array);
	}

	// Method to do inorder traversal
	public void inorder(Node n, int[] array) {
		if (n != null) {
			inorder(n.getRight(), array);

			// prints only 10 elements
			if (array[0] < 10) {
				System.out.println(n.getScore() + " ");
				array[0]++;
			}
			inorder(n.getLeft(), array);
		}
	}
}
