package com.example.seminar4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

                Librarie librarie = new Librarie(numeCarte, inStoc, isbn, nrBucati, pret);

                Intent intent = new Intent(AdaugareCarte.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("librarie", librarie);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
