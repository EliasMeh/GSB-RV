package fr.gsb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import fr.gsb.rv.technique.Session;

public class MenuRvActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_rv_activity);
        //Bundle informations = getIntent().getExtras();

        TextView textView2 = findViewById(R.id.textView2);

        Button boutonSaisir = findViewById(R.id.bouton_consulter);
        Button boutonConsulter = findViewById(R.id.bouton_saisir);


        String nom = Session.getSession().getLeVisiteur().getNom();
        String prenom = Session.getSession().getLeVisiteur().getPrenom();
        String info = nom + " " + prenom ;
        textView2.setText(info);


        boutonSaisir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuRvActivity.this, RechercheRvActivity.class);
                startActivity(intent);
            }

        });
        boutonConsulter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuRvActivity.this, SaisieRvActivity.class);
                startActivity(intent);

            }

        });

    }
}