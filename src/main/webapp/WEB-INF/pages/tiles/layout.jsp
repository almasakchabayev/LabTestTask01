<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>
        <bean:message key="layout.title" />
    </title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" />
    <link rel="stylesheet" href="<c:url value="/static/css/style.css" />" />
</head>
<body>
    <div class="container">
        <nav class="navbar">
            <div class="container">
                <tiles:insert attribute="header"/>
            </div>
        </nav>
        <hr />

        <div class="row">
            <div class="col-sm-2">
                <tiles:insert attribute="sidebar" />
            </div>
            <div class="col-sm-10" id="body">
                <tiles:insert attribute="body"/>
            </div>
        </div>
        <hr />

        <footer>
            <div class="container">
                <div class="row">
                    <tiles:insert attribute="footer"/>
                </div>
            </div>
        </footer>
    </div>
    <div style="visibility: hidden">
        <span id="delete"><bean:message key="body.news.list.delete" /></span>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script src="/static/js/custom.js"></script>
</body>
</html>