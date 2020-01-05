<div id="sidebar">
    <c:choose>
        <c:when test="${not empty menu}">
            <jsp:include page="menu1.jsp" />
        </c:when>
        <c:otherwise>
            <jsp:include page="menu2.jsp" />
        </c:otherwise>
    </c:choose>
</div>