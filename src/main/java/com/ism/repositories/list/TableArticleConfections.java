package com.ism.repositories.list;

import com.ism.entities.ArticleConfection;
import com.ism.services.IService;

import java.util.ArrayList;

public class TableArticleConfections extends AbstractTables<ArticleConfection> implements IService<ArticleConfection> {

    @Override
    public void add(ArticleConfection data) {

    }

    @Override
    public ArrayList<ArticleConfection> getAll() {
        return null;
    }

    @Override
    public ArticleConfection show(int id) {
        return null;
    }

    @Override
    public int remove(int id) {
        return 0;
    }

    @Override
    public int[] remove(int[] ids) {
        return new int[0];
    }
}
