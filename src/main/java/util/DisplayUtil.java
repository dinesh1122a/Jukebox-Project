package util;

import bean.Song;

import java.util.List;
import java.util.Scanner;

public class DisplayUtil {
    public void display(List<Song> songList){
        System.out.println("------------------------------------------------------------------------------");
        System.out.printf("|\t%-5s|\t%-17s|\t%-14s|\t%-10s|\t%-14s|\t%-14s|\t%-14s|\n", "songId", "songName", "Artist,", "Album", "Genre", "Duration", "Url");
        for (Song song:songList){
            System.out.printf("|\t%-5s|\t%-17s|\t%-14s|\t%-10s|\t%-14s|\t%-14s|\t%-14s|\n", song.getId(), song.getName(), song.getArtist(), song.getAlbum(), song.getGenre(), song.getDuration(), song.getUrl());
        }



    }

}
