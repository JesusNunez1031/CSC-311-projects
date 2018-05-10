import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Stock {
	//Initialize default values
	Scanner user_input = new Scanner(System.in);
	String buisnessName;
	double stockPrice;
	int time;
	String userID;
	String password;
	//Using a HashMap to store the users login info while the program is running
	//Primarily for the registration portion of the code
	//concept obtained from:
	//https://stackoverflow.com/questions/5155952/sorting-a-list-of-mapstring-string
	Map<String, String> loginInfo = new HashMap();

	//Default constructor
	public Stock() {
		buisnessName = "";
		stockPrice = 0;
		time = 0;
		userID = "";
		password = "";

	}
	
	//User defined constructor(Overloaded)
	public Stock(double price, int time, String id, String pass) {
		this.stockPrice = price;
		this.time = time;
		this.userID = id;
		this.password = pass;

	}

	//Method to set the name of the business
	public void setBuisnessName() {
		System.out.println("Enter Business Name:");
		this.buisnessName = user_input.nextLine();
	}

	//Method to set the password, includes error checking using recursion
	public void setPassword() {
		System.out.println("Enter desired password (Must be a minimum of 8 characters long):");
		this.password = user_input.nextLine();
		//If password is not 8 or more characters prompt error and call the method again
		if (this.password.length() >= 8) {
			System.out.println("***Accepted password***");
		} else {
			System.out.println("Password not long enough, please input new password:");
			setPassword();
		}
	}

	//Method to set the userID
	public void setUserID() {
		System.out.println("Enter unique ID for login:");
		int count = 0;
		//If user can't provide an accepted ID after 2 tries then the method generates default ID
		for (int k = 1; k <= 2; k++) {
			this.userID = user_input.nextLine();
			if(this.userID.length() >= 8){
				System.out.println("***Accepted ID***");
				break;
			}else
			count++;
		}

		if (userID.isEmpty() & count == 2) {
			int b = (int) Math.floor(Math.random() * 10000);
			userID = buisnessName.substring(0, 4) + b; //Uses the name of the business to generate default ID
			loginInfo.put(userID, password); //Stores the password and the userID in Map after successful registration
		}
	}

	//Method to allow user to register an account, calls other methods to allow user to provide login info
	public void register() {
		setBuisnessName();
		setUserID();
		setPassword();
		setStockPrice();

		System.out.println("Registration successful, please note down ID and Password");
		System.out.println("Login details:" + getLoginInfo());
	}
	
	//Once registration is complete, allows user to login and gets info from HashMap, if info doesn't match, call method again
	public void login() {
		System.out.println("Enter userID:");
		String id = user_input.next();
		System.out.println("Enter password:");
		String pass = user_input.next();
		if (id.equals(getUserID()) & pass.equals(getPassword())) {
			System.out.println("Login successful," + " welcome back " + getUserID());
			System.out.println("Buisness name: " + getBuisnessName() + " | " + " Stock price: " + getStockPrice());
		}
		else {
			System.out.println("Error, entered ID or password is incorrect, please try again.");
			login();
		}
	}

	//Method to get Business Name
	public String getBuisnessName() {
		return this.buisnessName;
	}

	//Method to set the price of the Stock
	public void setStockPrice() {
		System.out.println("Enter price of Stock:");
		this.stockPrice = user_input.nextDouble();

	}
	
	//Method to set Stock price my user
	public void setStockPrice(double value){
		this.stockPrice = value;
	}

	//Method to set the time of the stock
	public void setStockTime() {
		System.out.println("Enter the time in military time, e.g(10:00am --> 1000):");
		this.time = user_input.nextInt();
	}
	
	//Method to set the Time of stock to open time, 10am
	public void setStockTimeDefault() {
		this.time = 1000;
	}

	//Method to get the price of the Stock
	public double getStockPrice() {
		return this.stockPrice;

	}

	//Method to get the Stock time
	public int getStockTime() {
		return this.time;
	}

	// Method to get the password
	public String getPassword() {
		return this.password;
	}

	// Method to get the userID
	public String getUserID() {
		return this.userID;
	}

	public String getStockPriceStr() {
		String p = ("" + getStockPrice());
		return p;
	}

	// Method to get both stock Price and Time to allow to push them both on a
	// stack [as a string]
	public String getStockInfo() {
		String info = ("Price: " + getStockPrice() + " Time: " + getStockTime());
		return info;
	}

	// Method to get users login info
	public String getLoginInfo() {
		String data = (" ID: " + getUserID() + " | " + " Password: " + getPassword());
		return data;
	}

}
