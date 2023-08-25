package dao;

<<<<<<< HEAD
import bean.Song;

import exception.AlbumNotFoundException;
import exception.ArtistNotFoundException;
import exception.GenreNotFoundException;
import exception.SongNameNotFound;
import util.PlayAudioUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import static util.DatabaseConnectionUtil.connectToDatabase;


public class SongDao {
    static Connection connection;

    PlayAudioUtil playAudioUtil = new PlayAudioUtil();


    public static List<Song> getSongList() throws SQLException {
        connection = connectToDatabase();
        List<Song> songList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from song");
        while (resultSet.next()) {
            Song song = new Song();
            song.setId(resultSet.getInt(1));
            song.setName(resultSet.getString(2));
            song.setArtist(resultSet.getString(3));
            song.setGenre(resultSet.getString(4));
            song.setAlbum(resultSet.getString(5));
            song.setDuration(resultSet.getString(6));
            song.setUrl(resultSet.getString(7));
            song = new Song(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7));
            songList.add(song);

            Comparator<Song> genreComparator = ((o1, o2) -> o1.getGenre().compareTo(o2.getGenre()));
            songList.sort(genreComparator);



        }
        return songList;

    }

    public List<Song> searchByName(String Song) throws Exception {
        connection = connectToDatabase();
        Song song;
        List<Song> songList = new ArrayList<>();
        if (songList.size()==0 ) {
            throw new SongNameNotFound("song not found");
        }else {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from song where name = '" + Song + "';");
            while (resultSet.next()) {
                song = new Song(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7));
                songList.add(song);
            }
        }


        playAudioUtil.playSong(songList);
        return songList;
    }

    public List<Song> searchByArtist(String Song) throws SQLException,ArtistNotFoundException{
        connection = connectToDatabase();
        Song song;
        List<Song> songList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from song where artist = '" + Song + "';");
        while (resultSet.next()) {
            song = new Song(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7));
            songList.add(song);
        }
        if (songList.size() < 1 ) {
            throw new ArtistNotFoundException("Artist not found");
        }
        playAudioUtil.playSong(songList);
        return songList;
    }


    public List<Song> searchByGenre(String Song) throws Exception {
      connection=connectToDatabase();
        Song song;
        List<Song> songList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from song where genre = '" + Song + "';");
        while (resultSet.next()) {
            song = new Song(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7));
            songList.add(song);
        }
        if(songList.size()==0){
            throw new GenreNotFoundException("NOT found");
        }
        playAudioUtil.playSong(songList);
        return songList;
    }

    public List<Song> searchByAlbum(String Song) throws Exception {
        connection=connectToDatabase();
        Song song;
        List<Song> songList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from song where album = '" + Song + "';");
            while (resultSet.next()) {
                song = new Song(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7));
                    songList.add(song);
            }
            if (songList.size()==0){
                throw new AlbumNotFoundException("not found");
            }

        playAudioUtil.playSong(songList);
        return songList;
    }

=======
public class SongDao {
>>>>>>> origin/master

}
