package com.example.seminar4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import kotlinx.coroutines.Dispatchers;

public class AdaugareCarte extends AppCompatActivity {

    EditText etNumeCarte, etIsbn, etNrBucati, etPret;
    RadioButton rbInStocDa, rbInStocNu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adaugare_carte);

        etNumeCarte = findViewById(R.id.etNumeCarte);
        etIsbn = findViewById(R.id.etIsbn);
        etNrBucati = findViewById(R.id.etNrBucati);
        etPret = findViewById(R.id.etPret);
        rbInStocDa = findViewById(R.id.rbInStocDa);
        rbInStocNu = findViewById(R.id.rbInStocNu);

        Button btnAdauga = findViewById(R.id.btnAdauga);
        btnAdauga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numeCarte = etNumeCarte.getText().toString();
                String isbn = etIsbn.getText().toString();
                int nrBucati = Integer.parseInt(etNrBucati.getText().toString());
                float pret = Float.parseFloat(etPret.getText().toString());
                boolean inStoc = rbInStocDa.isChecked();

                Librarie librarie = new Librarie(isbn, numeCarte, inStoc, nrBucati, pret);

                LibrarieDatabase db = LibrarieDatabase.getDatabase(getApplicationContext());
                lifecycleScope.launch(Dispatchers.IO) {
                    db.librarieDao().insert(librarie);

                    runOnUiThread(() -> finish());
                };
            }
        });
    }
}
