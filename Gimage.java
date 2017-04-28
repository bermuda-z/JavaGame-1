package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by warat on 15/4/2560.
 */
public class Gimage {
    //Main
    private String BG = "image/BG.jpg";
    private String title1 = "image/title1.png";
    private String title2 = "image/title2.png";
    private String wire1 = "image/wire1.png";
    private String wire2 = "image/wire2.png";
    private String wire3 = "image/wire3.png";
    private String wireb = "image/wireb.png";


    //Game
    private String perfect = "Image/Perfect.png";
    private String good = "Image/Good.png";
    private String miss = "Image/Miss.png";
    private String star = "Image/Star.png";
    private String star1 = "Image/Star1.png";
    private String star2 = "Image/Star2.png";
    private String main = "Image/Main_game.jpg";
    private String icon = "Image/icon.png";
    private String back = "Image/back.png";
    private String playagain = "Image/playagain.png";

    private String mercury = "image/mercury.png";
    private String mars = "image/mars.png";
    private String earth = "image/earth.png";
    private String jupiter = "image/jupiter.png";
    private String neptune = "image/neptune.png";
    private String satus = "image/satus.png";
    private String venus = "image/venus.png";
    private String urenus = "image/urenus.png";

    private String mercury1 = "image/mercury1.png";
    private String mars1 = "image/mars1.png";
    private String earth1 = "image/earth1.png";
    private String jupiter1 = "image/jupiter1.png";
    private String neptune1 = "image/neptune1.png";
    private String satus1 = "image/satus1.png";
    private String venus1 = "image/venus1.png";
    private String urenus1 = "image/urenus1.png";

    private String rocket = "image/rocket.png";
    private String one = "image/1.png";
    private String two = "image/2.png";
    private String three = "image/3.png";
    private String go = "image/go.png";


    public String getPlayagain() {
        return playagain;
    }


    ImageView getOne() {
        ImageView imageView =  View(Importimage(one));
        return imageView;
    }
    ImageView getTwo() {
        ImageView imageView =  View(Importimage(two));
        return imageView;
    }
    ImageView getThree() {
        ImageView imageView =  View(Importimage(three));
        return imageView;
    }
    ImageView getGo() {
        ImageView imageView =  View(Importimage(go));
        return imageView;
    }

    ImageView getRocket() {
        ImageView imageView =  View(Importimage(rocket));
        imageView.setX(495);
        imageView.setY(0);
        return imageView;
    }
    ImageView getMercury() {
        ImageView imageView =  View(Importimage(mercury));
        imageView.setX(0);
        imageView.setY(650);
        return imageView;
    }
    ImageView getVenus() {
        ImageView imageView =  View(Importimage(venus));
        imageView.setX(137);
        imageView.setY(650);
        return imageView;
    }
    ImageView getEarth() {
        ImageView imageView =  View(Importimage(earth));
        imageView.setX(274);
        imageView.setY(650);
        return imageView;
    }
    ImageView getMars() {
        ImageView imageView =  View(Importimage(mars));
        imageView.setX(411);
        imageView.setY(650);
        return imageView;
    }
    ImageView getJupiter() {
        ImageView imageView =  View(Importimage(jupiter));
        imageView.setX(548);
        imageView.setY(650);
        return imageView;
    }
    ImageView getSaturn() {
        ImageView imageView =  View(Importimage(satus));
        imageView.setX(685);
        imageView.setY(650);
        return imageView;
    }
    ImageView getUrenus() {
        ImageView imageView =  View(Importimage(urenus));
        imageView.setX(822);
        imageView.setY(650);
        return imageView;
    }
    ImageView getNeptune() {
        ImageView imageView =  View(Importimage(neptune));
        imageView.setX(959);
        imageView.setY(650);
        return imageView;
    }

    ImageView getMercury1() {
        ImageView imageView =  View(Importimage(mercury1));
        imageView.setX(0);
        return imageView;
    }
    ImageView getVenus1() {
        ImageView imageView =  View(Importimage(venus1));
        return imageView;
    }
    ImageView getEarth1() {
        ImageView imageView =  View(Importimage(earth1));
        return imageView;
    }
    ImageView getMars1() {
        ImageView imageView = View(Importimage(mars1));
        return imageView;
    }
    ImageView getJupiter1() {
        ImageView imageView =  View(Importimage(jupiter1));
        return imageView;
    }
    ImageView getSaturn1() {
        ImageView imageView =  View(Importimage(satus1));
        return imageView;
    }
    ImageView getUrenus1() {
        ImageView imageView =  View(Importimage(urenus1));
        return imageView;
    }
    ImageView getNeptune1() {
        ImageView imageView =  View(Importimage(neptune1));
        return imageView;
    }

    //HS
    private String HS= "image/HS.jpg";

    public Gimage() {
    }

    public ImageView getBG() {
        ImageView Bg = View(Importimage(BG));

        return Bg;
    }

    public ImageView getPerfect() {
        return View(Importimage(perfect));
    }

    public ImageView getGood() {
        return View(Importimage(good));
    }

    public ImageView getMiss() {
        return View(Importimage(miss));
    }

    public ImageView getMain() {
        return View(Importimage(main));
    }

    public ImageView getBack() {
        ImageView imageView = View(Importimage(back));
        imageView.setX(30);
        imageView.setY(700);
        return imageView;
    }

    public ImageView getAgain() {
        ImageView imageView = View(Importimage(playagain));
        imageView.setX(830);
        imageView.setY(550);
        return imageView;
    }

    public Image Importimage(String s) {
        Image image = new Image(getClass().getResource(s).toExternalForm());
        return image;
    }

    public ImageView View(Image image) {
        ImageView imageView = new ImageView(image);
        return imageView;
    }

    public ImageView getTitle1() {
        ImageView imageView = View(Importimage(title1));
        imageView.setX(650);
        return imageView;
    }

    public ImageView getWire1() {
        ImageView imageView = View(Importimage(wire1));
        imageView.setX(80);
        return imageView;
    }

    public ImageView getWire2() {
        ImageView imageView = View(Importimage(wire2));
        imageView.setX(230);
        return imageView;
    }

    public ImageView getWire3() {
        ImageView imageView = View(Importimage(wire3));
        imageView.setX(380);
        return imageView;
    }

    public ImageView getWireb() {
        return View(Importimage(wireb));
    }

    public ImageView getHS() {
        return View(Importimage(HS));
    }



}
