import java.util.Scanner;

// This class represents an administrator user
public class Admin extends User {
    private String password;

    public Admin(String username, String password) {
        super(username, password);
        this.password = password;
    }

    public void banUser(User follower) {
        System.out.println("Deseja banir " + follower.getUserName() + "? (s/n)");
        if (new Scanner(System.in).nextLine().equals("s")) {
            try {
                System.out.println("Digite sua senha: ");
                String res = new Scanner(System.in).nextLine();
                if (res.equals(password)) {
                    System.out.println("Usuário " + follower.getUserName() + " banido!");
                    follower = null;
                    System.gc();
                } else {
                    throw new Exception("Senha incorreta!");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
