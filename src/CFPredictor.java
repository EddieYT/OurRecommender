import java.util.ArrayList;
/**
 * This class will predict a user's preference for a movie
 * @author luona
 *
 */
public class CFPredictor implements Predictor {
	
	Neighborhood n;
	Pearson p;
	
	/**
	 * The constructor initializes a Predictor object.
	 * @param n
	 */
	public CFPredictor(Neighborhood n) {
		this.n = n;
		p = new Pearson();
		
	}
	
	/**
	 * The method predicts a user's preference for a movie
	 * @param u
	 * @param i
	 * @return
	 */
	@Override
	public double predict(User u, Item i) {
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
