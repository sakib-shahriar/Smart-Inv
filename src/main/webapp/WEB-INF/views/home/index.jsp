<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <link href='<spring:url value="css/style.css"/>' rel="stylesheet" />
    <title>SMARTINV</title>
</head>
<body>
<h2>Welcome To Smart Inventory</h2>
<a href="${pageContext.request.contextPath}/logout">Log out</a>
</body>
</html>
