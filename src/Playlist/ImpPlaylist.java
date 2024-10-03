package Playlist;

import Playlist.Iplaylist;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.sql.*;
import java.util.Scanner;


public class ImpPlaylist implements Iplaylist
{
    Clip clip;
    AudioInputStream audioInputStream;
    String filePath ="";
    Long currentFrame;
    String status;

    int userId;
    Scanner sc=new Scanner(System.in);
    @Override
    public void createPlaylist(int userId)
    {
        int min = 400;
        int max = 499;
        int playlistId = (int) (Math.random() * (max - min + 1) + min);
        System.out.println("Enter  Name Of Playlist");
        String name = sc.next();


        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "root");
            String myquery1 = "insert into playlist values(?,?,?)";
            PreparedStatement pst1 = connection.prepareStatement(myquery1);
            pst1.setInt(1, playlistId);
            pst1.setString(2, name);
            pst1.setInt(3, userId);
            pst1.executeUpdate();


        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Inserted Successfully");
    }

    public void addSongsOrPodcastToPlaylist()
    {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "root");

            System.out.println("Enter Song/Podcast Name to add in Playlist");
            String search= sc.next();

            System.out.println("Enter Playlist Name to add song/podcast in it");
            String playlistName1= sc.next();
            String myquery2 = "select playlistId from playlist where playlistName='"+playlistName1+"'";
            Statement st1 = connection.createStatement();
            ResultSet rs1 = st1.executeQuery(myquery2);
            int id1=0;
            while (rs1.next())
            {
                 id1 = rs1.getInt("playlistId");
            }

            String myquery3 = "insert into playlistDetails values(?,?,?)";
            PreparedStatement pst1 = connection.prepareStatement(myquery3);
            pst1.setInt(1, id1);
            pst1.setString(2, playlistName1);
            pst1.setString(3, search);
            pst1.executeUpdate();
            System.out.println("Inserted Successfully");

        } catch (Exception e) {
            System.out.println(e);
        }

    }


    @Override
    public void viewPlaylist(int userId)
    {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "root");


            String myquery1 = "select playlistName from playlist  where userId='"+userId+"'";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(myquery1);

            while (rs.next())
            {
                System.out.println(rs.getString("playlistName"));
            }



        } catch (Exception e) {
            System.out.println(e);
        }


    }
    public void songsOrPodcastInPlaylist()
    {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "root");

            System.out.println("Enter Playlist Name to View songs or Podcast");
            String search= sc.next();
            String myquery1 = "select songOrPodcastName from playlistDetails  where playlistName='"+search+"'";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(myquery1);

            while (rs.next())
            {
                System.out.println(rs.getString("songOrPodcastName"));
            }


        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void playSong()
    {

        try {


            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Song Name to Play");
            String nameOfSong = sc.next();

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "root");
            String myquery1 = "select songPath from song where songName='"+ nameOfSong +"'";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(myquery1);


            while (rs.next()) {
                filePath = rs.getString("songPath");
            }


            audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

            clip = AudioSystem.getClip();

            clip.open(audioInputStream);

        }
        catch(Exception e)
        {
            System.out.println(e);
        }


    }


    public void play() {

        clip.start();
        status = "play";
    }

    public void pause() {
        if (status.equals("paused")) {
            System.out.println("audio is already paused");
            return;
        }
        currentFrame = clip.getMicrosecondPosition();
        clip.stop();
        status = "paused";
    }

    public void resumeAudio()  {
        if (status.equals("play")) {
            System.out.println("Audio is already being played");
            return;
        }
        clip.close();
        resetAudioStream();
        clip.setMicrosecondPosition(currentFrame);
        play();
    }

    public void restart()  {
        clip.stop();
        clip.close();
        resetAudioStream();
        currentFrame = 0L;
        clip.setMicrosecondPosition(0);
        play();
    }

    public void stop() {
        currentFrame = 0L;
        clip.stop();
        clip.close();
    }

    public void resetAudioStream()
    {
        try
        {
            audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
            clip.open(audioInputStream);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public void playPodcast()
    {

        try {


            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Podcast Name to Play");
            String nameOfPodcast = sc.next();

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "root");
            String myquery1 = "select podcastPath from podcast where podcastName='"+nameOfPodcast+"'";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(myquery1);


            while (rs.next()) {
                filePath = rs.getString("podcastPath");
            }


            audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

            clip = AudioSystem.getClip();

            clip.open(audioInputStream);

        }
        catch(Exception e)
        {
            System.out.println(e);
        }


    }


    public void playPodcast1() {

        clip.start();
        status = "play";
    }

    public void pausePodcast() {
        if (status.equals("paused")) {
            System.out.println("Audio is already paused");
            return;
        }
        currentFrame = clip.getMicrosecondPosition();
        clip.stop();
        status = "paused";
    }

    public void resumePodcast()  {
        if (status.equals("play")) {
            System.out.println("Audio is already being played");
            return;
        }
        clip.close();
        resetAudioStream1();
        clip.setMicrosecondPosition(currentFrame);
        play();
    }

    public void restartPodcast()  {
        clip.stop();
        clip.close();
        resetAudioStream1();
        currentFrame = 0L;
        clip.setMicrosecondPosition(0);
        play();
    }

    public void stopPodcast() {
        currentFrame = 0L;
        clip.stop();
        clip.close();
    }

    public void resetAudioStream1()
    {
        try
        {
            audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
            clip.open(audioInputStream);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }


}

