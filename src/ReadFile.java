import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Eddie on 4/17/17.
 */
public interface ReadFile {

    /**
     * Helper function builds up all users and items.
     */
    public void buildAll() throws IOException;

    /**
     * This methods will return all users.
     * @return a HashMap that stores all users
     */
    public HashMap<Integer, User> getAllUsers();


    /**
     * This methods will return all Items.
     * @return a HashMap that stores all items.
     */
    public HashMap<String, Item> getAllItems();
    
    public DataSet getDataSet();
}
