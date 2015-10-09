package ro.abla.www.abl_league;

import android.app.ActionBar;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {

    // used vars
    private DrawerLayout drawerLayout;
    private ListView listAblaLeft,listAblaMainSeason;
    private ActionBarDrawerToggle drawerListener;
    private ListView resultView;
    FragmentABLRounds a = new FragmentABLRounds();
    FragmentABLResult b = new FragmentABLResult();
    FragmentABLMvp c = new FragmentABLMvp();
    //ABLStoreSeason ablStoreSeason = new ABLStoreSeason();
    FragmentABLStandings fragmentABLStandings = new FragmentABLStandings();

    private JSONArray jArray;
    Spinner spinner;
    AnalyzeJson analyzeJson = new AnalyzeJson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find the list view in XML layout
        listAblaLeft = (ListView) findViewById(R.id.abla_drawer_list);
        listAblaLeft.setAdapter(new ABLMenuAdapter(this));
        listAblaLeft.setOnItemClickListener(this);
//        drawerListener = new ActionBarDrawerToggle(this, drawerLayout, R.drawable.mvp, R.string.open, R.string.open) {
//            @Override
//            public void onDrawerOpened(View drawerView) {
//                super.onDrawerOpened(drawerView);
//            }
//
//            @Override
//            public void onDrawerClosed(View drawerView) {
//                super.onDrawerClosed(drawerView);
//            }
//
//        };

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        //   drawerLayout.setDrawerListener(drawerListener);

       // Spinner staticSpinner = (Spinner) findViewById(R.id.static_spinner);

        // Create an ArrayAdapter using the string array and a default spinner
       // ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
        //        .createFromResource(this, R.array.brew_array,
         //               android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
      //  staticAdapter
        //        .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
     //   staticSpinner.setAdapter(staticAdapter);
        try {
            String result = analyzeJson.getData("http://abla.ro/testelek.php");
            ArrayList<ABLStoreSeason> s = new ArrayList<ABLStoreSeason>();
            jArray = new JSONArray(result);
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject json = jArray.getJSONObject(i);

                s.add(new ABLStoreSeason(json.getString("seassonname"), json.getString("id")));
                spinner = (Spinner) findViewById(R.id.abl_season_spinner);
                spinner.setAdapter(new ABLSeasonAdapter(this, s));

            }

        } catch (Exception e) {
            // TODO: handle exception
            Log.e("log_tag", "Error Parsing Data " + e.toString());
        }



        //ABLDownloadSeasonInfo ablDownloadSeasonInfo = new ABLDownloadSeasonInfo();
//        Spinner dynamicSpinner = (Spinner) findViewById(R.id.dynamic_spinner);
//
//        String[] items = new String[] { "Chai Latte", "Green Tea", "Black Tea" };
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_spinner_item, items);
//
//        dynamicSpinner.setAdapter(adapter);

//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view,
//                                       int position, long id) {
//                //ablStoreSeason.setSeasonID((String) parent.getItemAtPosition(position));
//                Log.v("item", (String) parent.getItemAtPosition(position));
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//                // TODO Auto-generated method stub
//            }
//        });
       // - See more at: http://www.ahotbrew.com/android-dropdown-spinner-example/#sthash.GRQ0x8QK.dpuf
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //handling item clikc on menu
        // when somebodi click on the nav bar action bar with the method at bottom we will open the drawer
        if (drawerListener.onOptionsItemSelected(item)) {
            //Toast.makeText(this,item,Toast.LENGTH_LONG).show();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {

        super.onConfigurationChanged(newConfig);
        drawerListener.onConfigurationChanged(newConfig);

    }

    @Override
//    protected void onPostCreate(Bundle savedInstanceState) {
//        //indicates to the user that is a drawer present
//        super.onPostCreate(savedInstanceState);
//        drawerListener.syncState();
//    }


    //@Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //   Toast.makeText(this, planets[position], Toast.LENGTH_LONG).show();
        selectItem(position);

    }

    public void selectItem(int position) {
        listAblaLeft.setItemChecked(position, true);
        FragmentTransaction ft = getFragmentManager().beginTransaction();

        switch (position) {

            case 0:

                ft.replace(R.id.mainContnet, a);

                // ft.add(R.id.mainContnet, fb);
                ft.addToBackStack(null);
                ft.commit();

                //parse json data


                break;
            case 1:
                ft.replace(R.id.mainContnet, fragmentABLStandings);
                // ft.add(R.id.mainContnet, fb);
                ft.addToBackStack(null);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.mainContnet, b);
                // ft.add(R.id.mainContnet, fb);
                ft.addToBackStack(null);
                ft.commit();
                break;
            case 3:
                ft.replace(R.id.mainContnet, c);
                // ft.add(R.id.mainContnet, fb);
                ft.addToBackStack(null);
                ft.commit();
                break;

        }


    }
}



