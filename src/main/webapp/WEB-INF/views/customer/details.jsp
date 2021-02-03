<%@ include file="/WEB-INF/views/common/header.jsp"%>
<jsp:include page="/WEB-INF/views/common/navbar.jsp"/>
<h2 class="test">Customer Details</h2>
<table class="table">
    <tbody>
    <tr>
        <td><strong>Name</strong></td>
        <td>${customer.name}</td>
    </tr>
    <tr>
        <td><strong>Email</strong></td>
        <td>${customer.email}</td>
    </tr>
    <tr>
        <td><strong>Phone</strong></td>
        <td>${customer.phone}</td>
    </tr>
    <tr>
        <td><strong>address</strong></td>
        <td>${customer.address.getFullAddress()}</td>
    </tr>
    </tbody>
</table>
<a href="${pageContext.request.contextPath}/customer/edit?id=${customer.id}">Edit</a>
</body>
</html>
