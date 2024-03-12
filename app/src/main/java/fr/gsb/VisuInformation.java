package fr.gsb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import fr.gsb.rv.entites.Cadeau;
import fr.gsb.rv.entites.RV;
import fr.gsb.rv.entites.Visiteur;
import fr.gsb.rv.modeles.ModeleGsb;

import androidx.appcompat.app.AppCompatActivity;

public class VisuInformation extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visu_informations);
        String itemselec = this.getIntent().getStringExtra("ItemSelec") ;
        //System.out.println(itemselec);
        Integer intitemselec = new Integer(0);
        intitemselec = Integer.parseInt(itemselec);
        ModeleGsb modeleGsb = ModeleGsb.getInstance();
        RV res = modeleGsb.renvoyerRVspe(intitemselec);
        int nbEchant = modeleGsb.renvoyerEchant(intitemselec);
        //System.out.println(intitemselec);

        TextView textView2 = findViewById(R.id.textView2);
        TextView textView3 = findViewById(R.id.textView3);
        TextView textView4 = findViewById(R.id.textView4);
        TextView textView5 = findViewById(R.id.textView5);
        TextView textView6 = findViewById(R.id.textView6);


        textView2.setText("\nNuméro de rapport : " +res.getRap_num().toString());
        textView3.setText("Praticien visité : " + res.getPraticien().getPra_nom() + " " + res.getPraticien().getPra_prenom());
        textView4.setText("Visiteur : " + res.getVisiteur().getNom() + " " + res.getVisiteur().getPrenom());
        textView5.setText("Date de visite :" + res.getRap_date_visite());
        //textView6.setText("Bilan :" + res.getRap_bilan() + " / " + nbEchant);


        Button recher = findViewById(R.id.recher);

        if (nbEchant != 0) {
            recher.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(VisuInformation.this, VisuEchant.class);
                    intent.putExtra("numrapechant", itemselec);
                    System.out.println("Affichage des échantillons");
                    startActivity(intent);

                }
            });
        }
        else {

        }

        Button deco = findViewById(R.id.deco);
        deco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VisuInformation.this, MenuRvActivity.class);
                System.out.println("Déconnexion");
                startActivity(intent);
            }

        });

    }
}
