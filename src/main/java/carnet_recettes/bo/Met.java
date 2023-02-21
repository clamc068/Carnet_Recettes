package carnet_recettes.bo;

import java.util.List;

public class Met {
    private int idMet;
    private String nomMet;
    private List<Recette> recettes;

    public Met(int idMet, String nomMet, List<Recette> recettes) {
        this.idMet = idMet;
        this.nomMet = nomMet;
        this.recettes = recettes;
    }

    public Met(String nomMet) {
        this.nomMet = nomMet;
    }

    public int getIdMet() {
        return idMet;
    }

    public void setIdMet(int idMet) {
        this.idMet = idMet;
    }

    public String getNomMet() {
        return nomMet;
    }

    public void setNomMet(String nomMet) {
        this.nomMet = nomMet;
    }

    public List<Recette> getRecettes() {
        return recettes;
    }

    public void setRecettes(List<Recette> recettes) {
        this.recettes = recettes;
    }
}
