package com.example.christiancarl.lim_listview.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.christiancarl.lim_listview.Adapter.CustomAdapter;
import com.example.christiancarl.lim_listview.Model.College;
import com.example.christiancarl.lim_listview.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int[] logos;
    String[] Years;
    String[] Colleges;
    ListView listView_Colleges;
    CustomAdapter adapter;
    ArrayList<College> listColleges;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Colleges = getResources().getStringArray(R.array.Colleges);
        Years = getResources().getStringArray(R.array.Year);

        listView_Colleges = (ListView) findViewById(R.id.listView_Colleges);
        listColleges = new ArrayList<College>();

        logos = new int[]{R.drawable.iics, R.drawable.engg, R.drawable.med, R.drawable.pharm, R.drawable.engg};

        for(int i = 0; i < Colleges.length; i++){
            listColleges.add(new College(logos[i], Colleges[i], Years[i]));
        }

        adapter = new CustomAdapter(MainActivity.this, listColleges);
        listView_Colleges.setAdapter(adapter);

        listView_Colleges.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String message = "You clicked " + Colleges[i];

                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
