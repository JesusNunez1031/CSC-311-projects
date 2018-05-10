
public class movieSorting {

	//Using Bubble sort, sorts the array by the value of Year
	//Basic bubble sort algorithim found on Stackoverflow.com -->
	//link: https://stackoverflow.com/questions/9949817/bubble-sorting-an-object-array-in-java
	public void displaySortedByYear(Movie[] movies) {
		for (int i = 0; i < movies.length-5; i++) {
			for (int j = 1; j < movies.length - i-5; j++) {
				if ((movies[j - 1].getYear() > movies[j].getYear())) {
					// Swap temp and movies[i]
					Movie temp = movies[j - 1];
					movies[j - 1] = movies[j];
					movies[j] = temp;
				}
			}

		}

	}

	//Using Bubble sort, sorts the array by value of run time
	public void displaySortedByRunTime(Movie[] movies) {
		for (int i = 0; i < movies.length-5; i++) {
			for (int j = 1; j < movies.length - i-5; j++) {
				if ((movies[j - 1].getRunTime() > movies[j].getRunTime())) {
					// Swap temp and movies[i]
					Movie temp = movies[j - 1];
					movies[j - 1] = movies[j];
					movies[j] = temp;
				}
			}

		}

	}

	//Using Bubble sort, sorts the array by value of rating
	public void displaySortedByRating(Movie[] movies) {
		for (int i = 0; i < movies.length-5; i++) {
			for (int j = 1; j < movies.length - i-5; j++) {
				if ((movies[j - 1].getRating() > movies[j].getRating())) {
					// Swap temp and movies[i]
					Movie temp = movies[j - 1];
					movies[j - 1] = movies[j];
					movies[j] = temp;
				}
			}

		}

	}

}
