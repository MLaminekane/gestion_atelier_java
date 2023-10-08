package com.ism.repositories.bd;

import com.ism.entities.Categorie;
import com.ism.repositories.ITables;
import java.util.ArrayList;

public class CategorieRepository extends MySqlRepository implements ITables<Categorie> {
    private static final String INSERT_SQL = "INSERT INTO `categories` (`id`, `libelle`) VALUES (NULL, ?)";
    private static final String UPDATE_SQL = "UPDATE `categories` SET `libelle` = ? WHERE `categories`.`id` = ?";
    private static final String SELECT_ALL_SQL = "SELECT id, libelle FROM categories";
    private static final String SELECT_BY_ID_SQL = "SELECT id, libelle FROM categories WHERE id=?";
    private static final String DELETE_SQL = "DELETE FROM `categories` WHERE `categories`.`id` = ?";
    @Override
    public int insert(Categorie data) {
        return executeUpdate(INSERT_SQL, data.getLibelle());
    }
    @Override
    public int update(Categorie data) {
        return executeUpdate(UPDATE_SQL, data.getLibelle(), data.getId());
    }
    @Override
    public ArrayList<Categorie> findAll() {
        return executeQuery(SELECT_ALL_SQL);
    }
    @Override
    public Categorie findById(int id) {
        ArrayList<Categorie> result = executeQuery(SELECT_BY_ID_SQL, id);
        return result.isEmpty() ? null : result.get(0);
    }
    @Override
    public int delete(int id) {
        return executeUpdate(DELETE_SQL, id);
    }
    @Override
    public int indexOf(int id) {
        return 0;
    }
}
