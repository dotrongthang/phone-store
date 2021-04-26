<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="productURL" value="/quan-tri/san-pham/danh-sach"/>
<c:url var="editProductURL" value="/quan-tri/san-pham/chinh-sua"/>
<c:url var="productAPI" value="/api/product"/>
<html>
<head>
<title>Chỉnh sửa sản phẩm</title>
</head>
<body>
<div class="main-content">
	<div class="main-content-inner">
		<div class="breadcrumbs" id="breadcrumbs">
			<script type="text/javascript">
				try {
					ace.settings.check('breadcrumbs', 'fixed')
				} catch (e) {
				}
			</script>

			<ul class="breadcrumb">
				<li><i class="ace-icon fa fa-home home-icon"></i> <a href="<c:url value= '/quan-tri/trang-chu'/>">Trang quản trị</a>
				</li>

				<li><a href="<c:url value= '/quan-tri/san-pham/danh-sach?page=1&limit=2'/>">Danh sách sản phẩm</a></li>
				<li class="active">Chi tiết sản phẩm</li>
			</ul>
			<!-- /.breadcrumb -->
		</div>
		
		<div class="page-content">
			<div class="row">
				<div class="col-xs-12">
				<c:if test="${not empty message}">
				<div class="alert alert-${alert}">
				  	${message}
				</div>
				</c:if>
				
					<form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model">
						<div class="form-group">
						 <label class="col-sm-3 control-label no-padding-right" for="categoryCode">Hãng: </label>
						 <div class="col-sm-9">
						  
						  <form:select path="categoryCode" id="categoryCode">
						  	<form:option value="" label="-- Chọn thể loại --"/>
						  	<form:options items="${categories}"/>
						  </form:select>
						  </div>
						</div>
						<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Tên sản phẩm </label>
								<div class="col-sm-9">
									<form:input path="name" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Hình ảnh </label>
								<div class="col-sm-9">
									<input type="file" class="col-xs-10 col-sm-5" id="image" name="image"/>
								</div>
						</div>
						<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Giá nhập </label>
								<div class="col-sm-9">
									<form:input path="price" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						
						<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Giá bán </label>
								<div class="col-sm-9">
									<form:input path="sold" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						
						<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Màu sắc </label>
								<div class="col-sm-9">
									<form:input path="color" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						
						<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Số lượng </label>
								<div class="col-sm-9">
									<form:input path="count" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						
						<div class="form-group">
							  <label class="col-sm-3 control-label no-padding-right" for="comment">Mô tả</label>
							  <div class="col-sm-9">
							  	<form:textarea path="description" rows="5" cols="10" id="description" cssClass="form-control"/>
							  </div>
						</div>
						<form:hidden path="id" id="productId"/>
						<div class="clearfix form-actions">
							<div class="col-md-offset-3 col-md-9">
								<c:if test="${not empty model.id}">
									<button class="btn btn-info" type="button" id="btnAddOrUpdateProduct">
										<i class="ace-icon fa fa-check bigger-110"></i>
										Cập nhật sản phẩm
									</button>
								</c:if>
								<c:if test="${empty model.id}">
									<button class="btn btn-info" type="button" id="btnAddOrUpdateProduct">
										<i class="ace-icon fa fa-check bigger-110"></i>
										Thêm sản phẩm
									</button>
								</c:if>
								

											&nbsp; &nbsp; &nbsp;
								<button class="btn" type="reset">
									<i class="ace-icon fa fa-undo bigger-110"></i>
									Hủy
								</button>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
	$('#btnAddOrUpdateProduct').click(function (e) {
	    e.preventDefault();
	    var data = {};
	    var formData = $('#formSubmit').serializeArray();
	    $.each(formData, function (i, v) {
            data[""+v.name+""] = v.value;
        });
	    var id = $('#productId').val();
	    if (id == "") {
            addProduct(data);
        } else {
            updateProduct(data);
        }
	});
	
	function addProduct(data){
		$.ajax({
            url: '${productAPI}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${editProductURL}?id="+result.id+"&message=insert_success";
            },
            error: function (error) {
            	window.location.href = "${productURL}?page=1&limit=2&message=error_system";
            }
        });
	}
	
	function updateProduct(data){
		$.ajax({
            url: '${productAPI}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${editProductURL}?id="+result.id+"&message=update_success";
            },
            error: function (error) {
            	window.location.href = "${productURL}?page=1&limit=2&message=error_system";
            }
        });
	}
</script>
</body>
</html>