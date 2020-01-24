<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.kovaliv.blog.hibernate.models.User" %>

<br>
    <p>Hello ${name} (<a href="/logout">logout</a>)</p>
    <p id="menu_button"><a href = "/myProfile" >My profile</a></p>
    <p id="menu_button"><a href = "/myArticles" >My articles</a></p>
    <p id="menu_button"><a href = "/addArticle" >Add new article</a></p>
<br>