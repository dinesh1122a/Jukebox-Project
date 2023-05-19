import bean.Song;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SongTest {
    Song song =new Song();
    @Before
    public void setUp()
    {
        song = new Song(4," wo Noor","ap dhillon","mix","heart","00:02:34","D:\\java\\juke\\src\\main\\resources\\Wo-Noor---Ap-Dhillon(PagalWorld).wav");
    }
    @After
    public void tearDown()

    {
        song=null;
    }
    @Test
    public void checkSong()
    {
        assertEquals(4,song.getId());
    }
    @Test
    public void checkSongbyName()
    {
        assertEquals(" wo Noor",song.getName());
    }
    @Test
    public void checkgenre()
    {
        assertEquals("mix",song.getGenre());
    }
    @Test
    public void checkalbumName()
    {
        assertEquals("heart",song.getAlbum());
    }
    @Test
    public void checkartistName()
    {
        assertEquals("ap dhillon",song.getArtist());
    }


}


