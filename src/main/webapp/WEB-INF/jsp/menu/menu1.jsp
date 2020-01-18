<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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