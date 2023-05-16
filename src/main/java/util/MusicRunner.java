package util;

import bean.Song;
import dao.SongDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MusicRunner {

    public static void main(String[] args) throws SQLException {
        DatabaseConnectionUtil databaseConnectionUtil=new DatabaseConnectionUtil();
        Connection connection=databaseConnectionUtil.connectToDatabase();
        SongDao songDao=new SongDao();
        List<Song> songList=songDao.getSongList(connection);
        DisplayUtil displayUtil=new DisplayUtil();
        displayUtil.display(songList);


    }
}
