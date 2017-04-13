import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
/**
 * This class will find the neighbors for a user according to the similarity between users.
 * @author luona
 *
 */
public class Neighborhood{
	
	Pearson p;
	ReadFile rf;
	
	/**
	 * The constructor will initialize a Neighborhood object by taking a ReadFile parameter.
	 * @param rf
	 */
	public Neighborhood(ReadFile rf) {
		p = new Pearson();
		this.rf = rf;
	}
	
	/**
	 * The method will find all similarity between user a and other users.
	 * @param a
	 * @return a HashMap contains all similarity
	 */
	public HashMap<User, Double> getAllSimilarity(User a) {
		if (!a.getAllSimilarity().isEmpty()) return a.getAllSimilarity();
		HashMap<Integer, User> allUsers = rf.getAllUsers();
		HashMap<User, Double> similarity = new HashMap<>();
		for (User u : allUsers.values()) {
			if (u != a) {
				double s = p.runSimilarity(u, a);
				similarity.put(u, s);
			}
		}
		a.setAllSimilarity(similarity);
		return similarity;
	}
	
	/**
	 * The method will find the neighbors for a user according to the similarity and threshold.
	 * @param u
	 * @param movie
	 * @param threshold
	 * @return a list of neighbors
	 */
	public ArrayList<User> findNbs(User u, Movie movie, int threshold) {
		HashMap<User, Double> allS = getAllSimilarity(u);
		PriorityQueue<Map.Entry<User, Double>> nbs = new PriorityQueue<>(threshold, new Comparator<Map.Entry<User, Double>>() {
			public int compare(Map.Entry<User, Double> A, Map.Entry<User, Double> B) {
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
		for (Map.Entry<User, Double> m : allS.entrySet()) {
			if (!m.getKey().getAllRatings().containsKey(movie)) continue;
			if (count < threshold) {
				nbs.add(m);
				count++;
			} else {
				if (m.getValue() - nbs.peek().getValue() > 0) {
					nbs.poll();
					nbs.add(m);
				}
			}
		}
		ArrayList<User> res = new ArrayList<User>();
		while (!nbs.isEmpty()) {
			res.add(nbs.poll().getKey());
		}
		return res;
	}


}
