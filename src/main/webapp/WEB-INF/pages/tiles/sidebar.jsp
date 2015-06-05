<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<h4><bean:message key="sidebar.navigation.header" /></h4>
<ul class="nav nav-pills nav-stacked">
    <li>
        <html:link action="/newsList">
            <bean:message key="sidebar.navigation.news.list" />
        </html:link>
    </li>
    <li>
        <html:link action="/newsEdit">
            <bean:message key="sidebar.navigation.news.add" />
        </html:link>
    </li>
</ul>