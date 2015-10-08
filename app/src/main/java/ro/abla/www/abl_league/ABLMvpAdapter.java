package ro.abla.www.abl_league;

import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by User on 10/7/2015.
 */
public class ABLMvpAdapter extends BaseAdapter {

    ArrayList<ABLAMvp> arr;
    Context context;

    public ABLMvpAdapter(Context context, ArrayList<ABLAMvp> arr) {
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
        TextView t1,t2;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.abl_row_mvp_layout, parent, false);
            
        } else {
            row = convertView;
        }

      Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        int orient = display.getOrientation();



        t1 = (TextView) row.findViewById(R.id.csaktest);
        t2 = (TextView) row.findViewById(R.id.csaktest2);

        //result =(TextView) row.findViewById(R.id.result_result1);
        //etap =(TextView) row.findViewById(R.id.roundgameWhere);
if(orient == 0) {
    t1.setText(arr.get(position).getPlayerName());
}
        else {
    t1.setText(arr.get(position).getPlayerName());
    t2.setText(arr.get(position).getAssists());
}
        //  result.setText(arr.get(position).getRoundGame());

        return row;
    }
}
