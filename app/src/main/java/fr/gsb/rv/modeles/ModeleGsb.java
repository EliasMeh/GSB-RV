package fr.gsb.rv.modeles;

import java.util.ArrayList;
import java.util.List ;

import fr.gsb.rv.entites.Cadeau;
import fr.gsb.rv.entites.Medicament;
import fr.gsb.rv.entites.Motif;
import fr.gsb.rv.entites.Praticien;
import fr.gsb.rv.entites.Visiteur;
import fr.gsb.rv.entites.RV;

public class ModeleGsb {

    private static ModeleGsb modele = null ;

    private List<Visiteur> lesVisiteurs = new ArrayList<Visiteur>() ;
    private List<Praticien> lesPraticiens = new ArrayList<Praticien>() ;
    private List<Medicament> lesMedicaments = new ArrayList<Medicament>() ;
    private List<RV> lesRapports = new ArrayList<RV>() ;
    private List<Cadeau> lesCados = new ArrayList<Cadeau>();
    private List<Motif> lesMotifs = new ArrayList<Motif>();



    private ModeleGsb(){
        super() ;
        this.peupler() ;
        this.peuplercontenu();
    }

    public static ModeleGsb getInstance(){
        if( ModeleGsb.modele == null ){
            modele = new ModeleGsb() ;
        }
        return ModeleGsb.modele ;
    }

    private void peupler(){
        this.lesVisiteurs.add( new Visiteur("a131","azerty","Villechalane","Louis") ) ;
        this.lesVisiteurs.add( new Visiteur("b13","azerty","Bentot","Pascal") ) ;
        this.lesVisiteurs.add( new Visiteur("b16","azerty","Bioret","Luc") ) ;
        this.lesVisiteurs.add( new Visiteur("a17","azerty","Andre","David") ) ;

        this.lesPraticiens.add( new Praticien(1,"Rotschild","Macron")) ;
        this.lesPraticiens.add( new Praticien(2, "Lapierre","Deterre")) ;

    }
    private void peuplercontenu(){
        this.lesMedicaments.add( new Medicament("AAA111","Doliprane"));
        this.lesMedicaments.add( new Medicament("AAA112", "Spasfon"));

        this.lesMotifs.add(new Motif(1, "Recommandation du praticien"));
        this.lesMotifs.add(new Motif(2, "Visite régulière"));
        this.lesMotifs.add(new Motif(3, "1ère visite/ Prospection"));

        this.lesRapports.add(new RV(1,"3/3/2024","Vendu échantillons",lesVisiteurs.get(0),lesPraticiens.get(0),lesMotifs.get(0)));
        this.lesRapports.add(new RV(2,"1/1/2020","Vendu échantillons",lesVisiteurs.get(0),lesPraticiens.get(1),lesMotifs.get(1)));
        this.lesRapports.add(new RV(3,"3/3/2024","Vendu échantillons",lesVisiteurs.get(0),lesPraticiens.get(0),lesMotifs.get(2)));

//        this.lesRapports.add(new RV(1,"3/3/2024","Vendu échantillons",lesVisiteurs.get(0),lesPraticiens.get(0)));
//        this.lesRapports.add(new RV(2,"1/1/2020","Vendu échantillons",lesVisiteurs.get(0),lesPraticiens.get(1)));
//        this.lesRapports.add(new RV(3,"3/3/2024","Vendu échantillons",lesVisiteurs.get(0),lesPraticiens.get(0)));

        this.lesCados.add(new Cadeau(20, lesRapports.get(0), lesMedicaments.get(0)));
        this.lesCados.add(new Cadeau(10, lesRapports.get(0), lesMedicaments.get(1)));
        this.lesCados.add(new Cadeau(40, lesRapports.get(1), lesMedicaments.get(0)));




    }

    public ArrayList<Medicament> renvoyerMedoc(){
        ArrayList<Medicament> listmedoc = new ArrayList<>();
        for(int k = 0; k < lesMedicaments.size(); k++){
            listmedoc.add(lesMedicaments.get(k));
        }
        return listmedoc ;
    }


    public RV renvoyerRVspe(int o){
        for (int i=0; i< this.lesRapports.size();i++){
            if (lesRapports.get(i).getRap_num() == o){
                return lesRapports.get(i);
            }
        }
        return null;
    }


    public ArrayList<RV> renvoyerRV(){
        ArrayList<RV> listrap = new ArrayList<>();
        for(int k = 0; k < lesRapports.size(); k++){
            listrap.add(lesRapports.get(k));
        }
        return listrap ;
    }
    public int renvoyerEchant(int o){
        for (int i = 0; i < this.lesCados.size(); i++){
            if ( lesCados.get(i).getRapport().getRap_num() == o){
                return lesCados.get(i).getQuantite();
            }
        }

        return 0;
    }
    public ArrayList<Cadeau> renvoyerToutEchant(int o){
        ArrayList<Cadeau> Retour = new ArrayList<>();
        for (int i = 0; i < this.lesCados.size(); i++){
            if ( lesCados.get(i).getRapport().getRap_num() == o){
                Retour.add(lesCados.get(i));
            }
        }
        return Retour;
    }
    public ArrayList renvoyerPraticien(){
        ArrayList<Praticien> listePraticien = new ArrayList<>();
        for (int i=0; i< this.lesPraticiens.size();i++){
            listePraticien.add(lesPraticiens.get(i));
        }
        return listePraticien ;
    }
    public ArrayList renvoyerMotif(){
        ArrayList<Motif> listeMotif = new ArrayList<>();
        for (int o=0; o< this.lesMotifs.size();o++){
            listeMotif.add(lesMotifs.get(o));
        }
        return listeMotif ;
    }
    public Motif renvoyerMotifSpe(int o){
        for (int i=0; i< this.lesMotifs.size();i++){
            if (lesMotifs.get(i).getNum_motif() == o){
                return lesMotifs.get(i);
            }
        }
        return null;
    }
    public ArrayList<RV> FiltrationRV(String annee, String mois){
        ArrayList<RV> Retour = new ArrayList<>();
        for(int i=0; i < this.lesRapports.size(); i++){
            if( lesRapports.get(i).extractMonth().equals(mois) && lesRapports.get(i).extractYear().equals(annee)){
                Retour.add(lesRapports.get(i));
            }
        }
        return Retour;
    }

    public Visiteur seConnecter(String matricule, String mdp){

        for( Visiteur unVisiteur : this.lesVisiteurs ){
            if( unVisiteur.getMatricule().equals(matricule) && unVisiteur.getMdp().equals(mdp) ){
                return unVisiteur ;
            }
        }

        return null ;

    }


}