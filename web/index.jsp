<%--
  Created by IntelliJ IDEA.
  User: wardso
  Date: 3/29/11
  Time: 7:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld" %>
<stripes:layout-render name="/layout/master.jsp">
    <stripes:layout-component name="html_head">
        <title>Hello World</title>
    </stripes:layout-component>

    <stripes:layout-component name="contents">
        <stripes:errors/>
        <stripes:form
            beanclass="com.wardso.HeroesOfRokugan.action.HomeAction">
        Please enter your name: <br>
        First name: <stripes:text name="person.firstName"/><br>
        Last name:<stripes:text name="person.lastName"/><br>
        <stripes:submit name="hello" value="Say Hello"/>
        </stripes:form>
    </stripes:layout-component>
</stripes:layout-render>