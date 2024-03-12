package fr.gsb;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.view.View.OnClickListener ;
import android.widget.Toast;

import fr.gsb.rv.entites.Visiteur;
import fr.gsb.rv.modeles.ModeleGsb;
import fr.gsb.rv.technique.Session;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boutonAnnuler = findViewById(R.id.bouton_annuler);
        Button boutonValider = findViewById(R.id.bouton_valider);

        boutonAnnuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText champTexte1 = findViewById(R.id.editTextMatricule);
                EditText champTexte2 = findViewById(R.id.editTextMdp);

                champTexte1.setText("");
                champTexte2.setText("");
            }
        });

        boutonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("GSB_MAIN_ACTIVITY", "Initialisation des champs");

                EditText matriculeText = findViewById(R.id.editTextMatricule);
                EditText mdpText = findViewById(R.id.editTextMdp);

                String matricule = matriculeText.getText().toString();
                String mdp = mdpText.getText().toString();

                ModeleGsb modeleGsb = ModeleGsb.getInstance();

                Visiteur bruh = modeleGsb.seConnecter(matricule,mdp);

                if(bruh != null){
                    Log.i("GSB_MAIN_ACTIVITY", "Connexion Ok " + bruh.getNom() + " " + bruh.getPrenom()) ;
                    //boutonAnnuler.setEnabled(false);
                    //boutonValider.setEnabled(false);
                    Intent intent = new Intent(MainActivity.this, MenuRvActivity.class);
                    //Bundle informations = new Bundle();
                    //informations.putString("nom", bruh.getNom());
                    //informations.putString("prenom", bruh.getPrenom());
                    Session.ouvrir(bruh);

                    //intent.putExtras(informations);

                    startActivity(intent) ;
                }
                else{
                    Log.i("GSB_MAIN_ACTIVITY", "Connexion Nok");
                    Toast.makeText(MainActivity.this, "Identifiant ou mot de passe incorrect", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}

