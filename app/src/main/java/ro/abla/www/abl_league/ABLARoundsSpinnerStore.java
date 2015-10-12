package ro.abla.www.abl_league;

/**
 * Created by User on 10/12/2015.
 */
public class ABLARoundsSpinnerStore {

    private String roundID;
    private String roundName;

    public ABLARoundsSpinnerStore(String roundID, String roundName){
        this.roundID = roundID;
        this.roundName = roundName;
    }

    public String getRoundID() {
        return roundID;
    }

    public String getRoundName() {
        return roundName;
    }
}
