<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.kovaliv.blog.hibernate.models.User" %>

<br>
    <p>Hello ${name}</p>
<br>
    <p><a href = "/user" >Profile</a></p>
    <p><a href = "/myArticles" >My Articles</a></p>
    <p><a href = "/addArticle" >Add new article</a></p>
<br>
    <p><a href="/logout">logout</a></p>
<br>