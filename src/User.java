import java.util.HashMap;
/**
 * The User class represents an user.
 * @author Eddie
 *
 */
public class User {
	private int id;
	private HashMap<Movie, Double> ratings;
	
<<<<<<< HEAD
	public int getId() {
		return id;
	}
	
	public HashMap<Movie, Double> getRatings() {
		return ratings;
	}
	
	
	public double getAverage() {
		double total = 0;
		for (double rating : ratings.values()) {
			total = total + rating;
		}
		return total/ratings.size();
	}
	
	public double getRating(Movie m) {
		return ratings.get(m);
=======
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
>>>>>>> cc6dab7ce474da0afc0590b743599ff934e81b76
	}
}
