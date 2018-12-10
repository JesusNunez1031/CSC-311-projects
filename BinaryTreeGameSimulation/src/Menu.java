import java.util.Random;
import java.util.Scanner;

public class Menu {
	Scanner user_input = new Scanner(System.in);
	BinaryTree tree = new BinaryTree();
	Random rand = new Random();

	public void Simulation() {

		while (true) {
			System.out.println("Enter one of the following options:");
			System.out.println("1. Play game and generate scores");
			System.out.println("2. Display top 10 scores");
			System.out.println("3. Search a Score");
			System.out.println("4. Delete a Score");
			System.out.println("5. Quit");

			int choice = user_input.nextInt();
			//if user selects 1, inputs 25 random score onto tree
			if(choice == 1){
				// insert values into the tree
				for (int i = 0; i < 25; i++) {
					tree.insert(rand.nextInt(101));
				}
				System.out.println("Scores generated!");
			}
			
			//if user selects 2, displays top 10 scores
			if (choice == 2) {
				System.out.println("Top 10 Scores: ");
				tree.printTop10();
				
			//if user selects 3, search for a provided score and see if its in the tree
			} else if (choice == 3) {
				System.out.println("Enter the score you wish to search for: ");
				int value = user_input.nextInt();
				if (tree.search(value) == true) {
					System.out.println(value + " is present!");
				} else
					System.out.println(value + " is not present.");
				
			//if user selects 4, delete given value
			} else if (choice == 4) {
				System.out.println("Enter a score you wish to delete:");
				int value = user_input.nextInt();
				tree.deleteValue(value);
				
			//Exits program
			} else if (choice == 5) {
				System.exit(0);
			}
		}
	}
}
