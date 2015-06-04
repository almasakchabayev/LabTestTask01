<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<html:form action="/delete-news">

<logic:iterate name="newsList" id="news">
    <div class="col-sm-10">
        <h4>
            <bean:write name="news" property="title" /> <bean:write name="news" property="brief"/>
        </h4>
        <p>
            <bean:write name="news" property="content" />
        </p>
    </div>
    <div class="col-sm-2 text-right">
    <span id="date">
        <bean:write name="news" property="date" />
    </span>
    </div>
    <div class="col-sm-12">
        <div class="text-right">
            <a href="#">view</a>
            <a href="#">edit</a>
            <html:checkbox property=""
        </div>
    </div>

</logic:iterate>


