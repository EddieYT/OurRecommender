import java.util.ArrayList;

public class Predictor {
	
	Neighborhood n;
	Pearson p;
	
	public Predictor(Neighborhood n) {
		this.n = n;
		p = new Pearson();
		
	}
	
	public double predict(User u, Movie i) {
		// The user has watched the movie, return the review directly
		if (u.getAllRatings().containsKey(i)) {
			return u.getRating(i);
		}
		ArrayList<User> nbs = n.findNbs(u, i, 50);
		double value1 = 0;
		for (User user : nbs) {
			if (!user.getAllRatings().containsKey(i)) {
				System.out.println("Here");
				continue;
			}
			value1 = value1 + p.runSimilarity(user, u)*(user.getRating(i)-user.getAverage());
		}
		double value2 = 0;
		for (User user : nbs) {
			value2 = value2 + Math.abs(p.runSimilarity(user, u));
		}
		double res = u.getAverage() + value1/value2;
		return res;
	}

}
