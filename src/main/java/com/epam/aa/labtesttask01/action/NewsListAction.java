package com.epam.aa.labtesttask01.action;

import com.epam.aa.labtesttask01.dao.DaoFactory;
import com.epam.aa.labtesttask01.dao.NewsDao;
import com.epam.aa.labtesttask01.form.NewsListForm;
import com.epam.aa.labtesttask01.model.News;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class NewsListAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping,ActionForm form,
                                 HttpServletRequest request,HttpServletResponse response) throws Exception {

        DaoFactory daoFactory = DaoFactory.getInstance("jdbc");
        NewsDao newsDao = daoFactory.getNewsDao();
        List<News> newsList = newsDao.findAll();

        NewsListForm newsListForm = (NewsListForm) form;
        newsListForm.setNewsList(newsList);
        request.setAttribute("newsList", newsList);
        return mapping.findForward("success");
    }
}
