<div id="sidebar">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import="com.kovaliv.blog.controllers.LoginController" %>
    <%@ page import="com.kovaliv.blog.hibernate.models.User" %>
    <%!
        User user = LoginController.getUser();
    %>
    <c:choose>
        <c:when test="${user ne null}">
            <jsp:include page="menu1.jsp" />
        </c:when>
        <c:otherwise>
            <jsp:include page="menu2.jsp" />
        </c:otherwise>
    </c:choose>
</div>