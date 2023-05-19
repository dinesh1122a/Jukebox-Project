package dao;

import bean.Playlist;
import util.DatabaseConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static util.DatabaseConnectionUtil.connectToDatabase;

public class PlaylistDao {
    Connection connection = DatabaseConnectionUtil.connectToDatabase();

    public List<Playlist> getPlayList() throws SQLException {
        connection = connectToDatabase();
        List<Playlist> playlist = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from playlist");
        while (resultSet.next()) {
            Playlist playlists = new Playlist();
            playlists.setId(resultSet.getInt(1));
            playlists.setName(resultSet.getString(2));
            playlists.setDateOfCreation(resultSet.getString(3));

        }
        return playlist;

    }

    public void createPlayList() throws SQLException {
        DatabaseConnectionUtil databaseConnectionUtil = new DatabaseConnectionUtil();
        Connection connection = connectToDatabase();
        System.out.println("Enter Id");
        Scanner scanner = new Scanner(System.in);
        int playlistid = scanner.nextInt();
        System.out.println("Enter Song Name");
        String name = scanner.next();
        System.out.println("Enter Date like YYYY-MM-DD");
        String dateofcreation = scanner.next();
        Statement statement = connection.createStatement();
        statement.executeUpdate("insert into  playlist values (" + playlistid + ",'" + name + "','" + dateofcreation + "');");

    }

}
