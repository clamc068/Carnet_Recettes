package carnet_recettes.dal;

import carnet_recettes.bo.Met;

import java.util.List;

public interface RecetteDAO {
    public List<Met> selectAllMet();
    public Met selectRecetteByMet(int idMets);
}
