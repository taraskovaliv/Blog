<div id="sidebar">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:choose>
        <c:when test="${login ne null}">
            <jsp:include page="menuAuthorized.jsp" />
        </c:when>
        <c:otherwise>
            <jsp:include page="menuNotAuthorized.jsp" />
        </c:otherwise>
    </c:choose>
</div>