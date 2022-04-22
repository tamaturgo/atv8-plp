import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract class which represents a generic user
public abstract class User {
    private String userName;
    private String password;

    protected List<Podcast> subscriptions = new ArrayList<Podcast>(); // List of subscriptions
    protected List<Podcast> myPodcasts = new ArrayList<Podcast>(); // List of podcasts created by the user

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    // Method for the user's logout
    public void logout() {
        try (Scanner scanner = new Scanner(System.in)) {
            try {
                System.out.println("Enter your password: ");
                String res = scanner.nextLine();
                if (!res.equals(password)) {
                    throw new Exception("Wrong password");
                }
                System.out.println("User " + userName + " logged out");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Method for adding a new episode to an existing podcast,
    // then notify all the followers of the podcast
    public void uploadEpisode(Episode episode, Podcast podcast) {
        podcast.addEpisode(episode);
        podcast.notifyFollowers();
    }

    // Method for adding a new podcast to the user's list of podcasts
    public void createPodcast(String name) {
        Podcast newPodcast = new Podcast(name);
        myPodcasts.add(newPodcast);
    }

    public List<Podcast> getMyPodcasts() {
        return myPodcasts;
    }

    public void ListMyPodcasts() {
        for (Podcast podcast : myPodcasts) {
            System.out.println(myPodcasts.indexOf(podcast) + " + " + podcast.getName());
        }
    }

    public String getUserName() {
        return userName;
    }
}
