package com.epam.aa.labtesttask01.action;

import com.epam.aa.labtesttask01.dao.DaoFactory;
import com.epam.aa.labtesttask01.dao.NewsDao;
import com.epam.aa.labtesttask01.form.NewsForm;
import com.epam.aa.labtesttask01.model.News;
import org.apache.struts.action.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class NewsViewAction extends Action {
    private static final Logger LOGGER = LoggerFactory.getLogger(NewsViewAction.class);

    DaoFactory daoFactory;

    public NewsViewAction() {
        this.daoFactory = DaoFactory.getInstance("jdbc");
    }

    @Override
    public ActionForward execute(ActionMapping mapping,ActionForm form,
                                 HttpServletRequest request,HttpServletResponse response) throws Exception {

        String method = request.getMethod();
        if (method.equals("GET")) {
            return processGetMethod(mapping, (NewsForm) form);
        } else if (method.equals("POST")) {
            return processPostMethod(mapping, (NewsForm) form);
        } else {
            throw new ActionException("Methods other then GET and POST are not supported");
        }

    }

    private ActionForward processGetMethod(ActionMapping mapping, NewsForm form) {
        Integer id = form.getId();
        NewsDao newsDao = daoFactory.getNewsDao();
        try {
            News news = newsDao.findById(id);
            form.setNews(news);
            return mapping.findForward("success");
        } catch (SQLException e) {
            throw new ActionException("Could not retrieve news by id {}" + id, e);
        }
    }

    private ActionForward processPostMethod(ActionMapping mapping, NewsForm form) throws SQLException {
        Integer id = form.getId();
        try {
            NewsDao newsDao = daoFactory.getNewsDao();
            newsDao.delete(id);
            ActionRedirect redirect = new ActionRedirect(mapping.findForward("redirect"));
            return redirect;
        } catch (SQLException e) {
            throw new ActionException("Could not delete news given id {}" + id, e);
        }
    }
}
