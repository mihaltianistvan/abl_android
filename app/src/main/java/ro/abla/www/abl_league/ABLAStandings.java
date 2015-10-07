package ro.abla.www.abl_league;

/**
 * Created by User on 10/6/2015.
 */
public class ABLAStandings {

    private String teamABL;
    private String points;

    public ABLAStandings(String teamABL,String points) {
        this.teamABL = teamABL;
        this.points = points;
    }

    public String getPoints() {
        return points;
    }

    public String getTeamABL() {
        return teamABL;
    }
}
