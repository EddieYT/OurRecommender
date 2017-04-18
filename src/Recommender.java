import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * The class will recommend a list of Items to a user
 * @author luona
 *
 */
public class Recommender {
	
	Predictor p;
	ReadFile rf;
	
	/**
	 * The constructor initializes a Recommender object
	 * @param p
	 * @param rf
	 */
	public Recommender(Predictor p, ReadFile rf) {
		this.p = p;
		this.rf = rf;
		
	}
	
	/**
	 * The method computes the user's preference for all Items.
	 * @param a
	 * @return a HashMap contains user's preference for all Items
	 */
	public HashMap<Item, Double> getAllPre(User a) {
		HashMap<String, Item> allItems = rf.getAllItems();
		HashMap<Item, Double> predictRating = new HashMap<>();
		for (Item m : allItems.values()) {
			double predictR = p.predict(a, m);
			predictRating.put(m, predictR);
		}
		return predictRating;
	}
	
	/**
	 * The method recommends a list of Items to a user
	 * @param u
	 * @param range
	 * @return a list of Items
	 */
	public ArrayList<Item> recommend(User u, int range) {
		HashMap<Item, Double> allPre = getAllPre(u);
		PriorityQueue<Map.Entry<Item, Double>> topRating = new PriorityQueue<>(range, new Comparator<Map.Entry<Item, Double>>() {
			public int compare(Map.Entry<Item, Double> A, Map.Entry<Item, Double> B) {
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
		for (Map.Entry<Item, Double> m : allPre.entrySet()) {
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
		ArrayList<Item> res = new ArrayList<Item>();
		while (!topRating.isEmpty()) {
			res.add(topRating.poll().getKey());
		}
		return res;
	}

}
