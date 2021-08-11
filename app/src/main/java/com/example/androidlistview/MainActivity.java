package com.example.androidlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvItem;
    private String[] namaNegara = new String[] { "Indonesia", "Malaysia", "Singapura", "Italia", "Inggris", "Belanda", "Argentina", "Chile", "Mesir", "Uganda" };
    private String[] namaIbuKota = new String[] { "Jakarta", "Kuala Lumpur", "Singapura", "Roma", "London", "Amsterdam", "Buenos Aires", "Santiago", "Cairo", "Kampala" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Aplikasi ListView");

        ArrayList<Negara> listNegara = new ArrayList<Negara>();

        for (int i = 0; i < namaNegara.length; i++) {
            Negara n = new Negara(namaNegara[i], namaIbuKota[i]);
            listNegara.add(n);
        }

        lvItem = (ListView)findViewById(R.id.list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.view_item_negara, R.id.txtNegara, namaNegara);

        lvItem.setAdapter(adapter);
        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Negara yang dipilih : " + listNegara.get(position).getNegara() + ", Ibu Kota : " + listNegara.get(position).getIbuKota(), Toast.LENGTH_LONG).show();
            }
        });
    }
}