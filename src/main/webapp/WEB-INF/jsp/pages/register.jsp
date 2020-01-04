<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ua">

   <jsp:include page="../fragments/headSmall.jsp" />

   <body>
        <div id="small">
            <jsp:include page="../fragments/header.jsp" />

            <div id = "center_form">
                <h2>Register</h2>
                <form action="register" method="post">
                    <p>Name</p>
                    <input type="text" name="name"><br>
                    <p>Surname</p>
                    <input type="text" name="surname"><br>
                    <p>Email</p>
                    <input type="email" name="email"><br>
                    <p>Login</p>
                    <input type="text" name="login"><br>
                    <p>Password</p>
                    <input type="password" name="password"><br>
                    <input id="button" type="submit" value="Register">
                </form>
            </div>
            <jsp:include page="../fragments/footer.jsp" />
        </div>
   </body>
</html>