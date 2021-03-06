package ro.abla.www.abl_league;

import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by User on 10/6/2015.
 */
public class FragmentABLStandings extends Fragment {

    private JSONArray jArray;
    ListView resultView;
    AnalyzeJson analyzeJson = new AnalyzeJson();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View finalView = inflater.inflate(R.layout.abl_table_layout, container, false);

        try {
            String result = analyzeJson.getData("http://abla.ro/androidTableQuery.php"); //getData("http://abla.ro/androidmysql.php");
            ArrayList<ABLAStandings> s = new ArrayList<ABLAStandings>();
            jArray = new JSONArray(result);
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject json = jArray.getJSONObject(i);

                s.add(new ABLAStandings(json.getString("teamname"), json.getString("points"), json.getString("played"),
                        json.getString("win"), json.getString("loose"), json.getString("pointsdif"), json.getString("pointsmy")));
                resultView = (ListView) finalView.findViewById(R.id.abla_table_listview);
                resultView.setAdapter(new ABLStandingsAdapter(this.getActivity(), s));
            }
        } catch (Exception e) {
            // TODO: handle exception
            Log.e("log_tag", "Error Parsing Data " + e.toString());
        }


        return finalView;
    }
}
