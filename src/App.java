import java.util.ArrayList;
import java.util.Scanner;

public class App {

  // Usuários da aplicação 
  static ArrayList<User> users = new ArrayList<User>();

  // Função de login do usuário
  static Follower login() {
    System.out.println("Seja bem-vindo ao JavaCast!");

    Scanner scanner = new Scanner(System.in);

    System.out.println("Digite seu nome de usuário: ");
    String username = scanner.next();
    System.out.println("Digite sua senha: ");
    String password = scanner.next();

    // Cria usuário comum com o nome de usuário e senha inseridos
    Follower follower = new Follower(username, password); 
    // Adiciona o novo usuário ao array de usuários
    users.add(follower);
    return follower;
  }

  public static void main(String[] args) {
    // Administrador do sistema
      Admin Luis = new Admin("lscantelbury", "123");
      
      users.add(Luis);

    // Usuário comum
      Follower Diogeles = new Follower("dio", "321");
    
      users.add(Diogeles);
      
      // Usuário cria um podcast
      Diogeles.createPodcast("Dicas de Valorant");

    // Novo usuário que está fazendo login
    Follower follower = login();

    System.out.println("Seja bem-vindo " + follower.getUsername());
    System.out.println("Você está seguindo " + follower.getMyPodcasts().size() + " podcasts");
    System.out.println("Esses são os seus recomendados:");

    // Mostra os usuários da plataforma
    for (User user : users){
      System.out.println(users.indexOf(user) + " - Ver " + user.getUserName());
    }
    
    // Lista os podcasts do usuário escolhido
    Scanner scanner = new Scanner(System.in);
    int option = scanner.nextInt();
    User userSelected = users.get(option);
    userSelected.ListMyPodcasts();

    System.out.println("Digite o número do podcast que você quer seguir: ");

    // Inscreve o novo usuário no podcast escolhido
    option = scanner.nextInt();
    follower.subscribe(userSelected.myPodcasts.get(option));
    System.out.println("Você está seguindo " + userSelected.myPodcasts.get(option).getName());

    // Diogeles cria um novo episódio do podcast que o usuário segue
    Diogeles.uploadEpisode(new Episode("Episódio piloto"), Diogeles.myPodcasts.get(0));

    // O usuário então é notificado do novo episódio

    // ADM dá Ban nos dois pra limpar o código ;D
    Luis.banUser(follower);
    Luis.banUser(Diogeles);
  }
}
