import java.util.Map.Entry;

/**
 * The class will predict the user's preference for a movie according to Baseline Predictor.
 * @author luona
 *
 */
public class BaselinePredictor implements Predictor {
	DataSet ds;
	
	public BaselinePredictor(DataSet ds) {
		this.ds = ds;
		
	}
	
	@Override
	public double predict(User u, Item i) { 
		double average = ds.getAverage();
		//System.out.println("average" + average);
		double value1 = 0;
		double value2 = 0;
		for (double rating : u.getAllRatings().values()) {
			value1 = value1 + (rating - average);
		}
		value1 = value1/u.getAllRatings().size();
		for (Entry<User, Double> rating : i.getUserRatings().entrySet()) {
			value2 = value2 + (rating.getValue() - this.getBu(rating.getKey()) - average);
		}
		value2 = value2/i.getUserRatings().size();
		return average + value1 + value2;
	}
	
	
	public double getBu(User u) {
		double res = 0;
		for (double rating : u.getAllRatings().values()) {
			res = res + (rating - ds.getAverage());
		}
		return res/u.getAllRatings().size();
		
	}
	

}
