import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class will count the similarity between two users.
 * @author luona
 *
 */
public class Pearson implements RelationFormula{
	
	/**
	 * This method counts the similarity between two users.
	 */
	public double runSimilarity (User a, User b) {
		ArrayList<Item> both = and (a, b);
		double value1 = 0;
		double value2 = 0;
		double value3 = 0;
		int count = 0;
		for (Item m : both) {
			value1 = value1 + ((a.getRating(m) - a.getAverage())*(b.getRating(m) - b.getAverage()));
			value2 = value2 + (a.getRating(m) - a.getAverage()) * (a.getRating(m) - a.getAverage());
			value3 = value3 + (b.getRating(m) - b.getAverage()) * (b.getRating(m) - b.getAverage());
		}
		if (value2 == 0 || value3 == 0) return 0;
		double similarity = (double)value1/(Math.sqrt(value2)*Math.sqrt(value3));
		return similarity;	
	}
	
	/**
	 * This method returns the Items that watched by both User a and User b
	 * @param a
	 * @param b
	 * @return the list of Items
	 */
	public ArrayList<Item> and (User a, User b) {
		ArrayList<Item> res = new ArrayList<>();
		HashMap<Item, Double> ratingA = a.getRatings();
		HashMap<Item, Double> ratingB = b.getRatings();
		for (Item m : ratingA.keySet()) {
			if (ratingB.containsKey(m)) {
				res.add(m);
			}
		}
		return res;
	}

}
