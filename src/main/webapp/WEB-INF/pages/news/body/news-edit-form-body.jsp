<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>

<html:form action="/newsEdit">
    <div class="news-part">
        <div class="col-sm-2">
            News Title
        </div>
        <div class="col-sm-10">
            <html:text property="news.title" style="width: 100%" />
        </div>
    </div>
    <div class="clearfix"></div>
    <br/>

    <div class="news-part">
        <div class="col-sm-2">
            News Date
        </div>
        <div class="col-sm-10">
            <html:text property="news.date" style="width: 100%" />
        </div>
    </div>
    <div class="clearfix"></div>
    <br/>

    <div class="news-part">
        <div class="col-sm-2">
            News Brief
        </div>
        <div class="col-sm-10">
            <html:textarea property="news.brief" style="width: 100%; height: 100px" />
        </div>
    </div>
    <div class="clearfix"></div>
    <br/>

    <div class="news-part">
        <div class="col-sm-2">
            News Content
        </div>
        <div class="col-sm-10">
            <html:textarea property="news.content" style="width: 100%; height: 100px" />
        </div>
    </div>
    <div class="clearfix"></div>
    <br/>
    <html:text property="id" style="visibility: hidden" />

    <div class="col-sm-12 text-center">
        <html:submit value="Save" />
        <nested:link action="/newsView" paramId="id" paramProperty="id">
            Cancel
        </nested:link>
    </div>
</html:form>
