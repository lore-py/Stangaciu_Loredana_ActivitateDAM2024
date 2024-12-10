package com.example.recuperare_seminar;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileOutputStream;
import java.io.IOException;

public class AdaugaCarte extends AppCompatActivity {

    private EditText etTitlu, etAutor, etAn;
    private Button btnAdauga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adauga_carte);

        etTitlu = findViewById(R.id.etTitlu);
        etAutor = findViewById(R.id.etAutor);
        etAn = findViewById(R.id.etAn);
        btnAdauga = findViewById(R.id.btnAdauga);

        btnAdauga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titlu = etTitlu.getText().toString();
                String autor = etAutor.getText().toString();
                int an;

                try {
                    an = Integer.parseInt(etAn.getText().toString());
                } catch (NumberFormatException e) {
                    Toast.makeText(AdaugaCarte.this, "Anul trebuie să fie un număr!", Toast.LENGTH_SHORT).show();
                    return;
                }

                Carte carte = new Carte(titlu, autor, an);

                try {
                    FileOutputStream fos = openFileOutput("carti.txt", Context.MODE_APPEND);
                    String data = carte.toString() + "\n";
                    fos.write(data.getBytes());
                    fos.close();
                    Toast.makeText(AdaugaCarte.this, "Carte adăugată!", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(AdaugaCarte.this, "Eroare la salvare!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
