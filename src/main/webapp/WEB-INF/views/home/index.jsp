<%@ include file="/WEB-INF/views/common/header.jsp"%>
<jsp:include page="/WEB-INF/views/common/navbar.jsp"/>
<h2 class="text-center mb-2 mt-2">Welcome To Smart Inventory</h2>
<div>
    <a href="${pageContext.request.contextPath}/customer/create">Create Customer</a>
    <a href="${pageContext.request.contextPath}/customer/list">Customer List</a>
</div>
<div class="mt-3">
    <a href="${pageContext.request.contextPath}/user/create">Create User</a>
    <a href="${pageContext.request.contextPath}/customer/list">User List</a>
</div>
</body>
</html>
