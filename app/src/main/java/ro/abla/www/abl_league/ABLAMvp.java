package ro.abla.www.abl_league;

/**
 * Created by User on 10/7/2015.
 */
public class ABLAMvp {

    private String playerName;
    private String playerTeam;
    private String points;
    private String rebounds;
    private String assists;
    private String treepointers;
    private String blocks;
    private String fouls;
    private String games;

    public ABLAMvp(String playerName, String playerTeam, String points, String rebounds,
                   String assists, String treepointers, String blocks, String fouls, String games) {

        this.playerName = playerName;
        this.playerTeam = playerTeam;
        this.points = points;
        this.rebounds = rebounds;
        this.assists = assists;
        this.treepointers = treepointers;
        this.blocks = blocks;
        this.fouls = fouls;
        this.games = games;

    }

    public String getPoints() {
        return points;
    }

    public String getAssists() {
        return assists;
    }

    public String getBlocks() {
        return blocks;
    }

    public String getFouls() {
        return fouls;
    }

    public String getGames() {
        return games;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerTeam() {
        return playerTeam;
    }

    public String getRebounds() {
        return rebounds;
    }

    public String getTreepointers() {
        return treepointers;
    }

    public int getPPG(){
        return Integer.parseInt(getPoints()) / Integer.parseInt(getGames());
    }

}
