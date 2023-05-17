package util;

import bean.Song;
import dao.SongDao;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DisplayUtil {
    Connection connection;
    PlayAudioUtil playAudioUtil=new PlayAudioUtil();
    Scanner scanner=new Scanner(System.in);

    public DisplayUtil()  {
    }
    public void mainMenu() throws SQLException {
        PlayAudioUtil playAudioUtil=new PlayAudioUtil();
        SongDao songDao=new SongDao();
        System.out.println("*******************************************************************");
        System.out.println("***************** WELCOME TO JUKEBOX********************************");
        System.out.println("********************************************************************");
        System.out.println("1.Display the songList ");
        System.out.println("2.Play a specific song");
        System.out.println("3.Play all the songs");
        System.out.println("3.search");
        System.out.println("4 Exit");
        int choice=scanner.nextInt();
        switch (choice){
            case 1:
                System.out.println("Press 1");
                DisplayUtil displayUtil=new DisplayUtil();
               List<Song> songList=songDao.getSongList();
               displayUtil.display(songList);
            case 2:
                System.out.println("enter song Id");
                int Id=scanner.nextInt();
                playAudioUtil.playSong(Id);
            case 3:
                System.out.println("Playing all the songs");
                List<Song>list=songDao.getSongList();
                playAudioUtil.playSong(list);
        }


    }

    public void display(List<Song> songList){
        System.out.println("------------------------------------------------------------------------------");
        System.out.printf("|\t%-5s|\t%-17s|\t%-14s|\t%-10s|\t%-14s|\t%-14s|\t%-14s|\n", "songId", "songName", "Artist,", "Album", "Genre", "Duration", "Url");
        for (Song song:songList){
            System.out.printf("|\t%-5s|\t%-17s|\t%-14s|\t%-10s|\t%-14s|\t%-14s|\t%-14s|\n", song.getId(), song.getName(), song.getArtist(), song.getAlbum(), song.getGenre(), song.getDuration(), song.getUrl());
        }

    }

}


