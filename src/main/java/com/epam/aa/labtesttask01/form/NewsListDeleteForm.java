package com.epam.aa.labtesttask01.form;

import com.epam.aa.labtesttask01.model.News;
import org.apache.struts.action.ActionForm;

import java.util.List;

public class NewsListDeleteForm extends ActionForm {
    List<News> newsList;

    public News getNews(int index) {
        return newsList.get(index);
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }
}
