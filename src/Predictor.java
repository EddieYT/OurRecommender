import java.util.ArrayList;

public class Predictor {
	
	Neighborhood n;
	Pearson p;
	
	public Predictor(Neighborhood n) {
		this.n = n;
		p = new Pearson();
		
	}
	
	public double predict(User u, Movie i) {
		ArrayList<User> nbs = n.findNbs(u, i, 20);
		double value1 = 0;
		for (User user : nbs) {
			value1 = value1 + u.getSimilarity(user)*(user.getRating(i)-user.getAverage());
		}
		double value2 = 0;
		for (User user : nbs) {
			value2 = value2 + Math.abs(u.getSimilarity(user));
		}
		double res = u.getAverage() + value1/value2;
		return res;
	}

}
