package ro.abla.www.abl_league;

/**
 * Created by User on 10/9/2015.
 */
public class ABLStoreSeason {

    private String seasonName;
    private String seasonID;
    private String etap;

    public ABLStoreSeason(String seasonName,String seasonID){
        this.seasonName = seasonName;
        this.seasonID = seasonID;
        this.etap = etap;

    }

    public String getSeasonID() {
        return seasonID;
    }

    public String getSeasonName() {
        return seasonName;
    }

public String getEtap(){
    return etap;
}
}
