/**
 * The class will predict the user's preference for a movie according to Baseline Predictor.
 * @author luona
 *
 */
public class BaselinePredictor {
	DataSet ds;
	
	public BaselinePredictor(DataSet ds) {
		this.ds = ds;
		
	}
	
	public double predict(User u, Item i) { 
		double average = ds.getAverage();
		double value1 = 0;
		double value2 = 0;
		for (double rating : u.getAllRatings().values()) {
			value1 = value1 + (rating - average);
		}
		value1 = value1/u.getAllRatings().size();
		for (double rating : i.getUserRatings().values()) {
			value2 = value2 + (rating - value1 - average);
		}
		value2 = value2/u.getAllRatings().size();
		return average + value1 + value2;
	}
	
	

}
