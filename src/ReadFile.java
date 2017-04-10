import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
/**
 * This class will read in a file and store all data.
 * @author Eddie
 *
 */
public class ReadFile {
	private HashMap<Integer, User> allUsers;
	private HashMap<Integer, Movie> allMovies;
	private Scanner in;
	private File f;
	
	/**
	 * Constructor 
	 * @param filename the name of the file to be read
	 * @throws FileNotFoundException
	 */
	public ReadFile(String filename) throws FileNotFoundException {
		allUsers = new HashMap<Integer, User>();
		allMovies = new HashMap<Integer, Movie>();
		f = new File(filename);
		in = new Scanner(f);
		buildAll();
	}
	
	/**
	 * This method builds up all users, movies and relations between them.
	 */
	private void buildAll() {
		while (in.hasNextLine()) {
			String line = in.nextLine();
			String[] info = line.split("::");
			int userID = Integer.parseInt(info[0]);
			int movieID = Integer.parseInt(info[1]);
			double rating = Double.parseDouble(info[2]);	
			User u = allUsers.get(userID);
			Movie m = allMovies.get(movieID);
			if (u == null) {
				u = new User(userID);
				allUsers.put(userID, u);
			}
			if (m == null) {
				m = new Movie(movieID);
				allMovies.put(movieID, m);
			}
			u.setRating(m, rating);
		}
	}
	
	/**
	 * @return the allUsers
	 */
	public HashMap<Integer, User> getAllUsers() {
		return allUsers;
	}

	/**
	 * @return the allMovies
	 */
	public HashMap<Integer, Movie> getAllMovies() {
		return allMovies;
	}
}
