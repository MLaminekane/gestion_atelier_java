package com.ism.services;

import java.util.ArrayList;

import com.ism.entities.ArticleConfection;

public class ArticleConfectionServiceImpl implements ArticleConfectionService {
    private IService<ArticleConfection> articleRepo;
    public ArticleConfectionServiceImpl(IService<ArticleConfection> articleRepo) {
        this.articleRepo = articleRepo;
    }
    public void setArticleRepo(IService<ArticleConfection> articleRepo){
        this.articleRepo = articleRepo;
    }
    @Override
    public void add(ArticleConfection confection, String libelle, Double prix, Double qte) {
        articleRepo.add(confection);

    }

    @Override
    public void add(ArticleConfection data) {

    }

    @Override
    public ArrayList<ArticleConfection> getAll() {
        return articleRepo.getAll();

    }

    @Override
    public int update(ArticleConfection data) {
        return 0;
    }

    @Override
    public int update(ArticleConfection data, String libelle, Double prix, Double qte) {
        return articleRepo.update(data);

    }

    @Override
    public ArticleConfection show(int id) {
        return articleRepo.getAll().get(id);
    }

    @Override
    public int remove(int id) {
        return articleRepo.remove(id);
    }

    @Override
    public int[] remove(int[] ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }
    
}
