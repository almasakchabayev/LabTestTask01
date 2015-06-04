<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insert definition="news-template" >
	<tiles:put name="body" value="/WEB-INF/pages/news/body/news-view-form-body.jsp" />
</tiles:insert>