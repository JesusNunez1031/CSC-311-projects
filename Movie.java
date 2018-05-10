
import java.util.Random;
import java.util.Scanner;

public class Movie {
	Scanner input = new Scanner(System.in);
	public int Year;
	public float rating;
	public int runTime;
	public String genre;
	public String name;

	// Normal Constructor
	public Movie() {
		this.name = "name";
		this.Year = 2017;
		this.runTime = 200;
		this.genre = "Action";
		this.rating = (float) 10.0;
	}

	// Constructor with values
	public Movie(String name, int Year, int runTime, String genre, float rating) {
		this.name = name;
		this.Year = Year;
		this.runTime = runTime;
		this.genre = genre;
		this.rating = rating;
	}

	// Sets a name to an object by randomly selecting an index
	public void setName() {
		Random random = new Random();
		String[] name = { "Movie1", "Movie2", "Movie3", "Movie4", "Movie5", "Movie6", "Movie7", "Movie8", "Movie9",
				"Movie10", "Movie11", "Movie12", "Movie13", "Movie14", "Movie15", "Movie16", "Movie17", "Movie18",
				"Movie19", "Movie20", "Movie21", "Movie22", "Movie23", "Movie24", "Movie25", "Movie26", "Movie27",
				"Movie28", "Movie29", "Movie30", "Movie31", "Movie32", "Movie33", "Movie34", "Movie35", "Movie36",
				"Movie37", "Movie38", "Movie39", "Movie40", "Movie41", "Movie42", "Movie43", "Movie44", "Movie45",
				"Movie46", "Movie47", "Movie48", "Movie49", "Movie50", "Movie51", "Movie52", "Movie53", "Movie54",
				"Movie55", "Movie56", "Movie57", "Movie58", "Movie59", "Movie60", "Movie61", "Movie62", "Movie63",
				"Movie64", "Movie65", "Movie66", "Movie67", "Movie68", "Movie69", "Movie70", "Movie71", "Movie72",
				"Movie73", "Movie74", "Movie75", "Movie76", "Movie77", "Movie78", "Movie79", "Movie80", "Movie91",
				"Movie92", "Movie93", "Movie94", "Movie95", "Movie96", "Movie97", "Movie98", "Movie99", "Movie100",
				"Movie101", "Movie102", "Movie103", "Movie104", "Movie105", "Movie106", "Movie107", "Movie108",
				"Movie109", "Movie110", "Movie111", "Movie112", "Movie113", "Movie114", "Movie115", "Movie116",
				"Movie117", "Movie118", "Movie119", "Movie120", "Movie121", "Movie122", "Movie123", "Movie124",
				"Movie125", "Movie126", "Movie127", "Movie128", "Movie129", "Movie130", };
		int index = random.nextInt(name.length);
		this.name = name[index];
	}

	// Returns the name of a movie
	public String getName() {
		return this.name;
	}

	// allows user to input the value of name
	public void setNameByUser() {
		System.out.println("Enter desired name:");
		this.name = input.nextLine();
	}

	// Returns a random genre by selecting a random index
	public void setGenre() {
		Random random = new Random();
		String[] genre = { "Comedy", "Drama", "Action", "Sci-Fi", "Documentary" };
		int index = random.nextInt(genre.length);
		this.genre = genre[index];
	}

	// Returns the current genre
	public String getGenre() {
		return this.genre;
	}

	// Allows user to set the value of the genre
	public void setGenreByUser() {
		System.out.println("Enter desired genre:");
		this.genre = input.nextLine();
	}

	// Sets the rating at random
	public void setRating() {
		Random rand = new Random();
		this.rating = (float) (rand.nextFloat() * (10.0 - 0.1) + .1);
		/*DecimalFormat numberFormat = new DecimalFormat("#.00");
		numberFormat.format(this.rating);
		My method returns a float number with too many significant figures so using the above code fixes it
		but it forces the return as string so its unusable*/
		Math.floor(this.rating);
		// return this.rating;

	}

	// Returns the value of rating
	public Float getRating() {
		return this.rating;
	}

	// Allows the user to set the value of rating
	public void setRatingByUser() {
		System.out.println("Enter desired rating:");
		this.rating = (float) input.nextDouble();
	}

	// Sets the year randomly
	public void setYear() {
		Random rand2 = new Random();
		this.Year = rand2.nextInt((2017 - 1920) + 1) + 1920;
		// this.Year;
	}

	// Returns the value of Year
	public int getYear() {
		return this.Year;
	}

	// Allows the user to input the value of year
	public void setYearByUser() {
		System.out.println("Enter desired year:");
		this.Year = input.nextInt();
	}

	// Sets a random value of run time
	public void setRunTime() {
		Random rand3 = new Random();
		this.runTime = rand3.nextInt((200 - 60) + 1) + 60;
		// this.runTime;
	}

	// Returns the value of run time
	public int getRunTime() {
		return this.runTime;
	}

	// Allows user to set the run time
	public void setRunTimeByUser() {
		System.out.println("Enter desired run time:");
		this.runTime = input.nextInt();
	}

	// Displays all values of any given array that uses the method
	public void display(Movie[] movies) {
		for (int i = 0; i < movies.length-5; i++) {
			System.out.println(movies[i].getName() + ": " + movies[i].getYear() + " " + movies[i].getRunTime() + "min "
					+ movies[i].getGenre() + " " + " Rating:" + movies[i].getRating());

		}
	}

}
