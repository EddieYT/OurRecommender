import java.util.HashMap;

/**
 * The Movie class represent a movie.
 * @author Eddie
 *
 */
public class Item {
	private String id;
	private HashMap<User, Double> userRatings;
	
	/**
	 * The constructor initializes a Movie object
	 * @param id
	 */
	public Item (String id) {
		this.id = id;
	}
	
	/**
	 * The method returns the movie Id.
	 * @return
	 */
	public String getID() {
		return this.id;
	}

    public HashMap<User, Double> getUserRatings() {
        return userRatings;
    }

    public void setUserRatings(User u, double rating) {
	    this.userRatings.put(u, rating);
    }

    public double getRating(User u) {
	    return userRatings.get(u);
    }
}
