<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html>
<head>
</head>
<body>
<h1>
</h1>
<bean:write name="NewsListForm" property="newsList">
    <logic:iterate name="newsList" id="newsListId">
        <h2><bean:write name="newsListId" property="title"/></h2>
    </logic:iterate>
</bean:write>
</body>
</html>
