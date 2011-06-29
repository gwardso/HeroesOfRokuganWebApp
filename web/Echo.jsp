<%--
  Created by IntelliJ IDEA.
  User: wardso
  Date: 3/29/11
  Time: 7:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="stripes"
       uri="http://stripes.sourceforge.net/stripes.tld" %>
<stripes:layout-render name="/layout/master.jsp">
    <stripes:layout-component name="html_head">
        <title>Hello World</title>
    </stripes:layout-component>
    <stripes:layout-component name="contents">
        <stripes:errors/>
        <span>Hello, ${actionBean.person.firstName} ${actionBean.person.lastName}.</span><br/>
        <span>This web application is currently under development.</span><br/>

        <stripes:link beanclass="com.wardso.HeroesOfRokugan.action.HomeAction">
          Say Hello Again
        </stripes:link>
    </stripes:layout-component>
</stripes:layout-render>