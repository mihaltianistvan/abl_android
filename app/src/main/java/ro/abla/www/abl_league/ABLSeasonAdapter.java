package ro.abla.www.abl_league;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User on 10/9/2015.
 */
public class ABLSeasonAdapter extends BaseAdapter {

    ArrayList<ABLStoreSeason> arr;
    Context context;

    public ABLSeasonAdapter(Context context, ArrayList<ABLStoreSeason> arr) {
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
        TextView text;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.abl_row_season_spinner_text, parent, false);


        } else {
            row = convertView;
        }

            text = (TextView) row.findViewById(R.id.abl_row_spinner);

            text.setText(arr.get(position).getSeasonName());
        //  result.setText(arr.get(position).getRoundGame());

        return row;
    }
}
