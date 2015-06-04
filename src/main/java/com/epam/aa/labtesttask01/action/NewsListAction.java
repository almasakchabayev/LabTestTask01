package com.epam.aa.labtesttask01.action;

import com.epam.aa.labtesttask01.dao.DaoFactory;
import com.epam.aa.labtesttask01.dao.NewsDao;
import com.epam.aa.labtesttask01.form.NewsListForm;
import com.epam.aa.labtesttask01.model.News;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class NewsListAction extends Action {
    private static final Logger LOGGER = LoggerFactory.getLogger(NewsListAction.class);

    DaoFactory daoFactory;

    public NewsListAction() {
        this.daoFactory = DaoFactory.getInstance("jdbc");
    }

    @Override
    public ActionForward execute(ActionMapping mapping,ActionForm form,
                                 HttpServletRequest request,HttpServletResponse response) throws Exception {

        String method = request.getMethod();
        if (method.equals("GET")) {
            return processGetMethod(mapping, (NewsListForm) form);
        } else if (method.equals("POST")) {
            return processPostMethod(mapping, (NewsListForm) form);
        } else {
            // todo add error
            return mapping.findForward("error");
        }
    }

    private ActionForward processGetMethod(ActionMapping mapping, NewsListForm form) {
        NewsDao newsDao = daoFactory.getNewsDao();
        try {
            List<News> newsList = newsDao.findAll();
            form.setNewsList(newsList);
            return mapping.findForward("success");
        } catch (SQLException e) {
            LOGGER.error("Could not retrieve news entities with findAll method", e);
            return mapping.findForward("error");
        }
    }

    private ActionForward processPostMethod(ActionMapping mapping, NewsListForm form) throws SQLException {
        String[] newsIdsToDelete = form.getNewsIdsToDelete();
        Integer[] newsIds = new Integer[newsIdsToDelete.length];
        for (int i = 0; i < newsIds.length; i++) {
            newsIds[i] = Integer.parseInt(newsIdsToDelete[i]);
        }

        try {
            NewsDao newsDao = daoFactory.getNewsDao();
            newsDao.deleteByIds(newsIds);
            return processGetMethod(mapping, form);
        } catch (SQLException e) {
            LOGGER.error("Could not delete news entities given ids {}", newsIds,  e);
            return mapping.findForward("error");
        }
    }
}
