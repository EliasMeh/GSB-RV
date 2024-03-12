package fr.gsb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class RechercheRvActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recherche_rv_activity);
        Button deco = findViewById(R.id.deco);
        Button cher = findViewById(R.id.cher);
        Spinner spinnerM = findViewById(R.id.spinnerMois) ;
        Spinner spinnerA = findViewById(R.id.spinnerAnnee);

        ArrayList<String> mois = new ArrayList<>();

        for(int i = 1;i<=12;i++){
            mois.add(Integer.toString(i));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mois);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinnerM.setAdapter(adapter);

        ArrayList<String> annee = new ArrayList<>();

        for(int i = 2020;i<=2025;i++){
            annee.add(Integer.toString(i));
        }
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, annee);
        adapter1.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinnerA.setAdapter(adapter1);



        deco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RechercheRvActivity.this, MenuRvActivity.class);
                System.out.println("Déconnexion");
                startActivity(intent);
            }

        });
        cher.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(RechercheRvActivity.this,ListeRvActivity.class );
                String anneeSelectionne = spinnerA.getSelectedItem().toString();
                String moisSelectionne = spinnerM.getSelectedItem().toString();


                intent.putExtra("annee", anneeSelectionne);
                intent.putExtra("mois", moisSelectionne);
                System.out.println("Recherche avec annee et mois");
                startActivity(intent);

            }
        });
    }

}
