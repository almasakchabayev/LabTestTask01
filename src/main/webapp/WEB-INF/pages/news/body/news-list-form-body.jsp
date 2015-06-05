<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html:form action="newsList" onsubmit="return confirm('Are you sure?');">

    <nested:iterate property="newsList">
        <div class="col-sm-10">
            <h4>
                <nested:write property="title" />: <nested:write property="brief"/>
            </h4>
            <p>
                <nested:write property="content" />
            </p>
        </div>
        <div class="col-sm-2 text-right">
        <span id="date">
            <nested:write property="date" />
        </span>
        </div>
        <div class="col-sm-12">
            <div class="text-right">
                <nested:link action="/newsView" paramId="id" paramProperty="id">
                    <bean:message key="body.news.list.view" />
                </nested:link>
                <nested:link action="/newsEdit" paramId="id" paramProperty="id">
                    <bean:message key="body.news.list.edit" />
                </nested:link>
                <html:multibox property="newsIdsToDelete">
                    <nested:write property="id"/>
                </html:multibox>
            </div>
        </div>
        <div class="clearfix"></div>
        <br/>

    </nested:iterate>

    <div class="col-sm-12 text-right">
        <html:submit>
            <bean:message key="body.news.list.delete" />
        </html:submit>
    </div>

</html:form>
