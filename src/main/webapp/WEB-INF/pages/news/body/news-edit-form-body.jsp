<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>

<html:form action="/newsEdit">
    <div class="news-part">
        <div class="col-sm-2">
            <bean:message key="body.news.view.title" />
        </div>
        <div class="col-sm-10">
            <html:text property="news.title" style="width: 100%" />
        </div>
    </div>
    <div class="clearfix"></div>
    <br/>

    <div class="news-part">
        <div class="col-sm-2">
            <bean:message key="body.news.view.date" />
        </div>
        <div class="col-sm-10">
            <html:text property="news.date" style="width: 100%" />
        </div>
    </div>
    <div class="clearfix"></div>
    <br/>

    <div class="news-part">
        <div class="col-sm-2">
            <bean:message key="body.news.view.brief" />
        </div>
        <div class="col-sm-10">
            <html:textarea property="news.brief" style="width: 100%; height: 100px" />
        </div>
    </div>
    <div class="clearfix"></div>
    <br/>

    <div class="news-part">
        <div class="col-sm-2">
            <bean:message key="body.news.view.content" />
        </div>
        <div class="col-sm-10">
            <html:textarea property="news.content" style="width: 100%; height: 100px" />
        </div>
    </div>
    <div class="clearfix"></div>
    <br/>
    <html:text property="id" style="visibility: hidden" />

    <div class="col-sm-12 text-center">
        <html:submit>
            <bean:message key="body.news.edit.save" />
        </html:submit>
        <nested:link action="/newsView" paramId="id" paramProperty="id">
            <bean:message key="body.news.edit.cancel" />
        </nested:link>
    </div>
</html:form>
