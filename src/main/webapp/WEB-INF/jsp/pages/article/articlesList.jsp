<div>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ page import = "com.kovaliv.blog.hibernate.models.Article" %>
    <c:forEach items="${list}" var="article">
        <div id="article">
            <h3>${article.name}</h3>
            <p><a href="/user/${article.author}">@${article.author}</a></p>
            <p id="text">${article.text}</p>
            <p id="date">${article.date}<p>
            <c:if test="${article.author eq login}">
                <p><a href = "/editArticle/${article.id}" id="small_button">Edit</a><a href="/deleteArticle/${article.id}" id="small_button">Delete</a></p>
            </c:if>
        </div>
    </c:forEach>
</div>