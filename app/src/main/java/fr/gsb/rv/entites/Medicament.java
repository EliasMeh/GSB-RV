package fr.gsb.rv.entites;

public class Medicament {
    private String depotlegal;
    private String nomcommercial ;

    public Medicament(String depotlegal, String nomcommercial) {

        this.depotlegal = depotlegal ;
        this.nomcommercial = nomcommercial ;
    }

    public String getDepotlegal() {
        return depotlegal;
    }

    public void setDepotlegal(String depotlegal) {
        this.depotlegal = depotlegal;
    }

    public String getNomcommercial() {
        return nomcommercial;
    }

    public void setNomcommercial(String nomcommercial) {
        this.nomcommercial = nomcommercial;
    }
}
