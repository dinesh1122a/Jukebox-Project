package util;

import bean.Song;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class PlayAudioUtil {
    Scanner scanner = new Scanner(System.in);

    public void playSong(int id) {
        DatabaseConnectionUtil databaseConnectionUtil=new DatabaseConnectionUtil();
        Connection connection=databaseConnectionUtil.connectToDatabase();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select  url from song where songId= '" + id + "';");

            String url=null;
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
                    if (response.equals("Q") || response.equals("q"))
                        break;
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


//
//    public void pause() {
//        if (status.equals("paused")) {
//            System.out.println("audio is already paused");
//            return;
//        }
//        this.currentFrame = this.clip.getMicrosecondPosition();
//        clip.stop();
//        status = "paused";
//    }
//
//
//    public void resumeAudio() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
//        if (status.equals("play")) {
//            System.out.println("Audio is already " + "being played");
//            return;
//        }
//        clip.close();
//        resetAudioStream();
//        clip.setMicrosecondPosition(currentFrame);
//        this.play();
//    }
//
//
//    public void restart() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
//        clip.stop();
//        clip.close();
//        resetAudioStream();
//        currentFrame = 0L;
//        clip.setMicrosecondPosition(0);
//        this.play();
//    }
//
//
//    public void stop() {
//        currentFrame = 0L;
//        clip.stop();
//        clip.close();
//    }
//
//    public void resetAudioStream() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
//        audioInputStream = AudioSystem.getAudioInputStream(new File(url).getAbsoluteFile());
//        clip.open(audioInputStream);
//        clip.loop(Clip.LOOP_CONTINUOUSLY);
//    }
//



//    public void PlaySong(List<Song> songList) {
//        try {
//            AudioInputStream audioStream = AudioSystem.getAudioInputStream(();
//            Clip clip = AudioSystem.getClip();
//            clip.open(audioStream);
//            String response = "";
//            while (!response.equals("Q")) {
//                System.out.println("P=Play,S=Stop,R=Reset,Q=Quit");
//                response = scanner.next();
//                response = response.toUpperCase();
//                switch (response) {
//                    case ("P"):
//                        clip.start();
//                        break;
//                    case ("S"):
//                        clip.stop();
//                        break;
//                    case ("R"):
//                        clip.setMicrosecondPosition(1);
//                        break;
//                    case ("Q"):
//                        clip.close();
//                        break;
//                    default:
//                        System.out.println("Your Choice is Wrong Enter Correct choice");
//                }
//                if (response.equals("Q")||response.equals("q"))
//                    break;
//            }
//        } catch (UnsupportedAudioFileException e) {
//            throw new RuntimeException(e);
//        } catch (LineUnavailableException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
//
//
//
//
//
//
}