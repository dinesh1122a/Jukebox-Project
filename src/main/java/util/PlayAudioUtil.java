package util;

import bean.Song;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PlayAudioUtil {
    static Scanner scanner = new Scanner(System.in);

    public void playSong(int id) {
        DatabaseConnectionUtil databaseConnectionUtil = new DatabaseConnectionUtil();
        Connection connection = DatabaseConnectionUtil.connectToDatabase();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select  url from song where songId= '" + id + "';");

            String url = null;
            while (resultSet.next()) {
                url = resultSet.getString("url");
            }
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(url));
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            String response = "";
            while (!response.equals("Q")) {
                System.out.println("p=Play,s=Stop,r=Reset,q=Quit,N=next");
                response = scanner.next();
                response = response.toUpperCase();
                switch (response) {
                    case ("P"):
                        clip.start();
                        break;
                    case ("S"):
                        clip.stop();
                        break;
                    case ("R"):
                        clip.setMicrosecondPosition(1);
                        break;
                    case ("Q"):
                        clip.close();
                        break;
                    case ("N"):
                        clip.stop();
                        continue;
                    default:
                        System.out.println("Your Choice is Wrong Enter Correct choice");
                }
                if (response.equals("Q") || response.equals("q")) break;
            }

        } catch (UnsupportedAudioFileException ex) {
            throw new RuntimeException(ex);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (LineUnavailableException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }


    public void playSong(List<Song> songList) {


        Iterator<Song> iterator = songList.iterator();
        String url = "";
        try {
            while (iterator.hasNext()) {
                url = iterator.next().getUrl();
                AudioInputStream audioStream = AudioSystem.getAudioInputStream((new File(url)));
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                String response = "";

                while (!response.equals("Q")) {
                    System.out.println("P=Play,S=Stop,R=Reset,,N=Next,Q=Quit,");
                    response = scanner.next();
                    response = response.toUpperCase();
                    switch (response) {
                        case ("P"):
                            clip.start();
                            break;
                        case ("S"):
                            clip.stop();
                            break;
                        case ("R"):
                            clip.setMicrosecondPosition(1);
                            break;
                        case ("N"):
                            clip.close();
                            break;
                        case ("Q"):
                            clip.close();
                            break;
                        default:
                            System.out.println("Your Choice is Wrong Enter Correct choice");
                    }
                    if (response.equals("Q") || response.equals("q") || response.equals("N") || response.equals("n"))
                        break;
                }
                if (response.equals("Q") || response.equals("q")) break;
            }
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}




