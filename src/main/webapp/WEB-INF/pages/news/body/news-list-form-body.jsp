<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>

<html:form action="newsList">

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
                    <a href="#">view</a>
                    <a href="#">edit</a>
                    <html:multibox property="newsIdsToDelete">
                        <nested:write property="id"/>
                    </html:multibox>
                </div>
            </div>

    </nested:iterate>

    <div class="col-sm-12 text-right">
        <html:submit value="Delete" />
    </div>

</html:form>
