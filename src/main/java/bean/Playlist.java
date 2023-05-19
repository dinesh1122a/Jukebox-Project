package bean;

import java.util.ArrayList;


public class Playlist {
    private int id;
    private String name;
    private String dateOfCreation;
    private ArrayList<Song> songArrayList;

    public Playlist(int id, String name, String dateOfCreation, ArrayList<Song> songArrayList) {
        this.id = id;
        this.name = name;
        this.dateOfCreation = dateOfCreation;
        this.songArrayList = songArrayList;
    }

    public Playlist() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public ArrayList<Song> getSongArrayList() {
        return songArrayList;
    }

    public void setSongArrayList(ArrayList<Song> songArrayList) {
        this.songArrayList = songArrayList;
    }


    @Override
    public String toString() {
        return "Playlist{" + "id=" + id + ", name='" + name + '\'' + ", dateOfCreation='" + dateOfCreation + '\'' + ", songArrayList=" + songArrayList + '}';
    }
}