package com.ism.services;



import com.ism.entities.ArticleConfection;


public interface ArticleConfectionService extends IService<ArticleConfection>  {

    void add(ArticleConfection confection, String libelle, Double prix, Double qte);
}
