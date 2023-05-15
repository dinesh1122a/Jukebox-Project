package juke;

import java.util.Objects;

public class Playlist {
    private int id;
    private String name;
    private String dateOfCreation;

    public Playlist(int id, String name, String dateOfCreation) {
        this.id = id;
        this.name = name;
        this.dateOfCreation = dateOfCreation;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playlist playlist = (Playlist) o;
        return id == playlist.id && Objects.equals(name, playlist.name) && Objects.equals(dateOfCreation, playlist.dateOfCreation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dateOfCreation);
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfCreation='" + dateOfCreation + '\'' +
                '}';
    }
}
