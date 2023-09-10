package com.example.lamkadam_hamza_exam_rat_m1iibdcc_23_v1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    ArrayList<ItemModel>  arrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView.findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        try {
            JSONObject object = new JSONObject(readJSON());

            JSONArray array = object.getJSONArray("contacts");
            for (int i = 0; i < array.length(); i++) {

                JSONObject jsonObject = array.getJSONObject(i);
                String id = jsonObject.getString("id");
                String first_name = jsonObject.getString("first_name");
                String last_name = jsonObject.getString("last_name");
                String job = jsonObject.getString("job");
                String email = jsonObject.getString("email");
                String phone = jsonObject.getString("phone");

                final ItemModel model = new ItemModel();
                model.setId(id);
                model.setName(first_name + " " + last_name);
                model.setJob(job);
                model.setEmail(email);
                model.setPhone(phone);
                arrayList.add(model);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        CustomAdapter adapter = new CustomAdapter(this, arrayList);
        ListView listView = (ListView) findViewById(R.id.recyclerView);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(), "Hi",Toast.LENGTH_LONG).show();

            }
        });

    }



    private String readJSON() {


        String json = null;
        try {
            // Opening data.json file
            InputStream inputStream = getAssets().open("data.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            // read values in the byte array
            inputStream.read(buffer);
            inputStream.close();
            // convert byte to string
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return json;
        }
        return json;

    }


}