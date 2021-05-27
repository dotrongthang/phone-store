<%@ page import="com.project.util.SecurityUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="billAPI" value="/api/bill"/>
<c:url var="cartURL" value="/san-pham/cart"/>
<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Trang chủ</title>


</head>

<body>

	<!--Section: Block Content-->
	<section>

		<!--Grid row-->
		<div class="row">

			<!--Grid column-->

			<div class="col-lg-1"></div>
			<div class="col-lg-5">

				<!-- Card -->
				<div class="mb-3">
					<div class="pt-4 wish-list">

						<h5 class="mb-4">Giỏ hàng</h5>

						<div class="row mb-4">
							<div class="col-md-5 col-lg-3 col-xl-3">
								<div class="view zoom overlay z-depth-1 rounded mb-3 mb-md-0">
									<img class="img-fluid w-100"
										src="${pageContext.request.contextPath}/image/${model.image }"
										alt="Sample">
								</div>
							</div>
							<div class="col-md-7 col-lg-9 col-xl-9">
								<div>
									<div class="d-flex justify-content-between">
										<div>
											<h5>${model.name }</h5>
											<p class="mb-2 text-muted text-uppercase small">Màu:
												${model.color }</p>
										</div>

									</div>
									<div class="d-flex justify-content-between align-items-center">
										<p class="mb-0">
											<span>Giá: <strong id="summary">${model.sold } VNĐ</strong></span>
										</p class="mb-0">
									</div>
								</div>
							</div>
						</div>
						<hr class="mb-4">
					</div>
				</div>

			</div>

			<!--Grid column-->
			<div class="col-lg-5">
				<!-- Card -->
				<div class="mb-3">
					<div class="pt-4">
					
					<c:if test="${not empty message}">
				<div class="alert alert-${alert}">
				  	${message}
				</div>
				</c:if>

						<h5 class="mb-3">Thông tin hóa đơn</h5>

						<ul class="list-group list-group-flush">
							<li
								class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 pb-0">
								Tên khách hàng: <span><%=SecurityUtils.getPrincipal().getFullName()%></span>
							</li>

							<li
								class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 pb-0">
								Số điện thoại: <span><%=SecurityUtils.getPrincipal().getPhoneNumber()%></span>
							</li>

							<li
								class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 pb-0">
								Địa chỉ: <span><%=SecurityUtils.getPrincipal().getAddress()%></span>
							</li>
							
							<li
								class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 pb-0">
								Tên sản phẩm mua: <span>${model.name }</span>
							</li>

							<li
								class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 pb-0">
								Giá tiền: <span>${model.sold } VNĐ</span>
							</li>
							<li
								class="list-group-item d-flex justify-content-between align-items-center px-0">
								Phí vận chuyển: <span>miễn phí</span>
							</li>
							<li
								class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 mb-3">
								<div>
									<strong>Tổng: </strong>
								</div> <span><strong>${model.sold } VNĐ</strong></span>
							</li>
						</ul>

						<button type="button" id="btnAddBill" class="btn btn-primary btn-block">Xác
							nhận</button>
					</div>
				</div>
			</div>

		</div>


	</section>
	<!--Section: Block Content-->
	
<script>
	$('#btnAddBill').click(function (e) {
	    e.preventDefault();
	    var data = {};
	    var userId = <%=SecurityUtils.getPrincipal().getId()%>
	    var productId = ${model.id}
	  
	    data["userId"] = userId;
	    data["productId"] = productId;
	    
	    addBill(data);
	});
	
	function addBill(data){
		$.ajax({
            url: '${billAPI}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${cartURL}?id="+${model.id}+"&message=cart_success";
            },
            error: function (error) {
            
            }
        });
	}

</script>
</body>

</html>