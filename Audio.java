package sample;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;

import java.net.URL;

/**
 * Created by warat on 15/4/2560.
 */
public class Audio {

    private String backinblack = "music/backinblack.mp3";
    private String canon = "music/canon.mp3";
    private String cometogether = "music/comtogether.mp3";
    private String icky = "music/icky.mp3";
    private String marugo = "music/marukohook.mp3";
    private String undone = "music/undone.mp3";
    private String guitar1 = "music/guitarline1.mp3";
    private String guitar2 = "music/guitarline2.mp3";
    private String guitar3 = "music/guitarline3.mp3";
    private String guitar4 = "music/guitarline4.mp3";
    private String guitar5 = "music/guitarline5.mp3";
    private String guitar6 = "music/guitarline6.mp3";

    public Audio() {

    }

    public AudioClip getBackinblack() {
        return Music(backinblack);
    }

    public AudioClip getCanon() {
        return Music(canon);
    }

    public AudioClip getCometogether() {
        return Music(cometogether);
    }

    public AudioClip getIcky() {
        return Music(icky);
    }

    public AudioClip getMarugo() {
        return Music(marugo);
    }

    public AudioClip getUndone() {
        return Music(undone);
    }

    public AudioClip getGuitar1() {
        return Music(guitar1);
    }

    public AudioClip getGuitar2() {
        return Music(guitar2);
    }

    public AudioClip getGuitar3() {
        return Music(guitar3);
    }

    public AudioClip getGuitar4() {
        return Music(guitar4);
    }

    public AudioClip getGuitar5() {
        return Music(guitar5);
    }

    public AudioClip getGuitar6() {
        return Music(guitar6);
    }


    public AudioClip Music(String s) {
        URL resource = getClass().getResource(s);
        Media media = new Media(resource.toString());
        AudioClip AC = new AudioClip(media.getSource());
        return AC;

    }
}
