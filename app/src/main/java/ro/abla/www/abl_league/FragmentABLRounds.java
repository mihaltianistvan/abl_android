package ro.abla.www.abl_league;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.support.v4.app.*;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by User on 10/5/2015.
 */
public class FragmentABLRounds extends Fragment {
    private JSONArray jArray;
    private String queryParamsSeasonId,getQueryParamsSeasonRound;
    private String queryParams;
    ListView resultView;
    AnalyzeJson analyzeJson = new AnalyzeJson();
    ABLRoundAdapter adapter;

    public FragmentABLRounds() {

    }

    public FragmentABLRounds(String queryParamsSeasonId, String queryParamsSeasonRound) {


        setQueryParams(queryParamsSeasonId,queryParamsSeasonRound);

    }

    public void setQueryParams(String queryParamsSeasonId,String getQueryParamsSeasonRound){
        this.queryParamsSeasonId = queryParamsSeasonId;
        this.getQueryParamsSeasonRound = getQueryParamsSeasonRound;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View finalView = inflater.inflate(R.layout.abl_rounds_layout, container, false);
     //   Toast.makeText(this.getActivity(),"FRAGMENT: "+getQueryParamsSeasonRound,Toast.LENGTH_LONG);
        try {

            String result = analyzeJson.getData("http://abla.ro/androidmysql.php?seasonID="+queryParamsSeasonId+"&etapID="+getQueryParamsSeasonRound); //getData("http://abla.ro/androidmysql.php");
            ArrayList<ABLARounds> s = new ArrayList<ABLARounds>();
//Toast.makeText(getActivity(),"FRAGMENT: "+getQueryParamsSeasonRound,Toast.LENGTH_LONG);
            jArray = new JSONArray(result);
            //resultView.invalidateViews();
        for(int i=0; i<jArray.length();i++){
            JSONObject json = jArray.getJSONObject(i);
            s.add(new ABLARounds(json.getString("teamname1"), json.getString("teamname2"), json.getString("mwhen"), json.getString("mwhere")));
            resultView = (ListView) finalView.findViewById(R.id.abl_rounds_list);
            adapter = new ABLRoundAdapter(this.getActivity(), s);

            adapter.notifyDataSetChanged();
            resultView.setAdapter(adapter);


        }

        //resultView.setText(s);

    } catch (Exception e) {
        // TODO: handle exception
        Log.e("log_tag", "Error Parsing Data " + e.toString());
    }


        return finalView;
    }

}
