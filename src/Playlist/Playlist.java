package Playlist;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.sql.*;
import java.util.Scanner;

public class Playlist
{
     private int playlistId ;
     private String  playlistName ;
     private String type ;
     private String songOrPodcastName;





    public Playlist(int playlistId, String playlistName, String type, String songOrPodcastName){
        this.playlistId = playlistId;
        this.playlistName = playlistName;
        this.type = type;
        this.songOrPodcastName=songOrPodcastName;

    }



    public int getPlaylistId() {
        return playlistId;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public String getType() {
        return type;
    }


    public String getSongOrPodcastName()
   {
       return  songOrPodcastName;
   }



}
