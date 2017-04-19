import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
/**
 * This class will read in a file and store all data.
 * @author Eddie
 *
 */
public class ReadSmallMovie implements ReadFile {
    private BufferedReader in;
    private DataSet ds;

    /**
     * Constructor
     * @param filename the name of the file to be read
     * @throws IOException
     */
    public ReadSmallMovie(String filename) throws IOException {
        ds = new DataSet();
        in = new BufferedReader(new FileReader(filename));
        buildAll();
    }

    @Override
    public void buildAll() throws IOException {
        while (in.ready()) {
            String line = in.readLine();
            if (!Character.isDigit(line.charAt(0))) continue;
            String[] info = line.split(",");
            int userID = Integer.parseInt(info[0]);
            String movieID = info[1];
            double rating = Double.parseDouble(info[2]);
            User u = ds.getAllUsers().get(userID);
            Item m = ds.getAllItems().get(movieID);
            if (u == null) {
                u = new User(userID);
                ds.setUser(u);
            }
            if (m == null) {
                m = new Item(movieID);
                ds.setItem(m);
            }
            u.setRating(m, rating);
            m.setUserRatings(u, rating);
            ds.addSum(rating);
        }
    }

    @Override
    public HashMap<Integer, User> getAllUsers() {
        return ds.getAllUsers();
    }

    @Override
    public HashMap<String, Item> getAllItems() {
        return ds.getAllItems();
    }
    
    public DataSet getDataSet() {
    	return ds;
    }


}
