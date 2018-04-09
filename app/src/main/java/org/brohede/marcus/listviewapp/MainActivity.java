package org.brohede.marcus.listviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.R.attr.duration;
import static org.brohede.marcus.listviewapp.R.id.text;

public class MainActivity extends AppCompatActivity {
    private String[] mountainNames = {"Matterhorn","Mont Blanc","Denali"};
    private String[] mountainLocations = {"Alps","Alps","Alaska"};
    private int[] mountainHeights ={4478,4808,6190};
    // Create ArrayLists from the raw data above and use these lists when populating your ListView.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] rawData = {"Leif","Ulla","Kjell"};
        List<String> listData = new ArrayList<String>(Arrays.asList(mountainNames));

        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),R.layout.list_item_textview,
                R.id.my_item_textView, listData);

        ListView myListView = (ListView)findViewById(R.id.my_listView);
        myListView.setAdapter(adapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(), mountainNames[position]+" is in the "+mountainLocations[position]+" category and has a height of "+Integer.toString(mountainHeights[position])+"m", Toast.LENGTH_LONG).show();
            }
        });

        //adapter.add("Hilding");
    }
}
