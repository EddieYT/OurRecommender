import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Eddie on 4/17/17.
 */
public class ReadBook implements ReadFile{
    private Scanner in;
    private File f;
    private DataSet ds;

    public ReadBook(String filename) throws FileNotFoundException {
        f = new File(filename);
        in = new Scanner(f);
        ds = new DataSet();
        this.buildAll();
    }

    @Override
    public void buildAll() {
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (!Character.isDigit(line.charAt(0))) continue;
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
            ds.addSum(rating);
        }
    }

    @Override
    public HashMap<Integer, User> getAllUsers() {
        return null;
    }

    @Override
    public HashMap<String, Item> getAllItems() {
        return null;
    }
}
