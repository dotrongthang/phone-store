<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:url var="APIurl" value="/api/register" />
<c:url var="registerURL" value="/dang-ky"/>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng ký tài khoản</title>
</head>
<body>
	<div class="main">

		<section class="signup"> <!-- <img src="images/signup-bg.jpg" alt=""> -->
		<div class="container">
			<div class="signup-content">
				<form id="signup-form" class="signup-form">
					<h2 class="form-title">Đăng ký tài khoản</h2>
					
					<c:if test="${not empty message}">
						<div class="alert alert-${alert}">${message}</div>
					</c:if>
					
					<div class="form-group">
						<input type="text" class="form-input" name="fullname"
							id="fullname" placeholder="Họ và tên" />
					</div>
					<div class="form-group">
						<input type="text" class="form-input" name="username"
							id="username" placeholder="Tài khoản" />
					</div>
					<div class="form-group">
						<input type="text" class="form-input" name="password"
							id="password" placeholder="Mật khẩu" /> 
							<span toggle="#password" onclick="hideAndShowPw()"
							class="zmdi zmdi-eye field-icon toggle-password"></span>
					</div>
					<div class="form-group">
						<input type="password" class="form-input" name="re_password"
							id="re_password" placeholder="Nhập lại mật khẩu" />
					</div>

					<div class="form-group">
						<input type="submit" name="submit" id="submit" class="form-submit"
							value="Sign up" />
					</div>
				</form>
				<p class="loginhere">
					Bạn đã có tài khoản ? <a href="<c:url value= '/dang-nhap'/>"
						class="loginhere-link">Đăng nhập ngay</a>
				</p>
			</div>
		</div>
		</section>

	</div>

	<script>
		$('#submit').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#signup-form').serializeArray();
			$.each(formData, function(i, v) {
				/* if(v.name == "password"){
					data["" + v.name + ""] = CryptoJS.MD5(v.value).toString();
				} else{
					data["" + v.name + ""] = v.value;
				} */
				data["" + v.name + ""] = v.value;
			});
			register(data);

		});

		function register(data) {
			$.ajax({
				url : '${APIurl}',
				type : 'POST',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success: function (result) {
	            	window.location.href = "${registerURL}?message=insert_success";
	            },
	            error: function (error) {
	            	window.location.href = "${registerURL}?message=error_system";
	            }
			});
		}
		
		function hideAndShowPw() {
			  var x = document.getElementById("password");
			  if (x.type === "password") {
			    x.type = "text";
			  } else {
			    x.type = "password";
			  }
			}
		
	</script>

</body>
</html>