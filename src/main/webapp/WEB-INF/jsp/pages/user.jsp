<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ua">

   <jsp:include page="../fragments/head.jsp" />
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@ page import = "com.kovaliv.blog.controllers.LoginController" %>
   <%@ page import = "com.kovaliv.blog.hibernate.models.User" %>
   <%!
       User user = LoginController.getUser();
       String name = user.toString();
       String login = user.getLogin();
       Integer id = user.getUserId();
       String email = user.getEmail();
   %>
   <body>
        <jsp:include page="../fragments/header.jsp" />
        <div id="content">
            <h2>Profile ${login}</h2>

                <p id = "message">${message}</p><br>

                <p>Your id = ${id}</p>
                <p>You are ${name}</p>
                <p>Your email ${email}</p>
            <form  action="editProfile" method="get">
                <button type="submit" value="Edit Profile">Edit Profile</button>
            </form>
        </div>
        <jsp:include page="../menu/menu.jsp" />
        <jsp:include page="../fragments/footer.jsp" />
   </body>
</html>