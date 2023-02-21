package carnet_recettes.bo;

import java.util.List;

public class Recette {
    private int idRecette;
    private String nomRecette;
    private List<Methode> methode;
    private Met met;

    public Recette(int idRecette, String nomRecette) {
        this.idRecette = idRecette;
        this.nomRecette = nomRecette;
    }

    public Recette(String nomRecette, List<Methode> methode, Met met) {
        this.nomRecette = nomRecette;
        this.methode = methode;
        this.met = met;
    }

    public int getIdRecette() {
        return idRecette;
    }

    public void setIdRecette(int idRecette) {
        this.idRecette = idRecette;
    }

    public String getNomRecette() {
        return nomRecette;
    }

    public void setNomRecette(String nomRecette) {
        this.nomRecette = nomRecette;
    }

    public List<Methode> getMethode() {
        return methode;
    }

    public void setMethode(List<Methode> methode) {
        this.methode = methode;
    }

    public Met getMet() {
        return met;
    }

    public void setMet(Met met) {
        this.met = met;
    }
}
