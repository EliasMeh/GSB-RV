package fr.gsb.rv.entites;

public class RV {
    private Integer rap_num;
    private String rap_date_visite;
    private String rap_bilan;
    private Visiteur visiteur;
    private Praticien praticien ;
    private Motif motif ;


    public RV(Integer rap_num, String rap_date_visite, String rap_bilan, Visiteur visiteur, Praticien praticien, Motif motif) {
        this.rap_num = rap_num;
        this.rap_date_visite = rap_date_visite;
        this.rap_bilan = rap_bilan;
        this.visiteur = visiteur ;
        this.praticien = praticien ;
        this.motif = motif;
    }

    public Integer getRap_num() {
        return rap_num;
    }

    public void setRap_num(Integer rap_num) {
        this.rap_num = rap_num;
    }

    public String getRap_date_visite() {
        return rap_date_visite;
    }

    public void setRap_date_visite(String rap_date_visite) {
        this.rap_date_visite = rap_date_visite;
    }

    public String extractDay() {
        String[] parts = rap_date_visite.split("/");
        return parts[0];
    }

    public String extractMonth() {
        String[] parts = rap_date_visite.split("/");
        return parts[1];
    }
    public String extractYear() {
        String[] parts = rap_date_visite.split("/");
        return parts[2];
    }

    public Motif getMotif() {
        return motif;
    }

    public void setMotif(Motif motif) {
        this.motif = motif;
    }

    public String getRap_bilan() {
        return rap_bilan;
    }

    public void setRap_bilan(String rap_bilan) {
        this.rap_bilan = rap_bilan;
    }

    public Visiteur getVisiteur() {
        return visiteur;
    }

    public void setVisiteur(Visiteur visiteur) {
        this.visiteur = visiteur;
    }

    public Praticien getPraticien() {
        return praticien;
    }

    public void setPraticien(Praticien praticien) {
        this.praticien = praticien;
    }
}
