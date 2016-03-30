package ars.it.okhttpdemo;

import android.os.StrictMode;
import android.util.Log;

import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by root on 29/3/16.
 */
public class Connection {


    public JSONObject conn(){
        try {StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Log.e("conn","sdsd");
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("http://103.254.96.198:8087/jobtrackinglove/Androidordertype.jsp?ordertype=PO")
                    .build();

            Response response = client.newCall(request).execute();
            String responseData = response.body().string();
            JSONObject object=new JSONObject(responseData);
            Log.e("conn",object.getString("parties"));
            return  object;
        }catch (Exception ex)
        {
            Log.e("exception",ex.toString());
            return  null;
        }

    }
}
