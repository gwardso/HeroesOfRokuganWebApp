<%@ include file="/taglibs.jsp" %>
<div id="Header" class="header">
    <div class="pageIdentity">
        <div class="identityLink"><a href="http://heroes-of-rokugan.appspot.com">Heroes of Rokugan III</a></div>
    </div>
    <div class="userLinks">
        <c:choose>
            <c:when test="${not empty user}">
                <a href="${actionBean.context.logoutURL}">Logout</a>
            </c:when>
            <c:when test="${empty user}">
                <a href="${actionBean.context.loginURL}">Sign In</a>
            </c:when>
        </c:choose>
    </div>
    <div class="navRibbon">
        <div class="navLink navPlain"><span><a href="/">Stuff</a></span></div>
        <div class="navLink navHover"><span><a href="/">More Stuff</a></span></div>
    </div>
</div>