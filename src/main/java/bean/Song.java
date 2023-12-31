package bean;



public class Song {
    private int id;
    private String name;
    private String artist;
    private String genre;
    private String album;
    private String duration;
    private String url;

    public Song(int id, String name, String artist, String genre, String album, String duration, String url) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.album = album;
        this.duration = duration;
        this.url = url;
    }

    public Song() {

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

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public String toString() {
        return "Song{" + "id=" + id + ", name='" + name + '\'' + ", artist='" + artist + '\'' + ", genre='" + genre + '\'' + ", album='" + album + '\'' + ", duration='" + duration + '\'' + ", url='" + url + '\'' + '}';
    }
}
