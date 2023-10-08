package com.ism.repositories.bd;

import com.ism.entities.ArticleConfection;
import com.ism.entities.Categorie;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
public abstract class MySqlRepository {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/gestion_couture_java";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erreur lors de la connexion à la base de données : " + e.getMessage(), e);
        }
    }
    protected int executeUpdate(String sql, Object... params) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            int i = 1;
            for (Object param : params) {
                statement.setObject(i++, param);
            }
            return statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
            return 0;
        }
    }
    protected ArrayList<Categorie> executeQuery(String sql, Object... params) {
        ArrayList<Categorie> categories = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            int i = 1;
            for (Object param : params) {
                statement.setObject(i++, param);
            }
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    Categorie categorie = new Categorie(rs.getInt("id"), rs.getString("libelle"));
                    categories.add(categorie);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
        }
        return categories;
    }
    protected ArrayList<ArticleConfection> executeQueryArt(String sql, Object... params) {
        ArrayList<ArticleConfection> articles = new ArrayList<>();
        try (Connection connection = MySqlRepository.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            int i = 1;
            for (Object param : params) {
                statement.setObject(i++, param);
            }
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    ArticleConfection article = new ArticleConfection();
                    article.setId(rs.getInt("id"));
                    article.setLibelle(rs.getString("libelle"));
                    article.setPrix(rs.getDouble("prix"));
                    article.setQte(rs.getDouble("qte"));
                    Categorie categorie = new Categorie();
                    categorie.setId(rs.getInt("catID"));
                    categorie.setLibelle(rs.getString("catLibelle"));
                    article.setCategorie(categorie);
                    articles.add(article);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
        }
        return articles;
    }
    protected static void closeResources(Connection connection, Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                // Gérer les exceptions ici
                e.printStackTrace();
            }
        }
    }
}