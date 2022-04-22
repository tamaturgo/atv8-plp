public class App {
    public static void main(String[] args) {
      Follower Luis = new Follower("lscantelbruy", "123");
      
      Luis.createPodcast("Podcast do Luis");

      Follower dio = new Follower("Diogele", "123");

      dio.seePodcasts(Luis);
      dio.subscribe(Luis.getMyPodcasts().get(0));

      Luis.uploadEpisode(new Episode("Episódio 1"), Luis.getMyPodcasts().get(0));

      dio.createPodcast("Podcast do Dio");

      Luis.subscribe(dio.getMyPodcasts().get(0));

      dio.uploadEpisode(new Episode("Episodio do dio"), dio.getMyPodcasts().get(0));
    }
}
