import Playlist.ImpPlaylist;
import Podcast.ImpPodcast;
import Songs.ImpSongs;
import User.ImpUser;


import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ImpSongs impSongs=new ImpSongs();
        ImpPodcast impPodcast=new ImpPodcast();
        ImpUser impUser=new ImpUser();
        ImpPlaylist impPlaylist=new ImpPlaylist();




        System.out.println("Welcome To Music World");
        System.out.println("Select\n 1. New User\n 2. Login");
        int choice1 = sc.nextInt();

            switch (choice1)
            {
                case 1:
                    impUser.newUser();
                    break;

                case 2:
                    System.out.println("Enter User Id");
                    int userId = sc.nextInt();
                    impUser.login(userId);

                    while (true)
                    {
                        System.out.println("To Proceed Please select\n 1. Songs\n 2. Podcast\n 3. Playlist\n 4. Exit");
                        int choice2 = sc.nextInt();

                            switch (choice2)
                            {
                                case 1:
                                    System.out.println("Select\n 1. Display All songs\n 2. Search Song\n 3. Sort Songs\n 4. Exit");
                                    int choice3 = sc.nextInt();
                                    switch (choice3)
                                    {
                                        case 1:
                                            impSongs.displaySongs();
                                            break;

                                        case 2:

                                            impSongs.searchSong();
                                            break;

                                        case 3:
                                            impSongs.sortSong();
                                            break;

                                        case 4:
                                            System.exit(0);

                                    }
                                    break;

                                case 2:
                                    System.out.println("Select\n 1. Display All Podcast\n 2. Search Podcast\n 3. Sort Podcast\n 4. Exit");
                                    int choice4 = sc.nextInt();
                                    switch (choice4)
                                    {
                                        case 1:
                                            impPodcast.displayPodcast();
                                            break;

                                        case 2:
                                           impPodcast.searchPodcast();
                                            break;

                                        case 3:
                                            impPodcast.sortPodcast();
                                            break;

                                        case 4:
                                            System.exit(0);
                                    }
                                    break;

                                case 3:
                                    System.out.println("Select\n 1. Create Playlist\n 2. View Playlist\n 3. View Songs and Podcast in Playlist\n 4. Play Song\n 5. Play Podcast\n 6. Add Song or Podcast to Playlist\n 7. Exit");
                                    int choice5 = sc.nextInt();
                                    switch (choice5)
                                    {
                                        case 1:
                                        	impPlaylist.createPlaylist(userId);
                                            break;

                                        case 2:
                                            impPlaylist.viewPlaylist(userId);
                                            break;

                                        case 3:
                                            impPlaylist.songsOrPodcastInPlaylist();
                                            break;

                                        case 4:
                                            impPlaylist.playSong();


                                            int c = 0;
                                            try {
                                            impPlaylist.play();
                                            Scanner scanner = new Scanner(System.in);
                                            while (true) {
                                            System.out.println("1. Pause");
                                            System.out.println("2. Resume");
                                            System.out.println("3. Restart");
                                            System.out.println("4. Stop");

                                            if (c == 4) {
                                            break;
                                            }

                                            if (scanner.hasNextInt()) {
                                            c = scanner.nextInt();
                                            } else {
                                            break;
                                            }
                                            switch (c) {
                                            case 1:
                                            impPlaylist.pause();
                                            break;
                                            case 2:
                                            impPlaylist.resumeAudio();
                                            break;
                                            case 3:
                                            impPlaylist.restart();
                                            break;
                                            case 4:
                                            impPlaylist.stop();
                                            break;
                                            }
                                            }
                                            } catch (Exception ex) {
                                                System.out.println("Error with playing sound." + ex);
                                            }
                                            break;

                                        case 5:
                                            impPlaylist.playPodcast();
                                            int d = 0;
                                            try {
                                                impPlaylist.play();
                                                Scanner scanner = new Scanner(System.in);
                                                while (true) {
                                                    System.out.println("1. Pause");
                                                    System.out.println("2. Resume");
                                                    System.out.println("3. Restart");
                                                    System.out.println("4. Stop");

                                                    if (d == 4) {
                                                        break;
                                                    }

                                                    if (scanner.hasNextInt()) {
                                                        d = scanner.nextInt();
                                                    } else {
                                                        break;
                                                    }
                                                    switch (d) {
                                                        case 1:
                                                            impPlaylist.pause();
                                                            break;
                                                        case 2:
                                                            impPlaylist.resumeAudio();
                                                            break;
                                                        case 3:
                                                            impPlaylist.restart();
                                                            break;
                                                        case 4:
                                                            impPlaylist.stop();
                                                            break;
                                                    }
                                                }
                                            } catch (Exception ex) {
                                                System.out.println("Error with playing sound." + ex);
                                            };
                                            break;

                                        case 6:
                                            impPlaylist.addSongsOrPodcastToPlaylist();
                                            break;

                                        case 7:
                                            System.exit(0);
                                            break;
                                    }
                                    break;


                        }
                    }


            }




    }
}
