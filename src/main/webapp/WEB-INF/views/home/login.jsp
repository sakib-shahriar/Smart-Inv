<html>
<head>
    <title>Log in</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/authenticate" method="post">
    <div>
        <input type="email" name="email" required>
    </div>
    <div>
        <input type="password" name="password" required>
    </div>
    <div>
        <input type="submit" value="Log in">
    </div>
    <div>
        ${message}
    </div>
</form>
</body>
</html>
