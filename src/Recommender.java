import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Recommender {
	
	Predictor p;
	ReadFile rf;
	
	public Recommender(Predictor p, ReadFile rf) {
		this.p = p;
		this.rf = rf;
		
	}
	
	
	public HashMap<Movie, Double> getAllPre(User a) {
		HashMap<Integer, Movie> allMovies = rf.getAllMovies();
		HashMap<Movie, Double> predictRating = new HashMap<>();
		for (Movie m : allMovies.values()) {
			double predictR = p.predict(a, m);
			System.out.println(predictR + " " + m.getID());
			predictRating.put(m, predictR);
		}
		return predictRating;
	}
	
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
			System.out.println(m.getValue());
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
