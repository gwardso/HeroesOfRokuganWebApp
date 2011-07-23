<%@ include file="/taglibs.jsp" %>

<stripes:layout-render name="/layout/master.jsp">
    <stripes:layout-component name="html_head">
        <title>Heroes of Rokugan III</title>
    </stripes:layout-component>

    <stripes:layout-component name="contents">
		<p>
		<c:if test="${not empty user}">
			Welcome: ${user.person.firstName} ${user.person.lastName}; ${user.googleUser.email }
		</c:if>
        <stripes:errors/>
        <span>This web application is currently under development.</span><br/>
    </stripes:layout-component>
</stripes:layout-render>