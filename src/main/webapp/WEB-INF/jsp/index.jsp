<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ua">

   <jsp:include page="fragments/head.jsp" />

   <body>
        <jsp:include page="fragments/header.jsp" />

        <div id="content">
            <h2>Kovaliv Taras</h2>
            <p>Some text and some thinks. Some text and some thinks. Some text and some thinks. Some text and some thinks.
            Some text and some thinks. Some text and some thinks. Some text and some thinks. Some text and some thinks.
            Some text and some thinks. Some text and some thinks. Some text and some thinks. Some text and some thinks. </p>
        </div>
        <div id="sidebar">
            <p><a href="#">Menu 1</a></p>
            <p><a href="#">Menu 2</a></p>
        </div>
        <jsp:include page="fragments/footer.jsp" />
   </body>
</html>