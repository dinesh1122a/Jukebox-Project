package bean;

import java.util.Objects;

public class Playlist {
    private int id;
    private String name;
    private String dateOfCreation;
    private Song song;

    public Playlist(int id, String name, String dateOfCreation, Song song) {
        this.id = id;
        this.name = name;
        this.dateOfCreation = dateOfCreation;
        this.song = song;
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

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playlist playlist = (Playlist) o;
        return id == playlist.id && Objects.equals(name, playlist.name) && Objects.equals(dateOfCreation, playlist.dateOfCreation) && Objects.equals(song, playlist.song);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dateOfCreation, song);
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfCreation='" + dateOfCreation + '\'' +
                ", song=" + song +
                '}';
    }
}