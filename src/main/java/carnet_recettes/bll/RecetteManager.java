package carnet_recettes.bll;

import carnet_recettes.bo.Recette;
import carnet_recettes.dal.RecetteDAO;
import carnet_recettes.dal.RecetteDAOFactory;

import java.util.List;

public class RecetteManager {

    private RecetteDAO recetteDAO;
    public static RecetteManager instance;

    public RecetteManager(){
        this.recetteDAO= RecetteDAOFactory.getRecetteDAO();
    }

    public static RecetteManager getInstance(){
        if(instance==null){
            instance=new RecetteManager();
        }
        return instance;
    }
    public List<Recette> selectRecettesByMet(int idMet){
        return recetteDAO.selectRecettesByMet(idMet);
    }
}
