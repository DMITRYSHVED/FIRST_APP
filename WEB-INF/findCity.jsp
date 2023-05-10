<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
<head>
    <title>
        FIND CITY
    </title>
</head>
<body>
<h2>
    FIND CITY
</h2>
<form action="${pageContext.request.contextPath}/cityFind" method="post">
    <input name="criteria" placeholder="CRITERIA">
    <button type="submit"> FIND </button>
</form>
<br>
<div style="float: left; margin-right: 50px;" >
    <H5> CITIES</H5>
    <table >
        <thead>
        <tr>
            <th> ID</th>
            <th> NAME</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="city" items="${cities}">
            <tr>
                <td><c:out value="${city.id}"/></td>
                <td><c:out value="${city.name}"/></td>
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