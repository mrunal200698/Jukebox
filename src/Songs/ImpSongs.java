package Songs;

import Songs.Songs;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.*;

public class ImpSongs implements Isongs

{


    @Override
    public List<Songs> displaySongs()
    {

        ArrayList<Songs> songList=new ArrayList<>();
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "root");
            String myquery1 = "select * from song";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(myquery1);
            System.out.printf("%10s %25s %10s %25s %20s","songId","songName","duration","artist","genere");
            System.out.println();

            while (rs.next())
            {
               Songs song1=new Songs(rs.getInt("songId"),rs.getString("songName"),rs.getDouble("duration"),rs.getString("artist"),rs.getString("genere"),rs.getString("songPath"));
               songList.add(song1);
                System.out.printf("%10s %25s %10s %25s %20s", rs.getInt("songId"), rs.getString("songName"), rs.getDouble("duration"), rs.getString("artist"), rs.getString("genere")+ "\n");

            }

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
        return songList;


    }


    @Override
    public void searchSong()
    {
        ArrayList<Songs> songList=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Song Name/Artist Name/Genre to search");
        String search= sc.next();
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "root");
            String myquery1 = "select * from song where artist='"+search+"' or songName='"+search+"' or genere ='"+search+"' ";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(myquery1);
            //System.out.printf("%10s %25s %10s %25s %20s","songId","songName","duration","artist","genere");
            System.out.println();

            while (rs.next())
            {
                Songs song1=new Songs(rs.getInt("songId"),rs.getString("songName"),rs.getDouble("duration"),rs.getString("artist"),rs.getString("genere"),rs.getString("songPath"));

                songList.add(song1);

            }

        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        songList.forEach(x->System.out.println("\n"+x));
        List<Songs> list1 = songList.stream().filter(s->s.getGenere().equals(search)).collect(Collectors.toList());

        System.out.println("-----------------------------------------------------------------------------------------------");
    }

    @Override
    public void sortSong() {
        ArrayList<Songs> songList=new ArrayList<>();
        System.out.println("Sorting of Songs");
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "root");
            String myquery1 = "select * from song ORDER BY songName";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(myquery1);
            System.out.printf("%10s %25s %10s %25s %20s","songId","songName","duration","artist","genere");
            System.out.println();

            while (rs.next())
            {
                Songs song1=new Songs(rs.getInt("songId"),rs.getString("songName"),rs.getDouble("duration"),rs.getString("artist"),rs.getString("genere"),rs.getString("songPath"));

                System.out.printf("%10s %25s %10s %25s %20s", rs.getInt("songId"), rs.getString("songName"), rs.getDouble("duration"), rs.getString("artist"), rs.getString("genere")+ "\n");
            }

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println("-----------------------------------------------------------------------------------------------");

    }


}
