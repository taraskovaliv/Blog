<%@ page import = "com.kovaliv.blog.hibernate.models.Article" %>

<!DOCTYPE html>
<html lang="ua">

   <jsp:include page="../../fragments/headSmall.jsp" />

   <body>
        <div id="small">
            <jsp:include page="../../fragments/header.jsp" />

            <div id = "center_form">
                <h2>Edit Article</h2>
                <p id = "message">${message}</p>
                <form action="/editArticle" method="post">
                    <p>Input name of article</p>
                        <input type="text" name="name" value="${article.name}"><br>
                    <p>Input text of article</p>
                        <textarea name="text" rows="15" cols="80">${article.text}</textarea>
                    <p id="invisible"><input type="number" name="id" id="invisible" value="${article.id}"></p>

                    <input id="button" type="submit" value="Edit article">
                </form>
            </div>

            <jsp:include page="../../fragments/footer.jsp" />
        </div>
   </body>
</html>