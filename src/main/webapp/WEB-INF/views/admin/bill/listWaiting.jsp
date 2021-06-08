<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:url var="billAPI" value="/api/bill"/>
<c:url var="billURL" value="/quan-tri/don-hang/danh-sach"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Danh sách sản phẩm</title>
	</head>

	<body>
		<div class="main-content">
		<form action="<c:url value='/quan-tri/don-hang/danh-sach'/>" id="formSubmit" method="get">
			
				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="<c:url value= '/trang-chu'/>">Trang chủ</a>
							</li>
						</ul>
						<!-- /.breadcrumb -->
					</div>
					<div class="page-content">
					<h2>Danh sách đơn hàng</h2>
						<div class="row">
							<div class="col-xs-12">
							<c:if test="${not empty message}">
							<div class="alert alert-${alert}">
							  	${message}
							</div>
							</c:if>
								<div class="widget-box table-filter">
									<div class="table-btn-controls">
										<div class="pull-right tableTools-container">
										<a id="btnUpdate" type="submit" onclick="warningBeforeUpdate()" class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
																	 title="Đã xử lý" >
																	<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
																</a>
											<div class="dt-buttons btn-overlap btn-group">
												<button id="btnDelete" type="button" onclick="warningBeforeDelete()"
														class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" data-toggle="tooltip" title='Xóa đơn hàng'>
																<span>
																	<i class="fa fa-trash-o bigger-110 pink"></i>
																</span>
												</button>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12">
										<div class="table-responsive">
											<table class="table table-bordered">
												<thead>
													<tr>
														<th><input type="checkbox" id="checkAll"></th>
														<th>Tên sản phẩm</th>
														<th>Màu sắc</th>
														<th>Giá bán</th>
														<th>Tên khách hàng</th>
														<th>Số điện thoại</th>
														<th>Địa chỉ</th>
														<th>Ngày đặt hàng</th>
														<th>Trạng thái</th>
														<th>Chuyển trạng thái</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="item" items="${model.listResult}">
														<tr>
															<td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
															<td>${item.productName}</td>
															<td>${item.productColor}</td>
															<td>${item.productSold}</td>
															<td>${item.customerName}</td>
															<td>${item.phoneNumber}</td>
															<td>${item.address}</td>
															<td>${item.createdDate}</td>
															<td>${item.statusOfBill}</td>
															<td>		
																							
																
															</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
											<ul class="pagination" id="pagination"></ul>	
											<input type="hidden" value="" id="page" name="page"/>
											<input type="hidden" value="" id="limit" name="limit"/>							
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
		</form>
		</div>
		<!-- /.main-content -->
		<script>
			var totalPages = ${model.totalPage};
			var currentPage = ${model.page};
			$(function () {
		        window.pagObj = $('#pagination').twbsPagination({
		            totalPages: totalPages,
		            visiblePages: 10,
		            startPage: currentPage,
		            onPageClick: function (event, page) {
		            	if (currentPage != page) {
		            		$('#limit').val(2);
							$('#page').val(page);
							$('#formSubmit').submit();
						}
		            }
		        });
		    });
			
			function warningBeforeUpdate(){
				swal({
					  title: "Xác nhận đơn hàng",
					  text: "Bạn có muốn chuyển trạng thái đơn hàng này không?",
					  type: "warning",
					  showCancelButton: true,
					  confirmButtonClass: "btn-success",
					  cancelButtonClass: "btn-danger",
					  confirmButtonText: "Xác nhận",
					  cancelButtonText: "Hủy bỏ",
					  closeOnConfirm: false

					}).then(function(isConfirm) {
					  if (isConfirm) {
							  var data = {};
								var ids = $('tbody input[type=checkbox]:checked').map(function () {
						            return $(this).val();
						        }).get();
								updateBill(ids);

					  } else{
						  event.preventDefault();
					  }
					},
				       function () { return false; }); 
			}
			
			function updateBill(data) {
		        $.ajax({
		            url: '${billAPI}',
		            type: 'PUT',
		            contentType: 'application/json',
		            data: JSON.stringify(data),
		            success: function (result) {
		                window.location.href = "${billURL}?page=1&limit=2&message=update_success";
		            },
		            error: function (error) {
		            	window.location.href = "${billURL}?page=1&limit=2&message=error_system";
		            }
		        });
		    }
			
			function warningBeforeDelete(){
				swal({
					  title: "Xác nhận xóa",
					  text: "Bạn có chắc chắn từ chối đơn hàng này không?",
					  type: "warning",
					  showCancelButton: true,
					  confirmButtonClass: "btn-success",
					  cancelButtonClass: "btn-danger",
					  confirmButtonText: "Xác nhận",
					  cancelButtonText: "Hủy bỏ",

					}).then(function(isConfirm) {
					  if (isConfirm) {
						var data = {};
						var ids = $('tbody input[type=checkbox]:checked').map(function () {
					            return $(this).val();
					        }).get();
							deleteBill(ids);
					  } 
					});
			}
			
			function deleteBill(data) {
		        $.ajax({
		            url: '${billAPI}',
		            type: 'DELETE',
		            contentType: 'application/json',
		            data: JSON.stringify(data),
		            success: function (result) {
		                window.location.href = "${billURL}?page=1&limit=2&message=delete_success";
		            },
		            error: function (error) {
		            	window.location.href = "${billURL}?page=1&limit=2&message=error_system";
		            }
		        });
		    }
		</script>
	</body>
	</html>