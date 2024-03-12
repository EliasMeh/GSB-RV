package fr.gsb;

import fr.gsb.rv.entites.Motif;
import fr.gsb.rv.entites.Praticien;
import fr.gsb.rv.entites.RV;
import fr.gsb.rv.entites.Visiteur;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import fr.gsb.rv.modeles.ModeleGsb;
import fr.gsb.rv.technique.Session;

public class SaisieRvActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saisie_rv_activity);

        ModeleGsb modele = ModeleGsb.getInstance();
        ArrayList<Praticien> listePraticien = modele.renvoyerPraticien();
        ArrayList<Motif> listeMotifs = modele.renvoyerMotif();

        Visiteur visactuel = Session.getSession().getLeVisiteur();

        Spinner spinpra = findViewById(R.id.spinpra);
        Spinner spinmotif = findViewById(R.id.spinmotif);

        ArrayList listpraNP = new ArrayList<>();
        for(int o = 0; o < listePraticien.size(); o++ ){
            listpraNP.add(listePraticien.get(o).getPra_nom() + " " + listePraticien.get(o).getPra_prenom());
        }
        ArrayList<String> listeNomMotif = new ArrayList<>();
        for(int k = 0; k < listeMotifs.size(); k++ ){
            listeNomMotif.add(listeMotifs.get(k).getNom_motif());
        }

        SpinnerAdapter praadapt = new ArrayAdapter<>(SaisieRvActivity.this, android.R.layout.simple_spinner_item, listpraNP);
        SpinnerAdapter motadapt = new ArrayAdapter<>(SaisieRvActivity.this, android.R.layout.simple_spinner_item, listeNomMotif);

        spinpra.setAdapter(praadapt);
        spinmotif.setAdapter(motadapt);

        EditText editText = findViewById(R.id.editext1);

        String editTextValue = editText.getText().toString();


        DatePicker datePicker = findViewById(R.id.datepicker);

        Button creer = findViewById(R.id.creer);

        Button deco = findViewById(R.id.deco);

        creer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SaisieRvActivity.this, SaisirEchantillon.class);

                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth() + 1;
                int year = datePicker.getYear();

                String date = day + "/" + month + "/" + year ;


                int selectPrat = spinpra.getSelectedItemPosition(); // Remove + 1
                int selectMot = spinmotif.getSelectedItemPosition(); // Remove + 1

                // Check if the selected position is valid
                if (selectPrat >= 0 && selectPrat < listePraticien.size() && selectMot >= 0 && selectMot < listeMotifs.size()) {
                    Praticien PraticienSelectionne = (Praticien) listePraticien.get(selectPrat);
                    Motif motif1 = (Motif) listeMotifs.get(selectMot);

                    ArrayList<RV> listrap = modele.renvoyerRV();
                    int num = listrap.size() + 1;
                    RV rvajout = new RV(num, date, editTextValue, visactuel, PraticienSelectionne, motif1);

                    System.out.println(rvajout.getMotif().getNom_motif() + " " + rvajout.getRap_date_visite() + " " + rvajout.getPraticien().getPra_nom());
                    System.out.println("num prat " + selectPrat + " num mot " + selectMot);

                    startActivity(intent);
                } else {
                    // Handle invalid selection
                    Toast.makeText(SaisieRvActivity.this, "Invalid selection", Toast.LENGTH_SHORT).show();
                }
            }
        });



        deco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SaisieRvActivity.this, MenuRvActivity.class);
                startActivity(intent);
            }

        });

    }
}
