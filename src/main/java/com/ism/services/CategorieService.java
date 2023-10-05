package com.ism.services;

import com.ism.entities.Categorie;

public interface CategorieService extends IService<Categorie> {

    Categorie get(int i);
}
