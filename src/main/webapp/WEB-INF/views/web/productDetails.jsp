<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Trang chủ</title>


</head>

<body>

	<div class="container">
		<br>
		<h2>Chi tiết sản phẩm</h2>
		<br>
		<div class="row">
			<div class="col-lg-6">
				<section class="panel">
					<div class="panel-body">
						<div class="col-lg-6">
							<div class="pro-img-details">
								<img
									src="${pageContext.request.contextPath}/image/${model.image }"
									alt="">
							</div>
							<!-- <div class="pro-img-list">
								<a href="#"> <img
									src="https://via.placeholder.com/115x100/87CEFA/000000" alt="">
								</a> <a href="#"> <img
									src="https://via.placeholder.com/115x100/FF7F50/000000" alt="">
								</a> <a href="#"> <img
									src="https://via.placeholder.com/115x100/20B2AA/000000" alt="">
								</a> <a href="#"> <img
									src="https://via.placeholder.com/120x100/20B2AA/000000" alt="">
								</a>
							</div> -->

						</div>
					</div>
				</section>
			</div>
			<div class="col-lg-1"></div>

			<div class="col-lg-5">
				<h4 class="pro-d-title">
					<a href="#" class=""> ${model.name} </a>
				</h4>
				<strong>Thông số kĩ thuật : </strong>
				<p>${model.description}</p>
				<!-- <div class="product_meta">
					<span class="posted_in"> <strong>Categories:</strong> <a
						rel="tag" href="#">Jackets</a>, <a rel="tag" href="#">Men</a>, <a
						rel="tag" href="#">Shirts</a>, <a rel="tag" href="#">T-shirt</a>.
					</span> <span class="tagged_as"><strong>Tags:</strong> <a rel="tag"
						href="#">mens</a>, <a rel="tag" href="#">womens</a>.</span>
				</div> -->
				<div class="m-bot15">
					<strong>Giá bán : </strong> <span class="pro-price">
						${model.sold} VNĐ </span>
				</div>
				<!-- <div class="form-group">
					<label>Quantity</label> <input type="quantiy" placeholder="1"
						class="form-control quantity">
				</div> -->
				<strong>Màu sắc : </strong> <span class="pro-price">
					${model.color} </span> <br>
					<br>
				<a href="/san-pham/cart?id=${model.id }" class="btn btn-info" role="button">Đặt mua ngay</a>
			</div>
		</div>
	</div>
</body>
<script>
	$(document).ready(function() {
		$(".search").click(function() {
			$(this).addClass("active");
		});
		$(document).click(function(e) {
			if (!$(e.target).closest(".search").length) { //another way to do this is to stop event propagation
				$(".search.active").removeClass('active');
			}
		});
	});
</script>
</html>