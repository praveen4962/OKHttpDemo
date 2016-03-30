package ars.it.okhttpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         try {

             Log.e("test",1+"");
             Connection connection=new Connection();
         // String data=   connection.conn();
            // Log.e("test",2+""+data+"2");
             JSONObject object=connection.conn();

             Log.e("",""+object.getString("parties"));
             ListView listView=(ListView)findViewById(R.id.list);
             JSONArray jsonArray = object.getJSONArray("parties");
             ArrayList arrayList=new ArrayList();
             for(int i=0;i<jsonArray.length();i++)
             {
                 arrayList.add(jsonArray.get(i));

             }

             Log.e("test",1+""+arrayList);

             ArrayAdapter arrayAdapter=new ArrayAdapter(getApplicationContext(),R.layout.sortby_listview,arrayList);
             listView.setAdapter(arrayAdapter);
         }catch (Exception ex)
         {
             Log.e("Exception in main",ex.toString());
         }

    }
}
