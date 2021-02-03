<%@ include file="/WEB-INF/views/common/header.jsp"%>
<jsp:include page="/WEB-INF/views/common/navbar.jsp"/>
<h2 class="test">Welcome To Smart Inventory</h2>
<a href="${pageContext.request.contextPath}/customer/create">Create Customer</a>
<a href="${pageContext.request.contextPath}/customer/list">Customer List</a>
</body>
</html>
