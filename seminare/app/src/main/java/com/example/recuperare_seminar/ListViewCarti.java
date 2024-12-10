package com.example.recuperare_seminar;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ListViewCarti extends AppCompatActivity {

    private ListView listViewCarti;
    private ArrayList<String> cartiList = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_carti);

        listViewCarti = findViewById(R.id.listViewCarti);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cartiList);
        listViewCarti.setAdapter(adapter);

        citesteCartiDinFisier();

        listViewCarti.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String carteSelectata = cartiList.get(position);

                SharedPreferences sharedPreferences = getSharedPreferences("FavoriteCarti", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Carte_" + position, carteSelectata);
                editor.apply();

                Toast.makeText(ListViewCarti.this, "Carte adăugată la favorite!", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    private void citesteCartiDinFisier() {
        try {
            FileInputStream fis = openFileInput("carti.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String line;
            while ((line = reader.readLine()) != null) {
                cartiList.add(line);
            }
            reader.close();
            adapter.notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
