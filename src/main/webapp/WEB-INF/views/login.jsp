<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng nhập</title>
</head>
<body>
	<%-- <div class="container">
		
		<!-- <h1 class="form-heading">Đăng nhập hệ thống</h1> -->
		<div class="login-form">
			<div class="main-div">
				<h3 class="form-title">Đăng nhập hệ thống</h3>
				<br></br>
				<c:if test="${param.incorrectAccount != null}">
					<div class="alert alert-danger">	
							Username or password incorrect
					</div>
				</c:if>
				<c:if test="${param.accessDenied != null}">
					<div class="alert alert-danger">	
							You not permission
					</div>
				</c:if>
				<form action="j_spring_security_check" id="formLogin" method="post">
					<div class="form-group">
						<input type="text" class="form-control" id="userName" name="j_username" placeholder="Tên đăng nhập">
					</div>

					<div class="form-group">
						<input type="password" class="form-control" id="password" name="j_password" placeholder="Mật khẩu">
					</div>
					<button type="submit" class="btn btn-primary" >Đăng nhập</button>
				</form>
				<br></br>
				<p class="loginhere">
					Bạn chưa có tài khoản? <a href="<c:url value= '/dang-ky'/>"
						class="loginhere-link">Đăng ký ngay</a>
				</p>
			</div>
		</div>
	</div> --%>

	<div class="main">
		<section class="signup"> <!-- <img src="images/signup-bg.jpg" alt=""> -->
		<div class="container">
			<div class="signup-content">

				<c:if test="${param.incorrectAccount != null}">
					<div class="alert alert-danger">Username or password
						incorrect</div>
				</c:if>
				<c:if test="${param.accessDenied != null}">
					<div class="alert alert-danger">You not permission</div>
				</c:if>

				<form action="j_spring_security_check" id="formLogin" method="post">
					<h2 class="form-title">Đăng nhập hệ thống</h2>

					<div class="form-group">
						<input type="text" class="form-input" name="j_username"
							id="username" placeholder="Tài khoản" />
					</div>
					<div class="form-group">
						<input type="password" class="form-input" name="j_password"
							id="password" placeholder="Mật khẩu" /> 	
					</div>
					
					<div class="form-group">
						<input type="submit" name="submit" id="submit" class="form-submit"
							value="Đăng nhập" />
					</div>
					<!-- <button type="submit" class="btn btn-primary">Đăng nhập</button> -->
				</form>
				<p class="registerhere">
					Bạn đã chưa có tài khoản? <a href="<c:url value= '/dang-ky'/>"
						class="registerhere-link">Đăng ký ngay</a>
				</p>
				<p class="homehere">
					Quay về trang chủ -> <a href="<c:url value= '/trang-chu'/>"
						class="homehere-link">Trang chủ</a>
				</p>
			</div>
		</div>
		</section>
	</div>
	<script>

</body>
</html>