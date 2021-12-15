<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${book.title}</title>

<link href="<%=getServletContext().getContextPath()%>/customer/css/header.css" rel="stylesheet">
<link href="<%=getServletContext().getContextPath()%>/customer/css/home.css" rel="stylesheet">
<link href="<%=getServletContext().getContextPath()%>/customer/css/book-detail.css" rel="stylesheet">


</head>
<body>
	<%String contextPath = getServletContext().getContextPath();%>
	<div class="container">
		<jsp:include page="header.jsp"></jsp:include>
		<p>
		<fmt:setLocale value="vi_VN"/>
		<fmt:formatDate value="${cart.createDate}" type="both"/>
		</p>
		<table class="table table-bordered">
			<thead>
				<tr>
					<td>Book</td>
					<td>Picture</td>
					<td>Quantity</td>
					<td>Price</td>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${cart.lineitems.size() gt 0}">
							<c:forEach items="${cart.lineitems}" var="item">
								<tr>
									<td>${item.book.title}</td>
									<td></td>
									<td>${item.quantity}</td>
									<td>${item.price}</td>
								</tr>
							</c:forEach>
					</c:when>
					
					<c:otherwise>
						<tr>
							<td rowspan="4">No Items</td>
						</tr>
					</c:otherwise>
				</c:choose>
						</tbody>
		</table>
		<jsp:include page="footer.jsp"></jsp:include>
		
	</div>
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" ></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="<%=contextPath%>/customer/js/book-detail.js"></script>
</body>
</html>