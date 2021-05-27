<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="editUserURL" value="/nguoi-dung/chinh-sua"/>
<c:url var="userAPI" value="/api/user"/>
<html>
<head>
<title>Chỉnh sửa thông tin người dùng</title>
</head>
<body>
<div class="main-content">
	<div class="main-content-inner">	
		<div class="page-content">
			<div class="row">
				<div class="col-lg-3">
				</div>
				
				<div class="col-lg-6">
				<c:if test="${not empty message}">
				<div class="alert alert-${alert}">
				  	${message}
				</div>
				</c:if>
				
				<br>
			<h2>Cập nhật thông tin người dùng</h2>
			<br>
				
					<form:form class="form-horizontal" method="post" role="form" id="formSubmit" modelAttribute="model">
						
						<div class="form-group">
								<label > Tên khách hàng </label>
								<div class="col-sm-12">
									<form:input path="fullname" class="form-control"/>
								</div>
						</div>
			
						<div class="form-group">
								<label > Tài khoản </label>
								<div class="col-sm-12">
									<form:input path="username" cssClass="form-control"/>
								</div>
						</div>
						
						<div class="form-group">
								<label> Số điện thoại </label>
								<div class="col-sm-12">
									<form:input path="phonenumber" cssClass="form-control"/>
								</div>
						</div>
						
						<div class="form-group">
								<label > Địa chỉ </label>
								<div class="col-sm-12">
									<form:input path="address" cssClass="form-control"/>
								</div>
						</div>
						
						<form:hidden path="id" id="userId"/>
						<div class="clearfix form-actions">
							<div class="col-md-offset-3 col-md-9">
								
									<button class="btn btn-info" style="width: 200px;" type="button" id="btnUpdateUser">
										<i class="ace-icon fa fa-check bigger-110"></i>
										Chỉnh sửa thông tin
									</button>
											&nbsp; &nbsp; &nbsp;
								<button class="btn btn-info" style="width: 200px;" type="reset">
									<i class="ace-icon fa fa-undo bigger-110"></i>
									Hủy
								</button>
								<br><br>
							</div>
						</div>
					</form:form>
				</div>
				<div class="col-lg-3">
				</div>
			</div>
		</div>
	</div>
</div>
<script>

	$('#btnUpdateUser').click(function (e) {
	    e.preventDefault();
	    var data = {};
	    var formData = $('#formSubmit').serializeArray();
	    $.each(formData, function (i, v) {
	        data[""+v.name+""] = v.value;
	    });
	    updateUser(data);
	});
	
	function updateUser(data){
		$.ajax({
            url: '${userAPI}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${editUserURL}?id="+result.id+"&message=update_success";
            },
            error: function (error) {
            	window.location.href = "${editUserURL}?id="+result.id+"&message=error_system";
            }
        });
	}

</script>
</body>
</html>