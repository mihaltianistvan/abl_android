package ro.abla.www.abl_league;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by User on 10/7/2015.
 */
public class FragmentABLMvp extends Fragment {

    private JSONArray jArray;
    ListView resultView;
    AnalyzeJson analyzeJson = new AnalyzeJson();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View finalView = inflater.inflate(R.layout.abl_mvp_layout, container, false);

        try {
            String result = analyzeJson.getData("http://abla.ro/androidMVPquery.php?seasonid=25");
            ArrayList<ABLAMvp> s = new ArrayList<ABLAMvp>();
            jArray = new JSONArray(result);
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject json = jArray.getJSONObject(i);

                s.add(new ABLAMvp(json.getString("playername"), json.getString("teamname"),json.getString("sp"),json.getString("sr"),json.getString("sa"),
                        json.getString("st"),json.getString("sb"),json.getString("stl"),json.getString("sm")));
                resultView = (ListView) finalView.findViewById(R.id.listView);
                resultView.setAdapter(new ABLMvpAdapter(this.getActivity(), s));

            }

        } catch (Exception e) {
            // TODO: handle exception
            Log.e("log_tag", "Error Parsing Data " + e.toString());
        }


        return finalView;
    }
}
