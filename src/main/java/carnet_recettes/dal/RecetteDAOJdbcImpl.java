package carnet_recettes.dal;

import carnet_recettes.bo.Met;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecetteDAOJdbcImpl implements RecetteDAO{
    private final static String SELECT_ALL_MET="SELECT * FROM METS";
    private final static String SELECT_RECETTE_BY_MET="SELECT * FROM RECETTES r JOIN METS_RECETTES mr ON r.id_Recettes=mr.id_Recettes JOIN METS m ON  m.id_Mets=mr.id_Mets Where mr.id_Mets =?";

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

    //Permet de trouver des recettes par tyoe de mets
    @Override
    public Met selectRecetteByMet(int idMets) {
        Met met =null;

        try(Connection cnx =ConnectionProvider.getConnection()){
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_RECETTE_BY_MET);
            pstmt.setInt(1,idMets);

            ResultSet rs =pstmt.executeQuery();

            if(rs.next()){
                met = new Met(rs.getInt("id_Mets"),rs.getString("type_Mets"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return met;
    }
}
