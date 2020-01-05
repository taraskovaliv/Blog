<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ua">

   <jsp:include page="../fragments/headSmall.jsp" />

   <body>
        <div id="small">
            <jsp:include page="../fragments/header.jsp" />

            <div id = "center_form">

                <h2>LOGIN</h2>

                <p id = "message">${message}</p>
                <br>

                <form action="login" method="post">
                    <p>Username</p>
                        <input type="text" name="login"><br>
                    <p>Password</p>
                        <input type="password" name="password"><br>
                    <input id="button" type="submit" value="Login">
                </form>
            </div>

            <jsp:include page="../fragments/footer.jsp" />
        </div>
   </body>
</html>