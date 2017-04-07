package sample;

import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;

public class Main extends Application {

    int y = 655;
    int[] x = {3,125,250,375,552,677,802,927};
    KeyCode[] p1 = {KeyCode.A,KeyCode.S,KeyCode.D,KeyCode.F};
    KeyCode[] p2 = {KeyCode.COLORED_KEY_0,KeyCode.COLORED_KEY_1,KeyCode.COLORED_KEY_2,KeyCode.COLORED_KEY_3};
    Pane pane = new Pane();
    Pane pane1 = new Pane();
    Scene scene = new Scene(pane);
    Stage Stage = new Stage();
    ImageView press = View(Importimage("image/Star1.png"));
    public void start(Stage Stage) throws Exception {

        Music("music/canon.mp3").play();
        pane.getChildren().add(View(Importimage("image/MAIN.jpg")));
        pane.getChildren().add(pane1);

        Press();
        TranslateTransition tt = new TranslateTransition(Duration.millis(2000),press);
        tt.setFromX(3);
        tt.setFromY(0);
        tt.setToY(800);
        tt.play();
        pane.getChildren().add(press);
        Showstage();


    }
    public void Showstage()
    {
        Stage.getIcons().add(new Image(getClass().getResource("image/Guitar-icon.png").toExternalForm()));
        Stage.setResizable(false);
        Stage.setTitle("GUITAR X");
        Stage.setScene(scene);
        Stage.show();}


    public AudioClip Music(String s) {
        URL resource = getClass().getResource(s);
        Media media = new Media(resource.toString());
        AudioClip AC = new AudioClip(media.getSource());
        return AC;

    }

    public Image Importimage(String s) {
        Image image = new Image(getClass().getResource(s).toExternalForm());
        return image;
    }

    public ImageView View(Image image) {
        ImageView imageView = new ImageView(image);
        return imageView;
    }

    public void Press() {
        scene.setOnKeyPressed(event -> {
            KeyCode keys = null;
            ImageView press1 = View(Importimage("image/Star1.png"));
            ImageView press2 = View(Importimage("image/Star2.png"));
            for(int i=0;i<4;i++)
            {
//                if(event.getCode() == p1[i])
//                {
//                    pane1.getChildren().add(press1);
//                    press1.setX(x[i]);
//                    press1.setY(y);
//                    break;
//                }
                if(event.getCode() == p2[i])
                {
                    pane1.getChildren().add(press2);
                    press2.setX(x[i+4]);
                    press2.setY(y);
                    break;
                }
            }
//            switch (event.getCode()) {
//                //player1
//                case A:
//                    pane1.getChildren().add(press1);
//                    press1.setX(3);
//                    press1.setY(655);
//                    break;
//                case S:
//                    pane1.getChildren().add(press1);
//                    press1.setX(125);
//                    press1.setY(655);
//                    break;
//                case D:
//                    pane1.getChildren().add(press1);
//                    press1.setX(250);
//                    press1.setY(655);
//                    break;
//                case F:
//                    pane1.getChildren().add(press1);
//                    press1.setX(375);
//                    press1.setY(655);
//                    break;
//                //player2
//                case K:
//                    pane1.getChildren().add(press2);
//                    press2.setX(552);
//                    press2.setY(655);
//                    break;
//                case L:
//                    pane1.getChildren().add(press2);
//                    press2.setX(677);
//                    press2.setY(655);
//                    break;
//                case SEMICOLON:
//                    pane1.getChildren().add(press2);
//                    press2.setX(802);
//                    press2.setY(655);
//                    break;
//                case QUOTE:
//                    pane1.getChildren().add(press2);
//                    press2.setX(927);
//                    press2.setY(655);
//                    break;
//            }
        });

        scene.setOnKeyReleased(event -> {
            pane1.getChildren().clear();
        });
    }


    public static void main(String[] args) {
        launch(args);
    }


}