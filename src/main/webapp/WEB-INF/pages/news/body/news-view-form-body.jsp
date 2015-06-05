<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>

<html:form action="/newsView" onsubmit="return confirm('Are you sure?');">
    <div class="news-part">
        <div class="col-sm-2">
            <bean:message key="body.news.view.title" />
        </div>
        <div class="col-sm-10">
            <bean:write name="newsForm" property="news.title" />
        </div>
    </div>
    <div class="clearfix"></div>
    <br/>

    <div class="news-part">
        <div class="col-sm-2">
            <bean:message key="body.news.view.date" />
        </div>
        <div class="col-sm-10">
            <bean:write name="newsForm" property="news.date" />
        </div>
    </div>
    <div class="clearfix"></div>
    <br/>

    <div class="news-part">
        <div class="col-sm-2">
            <bean:message key="body.news.view.brief" />
        </div>
        <div class="col-sm-10">
            <bean:write name="newsForm" property="news.brief" />
        </div>
    </div>
    <div class="clearfix"></div>
    <br/>

    <div class="news-part">
        <div class="col-sm-2">
            <bean:message key="body.news.view.content" />
        </div>
        <div class="col-sm-10">
            <bean:write name="newsForm" property="news.content" />
        </div>
    </div>
    <div class="clearfix"></div>
    <br/>
    <html:text property="id" style="visibility: hidden" />

    <div class="col-sm-12 text-right">
        <nested:link action="/newsEdit" paramId="id" paramProperty="id">
            <bean:message key="body.news.list.edit" />
        </nested:link>
        <html:submit>
            <bean:message key="body.news.list.delete" />
        </html:submit>
    </div>
</html:form>
