package util;

import bean.Song;
import dao.SongDao;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MusicRunner {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        DisplayUtil displayUtil=new DisplayUtil();
        displayUtil.mainMenu();


//        DatabaseConnectionUtil databaseConnectionUtil=new DatabaseConnectionUtil();
//        Connection connection=databaseConnectionUtil.connectToDatabase();
//        SongDao songDao=new SongDao();
//        List<Song> songList=songDao.getSongList();
//        DisplayUtil displayUtil=new DisplayUtil();
//        displayUtil.display(songList);
//        PlayAudioUtil playAudioUtil=new PlayAudioUtil();
//        Scanner scanner=new Scanner(System.in);
//        System.out.println("1.enter songId");
//        System.out.println("2.play all songs");
//        System.out.println("3.exit");
//        int choice=scanner.nextInt();
//        switch (choice){
//            case 1:
//                System.out.println("enter songId");
//                int songId=scanner.nextInt();
//                playAudioUtil.playSong(songId);
//                break;
//            case 2:
//                playAudioUtil.playSong(songList);
//                break;
//            case 3:
//                System.out.println("exit");
//                break;
//            default:
//        }
////
//    }
//}
    }
}


