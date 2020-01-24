<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import = "com.kovaliv.blog.hibernate.models.User" %>

<!DOCTYPE html>
<html lang="ua">

   <jsp:include page="../../fragments/head.jsp" />

   <body>
        <jsp:include page="../../fragments/header.jsp" />
        <div id="content">
            <div id="profile">
                <h2>Profile ${user.login}</h2>

                <p>${user.name}   ${user.surname}</p>
                <p>Email:  ${user.email}</p>
                <p>Profile views:  ${user.views}</p>
            </div>
            <jsp:include page="../article/articlesList.jsp" />
        </div>
        <jsp:include page="../../menu/menu.jsp" />
        <jsp:include page="../../fragments/footer.jsp" />
   </body>
</html>