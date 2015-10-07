package ro.abla.www.abl_league;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User on 10/6/2015.
 */
public class ABLResultAdapter extends BaseAdapter {

    ArrayList<ABLAResults> arr;
    Context context;

    public ABLResultAdapter(Context context, ArrayList<ABLAResults> arr) {
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
        View row = null;
        TextView teamA, teamB, result, scoreA, scoreB;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.abl_row_result_layout, parent, false);


        } else {
            row = convertView;
        }
        teamA = (TextView) row.findViewById(R.id.result_teamAName);
        teamB = (TextView) row.findViewById(R.id.result_teamBName);
        scoreA = (TextView) row.findViewById(R.id.score_teamA);
        scoreB = (TextView) row.findViewById(R.id.score_teamB);
        //result =(TextView) row.findViewById(R.id.result_result1);
        //etap =(TextView) row.findViewById(R.id.roundgameWhere);

        teamA.setText(arr.get(position).getTeamA());
        teamB.setText(arr.get(position).getTeamB());
        scoreA.setText(arr.get(position).getPointsA());
        scoreB.setText(arr.get(position).getPointsB());

        //  result.setText(arr.get(position).getRoundGame());

        return row;
    }
}
