package com.example.seminar11_firebase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText idEditText, marcaEditText;
    private CheckBox addToDatabaseCheckBox;
    private Button addLaptopButton;

    private FirebaseDatabase database;
    private DatabaseReference laptopsRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance();
        laptopsRef = database.getReference("laptops");

        idEditText = findViewById(R.id.editTextText2);
        marcaEditText = findViewById(R.id.editTextText);
        addToDatabaseCheckBox = findViewById(R.id.checkBox);
        addLaptopButton = findViewById(R.id.buttonAdaugaLaptop);

        addLaptopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idEditText.getText().toString();
                String marca = marcaEditText.getText().toString();

                if (id.isEmpty() || marca.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vă rugăm să completați toate câmpurile!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (addToDatabaseCheckBox.isChecked()) {
                    Laptop laptop = new Laptop();
                    laptop.setId(Integer.parseInt(id));
                    laptop.setMarca(marca);


                    laptopsRef.push().setValue(laptop)
                            .addOnCompleteListener(task -> {
                                if (task.isSuccessful()) {
                                    Toast.makeText(MainActivity.this, "Laptop adăugat cu succes!", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(MainActivity.this, "Eroare la adăugarea laptopului", Toast.LENGTH_SHORT).show();
                                }
                            });
                } else {
                    Toast.makeText(MainActivity.this, "Selectați căsuța pentru a adăuga laptopul", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
