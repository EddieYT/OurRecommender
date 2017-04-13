/**
 * The interface is to compute the similarity between two users.
 * We can implement different way to compute the similarity.
 * @author luona
 *
 */
public interface RelationFormula {
	
	
	/**
	 * This is an abstract method for counting the similarity between two users.
	 * @param a
	 * @param b
	 * @return the similarity
	 */
	public abstract double runSimilarity(User a, User b);
	
}
