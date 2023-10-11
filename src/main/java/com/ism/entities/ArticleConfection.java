package com.ism.entities;

import java.util.ArrayList;

public class ArticleConfection extends AbstractEntities {
    private int id;
    private String libelle;
    private double prix;
    private double qte;
    private String catLibelle;
    private Categorie categorie;

    // Attributs Navigationnels
    //@ManyToOne
    //@ManyToMany
    // Couplage Fort
    private ArrayList<Unite> unites = new ArrayList<>();

    public void addUnite(Unite unite) {
        unites.add(unite);
    }

    public ArrayList<Unite> getUnites() {
        return unites;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public ArticleConfection(String libelle, double prix, double qte, Categorie categorie) {
        this.libelle = libelle;
        this.prix = prix;
        this.qte = qte;
        this.categorie = categorie;
    }

    public ArticleConfection() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public double getQte() {
        return qte;
    }

    public void setQte(double qte) {
        this.qte = qte;
    }

    public String getCatLibelle() {
        return catLibelle;
    }

    public void setCatLibelle(String catLibelle) {
        this.catLibelle = catLibelle;
    }

    @Override
    public String toString() {
        return "ArticleConfection [id=" + id + ", libelle=" + libelle + ", prix=" + prix + ", qte=" + qte + ", catLibelle=" + catLibelle + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ArticleConfection other = (ArticleConfection) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
