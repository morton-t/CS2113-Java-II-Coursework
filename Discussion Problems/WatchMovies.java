import java.util.Scanner;

public class WatchMovies{
	public static void main (String[] args){
		Scanner scnr = new Scanner(System.in);
		final int numMovies = 15;					//Stores number of movies to watch for easier editing

		String[] movies = new String[numMovies];	//Array to store names & ratings of movies watched
						
		for (int moviesWatched = 0; moviesWatched < numMovies; moviesWatched++) {
	
			String currentMovie;				//Tracks current title and rating
			int movieRuntime;					//Tracks the running time of the current movie being watched
			int timeElapsed = 0;				//Tracks how long the movie has been watched

			System.out.print("What is the name of the movie?: ");
			currentMovie = scnr.nextLine();

			System.out.print("What is the movie's running time in minutes?: ");
			movieRuntime = scnr.nextInt(); //Does not use input validation, so non-ints will break the program

			scnr.nextLine(); //forces scanner to read from the next line

			while (timeElapsed < movieRuntime) {
				timeElapsed++; //increments time the movie has been watched by one minute for each iteration of the while loop

				if (timeElapsed % 10 == 0) { //updates user on time spent watching the movie (prompting each minute spams the viewer)
					System.out.println("Watching movie... " + timeElapsed + " minutes have passed.");
				}

				if (timeElapsed >= 120) {
					System.out.println("Two hours have passed! Stopping movie... ");
					break;
				}
			}

			System.out.print("\nDone! What is your rating out of 5?: ");
			currentMovie += ("\t\tRating: " + scnr.nextInt());	//Does not use input validation, so non-ints and ratings above 5 and below 0 are still accepted & can break the program
			scnr.nextLine();									//forces scanner to read from the next line
			movies[moviesWatched] = currentMovie;
		}
		
		System.out.println("\n\nAll " + numMovies + " movies watched! \nHere's your reviews: ");

		for (int i = 0; i < numMovies; ++i) {
			System.out.println(movies[i]);
		}

		System.out.println("\nFor your efforts, you receive one (1) firm handshake!");
	}
}