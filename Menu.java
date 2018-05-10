import java.util.Scanner;

public class Menu extends movieSorting {
	Scanner user_input = new Scanner(System.in);
	Movie list = new Movie();

	//The menu method only works if an array is given for it to iterate
	public void createMenu(Movie[] movies) {

		System.out.println("1. Display the list of movies: ");
		System.out.println("2. Display the movies sorted according to year, starting with the oldest one: ");
		System.out.println("3. Sort the movies according to running time: ");
		System.out.println("4. Sort the movies according to ratings: ");
		System.out.println("5. Display all movies for a given genre: [NOT WORKING]");
		System.out.println("6. Search for a specific movie by name: [NOT WORKING]");
		System.out.println("7. Add a movie to the list of movies: [NOT WORKING] ");
		System.out.println("8. To Exit press -1: ");
		System.out.println();
		int selection = user_input.nextInt();
		while (selection != -1) {
			
			//Menu section to display all movies
			if (selection == 1) {
				System.out.println("Now displaying list of movies: ");
				list.display(movies);
				System.out.println();
				selection = user_input.nextInt();
				
			//Menu section to sort movies based by year, calls the method in movieSorting
			}
			if (selection == 2) {
				System.out.println("Now displaying movies sorted by Year: ");
				displaySortedByYear(movies);
				list.display(movies);
				System.out.println();
				selection = user_input.nextInt();
				
			//Menu section to sort movies based by run time, calls the method in movieSorting
			}
			if (selection == 3) {
				System.out.println("Now displaying movies sorted by run time: ");
				displaySortedByRunTime(movies);
				list.display(movies);
				System.out.println();
				selection = user_input.nextInt();
				
			//Menu section to sort movies based by rating, calls the method in movieSorting
			}
			if (selection == 4) {
				System.out.println("Now displaying movies sorted by rating: ");
				displaySortedByRating(movies);
				list.display(movies);
				System.out.println();
				selection = user_input.nextInt();
				
			//Menu section let user pick genre and display all the movies under specified genre
			}
			if (selection == 5) {
				System.out.println("Enter the genre you wish to look for:");
				System.out.println("1:Comedy");
				System.out.println("2:Drama");
				System.out.println("3:Action");
				System.out.println("4:Sci-Fi");
				System.out.println("5:Documentary");
				int user_Num = user_input.nextInt();

				//if user selects 1 then all movies under comedy will be displayed
				if (user_Num == 1) {
					for (int i = 0; i < movies.length-5; i++) {
						if (movies[i].genre.equals("Comedy"))
							;
						System.out.println(movies[i].name);
					}
					
				//if user selects 2 then all movies under Drama will be displayed
				} else if (user_Num == 2) {
					for (int i = 0; i < movies.length-5; i++) {
						System.out.println(movies[i].genre.equals("Drama"));
						System.out.println(movies[i].name);
					}
					
				//if user selects 3 then all movies under Action will be displayed
				} else if (user_Num == 3) {
					for (int i = 0; i < movies.length-5; i++) {
						System.out.println(movies[i].genre.equals("Action"));
						System.out.println(movies[i].name);
					}
					
				//if user selects 4 then all movies under Sci-Fi will be displayed
				} else if (user_Num == 4) {
					for (int i = 0; i < movies.length-5; i++) {
						System.out.println(movies[i].genre.equals("Sci-Fi"));
						System.out.println(movies[i].name);
					}
				
				//if user selects 5 then all movies under Documentary will be displayed
				} else if (user_Num == 5) {
					for (int i = 0; i < movies.length-5; i++) {
						System.out.println(movies[i].genre.equals("Documentary"));
						System.out.println(movies[i].name);
					}
					selection = user_input.nextInt();
				}
			}
				
			/*//Menu section to search array given a specific movie title
			else if(selection == 6){
					System.out.println("Enter the name of the movie name you wish to see:");
					String choice = user_input.nextLine();
					for(int i = 0;i < movies.length-5;i++){
						if(movies[i].equals(choice)){
							list.display(movies);
						}
						else System.out.println("movie selected not found");
					}
				}
				*/
		
				
			//Menu Section to allow the user to input movies 
		else if (selection == 7) {
				System.out.println("You may add up to 5 more movies to the list.");
				System.out.println("Enter the number of movies you wish to add:");
				int numOfMovies = user_input.nextInt();

				if (numOfMovies == 1) {
					for (int i = 31; i < movies.length-3; i++) {
						System.out.println("Enter values for movie" + i);
						movies[i] = new Movie();
						movies[i].setNameByUser();
						movies[i].setYearByUser();
						movies[i].setRunTimeByUser();
						movies[i].setGenreByUser();
						movies[i].setRatingByUser();
						

					}
				} else if (numOfMovies == 2) {
					for (int i = 33; i < movies.length; i++) {
						movies[i] = new Movie();
						System.out.println("Enter values for movie" + i);
						movies[i].setNameByUser();
						movies[i].setYearByUser();
						movies[i].setRunTimeByUser();
						movies[i].setGenreByUser();
						movies[i].setRatingByUser();
					}
				} else if (numOfMovies == 3) {
					for (int i = 32; i < movies.length; i++) {
						movies[i] = new Movie();
						System.out.println("Enter values for movie" + i);
						movies[i] = new Movie();
						movies[i].setNameByUser();
						movies[i].setYearByUser();
						movies[i].setRunTimeByUser();
						movies[i].setGenreByUser();
						movies[i].setRatingByUser();
						
					}
				} else if (numOfMovies == 4) {
					for (int i = 31; i < movies.length; i++) {
						movies[i] = new Movie();
						System.out.println("Enter values for movie" + i);
						movies[i] = new Movie();
						movies[i].setNameByUser();
						movies[i].setYearByUser();
						movies[i].setRunTimeByUser();
						movies[i].setGenreByUser();
						movies[i].setRatingByUser();
						
					}
				}
				selection = user_input.nextInt();
			}
		}
	}
}


