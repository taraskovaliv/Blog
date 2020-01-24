<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import = "com.kovaliv.blog.hibernate.models.Article" %>
<!DOCTYPE html>
<html lang="ua">

   <jsp:include page="../fragments/head.jsp" />

   <body>
        <jsp:include page="../fragments/header.jsp" />

        <div id="content">
            <h2>Articles of ${name} ${surname}</h2>
            <c:forEach items="${list}" var="article">
                <div id="article">
                    <h4>${article.name}</h4>
                    <p>@${article.author}</p>
                    <p>${article.text}</p>
                </div>
            </c:forEach>
        </div>
        <jsp:include page="../menu/menu.jsp" />
        <jsp:include page="../fragments/footer.jsp" />
   </body>
</html>