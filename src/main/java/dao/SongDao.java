package dao;

import bean.Song;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static util.DatabaseConnectionUtil.connectToDatabase;


public class SongDao {
    Connection connection;
    public List<Song> getSongList(Connection dbConnection) throws SQLException {

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
            song.setUrl(resultSet.getLong(7));
            song =new Song(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getLong(7));
            songList.add(song);
        }
        return songList;

    }

}
