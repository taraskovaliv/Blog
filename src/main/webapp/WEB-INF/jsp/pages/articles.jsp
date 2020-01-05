<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ua">

   <jsp:include page="../fragments/head.jsp" />

   <body>
        <jsp:include page="../fragments/header.jsp" />

        <div id="content">
            <h2>Articles of ${name} ${surname}</h2>

        </div>
        <jsp:include page="../menu/menu.jsp" />
        <jsp:include page="../fragments/footer.jsp" />
   </body>
</html>