package ro.abla.www.abl_league;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User on 10/6/2015.
 */
public class ABLStandingsAdapter extends BaseAdapter {

    ArrayList<ABLAStandings> arr;
    Context context;

    public ABLStandingsAdapter(Context context,ArrayList<ABLAStandings> arr){
        this.context = context;
        this.arr = arr;


    }

    public int getCount() {
        return arr.size();
    }

    @Override
    public Object getItem(int position) {
        return arr.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row=null;
        TextView teamTXT, pointsTXT;

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.abl_row_rounds_layout, parent, false);
        }
        else {
            row=convertView;
        }
        teamTXT = (TextView) row.findViewById(R.id.team);
        pointsTXT = (TextView) row.findViewById(R.id.points);
        //whereRound =(TextView) row.findViewById(R.id.roundgameWhere);

        teamTXT.setText(arr.get(position).getTeamABL());
        pointsTXT.setText("Time: " + arr.get(position).getPoints());
        //whereRound.setText("Place: " + arr.get(position).getWhere());

        return row;
    }
}
