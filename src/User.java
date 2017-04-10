import java.util.HashMap;
/**
 * The User class represents an user.
 * @author Eddie
 *
 */
public class User {
	private int id;
	private HashMap<Movie, Double> ratings;
	
	/**
	 * Constructor
	 * @param id the user's id
	 */
	public User (int id) {
		this.id = id;
		ratings = new HashMap<Movie, Double>();
	}
	
	/**
	 * Gets the user's all ratings for certain movies.
	 * @return a mapping from Movie to rating
	 */
	public HashMap<Movie, Double> getAllRatings() {
		return this.ratings;
	}
	
	/**
	 * Sets the rating for a specified movie.
	 * @param m the movie
	 * @param rating the rating for the specified movie
	 */
	public void setRating(Movie m, double rating) {
		ratings.put(m, rating);
	}
}
