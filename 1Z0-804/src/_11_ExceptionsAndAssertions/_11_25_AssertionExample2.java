package _11_ExceptionsAndAssertions;

import java.util.Arrays;
class _11_25_AssertionExample2 {
	public static void main(String []args) {
		String [] jackieChanMovies =
			{"shanghai knights", "crime story", "heart of dragon", "police story", "drunken master"};
		System.out.println("Jackie Chan movies to watch are: ");
		for(String movie : jackieChanMovies) 
			System.out.println(movie);
		
		Arrays.sort(jackieChanMovies);
		// validate that sorting worked; 
		// once sorted the first element should be "crime story"
		assert jackieChanMovies[0].equals("crime story") : "something went wrong in sorting Jackie Chan movie list";
		System.out.println("The sorted order of Jackie Chan movies to watch are: ");
		for(String movie : jackieChanMovies) 
			System.out.println(movie);
	}
}
