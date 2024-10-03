package Songs;

public class Songs
{
    private int songId;
    private String songName;
    private double duration;
    private String artist;
    private String genere;
    private String songPath;


    public  Songs(int songId,String songName,double duration,String artist,String genere,String songPath)
    {
        this.songId=songId;
        this.songName=songName;
        this.duration=duration;
        this.artist=artist;
        this.genere=genere;
        this.songPath=songPath;
    }

    public String getSongPath() {
        return songPath;
    }

    public int getSongId() {
        return songId;
    }

    public String getSongName() {
        return songName;
    }

    public double getDuration() {
        return duration;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenere() {
        return genere;
    }






    public String toString()
    {
        return songId+"\t"+songName+"\t"+duration+"\t"+artist+"\t"+genere+"\t"+songPath;
    }

   

}
