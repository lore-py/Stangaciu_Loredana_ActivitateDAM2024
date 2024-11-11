package com.example.seminar4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final int ADD_BOOK_REQUEST = 1;
    private ArrayList<Librarie> librariiList;
    private ArrayAdapter<Librarie> adapter;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        librariiList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, librariiList);
        listView.setAdapter(adapter);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //button
        Button btn =  findViewById(R.id.adaugaCarteBT);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), AdaugareCarte.class);
                startActivityForResult(it, 403);
            }
        });

        ArrayList listaCarti = new ArrayList<Librarie>();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            Librarie librarie = bundle.getParcelable("librarie");
            listaCarti.add(librarie);

            if (librarie != null) {
                Toast.makeText(this, librarie.toString(), Toast.LENGTH_LONG).show();
            }
        }


            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                listView = findViewById(R.id.listView);
                librariiList = new ArrayList<>();
                adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, librariiList);
                listView.setAdapter(adapter);
            }

            @Override
            protected void onActivityResult(int requestCode, int resultCode, Intent data) {
                super.onActivityResult(requestCode, resultCode, data);

                if (requestCode == ADD_BOOK_REQUEST && resultCode == RESULT_OK) {
                    if (data != null) {
                        Bundle bundle = data.getExtras();
                        if (bundle != null) {
                            Librarie librarie = bundle.getParcelable("librarie");
                            if (librarie != null) {
                                librariiList.add(librarie);
                                adapter.notifyDataSetChanged();
                                Toast.makeText(this, "Carte adăugată: " + librarie.getNumeCarte(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
            }

            public void deschideAdaugareCarte(View view) {
                Intent intent = new Intent(this, AdaugareCarte.class);
                startActivityForResult(intent, ADD_BOOK_REQUEST);
            }
        }

        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

    }
}