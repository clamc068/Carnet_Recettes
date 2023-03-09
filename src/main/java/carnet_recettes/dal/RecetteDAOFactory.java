package carnet_recettes.dal;

public class RecetteDAOFactory {
    public static RecetteDAO getRecetteDAO(){
        return new RecetteDAOJdbcImpl();
    }
}
