import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
/**
 * This class will read in a file and store all data.
 * @author Eddie
 *
 */
public class ReadSmallMovie implements ReadFile {
    private Scanner in;
    private File f;
    private DataSet ds;

    /**
     * Constructor
     * @param filename the name of the file to be read
     * @throws FileNotFoundException
     */
    public ReadSmallMovie(String filename) throws FileNotFoundException {
        ds = new DataSet();
        f = new File(filename);
        in = new Scanner(f);
        buildAll();
    }

    @Override
    public void buildAll() {
        while (in.hasNextLine()) {
            String line = in.nextLine();
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


}
