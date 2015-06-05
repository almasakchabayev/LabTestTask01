<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insert definition="news-template" >
	<tiles:put name="body" value="/WEB-INF/pages/news/body/news-edit-form-body.jsp" />
</tiles:insert>