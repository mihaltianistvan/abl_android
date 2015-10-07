package ro.abla.www.abl_league;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User on 10/5/2015.
 */
public class ABLRoundAdapter extends BaseAdapter {
    String aa;
    String bb;
    ArrayList<ABLARounds> arr;
    Context context;

    public ABLRoundAdapter(Context context,ArrayList<ABLARounds> arr){
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
        TextView gameRound,whenRound,whereRound;

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.abl_row_rounds_layout, parent, false);
        }
        else {
            row=convertView;
        }
        gameRound = (TextView) row.findViewById(R.id.roundgameText);
        whenRound = (TextView) row.findViewById(R.id.roundgameWhen);
        whereRound =(TextView) row.findViewById(R.id.roundgameWhere);

        gameRound.setText(arr.get(position).getTeams());
        whenRound.setText("Time: " + arr.get(position).getWhen());
        whereRound.setText("Place: " + arr.get(position).getWhere());

        return row;
    }
}
