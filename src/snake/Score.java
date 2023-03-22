package snake;

public class Score implements Comparable<Score>{
    private int score;
    private String difficulty,date;

    public Score(int score, String difficulty, String date) {
        this.score = score;
        this.difficulty = difficulty;
        this.date = date;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    @Override
    public int compareTo(Score o) {
        return Integer.compare(this.getScore(), o.getScore());
    }
}
