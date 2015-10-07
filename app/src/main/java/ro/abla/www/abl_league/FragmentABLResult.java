package ro.abla.www.abl_league;

import android.app.FragmentManager;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.app.Fragment;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by User on 10/5/2015.
 */
public class FragmentABLResult extends Fragment {

    private JSONArray jArray;
    ListView resultView;
    AnalyzeJson analyzeJson = new AnalyzeJson();

//    public FragmentABLRounds(JSONArray jsonArray) {
//
//        this.jArray=jsonArray;
//    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View finalView = inflater.inflate(R.layout.abl_results_layout,container,false);

        try {
            String result = analyzeJson.getData("http://abla.ro/androidStandings.php");
            ArrayList<ABLAResults> s = new ArrayList<ABLAResults>();
            jArray = new JSONArray(result);
            for(int i=0; i<jArray.length();i++){
                JSONObject json = jArray.getJSONObject(i);

                s.add(new ABLAResults(json.getString("teamname1"),json.getString("teamname2"),json.getString("pointsteam1"),json.getString("pointsteam2"),json.getString("etapname")));
                resultView = (ListView) finalView.findViewById(R.id.result_listview);
                resultView.setAdapter(new ABLResultAdapter(this.getActivity(), s));

            }

            //resultView.setText(s);

        } catch (Exception e) {
            // TODO: handle exception
            Log.e("log_tag", "Error Parsing Data " + e.toString());
        }


        return finalView;
    }

}

