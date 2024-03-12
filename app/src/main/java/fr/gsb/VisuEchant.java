package fr.gsb;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;

import fr.gsb.rv.entites.Cadeau;
import fr.gsb.rv.entites.RV;
import fr.gsb.rv.entites.Visiteur;
import fr.gsb.rv.modeles.ModeleGsb;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class VisuEchant extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visu_echantillon);
        String numEchant = this.getIntent().getStringExtra("numrapechant") ;

        System.out.println(numEchant);
        //Integer intitemselec = new Integer(0);
        //int numEchant = Integer.parseInt("itemselec");
        ModeleGsb modeleGsb = ModeleGsb.getInstance();
        ArrayList<Cadeau> listEchant = modeleGsb.renvoyerToutEchant(Integer.parseInt(numEchant));
        //int nbEchant = modeleGsb.renvoyerEchant(intitemselec);
        //System.out.println(intitemselec);
        System.out.println(listEchant.get(0).getQuantite());
        //System.out.println(listEchant.get(1));
        //TextView textView2 = findViewById(R.id.textView2);
        //TextView textView3 = findViewById(R.id.textView3);
        ArrayList<String> listenommed = new ArrayList();
        for (int i = 0 ; i<listEchant.size(); i++){
            listenommed.add(listEchant.get(i).getMedoc().getNomcommercial());
        }
        ArrayList<Integer> listeqttmed = new ArrayList();
        for (int k = 0 ; k < listEchant.size(); k++){
            listeqttmed.add(listEchant.get(k).getQuantite());
        }
        ArrayList<String> res = new ArrayList<>();
        for(int o=0; o<listEchant.size(); o++){
            res.add(listenommed.get(o) + " - Quantité : " + listeqttmed.get(o));
        }
        ListView listeechant = findViewById(R.id.listeechant);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, res);


        listeechant.setAdapter(adapter);

        Button deco = findViewById(R.id.deco);
        deco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VisuEchant.this, MenuRvActivity.class);
                System.out.println("Déconnexion");
                startActivity(intent);
            }

        });



        //adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        //tabLayout.setAdapter(adapter);

        //textView2.setText("\nNuméro de rapport : " +res.getRap_num().toString());
        //textView3.setText("Praticien visité : " + res.getPraticien().getPra_nom() + " " + res.getPraticien().getPra_prenom());

        //TableLayout tabLayout = findViewById(R.id.table);




    }
}
