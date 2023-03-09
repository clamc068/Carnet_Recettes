package carnet_recettes.bo;

import java.util.Enumeration;
import java.util.List;

public class Methode {
    private int idMethode;
    private int numMethode;
    private String texte;
    List<Recette> recettes;

    public Methode(int idMethode, int numMethode, String texte, Recette recette) {
        this.idMethode = idMethode;
        this.numMethode = numMethode;
        this.texte = texte;
    }

    public Methode(int numMethode, String texte) {
        this.numMethode = numMethode;
        this.texte = texte;
    }

    public List<Recette> getRecettes() {
        return recettes;
    }

    public void setRecettes(List<Recette> recettes) {
        this.recettes = recettes;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public int getNumMethode() {
        return numMethode;
    }

    public void setNumMethode(int numMethode) {
        this.numMethode = numMethode;
    }

    public int getIdMethode() {
        return idMethode;
    }

    public void setIdMethode(int idMethode) {
        this.idMethode = idMethode;
    }
}
