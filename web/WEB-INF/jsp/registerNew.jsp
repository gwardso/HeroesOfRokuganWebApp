<%@ include file="/taglibs.jsp" %>

<stripes:layout-render name="/layout/master.jsp">
    <stripes:layout-component name="html_head">
        <title>Heroes of Rokugan III</title>
    </stripes:layout-component>

    <stripes:layout-component name="contents">
		<p>
            First time users need to submit their first and last names.
        </p>
        <stripes:form beanclass="com.wardso.HeroesOfRokugan.action.RegisterAction">
	        First name: <stripes:text name="person.firstName"/><br>
	        Last name:<stripes:text name="person.lastName"/><br>
	        <stripes:submit name="register" value="Submit"/>
        </stripes:form>
    </stripes:layout-component>
</stripes:layout-render>