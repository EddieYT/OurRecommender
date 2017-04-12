import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Neighborhood{
	
	Pearson p;
	ReadFile rf;
	
	public Neighborhood(ReadFile rf) {
		p = new Pearson();
		this.rf = rf;
	}
	
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
			// This neighbor hasn't watched this movie, skip it.
			if (!m.getKey().getAllRatings().containsKey(movie)) continue;
			if (count < threshold) {
				nbs.add(m);
				count++;
			} else {
				if (m.getValue() > nbs.peek().getValue()) {
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
