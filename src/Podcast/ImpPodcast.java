package Podcast;

import Songs.Songs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ImpPodcast implements Ipodcast
{


    @Override
    public void displayPodcast()
    {
        ArrayList<Podcast> podcastList=new ArrayList<>();
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "root");
            String myquery1 = "select * from podcast";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(myquery1);
            System.out.printf("%10s %25s %10s %25s %20s %25s ","podcastId","podcastName","duration","celebrity","category","episodeNo");
            System.out.println();
            System.out.println();

            while (rs.next())
            {
                Podcast podcast1=new Podcast(rs.getInt("podcastId"),rs.getString("podcastName"),rs.getDouble("duration"),rs.getString("celebrity"),rs.getString("category"),rs.getString("podcastPath"), rs.getInt("episodeNo") );
                //songList.add(song1);
                System.out.printf("%10s %25s %10s %25s %20s %25s ", rs.getInt("podcastId"), rs.getString("podcastName"), rs.getDouble("duration"), rs.getString("celebrity"), rs.getString("category"),rs.getInt("episodeNo")+"\n");

            }

        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        System.out.println("--------------------------------------------------------------------------------------------------------------------------");


    }

    @Override
    public void searchPodcast() {
        ArrayList<Podcast> podcastList=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Podcast Name ");
        String search= sc.next();
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "root");
            String myquery1 = "select * from podcast where podcastName='"+search+"' or podcastId='"+search+"' or celebrity ='"+search+"'";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(myquery1);
            //System.out.printf("%10s %25s %10s %25s %20s","songId","songName","duration","artist","genere");
            System.out.println();

            while (rs.next())
            {
                Podcast podcast1=new Podcast(rs.getInt("podcastId"),rs.getString("podcastName"),rs.getDouble("duration"),rs.getString("celebrity"),rs.getString("category"),rs.getString("podcastPath"),rs.getInt("episodeNo"));

                podcastList.add(podcast1);
            }

        }
        catch(Exception e)
        {
            System.out.println(e);
        }


        podcastList.forEach(x->System.out.println("\n"+x));
        //List<Podcast> list1 = podcastList.stream().filter(s->s.getPodcastName().equals(search)).collect(Collectors.toList());

        System.out.println("-----------------------------------------------------------------------------------------------");
    }

    @Override
    public void sortPodcast() {
        ArrayList<Podcast> podcastsList=new ArrayList<>();
        System.out.println("Sorting of Podcast");
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "root");
            String myquery1 = "select * from podcast ORDER BY podcastName";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(myquery1);
            System.out.printf("%10s %25s %10s %25s %20s %25s ","podcastId","podcastName","duration","celebrity","category","episodeNo");
            System.out.println();

            while (rs.next())
            {
                Podcast podcast1=new Podcast(rs.getInt("podcastId"),rs.getString("podcastName"),rs.getDouble("duration"),rs.getString("celebrity"),rs.getString("category"),rs.getString("podcastPath"),rs.getInt("episodeNo"));

                System.out.printf("%10s %25s %10s %25s %20s %20s", rs.getInt("podcastId"), rs.getString("podcastName"), rs.getDouble("duration"), rs.getString("celebrity"), rs.getString("category"),rs.getInt("episodeNo")+"\n");
            }

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println("-----------------------------------------------------------------------------------------------");


    }
}
