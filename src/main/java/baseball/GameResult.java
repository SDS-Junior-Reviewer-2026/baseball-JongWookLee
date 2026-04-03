package baseball;

public class GameResult {
    private boolean sovled;
    private int strikes;
    private int balls;

    public GameResult(boolean sovled, int strikes, int balls) {
        this.sovled = sovled;
        this.strikes = strikes;
        this.balls = balls;
    }

    public boolean isSovled() {
        return sovled;
    }

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }
}
