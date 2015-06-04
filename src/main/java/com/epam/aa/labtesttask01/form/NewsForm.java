package com.epam.aa.labtesttask01.form;

import com.epam.aa.labtesttask01.model.News;
import org.apache.struts.action.ActionForm;

public class NewsForm extends ActionForm {
    private News news;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}
