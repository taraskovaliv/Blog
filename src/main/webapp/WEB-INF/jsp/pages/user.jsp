<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ua">

   <jsp:include page="../fragments/head.jsp" />

   <body>
        <jsp:include page="../fragments/header.jsp" />
        <div id="content">
            <h2>Profile ${login}</h2>

                <p id = "message">${message}</p><br>

                <p>Your id = ${id}</p>
                <p>You are ${name}</p>
                <p>You are ${surname}</p>
                <p>Your email ${email}</p>
            <form  action="/editProfile" method="get">
                <button type="submit" value="Edit Profile">Edit Profile</button>
            </form>
        </div>
        <jsp:include page="../menu/menu.jsp" />
        <jsp:include page="../fragments/footer.jsp" />
   </body>
</html>