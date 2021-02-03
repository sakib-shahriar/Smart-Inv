<%@ include file="/WEB-INF/views/common/header.jsp"%>
<jsp:include page="/WEB-INF/views/common/navbar.jsp"/>
<h2 class="test">Customer List View</h2>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col">Email</th>
        <th scope="col">Phone</th>
        <th scope="col">Address</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${itemList}" var="item" varStatus="loop">
        <tr>
            <th scope="row">${loop.index}</th>
            <td><a href="${pageContext.request.contextPath}/customer/details?id=${item.id}">${item.name}</a></td>
            <td>${item.email}</td>
            <td>${item.phone}</td>
            <td>${item.address.getFullAddress()}</td>
            <td>
                <a href="${pageContext.request.contextPath}/customer/edit?id=${item.id}">Edit</a> /
                <a href="${pageContext.request.contextPath}/customer/delete?id=${item.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
