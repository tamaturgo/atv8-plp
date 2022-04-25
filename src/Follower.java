// This class represents a common user
public class Follower extends User{
    private String username;
    
    public Follower(String username, String password) {
        super(username, password);
        this.username = username;
    }

    // Método que notifica novo episódio
    public void update(String podcastName) {
        System.out.println("Novo episódio de " + podcastName + " está disponível!");
    }

    // Método que adiciona o usuário à lista de inscritos de um podcast
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
