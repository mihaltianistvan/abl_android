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
    private String madeBaskets;


    public ABLAStandings(String teamABL, String points, String playedGames, String
            winnGame, String looseGame, String pointDiff, String madeBaskets) {
        this.teamABL = teamABL;
        this.points = points;
        this.playedGames = playedGames;
        this.winnGame = winnGame;
        this.looseGame = looseGame;
        this.pointDiff = pointDiff;
        this.madeBaskets = madeBaskets;
    }

    public String getMadeBaskets() {
        return madeBaskets;
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

    public String getGotPoints() {
        int res =  Integer.parseInt(getMadeBaskets()) - Integer.parseInt(getPointDiff());
        return String.valueOf(res);

    }
}
