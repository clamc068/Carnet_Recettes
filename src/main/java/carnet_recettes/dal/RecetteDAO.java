package carnet_recettes.dal;

import carnet_recettes.bo.Met;
import carnet_recettes.bo.Recette;

import java.util.List;

public interface RecetteDAO {
    public List<Met> selectAllMet();
    public List<Recette> selectRecettesByMet(int idMet);
}
