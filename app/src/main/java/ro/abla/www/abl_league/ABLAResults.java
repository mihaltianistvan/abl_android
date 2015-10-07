package ro.abla.www.abl_league;

/**
 * Created by User on 10/6/2015.
 */
public class ABLAResults {

    private String teamA;
    private String teamB;
    private String pointsA;
    private String pointsB;
    private String roundGame;

    public ABLAResults(String teamA,String teamB,String pointsA,String pointsB, String roundGame) {

        this.teamA = teamA;
        this.teamB = teamB;
        this.pointsA = pointsA;
        this.pointsB = pointsB;
        this.roundGame = roundGame;
    }

    public String getTeamB() {
        return teamB;
    }

    public String getPointsB() {
        return pointsB;
    }

    public String getPointsA() {
        return pointsA;
    }

    public String getRoundGame() {
        return roundGame;
    }

    public String getTeamA() {
        return teamA;
    }

}
