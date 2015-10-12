package ro.abla.www.abl_league;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by User on 10/9/2015.
 */
public class ABLDownloadSeasonInfo{

//    private JSONArray jArray;
//    ListView resultView;
//    Spinner spinner;
//    Context cont;
//    View finalSpinnerView;
//    AnalyzeJson analyzeJson = new AnalyzeJson();
//
//    public ABLDownloadSeasonInfo(Context context) {
//        this.cont = context;
//        DownloadSeasonData();
//    }
//
//    public void DownloadSeasonData(){
//        try {
//            String result = analyzeJson.getData("http://abla.ro/testelek.php");
//            ArrayList<ABLStoreSeason> s = new ArrayList<ABLStoreSeason>();
//            jArray = new JSONArray(result);
//            for (int i = 0; i < jArray.length(); i++) {
//                JSONObject json = jArray.getJSONObject(i);
//
//                s.add(new ABLStoreSeason(json.getString("seassonname"), json.getString("id")));
//
//
//
//                //Spinner dynamicSpinner = (Spinner) cont.getSystemService(Context.LAYOUT_INFLATER_SERVICE)findViewById(R.id.dynamic_spinner);
//
//
//               // String[] items = new String[] { "Chai Latte", "Green Tea", "Black Tea" };
//
//
//
//
//            }
//
//        } catch (Exception e) {
//            // TODO: handle exception
//            Log.e("log_tag", "Error Parsing Data " + e.toString());
//        }
//    }
//
//    @Override
//    public int getCount() {
//        return 0;
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        LayoutInflater inflater = (LayoutInflater) cont.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        finalSpinnerView = inflater.inflate(R.layout.abl_season_spinner_view_layout, parent, false);
//
//        return null;
//    }
}
