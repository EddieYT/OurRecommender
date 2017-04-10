import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

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
	
	private void buildAll() {
		while(in.hasNextLine()) {
			String line = in.nextLine();
			
		}
	}
}
