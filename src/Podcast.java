import java.util.ArrayList;
import java.util.List;

public class Podcast {

    // Basic components of the Podcast (Name, Followers and Episodes)
    private String name; 
    private List<Follower> followers = new ArrayList<Follower>(); 
    private List<Episode> episodes = new ArrayList<Episode>();

    public Podcast(String name){
        this.name = name;
    }

    // Method which notifies every follower if there is a new episode
    public void notifyFollowers(){
        for(Follower follower : followers) {
            follower.update(name);
        }
    }

    // Method which adds a new episode to the podcast
    public void addEpisode(Episode episode) {
        episodes.add(episode);
    }

    // Method which adds a new follower to the podcast
    public void addFollowers(Follower follower) {
        followers.add(follower);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

