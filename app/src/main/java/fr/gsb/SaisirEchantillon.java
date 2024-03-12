package fr.gsb;

import fr.gsb.MenuRvActivity;
import fr.gsb.R;
import fr.gsb.rv.entites.Medicament;
import fr.gsb.rv.entites.Motif;
import fr.gsb.rv.entites.Praticien;
import fr.gsb.rv.entites.Visiteur;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import fr.gsb.rv.modeles.ModeleGsb;
import fr.gsb.rv.technique.Session;

public class SaisirEchantillon extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saisir_echantillon);

        ModeleGsb modele = ModeleGsb.getInstance();
        ArrayList<Medicament> listmedoc = modele.renvoyerMedoc();
        ArrayList<String> listmedocnom = new ArrayList<>();
        for( int k = 0; k < listmedoc.size();k++){
            listmedocnom.add(listmedoc.get(k).getNomcommercial());
        }

        Spinner spinnermedoc = findViewById(R.id.spinmed);
        SpinnerAdapter adaptermed = new ArrayAdapter<>(SaisirEchantillon.this, android.R.layout.simple_spinner_item, listmedocnom);

        spinnermedoc.setAdapter(adaptermed);

        Button deco = findViewById(R.id.deco);

        deco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SaisirEchantillon.this, MenuRvActivity.class);
                startActivity(intent);
            }

        });
    }
}
