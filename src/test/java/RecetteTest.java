
import carnet_recettes.dal.RecetteDAO;

import carnet_recettes.dal.RecetteDAOJdbcImpl;
import org.junit.jupiter.api.Test;

public class RecetteTest {
    /*on instancie recetteDao avec RecetteDAO*/
    RecetteDAO recetteDao= new RecetteDAOJdbcImpl();
    @Test
    public void selectRecettesByMetTest(){

    }
}
