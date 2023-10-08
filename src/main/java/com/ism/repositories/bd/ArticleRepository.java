package com.ism.repositories.bd;

import com.ism.entities.ArticleConfection;
import com.ism.entities.Categorie;
import com.ism.repositories.ITables;
import java.sql.*;
import java.util.ArrayList;

public class ArticleRepository extends MySqlRepository implements ITables<ArticleConfection> {
    private static final String INSERT_SQL = "INSERT INTO `articles` (`id`, `libelle`, `prix`, `qte`, `catID`, `catLibelle`) VALUES (NULL, ?, ?, ?, ?, ?)";
    private static final String UPDATE_SQL = "UPDATE `articles` SET `libelle`=?, `prix`=?, `qte`=?, `catID`=?, `catLibelle`=? WHERE `id`=?";
    private static final String SELECT_ALL_SQL = "SELECT * FROM `articles`";
    private static final String SELECT_BY_ID_SQL = "SELECT id, libelle, prix, qte, catID, catLibelle FROM articles WHERE id=?";
    private static final String DELETE_SQL = "DELETE FROM `articles` WHERE `id`=?";
    @Override
    public int insert(ArticleConfection data) {
        return executeUpdate(INSERT_SQL, data.getLibelle(), data.getPrix(), data.getQte(),
                data.getCategorie().getId(), data.getCategorie().getLibelle());
    }
    @Override
    public int update(ArticleConfection data) {
        return executeUpdate(UPDATE_SQL, data.getLibelle(), data.getPrix(), data.getQte(),
                data.getCategorie().getId(), data.getCategorie().getLibelle(), data.getId());
    }
    @Override
    public ArrayList<ArticleConfection> findAll() {
        return executeQueryArt(SELECT_ALL_SQL);
    }
    @Override
    public ArticleConfection findById(int id) {
        ArrayList<ArticleConfection> result = executeQueryArt(SELECT_BY_ID_SQL, id);
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