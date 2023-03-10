package carnet_recettes.dal;

import carnet_recettes.bo.Met;
import carnet_recettes.bo.Recette;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecetteDAOJdbcImpl implements RecetteDAO{
    private final static String SELECT_ALL_MET="SELECT * FROM METS";
    private final static String SELECT_RECETTES_BY_MET="SELECT r.id_Recettes, r.nom_Recettes FROM RECETTES r JOIN METS_RECETTES mr ON r.id_Recettes=mr.id_Recettes Where mr.id_Mets =?";
    private final static String SELECT_RECETTES_BY_NAME="SELECT r.nom_Recettes,m.type_Mets,i.nom_Ingredients,mes.quantite,mes.type_Mesure,me.numero_Etape,me.texte_Etape FROM RECETTES r \n" +
            "Inner Join METS_RECETTES mr ON r.id_Recettes=mr.id_Recettes\n" +
            "Inner Join METS m ON mr.id_Mets=m.id_Mets\n" +
            "Inner Join RECETTES_METHODES rm ON r.id_Recettes=rm.id_Recettes\n" +
            "Inner Join METHODES me ON rm.id_Methodes=me.id_Methodes\n" +
            "Inner Join RECETTES_INGREDIENTS ri ON ri.id_Recettes=r.id_Recettes\n" +
            "inner join INGREDIENTS i on i.id_Ingredients=ri.id_Ingredients\n" +
            "inner join MESURES mes on m.id_Mets=ri.id_Mesures\n" +
            "WHERE nom_Recettes =?";

    //Permet de selectionner les differents mets créés
    public List<Met> selectAllMet(){
        List<Met> mets =new ArrayList<>();

        try(Connection cnx=ConnectionProvider.getConnection()){
            PreparedStatement pstmt =cnx.prepareStatement(SELECT_ALL_MET);
            ResultSet rs=pstmt.executeQuery();

            while(rs.next()){
                Met met = new Met(rs.getInt("id_Mets"), rs.getString("type_Mets"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return mets;
    }

    //Permet de trouver des recettes par tyoe de met
    @Override
    public List<Recette> selectRecettesByMet(int idMet) {
        List<Recette>recettes= new ArrayList<>();
        try(Connection cnx =ConnectionProvider.getConnection()){
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_RECETTES_BY_MET);
            pstmt.setInt(1,idMet);

            ResultSet rs =pstmt.executeQuery();

            if(rs.next()){
                recettes.add(new Recette(rs.getInt("id_Recettes"), rs.getString("nom_Recettes"))) ;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return recettes;
    }
    public Recette selectRecetteByName(String nom){
        Recette recette= null;
        try(Connection cnx =ConnectionProvider.getConnection()){
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_RECETTES_BY_MET);
            pstmt.setString(1,nom);

            ResultSet rs =pstmt.executeQuery();

            if(rs.next()){
                            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  recette;
    }
}
