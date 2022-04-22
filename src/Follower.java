// This class represents a common user
public class Follower extends User{
    private String username;
    
    public Follower(String username, String password) {
        super(username, password);
        this.username = username;
    }

    // Method which notifies the user if there is a new episode
    public void update(String podcastName) {
        System.out.println("New podcast from " + podcastName + " is available!");
    }

    // Method which add the follower itself to the podcast's list of followers
    public void subscribe(Podcast podcast) {
        subscriptions.add(podcast);
        podcast.addFollowers(this);
    }

    public void seePodcasts(User user){
        user.ListMyPodcasts();
    }

    public String getUsername() {
        return username;
    }
}
