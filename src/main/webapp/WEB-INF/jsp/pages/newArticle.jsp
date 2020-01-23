<!DOCTYPE html>
<html lang="ua">

   <jsp:include page="../fragments/headSmall.jsp" />

   <body>
        <div id="small">
            <jsp:include page="../fragments/header.jsp" />

            <div id = "center_form">
                <h2>Add new Article</h2>
                <p id = "message">${message}</p>
                <form action="/addArticle" method="post">
                    <p>Input name of article</p>
                        <input type="text" name="name"><br>
                    <p>Input text of article</p>
                        <textarea name="text" rows="15" cols="80"></textarea>
                    <input id="button" type="submit" value="Add article">
                </form>
            </div>

            <jsp:include page="../fragments/footer.jsp" />
        </div>
   </body>
</html>