package fr.gsb.rv.entites;

public class Motif {
    private Integer num_motif;
    private String nom_motif;

    public Motif(Integer num_motif, String nom_motif) {
        this.num_motif = num_motif;
        this.nom_motif = nom_motif;
    }

    public Integer getNum_motif() {
        return num_motif;
    }

    public void setNum_motif(Integer num_motif) {
        this.num_motif = num_motif;
    }

    public String getNom_motif() {
        return nom_motif;
    }

    public void setNom_motif(String nom_motif) {
        this.nom_motif = nom_motif;
    }

    @Override
    public String toString() {
        return "Motif{" +
                "num_motif=" + num_motif +
                ", nom_motif='" + nom_motif + '\'' +
                '}';
    }

}
