
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Menu caller = new Menu();

		Movie[] movies = new Movie[35];
		//I changed the length on all methods since i want to make an array of 35
		//values and then add new ones, still not sure if it works since the length-5 wont change everywhere if i want
		for (int i = 0; i < movies.length - 5; i++) {
			movies[i] = new Movie();
			movies[i].setName();
			movies[i].setYear();
			movies[i].setRunTime();
			movies[i].setGenre();
			movies[i].setRating();
		}
		caller.createMenu(movies);

	}
}
