<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
<head>
    <title>
        FIND GROUP
    </title>
</head>
<body>
<h2>
    FIND GROUP
</h2>
<form action="${pageContext.request.contextPath}/groupFind" method="post">
    <input name="criteria" placeholder="CRITERIA">
    <button type="submit"> FIND </button>
</form>
<br>
<div style="float: left; margin-right: 50px;" >
    <H5> GROUPS</H5>
    <table >
        <thead>
        <tr>
            <th> ID</th>
            <th> TITLE</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="group" items="${groups}">
            <tr>
                <td><c:out value="${group.id}"/></td>
                <td><c:out value="${group.title}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <br>
    <a href="/home"><button>HOME PAGE</button></a>
</div>
</body>
</HTML>