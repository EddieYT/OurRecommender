import java.io.*;
import java.util.HashMap;

/**
 * Created by Eddie on 4/17/17.
 */
public class ReadBook implements ReadFile{
    private BufferedReader in;
    private DataSet ds;

    public ReadBook(String filename) throws IOException {
        in = new BufferedReader(new FileReader(filename));
        ds = new DataSet();
        this.buildAll();
    }

    @Override
    public void buildAll() throws IOException {
        int count = 0;
        while (in.ready()) {
            count++;
            String line = in.readLine();
            if (!Character.isDigit(line.charAt(1))) continue;
            String[] info = line.split(";");
            for (int i = 0; i < info.length; i++) {
                info[i] = info[i].replaceAll("\"", "");
            }
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
        return this.ds.getAllUsers();
    }

    @Override
    public HashMap<String, Item> getAllItems() {
        return this.ds.getAllItems();
    }
    
    public DataSet getDataSet() {
    	return ds;
    }
}
