<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="ua">

   <jsp:include page="../../fragments/head.jsp" />

   <body>
        <jsp:include page="../../fragments/header.jsp" />

        <div id="content">
            <h2>Articles of ${name} ${surname}</h2>
            <jsp:include page="articlesList.jsp" />
        </div>
        <jsp:include page="../../menu/menu.jsp" />
        <jsp:include page="../../fragments/footer.jsp" />
   </body>
</html>