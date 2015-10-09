package ro.abla.www.abl_league;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

/**
 * Created by User on 10/5/2015.
 */
public class ABLMenuAdapter extends BaseAdapter {
    // this adapter will create the ABL left drawer menu
    // converting text and put together with images finally
    // will return with a view

    private Context cont;
    private String[] menuArray;
    private int[] menuImages = {R.drawable.rounds, R.drawable.whistle, R.drawable.standings, R.drawable.mvp,R.drawable.mvp};

    public ABLMenuAdapter(Context context) {
        this.cont = context;
        menuArray = context.getResources().getStringArray(R.array.menu_points);

    }

    @Override
    public int getCount() {
        return menuArray.length;
    }

    @Override
    public Object getItem(int position) {
        return menuArray[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View finalDrawerRow;

        TextView menuText;
        ImageView menuIcon;

        if (convertView == null) {
            // if converted view is null then it means that we create this row first time for display
            LayoutInflater inflater = (LayoutInflater) cont.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            finalDrawerRow = inflater.inflate(R.layout.abla_drawer_row, parent, false);

        } else {
            finalDrawerRow = convertView;
        }

        // find elements on inflated layout for future use

        menuText = (TextView) finalDrawerRow.findViewById(R.id.menuText);
        menuIcon = (ImageView) finalDrawerRow.findViewById(R.id.menuIcon);

        menuText.setText(menuArray[position]);
        menuIcon.setImageResource(menuImages[position]);


        return finalDrawerRow;
    }
}
