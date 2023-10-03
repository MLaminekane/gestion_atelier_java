package com.ism.entities;

public abstract class AbstractEntities {
    //Attributs   Instances
    protected static int nbr;
    protected int id;
    protected String libelle;

    public AbstractEntities(String libelle) {
        this.id=++nbr;
        this.libelle = libelle;
    }
    //constructeur avec argument
    public AbstractEntities(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }
    //sans argument
    public AbstractEntities() {
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

    @Override
    public String toString() {
        return " [id=" + id + ", libelle=" + libelle + "]";
    }
    
}
