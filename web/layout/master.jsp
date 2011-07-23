<%--
  Created by IntelliJ IDEA.
  User: wardso
  Date: 5/18/11
  Time: 9:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/taglibs.jsp" %>

<stripes:layout-definition>
<html>
    <head>
        <stripes:layout-component name="html_head"/>
        <LINK REL=StyleSheet HREF="${pageContext.request.contextPath}/layout/HoR.css" TYPE="text/css" />
    </head>
    <body class="main">
        <div class="mainDiv"><div class="mainDiv2">

            <stripes:layout-component name="header">
                <jsp:include page="/layout/header.jsp"/>
            </stripes:layout-component>

			<div class="median">
				<div class="pageContent">
                <stripes:layout-component name="contents"/>
                </div>
            </div>

            <stripes:layout-component name="footer">
                <jsp:include page="/layout/footer.jsp"/>
            </stripes:layout-component>
        </div></div>
    </body>
</html>
</stripes:layout-definition>