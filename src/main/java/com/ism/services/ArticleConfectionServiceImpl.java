package com.ism.services;

import java.util.ArrayList;

import com.ism.entities.ArticleConfection;

import com.ism.entities.Categorie;
import com.ism.repositories.ITables;

public class ArticleConfectionServiceImpl implements ArticleConfectionService {
    private ITables<ArticleConfection> articles;
    public ArticleConfectionServiceImpl(ITables<ArticleConfection> articles) {
        this.articles = articles;
    }
    public void setArticleRepository(ITables<ArticleConfection> articleRepository) {
        this.articles = articleRepository;
    }

    @Override
    public void add(ArticleConfection data) {
        articles.insert(data);

    }

    @Override
    public ArrayList<ArticleConfection> getAll() {
        return articles.findAll();
    }

    @Override
    public int update(ArticleConfection data) {
        return articles.update(data);
    }

    @Override
    public ArticleConfection show(int id) {
        return articles.findById(id);
    }

    @Override
    public int remove(int id) {
        return articles.delete(id);
    }

    @Override
    public int[] remove(int[] ids) {
        return new int[0];
    }

}
