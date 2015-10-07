package ro.abla.www.abl_league;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Created by User on 10/5/2015.
 */
public class AnalyzeJson {

    private String jsonWebData;
    private String jsonResult;

    // get the right script file address
//    public AnalyzeJson(String webAddress) {
//        jsonWebData = webAddress;
//        getData();
//    }
    HttpClient httpclient;
    HttpPost httppost;
    HttpResponse response;
    HttpEntity entity;


    public String getData(String jsonWebData) {
        String result = "";
        InputStream isr = null;
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            httpclient = new DefaultHttpClient();
            httppost = new HttpPost(jsonWebData); //script address here
            response = httpclient.execute(httppost);
            entity = response.getEntity();
            isr = entity.getContent();
        } catch (Exception e) {
             Log.e("log_tag", "Error in http connection " + e.toString());
            //Toast.makeText(this,"can not connect",Toast.LENGTH_LONG);
            //resultView.setText("Couldnt connect to database");
        }
        //convert response to string
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(isr, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            isr.close();

            jsonResult = sb.toString();

        } catch (Exception e) {
            Log.e("log_tag", "Error  converting result " + e.toString());
        }


        return jsonResult;
    }





}
