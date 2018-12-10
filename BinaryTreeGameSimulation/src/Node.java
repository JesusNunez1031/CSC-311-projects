
public class Node {
	int data;
	Node left;
	Node right;

	// Overloaded Constructor
	public Node() {
		left = null;
		right = null;
		data = 0;
	}

	// Overloaded Constructor to allow user to enter score
	public Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
	
	//Method to set value to left node
	public void setLeft(Node n){
		left = n;
	}
	
	//Method to set value to right node
	public void setRight(Node n){
		right = n;
	}

	// Method to get left node
	public Node getLeft() {
		return left;
	}

	// Method to get right node
	public Node getRight() {
		return right;
	}

	// Method to set user defined data(score)
	public void setScore(int score) {
		data = score;
	}

	// Method to get the score from a node
	public int getScore() {
		return data;
	}
}
