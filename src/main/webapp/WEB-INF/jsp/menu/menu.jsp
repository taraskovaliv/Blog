<div id="sidebar">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:choose>
            <c:when test="${name ne null}">
                <jsp:include page="menu1.jsp" />
            </c:when>
            <c:otherwise>
                <jsp:include page="menu2.jsp" />
            </c:otherwise>
        </c:choose>
</div>