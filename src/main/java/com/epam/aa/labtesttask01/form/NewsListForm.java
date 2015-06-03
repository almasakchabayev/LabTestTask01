package com.epam.aa.labtesttask01.form;

import com.epam.aa.labtesttask01.model.News;
import org.apache.struts.action.ActionForm;

import java.util.ArrayList;
import java.util.List;

public class NewsListForm extends ActionForm {
    List<News> newsList = new ArrayList<>();

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
