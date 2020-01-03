<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ua">

   <jsp:include page="../fragments/headSmall.jsp" />

   <body >
        <jsp:include page="../fragments/header.jsp" />

        <div>
            <h2>LOGIN</h2>
            <form action="login" method="post">
                <input type="text" name="login"><br>
                <input type="password" name="password"><br>
                <input type="submit" value="Login">
            </form>
        </div>
        <jsp:include page="../fragments/footer.jsp" />
   </body>
</html>