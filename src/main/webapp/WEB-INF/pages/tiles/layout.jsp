<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>News Management</title>
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</body>
</html>