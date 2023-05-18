package dao;

import bean.Playlist;
import bean.Song;
import util.DatabaseConnectionUtil;

import javax.xml.transform.Result;
import java.sql.*;
import java.time.LocalDate;
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
//            playlists.setSongArrayList(resultSet.getObject();
        }
        return playlist;

    }

        public boolean createPlayList() throws SQLException {
            DatabaseConnectionUtil databaseConnectionUtil = new DatabaseConnectionUtil();
            Connection connection = databaseConnectionUtil.connectToDatabase();
            System.out.println("Enter Id");
            Scanner scanner = new Scanner(System.in);
            int Id = scanner.nextInt();
            System.out.println("Enter Song Name");
            String Name = scanner.next();
            System.out.println("Enter Date like YYYY-MM-DD");
            String dateofCreation = scanner.next();
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into  Playlist1 values (" + Id + ",'" + Name + "','" + dateofCreation + "');");
            return false;
        }

    }
