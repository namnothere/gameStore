<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <h1>jsp_example.jsp</h1>
    <!-- loop through games object and print out name -->
    <c:forEach var="game" items="${games}">
        <p>Game ID: ${game.getID()}</p>
        <p>Game Name: ${game.getName()}</p>
    </c:forEach>
    <p>
        <c:out value="${query.value}" />
    </p>

</body>
</html>
