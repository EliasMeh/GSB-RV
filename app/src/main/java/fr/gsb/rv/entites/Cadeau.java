package fr.gsb.rv.entites;

public class Cadeau {
    private Integer quantite;
    private RV rapport;
    private Medicament medoc;

    public Cadeau(Integer quantite, RV rapport, Medicament medoc) {
        this.quantite = quantite;
        this.rapport = rapport;
        this.medoc = medoc;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public RV getRapport() {
        return rapport;
    }

    public void setRapport(RV rapport) {
        this.rapport = rapport;
    }

    public Medicament getMedoc() {
        return medoc;
    }

    public void setMedoc(Medicament medoc) {
        this.medoc = medoc;
    }
}
