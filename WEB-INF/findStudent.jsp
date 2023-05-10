<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
<head>
    <title>
        FIND STUDENT
    </title>
</head>
<body>
    <h2>
         FIND STUDENT
    </h2>
    <form action="${pageContext.request.contextPath}/studentFind" method="post">
        <input name="criteria" placeholder="CRITERIA">
        <button type="submit"> FIND </button>
    </form>
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
        <br>
        <br>
        <a href="/home"><button>HOME PAGE</button></a>
    </div>
</body>
</HTML>