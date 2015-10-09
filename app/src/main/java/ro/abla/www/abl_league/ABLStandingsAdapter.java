package ro.abla.www.abl_league;

import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User on 10/6/2015.
 */
public class ABLStandingsAdapter extends BaseAdapter {

    ArrayList<ABLAStandings> arr;
    Context context;
    Display display;

    public ABLStandingsAdapter(Context context, ArrayList<ABLAStandings> arr) {
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
        TextView teamTXT, pointsTXT, gamesTXT, winTXT, looseTXT,pointsmadeTXT,pointsgotTXT, pointsdifTXT;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.abl_row_table_layout, parent, false);
        } else {
            row = convertView;
        }


        display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        int orient = display.getOrientation();


        teamTXT = (TextView) row.findViewById(R.id.abl_teamname_table_tv);
        pointsTXT = (TextView) row.findViewById(R.id.abl_points_table_tv);
        gamesTXT = (TextView) row.findViewById(R.id.abl_gamse_table_tv);
        winTXT = (TextView) row.findViewById(R.id.abl_wins_table_tv);
        looseTXT = (TextView) row.findViewById(R.id.abl_loose_table_tv);
        pointsmadeTXT = (TextView) row.findViewById(R.id.abl_pointsmade_table_tv);
        pointsgotTXT = (TextView) row.findViewById(R.id.abl_got_table_tv);
        pointsdifTXT = (TextView) row.findViewById(R.id.abl_pointsdiff_table_tv);


        if (orient == 0) {
            teamTXT.setText(arr.get(position).getTeamABL());
            pointsTXT.setText(arr.get(position).getPoints());
            gamesTXT.setText(arr.get(position).getPlayedGames());
            winTXT.setText(arr.get(position).getWinnGame());
            looseTXT.setText(arr.get(position).getLooseGame());
        } else {
            teamTXT.setText(arr.get(position).getTeamABL());
            pointsTXT.setText(arr.get(position).getPoints());
            gamesTXT.setText(arr.get(position).getPlayedGames());
            winTXT.setText(arr.get(position).getWinnGame());
            looseTXT.setText(arr.get(position).getLooseGame());
            pointsmadeTXT.setText(arr.get(position).getMadeBaskets());
            pointsgotTXT.setText(arr.get(position).getGotPoints());
            pointsdifTXT.setText(arr.get(position).getPointDiff());
        }

        return row;
    }
}
