<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ua">

   <jsp:include page="../fragments/headSmall.jsp" />

    <%@ page import = "com.kovaliv.blog.controllers.LoginController" %>
    <%@ page import = "com.kovaliv.blog.hibernate.models.User" %>
    <%!
       User user = LoginController.getUser();
       String name = user.getName();
       String surname = user.getSurname();
       String login = user.getLogin();
       String password = user.getPassword();
       String email = user.getEmail();
    %>

   <body>
        <div id="small">
            <jsp:include page="../fragments/header.jsp" />

            <div id = "center_form">

                <h2>Edit your profile</h2>

                <form action="editProfile" method="post">
                    <p>Name</p>
                        <input type="text" name="name" value = ${name}><br>
                    <p>Surname</p>
                        <input type="text" name="surname" value = ${surname}><br>
                    <p>Email</p>
                        <input type="email" name="email" value = ${email}><br>
                    <p>Password</p>
                        <input type="password" name="password" value = ${password}><br>
                        <input id="button" type="submit" value="Edit">
                </form>
            </div>

            <jsp:include page="../fragments/footer.jsp" />
        </div>
   </body>
</html>