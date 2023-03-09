package carnet_recettes.dal;

import carnet_recettes.bo.Met;
import carnet_recettes.bo.Recette;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecetteDAOJdbcImpl implements RecetteDAO{
    private final static String SELECT_ALL_MET="SELECT * FROM METS";
    private final static String SELECT_RECETTES_BY_MET="SELECT r.id_Recettes, r.nom_Recettes FROM RECETTES r JOIN METS_RECETTES mr ON r.id_Recettes=mr.id_Recettes Where mr.id_Mets =?";

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
}
