package com.ism.repositories.bd;

import com.ism.entities.Categorie;
import com.ism.repositories.ITables;
import java.util.ArrayList;

public class CategorieRepository implements ITables<Categorie> {

    @Override
    public int insert(Categorie data) {
        return 0;
    }

    @Override
    public int insert(Categorie data, String libelle, Double prix, Double qte) {
        return 0;
    }

    @Override
    public int update(Categorie data) {
        return 0;
    }

    @Override
    public ArrayList<Categorie> findAll() {
        return null;
    }

//    @Override
//    public ArrayList<Categorie> findAll() {
//        ArrayList <Categorie> categories = new ArrayList<>();
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nombdd" + ;
//            Statement statement = conn.createStatement();
//            ResultSet rs = statement.executeQuery("select id,libelle from categories");
//            while (rs.next()){
//                Categorie categorie = new Categorie(rs.getInt("id"), rs.getString("libelle"));
//                catategories.add(categorie);
//            }
//            conn.close();
//            Statement.close();
//            rs.close();
//        }catch (ClassNotFoundException e){
//            System.out.println("Error");
//        }
//        catch (SQLException e){
//            System.out.println("Erreur");
//        }
//        return categories;
//    }

    @Override
    public Categorie findById(int id) {
        return null;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public int indexOf(int id) {
        return 0;
    }
}
