<div id="sidebar">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%!
        Principal user = request.getUserPrincipal();
    %>
    <sec:authorize access="isAuthenticated()">
        <jsp:include page="menu1.jsp" />
    </sec:authorize>
    <sec:authorize access="!isAuthenticated()">
        <jsp:include page="menu2.jsp" />
    </sec:authorize>
</div>