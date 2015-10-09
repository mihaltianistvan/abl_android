package ro.abla.www.abl_league;

/**
 * Created by User on 10/6/2015.
 */
public class ABLAStandings {

    private String teamABL;
    private String points;
    private String playedGames;
    private String winnGame;
    private String looseGame;
    private String pointDiff;


    public ABLAStandings(String teamABL, String points, String playedGames, String
            winnGame, String looseGame, String pointDiff) {
        this.teamABL = teamABL;
        this.points = points;
    }

    public String getPoints() {
        return points;
    }

    public String getTeamABL() {
        return teamABL;
    }

    public String getLooseGame() {
        return looseGame;
    }

    public String getPlayedGames() {
        return playedGames;
    }

    public String getPointDiff() {
        return pointDiff;
    }

    public String getWinnGame() {
        return winnGame;
    }
}
