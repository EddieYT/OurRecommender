import java.util.ArrayList;
import java.util.HashMap;
/**
 * The class will compute the similarity of two users by implementing Cosine Similarity.
 * @author luona
 *
 */
public class CosineSimilarity implements RelationFormula{
	
	public double runSimilarity (User a, User b) {
		
		ArrayList<Item> both = and (a, b);
		double value1 = 0;
		double value2 = 0;
		double value3 = 0;
		int count = 0;
		for (Item m : both) {
			value1 = value1 + a.getRating(m)*b.getRating(m);
		}
		HashMap<Item, Double> ratingA = a.getRatings();
		HashMap<Item, Double> ratingB = b.getRatings();
		for (double rating : ratingA.values()) {
			value2 = value2 + rating*rating;
		}
		for (double rating : ratingB.values()) {
			value3 = value3 + rating*rating;
		}
		double res = value1/(Math.sqrt(value2)*Math.sqrt(value3));
		return res;
	}
	
	
	/**
	 * This method returns the movies that watched by both User a and User b
	 * @param a
	 * @param b
	 * @return the list of movies 
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
