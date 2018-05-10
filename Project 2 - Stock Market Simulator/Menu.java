import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
	Scanner input = new Scanner(System.in);

	ArrayStack<String> myStack = new ArrayStack<String>();
	ArrayStack<Double> myStackPrice = new ArrayStack<>(); //These two price and time stacks are used to get the largest value
	ArrayStack<Integer> myStackTime = new ArrayStack<>(); //and smallest value
	Stock s1 = new Stock();

	//Method to create menu, will run until user inputs value of '7'
	public void exeMenu() throws IOException {
		String fileName = "Values.txt"; //external file to where the program writes and gets last input price
		System.out.println(
				"Enter 1.Registration | 2.Login | 3.Change stock price | 4.Prices list | 5.Highest stock price [NOT WORKING] | 6.Lowest stock price [NOT WORKING] | 7.Exit");
		int choice = input.nextInt();

		//Needed help to read file so used this form as source for my code
		//https://www.mkyong.com/java/how-to-read-file-from-java-bufferedreader-example/
		//try catch statement to read from file and get last input stock price
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		String sCurrentLine;
		
		try {

			while ((sCurrentLine = br.readLine()) != null) {
				//set the stock price to the value in file, last input value from previous execution, and push it onto current stack
				double value = Double.parseDouble(sCurrentLine); //parse String line from file to double so that method parameters accept value
				s1.setStockPrice(value);
				s1.setStockTimeDefault();
				myStack.push(s1.getStockInfo());
			}
			// Error checking
		} catch (IOException e) {

			e.printStackTrace();
		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
	
		//Menu loop, user can exit the loop by either entering a value of -1 or choice 7
		while (choice != -1) {
			//Choice 1 register a user
			if (choice == 1) {
				s1.register();
				myStack.push(s1.getStockInfo());
				myStackPrice.push(s1.getStockPrice());
				myStackTime.push(s1.getStockTime());
				choice = input.nextInt();
				
			//Choice 2 is to allow user to login
			} else if (choice == 2) {
				s1.login();
				choice = input.nextInt();
				
			//Choice 3 to add new stock price and time to stack
			} else if (choice == 3) {
				System.out.println("Enter new price and time of stock");
				s1.setStockPrice();
				s1.setStockTime();
				
				//Use these two other stack for choices where we get largest and smallest value
				myStackPrice.push(s1.getStockPrice());
				myStackTime.push(s1.getStockTime());
				
				//push info onto the main stack
				myStack.push(s1.getStockInfo());
				System.out.println("Current log of changes:");
				myStack.display();
				//myStackPrice.display();
				choice = input.nextInt();
				
			//Choice 4 display's all values in reverse order from most recent to oldest
			} else if (choice == 4) {
				System.out.println("Now displaying current log of changes staring with most recent input:");
				//Here we pop the values onto an array and then we print the array
				String array[] = new String[myStack.StackSize()];
				for (int i = 0; i < array.length; i++) {
					array[i] = myStack.pop();
					System.out.print(array[i] + " | ");
				}
				choice = input.nextInt();
				
			/*//Choice 5 to get the largest price in stack [[[[NEEDS WORK]]]]
			//Giving null pointer error
			} else if (choice == 5){
				double array[] = new double[myStackPrice.StackSize()];
				double largest = 0;
				for(int i = 0; i < array.length; i++) {
					array[i] = myStackPrice.pop();
					if(array[i] > largest){
						largest = array[i];
					}
				}
				System.out.println("Largest value: " + largest);
				choice = input.nextInt();
				
			//Choice 5 to get the smallest price in stack [[[[NEEDS WORK]]]]
			}else if (choice == 6){
				double array[] = new double[myStackPrice.StackSize()];
				double small = 1000;
				for(int i = 0; i < array.length; i++) {
					array[i] = myStackPrice.pop();
					if(array[i] < small){
						small = array[i];
					}
				}
				System.out.println("Smallest value: " + small);
				choice = input.nextInt();*/
				
			//Exits the program and saves the very last price onto external file
			}else if (choice == 7) {
				try {
					FileWriter fileWriter = new FileWriter(fileName);
					BufferedWriter writer = new BufferedWriter(fileWriter);
					/*double finalVal = s1.getStockPrice();
					writer.write((int) finalVal);*/
					writer.write(s1.getStockPriceStr());
					writer.close();
					System.exit(0);
				} catch (IOException ex) {
					System.out.println("Error writing to file '" + fileName + "'");
				}
			}
		}
	}
}
