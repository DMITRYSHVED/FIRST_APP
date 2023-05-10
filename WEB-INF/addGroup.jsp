<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
<head>
    <title>ADD GROUP</title>
    <link rel="stylesheet" href="../styles.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
            crossorigin="anonymous"></script>
</head>
<body>
<h2>ADD GROUP</h2>

<form action="${pageContext.request.contextPath}/groupAdd" method="post">
    <input name="title" placeholder="GROUP-TITLE">
    <button type="submit"> ADD </button>
    <span style="color: red" class="error">${error}</span>
</form>
<br>
<br>

<div style="float: left; margin-right: 50px;">
    <h5> STUDENTS</h5>
    <table>
        <thead>
        <tr>
            <th> ID</th>
            <th> NAME</th>
            <th> SURNAME</th>
            <th> AGE</th>
            <th> CITY</th>
            <th> GROUP</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="student" items="${students}">
            <tr>
                <td><c:out value="${student.id}"/></td>
                <td><c:out value="${student.name}"/></td>
                <td><c:out value="${student.surname}"/></td>
                <td><c:out value="${student.age}"/></td>
                <td><c:out value="${student.city.name}"/></td>
                <td><c:out value="${student.grooup.title}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%--<h2>GROUPS LIST </h2>--%>
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
        <c:forEach var="grooup" items="${grooups}">
            <tr>
                <td><c:out value="${grooup.id}"/></td>
                <td><c:out value="${grooup.title}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%--<h2>CITIES LIST </h2>--%>
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
</div>
</body>
</HTML>