package fr.gsb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

import fr.gsb.rv.entites.RV;
import fr.gsb.rv.modeles.ModeleGsb;

public class ListeRvActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_rv_activity);

        Intent intent = getIntent();
        String anneeSelectionne = intent.getStringExtra("annee");
        String moisSelectionne = intent.getStringExtra("mois");

        ModeleGsb modeleGsb = ModeleGsb.getInstance();
        ArrayList<RV> filtreRVs = modeleGsb.FiltrationRV(anneeSelectionne, moisSelectionne);

        ListView listView = findViewById(R.id.bruh); // Make sure you have a ListView in your layout with id "listView"

        // Create an ArrayList of Strings to hold the representations of your RV objects
        ArrayList<String> rvStringList = new ArrayList<>();
        //ArrayList<Integer> rvlist = new ArrayList<>();
        for (RV rv : filtreRVs) {
        //    rvlist.add(rv.getRap_num());
            rvStringList.add( "Num rapport : " + rv.getRap_num().toString() + " - \n" + "Nom Visiteur : " + rv.getVisiteur().getNom()); // Assuming 'getRap_bilan()' returns a String
        }

        // Create an ArrayAdapter to adapt the ArrayList of Strings to your ListView
        ArrayAdapter<String> RVAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, rvStringList);

        listView.setAdapter(RVAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                String selectedItem = rvStringList.get(position);
                String[] parts = selectedItem.split("Num rapport : ");
                String rvNumber = parts[1].split(" - ")[0].trim();
                Intent intent = new Intent(ListeRvActivity.this, VisuInformation.class);
                intent.putExtra("ItemSelec", rvNumber);
                startActivity(intent);
            }
        });
        Button deco = findViewById(R.id.deco);
        deco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListeRvActivity.this, MenuRvActivity.class);
                System.out.println("Déconnexion");
                startActivity(intent);
            }

        });
    }
}

