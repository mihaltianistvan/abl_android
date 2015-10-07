package ro.abla.www.abl_league;

/**
 * Created by User on 10/5/2015.
 */
public class ABLARounds {

    String teamA;
    String teamB;
    String result;
    String when;
    String where;

    public ABLARounds(String teamA, String teamB, String when, String where) {
        this.teamA =teamA;
        this.teamB = teamB;
        this.when = when;
        this.where = where;

    }

    public String getTeamA() {
        return teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public String getWhen() {
        return when;
    }

    public String getWhere() {
        return where;
    }

    public String getResult() {
        return result;
    }

    public String getTeams (){
        return teamA + " vs. " + teamB;
    }
}
