import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * The class will take in a data file.
 * The class can predict the user's preference for a movie.
 * The class can recommend a list of movies to a user.
 * @author Eddie
 *
 */
public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the filename: ");
		String filename = in.nextLine();
		ReadFile rf;

		if (filename.equals("ratings.dat")) {
			rf = new ReadMovie(filename);
		} else if (filename.equals("BX-Book-Ratings.csv")) {
			rf = new ReadBook(filename);
		} else if (filename.equals("ratings.csv")) {
			rf = new ReadSmallMovie(filename);
		} else {
			throw new FileNotFoundException();
		}

		Neighborhood nb = new Neighborhood(rf);
		Predictor p = new Predictor(nb);
		Recommender re = new Recommender(p, rf);

		while (true) {

			System.out.print("Select a question you'd like know(a or b/ q for quit): \n"
					+ "a: Predict a user's preference of a movie\n"
					+ "b: Predict a movie list for a user according to it's preference\n");
			String choice = in.next();
			if (choice.equals("q")) {
				System.out.print("Exit Recommender.");
				break;
			} else if (choice.equals("a")) {
				try {
					System.out.println("Please enter a user id: ");
					int userID = Integer.parseInt(in.next());
					System.out.println("Please enter a movie id: ");
					String movieID = in.next();
					HashMap<Integer, User> allUsers = rf.getAllUsers();
					HashMap<String, Item> allMovies = rf.getAllItems();
					User u = allUsers.get(userID);
					Item m = allMovies.get(movieID);
					if (m == null) { 
						System.out.println("The movie doesn't exist");
						continue;
					}
					System.out.println(p.predict(u, m));
				} catch (Exception e) {
					System.out.println("Please input a number!");
				}
			} else if (choice.equals("b")) {
				try {
					System.out.println("Please enter a user id: ");
					int userID = Integer.parseInt(in.next());
					System.out.println("Please enter a range for ranking of preference: ");
					int range = Integer.parseInt(in.next());
					User u = rf.getAllUsers().get(userID);
					if (u == null) {
						System.out.println("This user doesnt exist");
					}
					ArrayList<Item> topMovie = re.recommend(u, range);
					System.out.println("We recommend these movies for user " + userID);
					int rank = topMovie.size();
					for (Item m: topMovie) {
						System.out.println("Top " + rank + ": " + m.getID());
						rank--;
					}
				} catch (Exception e) {
					System.out.println("Please input a number!");
				}
				
			} else {
				System.out.println("Your input format is not correct, please input again!");
			}
		}		
	}
}
