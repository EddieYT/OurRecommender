import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * The class will recommend a list of movies to a user 
 * @author luona
 *
 */
public class Recommender {
	
	Predictor p;
	ReadFile rf;
	
	/**
	 * The constructor initializes a movie object
	 * @param p
	 * @param rf
	 */
	public Recommender(Predictor p, ReadFile rf) {
		this.p = p;
		this.rf = rf;
		
	}
	
	/**
	 * The method computes the user's preference for all movies.
	 * @param a
	 * @return a HashMap contains user's preference for all movies
	 */
	public HashMap<Movie, Double> getAllPre(User a) {
		HashMap<Integer, Movie> allMovies = rf.getAllMovies();
		HashMap<Movie, Double> predictRating = new HashMap<>();
		for (Movie m : allMovies.values()) {
			double predictR = p.predict(a, m);
			predictRating.put(m, predictR);
		}
		return predictRating;
	}
	
	// It will take about 4 min to run this one.
	/**
	 * The method recommends a list of movies to a user
	 * @param u
	 * @param range
	 * @return a list of movies
	 */
	public ArrayList<Movie> recommend(User u, int range) {
		HashMap<Movie, Double> allPre = getAllPre(u);
		PriorityQueue<Map.Entry<Movie, Double>> topRating = new PriorityQueue<>(range, new Comparator<Map.Entry<Movie, Double>>() {
			public int compare(Map.Entry<Movie, Double> A, Map.Entry<Movie, Double> B) {
				if (A.getValue() - B.getValue() > 0) {
					return 1;
				} else if (A.getValue() - B.getValue() == 0) {
					return 0;
				} else  {
					return -1;
				}
			}
		});
		int count = 0;
		for (Map.Entry<Movie, Double> m : allPre.entrySet()) {
			// The user has already watched the movie, skip it.
			if (u.getAllRatings().containsKey(m.getKey())) continue;
			if (count < range) {
				topRating.add(m);
				count++;
			} else {
				if (m.getValue() > topRating.peek().getValue()) {
					topRating.poll();
					topRating.add(m);
				}
			}
		}
		ArrayList<Movie> res = new ArrayList<Movie>();
		while (!topRating.isEmpty()) {
			res.add(topRating.poll().getKey());
		}
		return res;
	}

}
