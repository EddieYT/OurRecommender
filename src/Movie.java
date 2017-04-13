/**
 * The Movie class represent a movie.
 * @author Eddie
 *
 */
public class Movie {
	private int id;
	private String name;
	
	/**
	 * The constructor initializes a Movie object
	 * @param id
	 */
	public Movie (int id) {
		this.id = id;
	}
	
	/**
	 * The method returns the movie Id.
	 * @return
	 */
	public int getID() {
		return this.id;
	}
}
