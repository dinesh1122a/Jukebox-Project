package dao;

import bean.Song;
import exception.ArtistNameNotFoundException;
import exception.GenreNotFoundException;
import exception.SongNotFoundException;
import util.DatabaseConnectionUtil;

import javax.naming.Name;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static util.DatabaseConnectionUtil.connectToDatabase;


public class SongDao {
    static Connection connection;
    public static List<Song> getSongList() throws SQLException {

        connection=connectToDatabase();
        List<Song>songList=new ArrayList<>();
        Statement statement= connection.createStatement();
        ResultSet resultSet=statement.executeQuery("select * from song");
        while (resultSet.next()){
            Song song=new Song();
            song.setId(resultSet.getInt(1));
            song.setName(resultSet.getString(2));
            song.setArtist(resultSet.getString(3));
            song.setGenre(resultSet.getString(4));
            song.setAlbum(resultSet.getString(5));
            song.setDuration(resultSet.getString(6));
            song.setUrl(resultSet.getString(7));
            song =new Song(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7));
            songList.add(song);
        }
        return songList;

    }

    public List<Song> searchBy(int press, String name) throws SQLException, SongNotFoundException, ArtistNameNotFoundException, GenreNotFoundException {

        List<Song> searchList = new ArrayList<>();

        String choice = "";
        switch (press) {
            case 1:
                choice = "Song name";
                break;
            case 2:
                choice = "ArtistName";
                break;
            case 3:
                choice = "Genre";
                break;
            default:
                System.out.println("invalid input");
        }
        String sql = "SELECT * FROM song WHERE " + choice + " LIKE '%" + name + "%';";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
           Song song=new Song();
           song.setId(resultSet.getInt(1));
            song.setName(resultSet.getString(2));
            song.setArtist(resultSet.getString(3));
            song.setGenre(resultSet.getString(4));
            song.setAlbum(resultSet.getString(5));
            song.setDuration(resultSet.getString(6));
            song.setUrl(resultSet.getString(7));
            song =new Song(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7));
            searchList.add(song);
        }



        if (searchList.size() == 0 && press == 1) {
            throw new SongNotFoundException("Song not Found");
        }
        if (searchList.size() == 0 && press == 2) {
            throw new ArtistNameNotFoundException("Artist not Found");
        }
        if (searchList.size() == 0 && press == 3) {
            throw new GenreNotFoundException("Genre not Found");
        }

        return searchList;
    }

}
