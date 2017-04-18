import java.util.HashMap;

/**
 * Created by Eddie on 4/17/17.
 */
public class DataSet {
    private HashMap<Integer, User> allUsers;
    private HashMap<String, Item> allItems;
    private int count;
    private double sum;

    public DataSet() {
        allItems = new HashMap<>();
        allUsers = new HashMap<>();
        count = 0;
        sum = 0;
    }

    public HashMap<Integer, User> getAllUsers() {
        return allUsers;
    }

    public HashMap<String, Item> getAllItems() {
        return allItems;
    }

    public void setUser(User u) {
        this.allUsers.put(u.getId(), u);
    }

    public void setItem(Item i) {
        this.allItems.put(i.getID(), i);
    }

    public double getAverage() {
        return sum/count;
    }

    public void addSum(double rating) {
        this.count++;
        this.sum += sum;
    }
}
