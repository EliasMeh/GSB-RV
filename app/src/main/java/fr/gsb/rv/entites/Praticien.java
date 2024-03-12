package fr.gsb.rv.entites;

public class Praticien {
    private Integer pra_num ;
    private String pra_nom ;
    private String pra_prenom ;

    public Praticien(Integer pra_num,String pra_nom,String pra_prenom){
        this.pra_num = pra_num ;
        this.pra_nom = pra_nom ;
        this.pra_prenom = pra_prenom ;
    }

    public Integer getPra_num() {
        return pra_num;
    }

    public void setPra_num(Integer pra_num) {
        this.pra_num = pra_num;
    }

    public String getPra_nom() {
        return pra_nom;
    }

    public void setPra_nom(String pra_nom) {
        this.pra_nom = pra_nom;
    }

    public String getPra_prenom() {
        return pra_prenom;
    }

    public void setPra_prenom(String pra_prenom) {
        this.pra_prenom = pra_prenom;
    }
}
