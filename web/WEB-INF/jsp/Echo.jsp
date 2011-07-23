<%--
  Created by IntelliJ IDEA.
  User: wardso
  Date: 3/29/11
  Time: 7:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/taglibs.jsp"%>
<stripes:layout-render name="/layout/master.jsp">
    <stripes:layout-component name="html_head">
        <title>Hello World</title>
    </stripes:layout-component>
    <stripes:layout-component name="contents">
        <stripes:errors/>
        <span>Hello, ${user.person.firstName} ${user.person.lastName}.</span><br/>
        <span>Thank you for registering.  This web application is currently under development.</span><br/>
    </stripes:layout-component>
</stripes:layout-render>