package util;

import bean.Song;
import dao.SongDao;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MusicRunner {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        DisplayUtil displayUtil = new DisplayUtil();
        displayUtil.mainMenu();


    }
}


