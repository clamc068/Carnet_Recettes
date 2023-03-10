package carnet_recettes.bo;

import java.util.List;

public class Recette {
    private int idRecette;
    private String nomRecette;
    private List<Methode> methode;

    private List<Ingredient> ingredients;
    private List<Mesure> mesures;

    private Met met;

    public Recette(int idRecette, String nomRecette) {
        this.idRecette = idRecette;
        this.nomRecette = nomRecette;
    }

    public Recette() {

    }

    public Recette(String nomRecette, List<Ingredient> ingredients,List<Mesure> mesures, List<Methode> methode, Met met) {
        this.met = met;
        this.nomRecette = nomRecette;
        this.ingredients = ingredients;
        this.mesures=mesures;
        this.methode = methode;

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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Mesure> getMesures() {
        return mesures;
    }

    public void setMesures(List<Mesure> mesures) {
        this.mesures = mesures;
    }

    @Override
    public String toString() {
        return "Recette{" +
                "idRecette=" + idRecette +
                ", nomRecette='" + nomRecette + '\'' +
                ", methode=" + methode +
                ", ingredients=" + ingredients +
                ", mesures=" + mesures +
                ", met=" + met +
                '}';
    }
}
