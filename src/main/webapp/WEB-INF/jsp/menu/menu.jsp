<div id="sidebar">

    <p>User ${name}</p>
    <p><a href="user">User</a></p>
    <c:choose>
        <c:when test="${menu == '1'}">
            <p><a href="logout">logout</a></p>
        </c:when>
        <c:otherwise>
            <p><a href="login">Login</a></p>
            <p><a href="register">Register</a></p>
        </c:otherwise>
    </c:choose>


</div>