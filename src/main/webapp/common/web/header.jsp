<%@ page import="com.project.util.SecurityUtils" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="#">Cửa hàng điện thoại</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link" href="<c:url value= '/trang-chu'/>">Trang chủ
						<span class="sr-only">(current)</span>
				</a></li>

				<security:authorize access = "isAnonymous()">
				<li class="nav-item"><a class="nav-link" href="<c:url value= '/dang-nhap'/>">Đăng nhập</a></li>
				<li class="nav-item"><a class="nav-link" href="<c:url value= '/dang-ky'/>">Đăng ký</a></li>
				</security:authorize>
				
				<security:authorize access = "isAuthenticated()">
				<c:set var = "idUser" value="<%=SecurityUtils.getPrincipal().getId() %>"/>
				<c:url var="updateProductURL" value="/nguoi-dung/chinh-sua">
					<c:param name="id" value= "${idUser }" />
				</c:url>
				<li class="nav-item"><a class="nav-link" href="<c:url value= '${updateProductURL}'/>">Xin chào: <%=SecurityUtils.getPrincipal().getFullName() %></a></li>
				<li class="nav-item"><a class="nav-link" href="<c:url value= '/thoat'/>">Thoát</a></li>
				</security:authorize>

			</ul>
		</div>
	</div>
</nav>