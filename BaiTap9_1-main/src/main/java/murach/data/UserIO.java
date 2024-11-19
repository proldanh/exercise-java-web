package murach.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import murach.business.User;

public class UserIO {
    public UserIO() {
    }

    public static boolean add(User user, String filepath) {
        try {
            File file = new File(filepath);
            PrintWriter out = new PrintWriter(new FileWriter(file, true));
            out.println(user.getEmail() + "|" + user.getFirstName() + "|" + user.getLastName());
            out.close();
            return true;
        } catch (IOException var4) {
            IOException e = var4;
            e.printStackTrace();
            return false;
        }
    }

    public static User getUser(String email, String filepath) {
        try {
            File file = new File(filepath);
            BufferedReader in = new BufferedReader(new FileReader(file));
            User user = new User();

            for(String line = in.readLine(); line != null; line = in.readLine()) {
                StringTokenizer t = new StringTokenizer(line, "|");
                if (t.countTokens() < 3) {
                    return new User("", "", "");
                }

                String token = t.nextToken();
                if (token.equalsIgnoreCase(email)) {
                    String firstName = t.nextToken();
                    String lastName = t.nextToken();
                    user.setEmail(email);
                    user.setFirstName(firstName);
                    user.setLastName(lastName);
                }
            }

            in.close();
            return user;
        } catch (IOException var10) {
            IOException e = var10;
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<User> getUsers(String filepath) {
        try {
            ArrayList<User> users = new ArrayList();
            BufferedReader in = new BufferedReader(new FileReader(filepath));

            for(String line = in.readLine(); line != null; line = in.readLine()) {
                StringTokenizer t = new StringTokenizer(line, "|");
                String email = t.nextToken();
                String firstName = t.nextToken();
                String lastName = t.nextToken();
                User user = new User(firstName, lastName, email);
                users.add(user);
            }

            in.close();
            return users;
        } catch (IOException var9) {
            IOException e = var9;
            e.printStackTrace();
            return null;
        }
    }
}
