import java.util.Scanner;

// This class represents an administrator user
public class Admin extends User {
    private String password;

    public Admin(String username, String password) {
        super(username, password);
        this.password = password;
    }

    public void banUser(Follower follower) {
        System.out.println("Do you wish to ban " + follower.getUsername() + "? (y/n)");
        if (new Scanner(System.in).nextLine().equals("y")) {
            try {
                System.out.println("Enter your password: ");
                String res = new Scanner(System.in).nextLine();
                if (res.equals(password)) {
                    System.out.println("User " + follower.getUsername() + " banned");
                    follower = null;
                    System.gc();
                } else {
                    throw new Exception("Wrong password");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
