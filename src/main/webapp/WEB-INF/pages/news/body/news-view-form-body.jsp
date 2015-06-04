<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>

<html:form action="/newsView">
    <div class="news-part">
        <div class="col-sm-2">
            News Title
        </div>
        <div class="col-sm-10">
            <bean:write name="newsViewForm" property="news.title" />
        </div>
    </div>
    <div class="clearfix"></div>
    <br/>

    <div class="news-part">
        <div class="col-sm-2">
            News Date
        </div>
        <div class="col-sm-10">
            <bean:write name="newsViewForm" property="news.date" />
        </div>
    </div>
    <div class="clearfix"></div>
    <br/>

    <div class="news-part">
        <div class="col-sm-2">
            News Brief
        </div>
        <div class="col-sm-10">
            <bean:write name="newsViewForm" property="news.brief" />
        </div>
    </div>
    <div class="clearfix"></div>
    <br/>

    <div class="news-part">
        <div class="col-sm-2">
            News Content
        </div>
        <div class="col-sm-10">
            <bean:write name="newsViewForm" property="news.content" />
        </div>
    </div>
    <div class="clearfix"></div>
</html:form>
