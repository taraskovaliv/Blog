<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import="com.kovaliv.blog.controllers.LoginController" %>
    <%@ page import="com.kovaliv.blog.hibernate.models.User" %>
    <%!
        User user = LoginController.getUser();
        String name = user.toString();
    %>
<c:if test="not empty ${name}">
    <br>
        <p>${name}</p>
</c:if>
<br>
    <p><a href = "user" >Profile</a></p>
    <p><a href = "myArticles" >My Articles</a></p>
    <p><a href = "addArticle" >Add new article</a></p>
<br>
    <p><a href="logout">logout</a></p>
<br>