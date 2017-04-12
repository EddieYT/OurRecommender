import java.util.HashMap;
/**
 * The User class represents an user.
 * @author Eddie
 *
 */
public class User {
	private int id;
	private double avg;
	private HashMap<Movie, Double> ratings;
	
	/**
	 * Constructor
	 * @param id the user's id
	 */
	public User (int id) {
		this.id = id;
		avg = -1;
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
	
	/**
	 * Gets the user's id
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Gets all ratings from a user.
	 * @return a HashMap maps movie to rating
	 */
	public HashMap<Movie, Double> getRatings() {
		return ratings;
	}
	
	/**
	 * Gets a specified movie's rating from a user
	 * @param m
	 * @return the number of rating
	 */
	public double getRating(Movie m) {
		return ratings.get(m);
	}
	
	/**
	 * Calculates the overall rating average for this user.
	 */
	private void calAvg() {
		double total = 0;
		for (double rating : ratings.values()) {
			total = total + rating;
		}
		this.avg = total/ratings.size();
	}
	
	/**
	 * Gets the overall average of all ratings from a user
	 * @return the average of all ratings
	 */
	public double getAverage() {
		if (avg < 0) this.calAvg();
		return this.avg;
	}
	
}
