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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewsEditAction extends Action {
    private static final Logger LOGGER = LoggerFactory.getLogger(NewsEditAction.class);

    DaoFactory daoFactory;

    public NewsEditAction() {
        this.daoFactory = DaoFactory.getInstance("jdbc");
    }

    @Override
    public ActionForward execute(ActionMapping mapping,ActionForm form,
                                 HttpServletRequest request,HttpServletResponse response) throws Exception {

        String method = request.getMethod();
        if (method.equals("GET")) {
            return processGetMethod(mapping, (NewsForm) form);
        } else if (method.equals("POST")) {
            return processPostMethod(mapping, (NewsForm) form, request);
        } else {
            throw new ActionException("Methods other then GET and POST are not supported");
        }

    }

    private ActionForward processGetMethod(ActionMapping mapping, NewsForm form) {
        Integer id = form.getId();
        if (id == null) {
            News news = new News();
            form.setNews(news);
            return mapping.findForward("success");
        }
        NewsDao newsDao = daoFactory.getNewsDao();
        try {
            News news = newsDao.findById(id);
            form.setNews(news);
            return mapping.findForward("success");
        } catch (SQLException e) {
            throw new ActionException("Could not retrieve news by id {}" + id, e);
        }
    }

    private ActionForward processPostMethod(ActionMapping mapping, NewsForm form, HttpServletRequest request) throws SQLException {
        News news = parseNewsFromRequest(form, request);
        try {
            NewsDao newsDao = daoFactory.getNewsDao();
            if (news.getId() == null) {
                Integer id = newsDao.insert(news);
                news.setId(id);
            } else {
                newsDao.update(news);
            }
            ActionRedirect redirect = new ActionRedirect(mapping.findForward("redirect"));
            redirect.addParameter("id", news.getId());
            return redirect;
        } catch (SQLException e) {
            throw new ActionException("Could not update news {}" + news, e);
        }
    }

    private News parseNewsFromRequest(NewsForm form, HttpServletRequest request) {
        String title = request.getParameter("news.title");
        String dateString = request.getParameter("news.date");
        String brief = request.getParameter("news.brief");
        String content = request.getParameter("news.content");
        DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        Date date;
        try {
            date = format.parse(dateString);
        } catch (ParseException e) {
            // todo add to errors which will shown to user
            throw new ActionException(e);
        }
        Integer id = form.getId();

        News news = new News();
        if (!id.equals(0)) {
            news.setId(id);
        }
        news.setTitle(title);
        news.setDate(date);
        news.setBrief(brief);
        news.setContent(content);
        return news;
    }
}
