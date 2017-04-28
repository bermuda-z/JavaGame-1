package sample;

import javafx.animation.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.util.ArrayList;

import static javafx.util.Duration.*;


    public class Main extends Application {
    /////////////////////////////////////////////////////////////////////////////
    private String filelocation = "C:\\Users\\warat\\IdeaProjects\\javaFXasigntGame\\src\\sample";
    private String Player1 = new String();
    private String Player2 = new String();
    //main
    private Pane panemain = new Pane();
    private Pane panewire1 = new Pane();
    private Pane panewire2 = new Pane();
    private Pane panewire3 = new Pane();
    javafx.scene.control.TextField textField1 = new javafx.scene.control.TextField();
    javafx.scene.control.TextField textField2 = new javafx.scene.control.TextField();
    javafx.scene.control.TextField textField3 = new javafx.scene.control.TextField();
    javafx.scene.control.TextField textField4 = new javafx.scene.control.TextField();


    //game
    private int[] x1 = {0, 137, 274, 411};
    private int[] x2 = {548, 685, 822, 959};
    private Pane panegame = new Pane();
    private Pane pane0 = new Pane();
    private Pane pane1 = new Pane();
    private Pane pane2 = new Pane();
    private Pane pane3 = new Pane();
    private Pane pane4 = new Pane();
    private Pane pane5 = new Pane();
    private Pane pane6 = new Pane();
    private Pane pane7 = new Pane();
    private Pane panescore1 = new Pane();
    private Pane panescore2 = new Pane();
    private Pane perfectpane = new Pane();
    private Duration d = Duration.millis(500);
    private boolean[] playerpress1 = new boolean[4];
    private boolean[] playerpress2 = new boolean[4];
    private boolean[] noteflow1 = new boolean[4];
    private boolean[] noteflow2 = new boolean[4];

    private int[] score = new int[2];
    private int[] lastscore = new int[2];
    private int[] combo = new int[2];
    private Gimage gimage = new Gimage();
    private Audio audio;
    private Scene scenegame = new Scene(panegame);
    //Highscore
    private Pane paneHS = new Pane();
    private Scene sceneHS = new Scene(paneHS);
    private Scene scenemain = new Scene(panemain);
    private Stage Stage = new Stage();
    private Pane pane123 = new Pane();
    private Scene scene123 = new Scene(pane123);

    public Main() {
        audio = new Audio();
    }

    public void start(Stage Stage) throws Exception {

        touch();
        paneMain();

    }

    public void paneHS() {
        Player1 = textField1.getText();
        Player2 = textField2.getText();
        if(textField1.getText().isEmpty())
        {
            Player1 = "Unknown1";
        }
        if(textField2.getText().isEmpty())
        {
            Player2 = "Unknown2";
        }
        paneHS.getChildren().clear();
        paneHS.getChildren().add(gimage.getHS());
        paneHS.getChildren().add(gimage.getBack());
//        paneHS.getChildren().add(gimage.getAgain());
        Text text1 = new Text(Player1);
        text1.setFont(Font.font("Impact", 50));
        text1.setFill(Color.WHITE);
        text1.setStroke(Color.BLACK);
        text1.setX(200);
        text1.setY(550);
        paneHS.getChildren().add(text1);
        Text text2 = new Text(Player2);
        text2.setFont(Font.font("Impact", 50));
        text2.setFill(Color.WHITE);
        text2.setStroke(Color.BLACK);
        text2.setX(200);
        text2.setY(650);
        paneHS.getChildren().add(text2);
        Text text3 = new Text(score[0] + "");
        text3.setFont(Font.font("Impact", 50));
        text3.setFill(Color.WHITE);
        text3.setStroke(Color.BLACK);
        text3.setX(800);
        text3.setY(550);
        paneHS.getChildren().add(text3);
        Text text24 = new Text(score[1] + "");
        text24.setFont(Font.font("Impact", 50));
        text24.setFill(Color.WHITE);
        text24.setStroke(Color.BLACK);
        text24.setX(800);
        text24.setY(650);
        paneHS.getChildren().add(text24);


//        paneHS();
//        audio.getIcky().stop();

        sceneHS.setOnMouseClicked(MouseEvent -> {
            System.out.println(MouseEvent.getX() + "  " + MouseEvent.getY());

            if (MouseEvent.getX() > 25 && MouseEvent.getX() < 200 && MouseEvent.getY() > 700 && MouseEvent.getY() < 800) {
                Showstage(scenemain);
            }

        });


        sceneHS.setOnMouseMoved(MouseEvent -> {

            if (MouseEvent.getY() > 128 && MouseEvent.getY() < 131) {
                audio.getGuitar6().play();
            }
            if (MouseEvent.getY() > 151 && MouseEvent.getY() < 154) {
                audio.getGuitar5().play();
            }
            if (MouseEvent.getY() > 174 && MouseEvent.getY() < 177) {
                audio.getGuitar4().play();
            }
            if (MouseEvent.getY() > 200 && MouseEvent.getY() < 203) {
                audio.getGuitar3().play();
            }
            if (MouseEvent.getY() > 229 && MouseEvent.getY() < 232) {
                audio.getGuitar2().play();
            }
            if (MouseEvent.getY() > 250 && MouseEvent.getY() < 253) {
                audio.getGuitar1().play();
            }

        });
        Showstage(sceneHS);
    }

    public void paneGame() {

        panegame.getChildren().clear();
        panegame.getChildren().add(gimage.getMain());
        panegame.getChildren().add(panescore1);
        panegame.getChildren().add(panescore2);
        panegame.getChildren().add(perfectpane);

        panegame.getChildren().add(gimage.getMercury());
        panegame.getChildren().add(gimage.getVenus());
        panegame.getChildren().add(gimage.getEarth());
        panegame.getChildren().add(gimage.getMars());
        panegame.getChildren().add(gimage.getJupiter());
        panegame.getChildren().add(gimage.getSaturn());
        panegame.getChildren().add(gimage.getUrenus());
        panegame.getChildren().add(gimage.getNeptune());
        panegame.getChildren().add(gimage.getRocket());
    }

    public void paneMain() {
        panemain.getChildren().clear();
        panemain.getChildren().add(gimage.getBG());
        panemain.getChildren().add(gimage.getWire1());
        panemain.getChildren().add(gimage.getWire2());
        panemain.getChildren().add(gimage.getWire3());
        panemain.getChildren().add(gimage.getTitle1());
        panemain.getChildren().add(panewire1);
        panemain.getChildren().add(panewire2);
        panemain.getChildren().add(panewire3);
        panemain.getChildren().add(textField1);
        panemain.getChildren().add(textField2);
        panemain.getChildren().add(textField3);
        panemain.getChildren().add(textField4);

        textField1.setLayoutX(800);
        textField1.setLayoutY(300);
        textField1.setScaleX(2);
        textField1.setScaleY(2);
        textField1.setPrefColumnCount(10);
        textField1.setPromptText("Enter your name(1)");
        Paint paint = Paint.valueOf("585858");
        textField1.setBackground(new Background(new BackgroundFill(paint, CornerRadii.EMPTY, Insets.EMPTY)));
        textField2.setLayoutX(800);
        textField2.setLayoutY(400);
        textField2.setScaleX(2);
        textField2.setScaleY(2);
        textField2.setPrefColumnCount(10);
        textField2.setPromptText("Enter your name(2)");
        textField2.setBackground(new Background(new BackgroundFill(paint, CornerRadii.EMPTY, Insets.EMPTY)));

        textField3.setLayoutX(800);
        textField3.setLayoutY(500);
        textField3.setScaleX(2);
        textField3.setScaleY(2);
        textField3.setPrefColumnCount(10);
        textField3.setPromptText("Enter speed");
        textField3.setBackground(new Background(new BackgroundFill(paint, CornerRadii.EMPTY, Insets.EMPTY)));

        textField4.setLayoutX(800);
        textField4.setLayoutY(600);
        textField4.setScaleX(2);
        textField4.setScaleY(2);
        textField4.setPrefColumnCount(10);
        textField4.setPromptText("Enter amount");
        textField4.setBackground(new Background(new BackgroundFill(paint, CornerRadii.EMPTY, Insets.EMPTY)));

        Text text = new Text();
        text.setText("Please enter speed and amount");
        text.setFont(Font.font("aliens and cows", 40));
        text.setFill(Color.RED);
        text.setX(550);
        text.setY(700);


        scenemain.setOnMouseClicked((MouseEvent MouseEvent) -> {


            if (MouseEvent.getX() > 95 && MouseEvent.getX() < 113) {


                if (textField3.getText().isEmpty() && textField4.getText().isEmpty()) {
                    panemain.getChildren().remove(text);
                    panemain.getChildren().remove(textField3);
                    panemain.getChildren().remove(textField4);
                    Paint paint2 = Paint.valueOf("BC3838");

                    textField3.setBackground(new Background(new BackgroundFill(paint2, CornerRadii.EMPTY, Insets.EMPTY)));
                    textField4.setBackground(new Background(new BackgroundFill(paint2, CornerRadii.EMPTY, Insets.EMPTY)));

                    panemain.getChildren().add(textField3);
                    panemain.getChildren().add(textField4);

                    panemain.getChildren().add(text);
                } else {

                    Timeline timeline = new Timeline();
                    timeline.getKeyFrames().add(
                            new KeyFrame(millis(1000),
                                    (ActionEvent event) -> {
                                        pane123.getChildren().add(gimage.getMain());
                                        pane123.getChildren().add(gimage.getThree());
                                        Showstage(scene123);
                                    })
                    );
                    timeline.play();
                    pane123.getChildren().clear();
                    Timeline timeline1 = new Timeline();
                    timeline1.getKeyFrames().add(
                            new KeyFrame(millis(1500),
                                    (ActionEvent event) -> {
                                        pane123.getChildren().add(gimage.getMain());
                                        pane123.getChildren().add(gimage.getTwo());
                                        Showstage(scene123);
                                    })
                    );
                    timeline1.play();
                    pane123.getChildren().clear();
                    Timeline timeline2 = new Timeline();
                    timeline2.setCycleCount(2);
                    timeline2.getKeyFrames().add(
                            new KeyFrame(millis(2000),
                                    (ActionEvent event) -> {
                                        pane123.getChildren().add(gimage.getMain());
                                        pane123.getChildren().add(gimage.getOne());
                                        Showstage(scene123);
                                    })
                    );
                    timeline2.play();
                    pane123.getChildren().clear();
                    timeline2.setOnFinished((ActionEvent Event) ->
                    {
                        Playerpress();
                        flow(textField4.getText());
                        paneGame();
                        Showstage(scenegame);

                        panemain.getChildren().remove(text);
                        panemain.getChildren().remove(textField3);
                        panemain.getChildren().remove(textField4);

                        Paint paint3 = Paint.valueOf("585858");

                        textField3.setBackground(new Background(new BackgroundFill(paint3, CornerRadii.EMPTY, Insets.EMPTY)));
                        textField4.setBackground(new Background(new BackgroundFill(paint3, CornerRadii.EMPTY, Insets.EMPTY)));
                        panemain.getChildren().add(textField3);
                        panemain.getChildren().add(textField4);
                    });

                }
            } else if (MouseEvent.getX() > 245 && MouseEvent.getX() < 266) {

                panemain.getChildren().remove(text);
                panemain.getChildren().remove(textField3);
                panemain.getChildren().remove(textField4);
                paneHS();

                Paint paint3 = Paint.valueOf("585858");

                textField3.setBackground(new Background(new BackgroundFill(paint3, CornerRadii.EMPTY, Insets.EMPTY)));
                textField4.setBackground(new Background(new BackgroundFill(paint3, CornerRadii.EMPTY, Insets.EMPTY)));
                panemain.getChildren().add(textField3);
                panemain.getChildren().add(textField4);


            } else if (MouseEvent.getX() > 396 && MouseEvent.getX() < 414) {
                Platform.exit();
            }
        });
        Showstage(scenemain);
    }

    public void Read0() {

        ImageView press = gimage.getMercury1();
        panegame.getChildren().add(press);
        press.setLayoutX(x1[0]);
        KeyValue keyValue = new KeyValue(press.yProperty(), 657);
        KeyFrame keyFrame = new KeyFrame(d, keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();

        timeline.setOnFinished((ActionEvent Event) ->
        {
            noteflow1[0] = true;
            panegame.getChildren().remove(press);
        });

    }

    public void Read1() {

        ImageView press = gimage.getVenus1();
        panegame.getChildren().add(press);
        press.setLayoutX(x1[1]);
        KeyValue keyValue = new KeyValue(press.yProperty(), 657);
        KeyFrame keyFrame = new KeyFrame(d, keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();

        timeline.setOnFinished((ActionEvent Event) ->
        {
            noteflow1[1] = true;
            panegame.getChildren().remove(press);
        });

    }

    public void Read2() {

        ImageView press = gimage.getEarth1();
        panegame.getChildren().add(press);
        press.setLayoutX(x1[2]);
        KeyValue keyValue = new KeyValue(press.yProperty(), 657);
        KeyFrame keyFrame = new KeyFrame(d, keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();

        timeline.setOnFinished((ActionEvent Event) ->
        {
            noteflow1[2] = true;
            panegame.getChildren().remove(press);
        });

    }

    public void Read3() {

        ImageView press = gimage.getMars1();
        panegame.getChildren().add(press);
        press.setLayoutX(x1[3]);
        KeyValue keyValue = new KeyValue(press.yProperty(), 657);
        KeyFrame keyFrame = new KeyFrame(d, keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();

        timeline.setOnFinished((ActionEvent Event) ->
        {
            noteflow1[3] = true;
            panegame.getChildren().remove(press);
        });

    }

    public void Read4() {

        ImageView press = gimage.getJupiter1();
        panegame.getChildren().add(press);
        press.setLayoutX(x2[0]);
        KeyValue keyValue = new KeyValue(press.yProperty(), 657);
        KeyFrame keyFrame = new KeyFrame(d, keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();

        timeline.setOnFinished((ActionEvent Event) ->
        {
            noteflow2[0] = true;
            panegame.getChildren().remove(press);
        });

    }

    public void Read5() {

        ImageView press = gimage.getSaturn1();
        panegame.getChildren().add(press);
        press.setLayoutX(x2[1]);
        KeyValue keyValue = new KeyValue(press.yProperty(), 657);
        KeyFrame keyFrame = new KeyFrame(d, keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();

        timeline.setOnFinished((ActionEvent Event) ->
        {
            noteflow2[1] = true;
            panegame.getChildren().remove(press);
        });

    }

    public void Read6() {

        ImageView press = gimage.getUrenus1();
        panegame.getChildren().add(press);
        press.setLayoutX(x2[2]);
        KeyValue keyValue = new KeyValue(press.yProperty(), 657);
        KeyFrame keyFrame = new KeyFrame(d, keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();

        timeline.setOnFinished((ActionEvent Event) ->
        {
            noteflow2[2] = true;
            panegame.getChildren().remove(press);
        });

    }

    public void Read7() {

        ImageView press = gimage.getNeptune1();
        panegame.getChildren().add(press);
        press.setLayoutX(x2[3]);
        KeyValue keyValue = new KeyValue(press.yProperty(), 657);
        KeyFrame keyFrame = new KeyFrame(d, keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();

        timeline.setOnFinished((ActionEvent Event) ->
        {
            noteflow2[3] = true;
            panegame.getChildren().remove(press);
        });

    }

    public void Playerpress() {

        scoreBar1();
        scoreBar2();


        scenegame.setOnKeyPressed((KeyEvent event) -> {

            int count1 = 0;
            int count2 = 0;
            double time = 100;
            //Player1
            boolean A = event.getCode() == KeyCode.A;
            boolean S = event.getCode() == KeyCode.S;
            boolean D = event.getCode() == KeyCode.D;
            boolean F = event.getCode() == KeyCode.F;
            boolean J = event.getCode() == KeyCode.J;
            boolean K = event.getCode() == KeyCode.K;
            boolean L = event.getCode() == KeyCode.L;
            boolean SEMICOLON = event.getCode() == KeyCode.SEMICOLON;

            if (A) {

                ImageView Perfect = gimage.getMercury();
                Perfect.setX(x1[0]);
                Perfect.setY(650);
                ScaleTransition perfect = new ScaleTransition(Duration.millis(time), Perfect);
                perfect.setByX(0.2f);
                perfect.setByY(0.2f);
                perfect.setAutoReverse(false);
                perfect.play();
                perfectpane.getChildren().add(Perfect);
                perfect.setOnFinished(event1 -> perfectpane.getChildren().remove(Perfect));

                playerpress1[0] = true;
                Checkscore1();
            }
            if (S) {

                ImageView Perfect = gimage.getVenus();
                Perfect.setX(x1[1]);
                Perfect.setY(650);
                ScaleTransition perfect = new ScaleTransition(Duration.millis(time), Perfect);
                perfect.setByX(0.2f);
                perfect.setByY(0.2f);
                perfect.setAutoReverse(false);
                perfect.play();
                perfectpane.getChildren().add(Perfect);
                perfect.setOnFinished(event1 -> perfectpane.getChildren().remove(Perfect));

                playerpress1[1] = true;
                Checkscore1();
            }
            if (D) {

                ImageView Perfect = gimage.getEarth();
                Perfect.setX(x1[2]);
                Perfect.setY(650);
                ScaleTransition perfect = new ScaleTransition(Duration.millis(time), Perfect);
                perfect.setByX(0.2f);
                perfect.setByY(0.2f);
                perfect.setAutoReverse(false);
                perfect.play();
                perfectpane.getChildren().add(Perfect);
                perfect.setOnFinished(event1 -> perfectpane.getChildren().remove(Perfect));

                playerpress1[2] = true;
                Checkscore1();
            }
            if (F) {

                ImageView Perfect = gimage.getMars();
                Perfect.setX(x1[3]);
                Perfect.setY(650);
                ScaleTransition perfect = new ScaleTransition(Duration.millis(time), Perfect);
                perfect.setByX(0.2f);
                perfect.setByY(0.2f);
                perfect.setAutoReverse(false);
                perfect.play();
                perfectpane.getChildren().add(Perfect);
                perfect.setOnFinished(event1 -> perfectpane.getChildren().remove(Perfect));

                playerpress1[3] = true;
                Checkscore1();
            }

            if (A && S && D && F) {
                for (int i = 0; i < 4; i++) {
                    playerpress1[i] = false;
                }
            }
            for (int i = 0; i < 4; i++) {
                if (playerpress1[i]) {
                    count1++;
                }
            }
            if (count1 == 3) {
                if (count1 == 1) {
                    for (int i = 0; i < 4; i++) {
                        playerpress1[i] = false;
                    }
                }
            }

            //Player2


            if (J) {

                ImageView Perfect = gimage.getJupiter();
                Perfect.setX(x2[0]);
                Perfect.setY(650);
                ScaleTransition perfect = new ScaleTransition(Duration.millis(time), Perfect);
                perfect.setByX(0.2f);
                perfect.setByY(0.2f);
                perfect.setAutoReverse(false);
                perfect.play();
                perfectpane.getChildren().add(Perfect);
                perfect.setOnFinished(event1 -> perfectpane.getChildren().remove(Perfect));

                playerpress2[0] = true;
                Checkscore2();
            }
            if (K) {

                ImageView Perfect = gimage.getSaturn();
                Perfect.setX(x2[1]);
                Perfect.setY(650);
                ScaleTransition perfect = new ScaleTransition(Duration.millis(time), Perfect);
                perfect.setByX(0.2f);
                perfect.setByY(0.2f);
                perfect.setAutoReverse(false);
                perfect.play();
                perfectpane.getChildren().add(Perfect);
                perfect.setOnFinished(event1 -> perfectpane.getChildren().remove(Perfect));

                playerpress2[1] = true;
                Checkscore2();
            }
            if (L) {
                ImageView Perfect = gimage.getUrenus();
                Perfect.setX(x2[2]);
                Perfect.setY(650);
                ScaleTransition perfect = new ScaleTransition(Duration.millis(time), Perfect);
                perfect.setByX(0.2f);
                perfect.setByY(0.2f);
                perfect.setAutoReverse(false);
                perfect.play();
                perfectpane.getChildren().add(Perfect);
                perfect.setOnFinished(event1 -> perfectpane.getChildren().remove(Perfect));

                playerpress2[2] = true;
                Checkscore2();
            }
            if (SEMICOLON) {

                ImageView Perfect = gimage.getNeptune();
                Perfect.setX(x2[3]);
                Perfect.setY(650);
                ScaleTransition perfect = new ScaleTransition(Duration.millis(time), Perfect);
                perfect.setByX(0.2f);
                perfect.setByY(0.2f);
                perfect.setAutoReverse(false);
                perfect.play();
                perfectpane.getChildren().add(Perfect);
                perfect.setOnFinished(event1 -> perfectpane.getChildren().remove(Perfect));

                playerpress2[3] = true;
                Checkscore2();
            }
            if (J && K && L && SEMICOLON) {
                for (int i = 0; i < 4; i++) {
                    playerpress2[i] = false;
                }
            }
            for (int i = 0; i < 4; i++) {
                if (playerpress2[i]) {
                    count2++;
                }
            }
            if (count2 == 3) {
                if (count2 == 1) {
                    for (int i = 0; i < 4; i++) {
                        playerpress2[i] = false;
                    }
                }
            }

        });
        Playerrelease();

    }

    public void Playerrelease() {


        scenegame.setOnKeyReleased(event -> {
            //Player1
            boolean A = event.getCode() == KeyCode.A;
            boolean S = event.getCode() == KeyCode.S;
            boolean D = event.getCode() == KeyCode.D;
            boolean F = event.getCode() == KeyCode.F;
            boolean J = event.getCode() == KeyCode.J;
            boolean K = event.getCode() == KeyCode.K;
            boolean L = event.getCode() == KeyCode.L;
            boolean SEMICOLON = event.getCode() == KeyCode.SEMICOLON;

            if (A) {
                pane0.getChildren().clear();
                playerpress1[0] = false;
            }
            if (S) {
                pane1.getChildren().clear();
                playerpress1[1] = false;
            }
            if (D) {
                pane2.getChildren().clear();
                playerpress1[2] = false;
            }
            if (F) {
                pane3.getChildren().clear();
                playerpress1[3] = false;
            }

            //Player2

            if (J) {
                pane4.getChildren().clear();
                playerpress2[0] = false;
            }
            if (K) {
                pane5.getChildren().clear();
                playerpress2[1] = false;
            }
            if (L) {
                pane6.getChildren().clear();
                playerpress2[2] = false;
            }
            if (SEMICOLON) {
                pane7.getChildren().clear();
                playerpress2[3] = false;
            }

        });
    }

    public void scoreBar1() {
        javafx.scene.text.Text scorebar1 = new javafx.scene.text.Text("" + score[0]);
        scorebar1.setFont(Font.font("Courier", 80));
        scorebar1.setFill(Color.WHITE);
        scorebar1.setStroke(Color.BLACK);
        scorebar1.setX(40);
        scorebar1.setY(100);
        if (score[0] != lastscore[0]) {
            panescore1.getChildren().clear();
            lastscore[0] = score[0];
        }
        panescore1.getChildren().add(scorebar1);
    }

    public void scoreBar2() {
        javafx.scene.text.Text scorebar2 = new javafx.scene.text.Text("" + score[1]);
        scorebar2.setFont(Font.font("Courier", 80));
        scorebar2.setFill(Color.WHITE);
        scorebar2.setStroke(Color.BLACK);
        scorebar2.setX(900);
        scorebar2.setY(100);
        if (score[1] != lastscore[1]) {
            panescore2.getChildren().clear();
            lastscore[1] = score[1];
        }
        panescore2.getChildren().add(scorebar2);
    }

    public void Checkscore1() {
        int x = 160;
        double time = 200;
        int check1 = 0;


        for (int i = 0; i < noteflow1.length; i++) {

            if (((noteflow1[i] == true && playerpress1[i] == true)) || ((noteflow1[i] == false && playerpress1[i] == false))) {
                check1 += 1;
            }
        }
        if (check1 <= 2) {
            Miss(x, time);
            combo[0] = 0;
        } else if (check1 == 4) {
            Perfect(x, time);
            score[0] += 100;
            combo[0]++;
        } else if (check1 == 3) {
            Good(x, time);
            score[0] += 20;
            combo[0]++;
        }
        scoreBar1();

    }

    public void Checkscore2() {
        int x = 710;
        double time = 200;
        int check2 = 0;

        for (int i = 0; i < noteflow1.length; i++) {
            if (((noteflow2[i] == true && playerpress2[i] == true)) || ((noteflow2[i] == false && playerpress2[i] == false))) {
                check2 += 1;
            }
        }
        if (check2 <= 2) {
            Miss(x, time);
            combo[1] = 0;
        } else if (check2 == 4) {
            Perfect(x, time);
            score[1] += 100;
            combo[1]++;
        } else if (check2 == 3) {
            Good(x, time);
            score[1] += 20;
            combo[1]++;
        }
        scoreBar2();
    }

    public void Perfect(int x, double time) {
        ImageView Perfect = gimage.getPerfect();
        Perfect.setX(x);
        Perfect.setY(250);
        ScaleTransition perfect = new ScaleTransition(Duration.millis(time), Perfect);
        perfect.setByX(1f);
        perfect.setByY(1f);
        perfect.setAutoReverse(false);
        perfect.play();
        perfectpane.getChildren().add(Perfect);
        perfect.setOnFinished(event -> perfectpane.getChildren().remove(Perfect));
    }

    public void Good(int x, double time) {
        ImageView Good = gimage.getGood();
        Good.setX(x);
        Good.setY(250);
        ScaleTransition good = new ScaleTransition(Duration.millis(time), Good);
        good.setByX(1f);
        good.setByY(1f);
        good.setAutoReverse(false);
        good.play();
        perfectpane.getChildren().add(Good);
        good.setOnFinished(event -> perfectpane.getChildren().remove(Good));
    }

    public void Miss(int x, double time) {
        ImageView Miss = gimage.getMiss();
        Miss.setX(x);
        Miss.setY(250);
        ScaleTransition miss = new ScaleTransition(Duration.millis(time), Miss);
        miss.setByX(1f);
        miss.setByY(1f);
        miss.setAutoReverse(false);
        miss.play();
        perfectpane.getChildren().add(Miss);
        miss.setOnFinished(event -> perfectpane.getChildren().remove(Miss));
    }

    public void flow(String timeIn) {
        score[0] = 0;
        score[1] = 0;
        scoreBar1();
        scoreBar2();

        ArrayList<String> arrayList = new ArrayList<>();
        try {
            File file1 = new File(filelocation + "/file/song.txt");
            BufferedReader br = new BufferedReader(new FileReader(file1));
            String line;
            while ((line = br.readLine()) != null) {
                String[] note = line.split(" ");
                for (int i = 0; i < note.length; i++) {
                    arrayList.add(note[i]);
                }
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            ex.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }


        audio.getMarugo().play();

        String round = arrayList.get(0);
        arrayList.remove(0);
        String time = arrayList.get(0);
        time = timeIn;
        arrayList.remove(0);

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Integer.parseInt(round));
        timeline.getKeyFrames().add(
                new KeyFrame(millis(Double.parseDouble(time)),
                        (ActionEvent event) -> {
                            for (int i = 0; i < arrayList.size(); i++) {
                                if (arrayList.get(i).equals("1") && i < 4) {
                                    if (i == 0) {
                                        Read0();
                                        Read4();
                                    } else if (i == 1) {
                                        Read1();
                                        Read5();
                                    } else if (i == 2) {
                                        Read2();
                                        Read6();
                                    } else {
                                        Read3();
                                        Read7();
                                    }
                                }
                            }
                            for (int i = 0; i < 4; i++) {
                                arrayList.remove(0);
                                noteflow1[i] = false;
                                noteflow2[i] = false;
                            }
                        }
                )
        );
        timeline.play();
        timeline.setOnFinished((ActionEvent Event) ->
        {
            panegame.getChildren().clear();
            paneHS();
            audio.getMarugo().stop();

        });
    }

    public void touch() {

        javafx.scene.text.Text popupPlay = new javafx.scene.text.Text("PLAY");
        javafx.scene.text.Text popupHigh = new javafx.scene.text.Text("SCORE");
        javafx.scene.text.Text popupExit = new javafx.scene.text.Text("EXIT");
        scenemain.setOnMouseMoved((MouseEvent MouseEvent) -> {
            ImageView wireb1 = gimage.getWireb();
            ImageView wireb2 = gimage.getWireb();
            ImageView wireb3 = gimage.getWireb();
            wireb1.setX(80);
            wireb2.setX(230);
            wireb3.setX(380);
            double x = (MouseEvent.getX());
            double y = (MouseEvent.getY());

            if (MouseEvent.getX() > 95 && MouseEvent.getX() < 113) {
                popupPlay.setFont(Font.font("aliens and cows", 50));
                popupPlay.setFill(Color.WHITE);
                popupPlay.setStroke(Color.BLACK);
                popupPlay.setX(x);
                popupPlay.setY(y);
                try {


                    panemain.getChildren().add(popupPlay);
                    panewire1.getChildren().add(wireb1);
                    panewire2.getChildren().clear();
                    panewire3.getChildren().clear();
                    panemain.getChildren().remove(popupHigh);
                    panemain.getChildren().remove(popupExit);
//                    audio.getGuitar4().setVolume(0);
                    audio.getGuitar4().play();


                } catch (Exception e) {

                }


            } else if (MouseEvent.getX() > 245 && MouseEvent.getX() < 266) {

                try {
                    popupHigh.setFont(Font.font("aliens and cows", 50));
                    popupHigh.setFill(Color.WHITE);
                    popupHigh.setStroke(Color.BLACK);
                    popupHigh.setX(x);
                    popupHigh.setY(y);
                    panemain.getChildren().add(popupHigh);
                    panewire2.getChildren().add(wireb2);
                    panewire1.getChildren().clear();
                    panewire3.getChildren().clear();
                    panemain.getChildren().remove(popupPlay);
                    panemain.getChildren().removeAll(popupExit);
                    audio.getGuitar5().play();
                } catch (Exception e) {

                }


            } else if (MouseEvent.getX() > 396 && MouseEvent.getX() < 414) {

                try {
                    popupExit.setFont(Font.font("aliens and cows", 50));
                    popupExit.setFill(Color.WHITE);
                    popupExit.setStroke(Color.BLACK);
                    popupExit.setX(x);
                    popupExit.setY(y);
                    panemain.getChildren().add(popupExit);
                    panewire3.getChildren().add(wireb3);
                    panewire1.getChildren().clear();
                    panewire2.getChildren().clear();
                    panemain.getChildren().removeAll(popupPlay);
                    panemain.getChildren().removeAll(popupHigh);
                    audio.getGuitar6().play();
                } catch (Exception e) {

                }
            }
        });

    }

    public void Showstage(Scene scene) {

        Stage.getIcons().add(new Image(getClass().getResource("image/icon.png").toExternalForm()));
        Stage.setResizable(false);
        Stage.setTitle("GUITAR GALAXY");
        Stage.setWidth(1105);
        Stage.setHeight(835);
        Stage.setScene(scene);
        Stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}