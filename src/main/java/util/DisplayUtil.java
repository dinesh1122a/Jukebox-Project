package util;

import bean.Song;
import dao.PlaylistDao;
import dao.SongDao;

import java.util.List;
import java.util.Scanner;

public class DisplayUtil {
    Scanner scanner = new Scanner(System.in);
    Scanner scanner1 = new Scanner(System.in);
    Scanner scanner2 = new Scanner(System.in);

    SongDao songDao = new SongDao();


    public DisplayUtil() {
    }

    public void mainMenu() throws Exception {
        PlayAudioUtil playAudioUtil = new PlayAudioUtil();
        DisplayUtil displayUtil = new DisplayUtil();
        int choose;
        do {

            System.out.println("********************+++++++++++++++++++++++****************************");
            System.out.println("*****************+++ WELCOME TO JUKEBOX+++********************************");
            System.out.println("*****************+++++++++++++++++++++++++++*************************");
            System.out.println("1.Display the songList ");
            System.out.println("2.Play a specific song");
            System.out.println("3.Play all the songs");
            System.out.println("4.search");
            System.out.println("5.create playlist");
            System.out.println("6 Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    List<Song> songList = SongDao.getSongList();
                    displayUtil.display(songList);
                case 2:
                    System.out.println("enter song Id");
                    int Id = scanner.nextInt();
                    playAudioUtil.playSong(Id);
                case 3:
                    System.out.println("Playing all the songs");
                    List<Song> list = SongDao.getSongList();
                    playAudioUtil.playSong(list);
                case 4:
                    System.out.println("-----------------------------");
                    System.out.println("1.search by songName");
                    System.out.println("2.search by artist");
                    System.out.println("3.search by genre");
                    System.out.println("4.search by album");
                    int option1 = scanner.nextInt();
                    switch (option1) {
                        case 1:
                            System.out.println("song name list");
                            System.out.println("Tu-aake-Dekhle 2-gulaab2 kanna pe baal wo Noor gaddi piche naa badmosh chora");
                            System.out.println("enter song name ");
                            String name = scanner1.nextLine();
                            songDao.searchByName(name);
                            break;
                        case 2:
                            System.out.println("artist list");
                            System.out.println("king billa pranjal dhaiya ap dhillon khan bhaini Mc square");
                            System.out.println("enter artist name");
                            String artist = scanner2.nextLine();
                            songDao.searchByArtist(artist);
                            break;
                        case 3:
                            System.out.println("genre list");
                            System.out.println("pop haryanvi mix punjabi");
                            System.out.println("enter genre name");
                            String genre = scanner1.nextLine();
                            songDao.searchByGenre(genre);
                            break;
                        case 4:
                            System.out.println("album list");
                            System.out.println("stage carnival white hill heart scycostyle zee music");
                            System.out.println("enter album name");
                            String album = scanner2.nextLine();
                            songDao.searchByAlbum(album);
                            break;
                        default:
                            System.out.println("invalid option plz enter correct option");
                    }
                    break;
                case 5:
                    System.out.println("create playlist");
                    System.out.println("1.view playlist");
                    int choice5 = scanner.nextInt();
                    switch (choice5) {

                        case 1:
                            System.out.println("view playlist");
                            List<Song> songLists = SongDao.getSongList();


                            displayUtil.display(songLists);
                            PlaylistDao playlistDao = new PlaylistDao();
                            playlistDao.createPlayList();
                            break;
                        case 2:
                            System.out.println("insert song into playlist");
                            break;
                        default:
                            System.out.println("plz enter correct choice");

                    }
                    break;
                default:
                    System.out.println("Thank you");


            }
            System.out.println("Enter 1 to mainMenu 0 for Exit");
            choose = scanner2.nextInt();
        }
        while (choose == 1);

    }


    public void display(List<Song> songList) {
        System.out.println("------------------------------------------------------------------------------");
        System.out.printf("|\t%-5s|\t%-17s|\t%-14s|\t%-10s|\t%-14s|\t%-14s|\t%-14s|\n", "songId", "songName", "Artist,", "Album", "Genre", "Duration", "Url");
        for (Song song : songList) {
            System.out.printf("|\t%-5s|\t%-17s|\t%-14s|\t%-10s|\t%-14s|\t%-14s|\t%-14s|\n", song.getId(), song.getName(), song.getArtist(), song.getAlbum(), song.getGenre(), song.getDuration(), song.getUrl());
        }

    }

}


