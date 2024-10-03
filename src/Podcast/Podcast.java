package Podcast;

public class Podcast
{
    private int podcastId;
    private String podcastName;
    private double duration;
    private String celebrity;
    private  String category;

    private String podcastPath;
    private  int episodeNo;

    public Podcast(int podcastId, String podcastName, double duration, String celebrity, String category,String podcastPath, int episodeNo) {
        this.podcastId = podcastId;
        this.podcastName = podcastName;
        this.duration = duration;
        this.celebrity = celebrity;
        this.category = category;

        this.podcastPath=podcastPath;
        this.episodeNo = episodeNo;
    }

    public int getPodcastId() {
        return podcastId;
    }

    public String getPodcastName() {
        return podcastName;
    }

    public double getDuration() {
        return duration;
    }

    public String getCelebrity() {
        return celebrity;
    }

    public String getCategories() {
        return category;
    }

    public int getEpisodeNo() {
        return episodeNo;
    }


    public String getPodcastPath() {
        return podcastPath;
    }
}
