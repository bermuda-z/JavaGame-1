package sample;

/**
 * Created by mew on 4/19/2017.
 */
public class Player {
    private String name;
    private int score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int perfectscore()
    {
        score += 100;
        return score;
    }

    public int goodscore()
    {
        score += 20;
        return score;
    }
}
