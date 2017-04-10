import java.util.ArrayList;
import java.util.HashMap;

public class Pearson implements RelationFormula{
	
	public double runSimilarity (User a, User b) {
		ArrayList<Movie> both = and (a, b);
		double value1 = 0;
		double value2 = 0;
		double value3 = 0;
		for (Movie m : both) {
			value1 = value1 + ((a.getRating(m) - a.getAverage())*(b.getRating(m) - b.getAverage()));
			value2 = value2 + (a.getRating(m) - a.getAverage())*(a.getRating(m) - a.getAverage());
			value3 = value3 + (b.getRating(m) - b.getAverage())*(b.getRating(m) - b.getAverage());
		}
		double similarity = value1/(Math.sqrt(value2)*Math.sqrt(value3));
		return similarity;
		
		
		
		
	}
	
	public ArrayList<Movie> and (User a, User b) {
		ArrayList<Movie> res = new ArrayList<>();
		HashMap<Movie, Double> ratingA = a.getRatings();
		HashMap<Movie, Double> ratingB = b.getRatings();
		for (Movie m : ratingA.keySet()) {
			if (ratingB.containsKey(m)) {
				res.add(m);
			}
		}
		return res;
	}

}
