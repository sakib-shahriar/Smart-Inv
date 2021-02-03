<%@ include file="/WEB-INF/views/common/header.jsp"%>
<jsp:include page="/WEB-INF/views/common/navbar.jsp"/>
<h1>Create Customer</h1>
<c:if test="${fields != null}">
    <h3>
        illegal value for
        <c:forEach items="${fields}" var="item">
            ${item.concat(" ")}
        </c:forEach>
    </h3>
</c:if>
<form:form method="POST" action="${pageContext.request.contextPath}/customer/save" modelAttribute="customer">
    <form:hidden path="id" ></form:hidden>
    <table>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="email">Email</form:label></td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td><form:label path="phone">
                Contact Number</form:label></td>
            <td><form:input path="phone"/></td>
        </tr>
        <tr>
            <td><form:label path="city">
                City</form:label></td>
            <td><form:input path="city"/></td>
        </tr>
        <tr>
            <td><form:label path="country">
                Country</form:label></td>
            <td><form:select path="country" items="${selectItems}"/></td>
        </tr>
        <tr>
            <td><form:label path="details">
                Details</form:label></td>
            <td><form:input path="details"/></td>
        </tr>
        <tr>
            <td><form:label path="postCode">
                Post Code</form:label></td>
            <td><form:input path="postCode"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
