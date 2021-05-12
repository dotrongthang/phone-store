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

    <div class="row">

      <div class="col-lg-3">
		<h2 class="my-4">Hãng sản xuất</h2>
        <div class="list-group">
          	<c:forEach var="item" items="${categories}">
				<a href="/trang-chu?code=${item.code}" class="list-group-item">${item.name }</a>	
			</c:forEach>
        </div>

      </div>
      <!-- /.col-lg-3 -->

      <div class="col-lg-9">

        <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
          <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
          </ol>
          <div class="carousel-inner" role="listbox">
            <div class="carousel-item active">
              <img class="d-block img-fluid" src="https://scontent.fhph1-1.fna.fbcdn.net/v/t1.6435-9/179804206_2968388903406342_8989929491327098964_n.jpg?_nc_cat=104&ccb=1-3&_nc_sid=0debeb&_nc_ohc=ESZAsDZHxGcAX9lSnO0&_nc_ht=scontent.fhph1-1.fna&oh=921465a978bb4c283da8052b61c891f8&oe=60B764C9" style="width:900px;height:300px;">
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid" src="https://scontent.fhph1-1.fna.fbcdn.net/v/t1.6435-9/45628914_1246667852141509_5041887285872689152_n.jpg?_nc_cat=102&ccb=1-3&_nc_sid=19026a&_nc_ohc=2Nv0A0WSQaIAX_azXEL&_nc_ht=scontent.fhph1-1.fna&oh=aa6ced5ccd5ed25329f1ab3569936c5b&oe=60B95F7B" style="width:900px;height:300px;">
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid" src="${pageContext.request.contextPath}/image/signup-bg.jpg" style="width:900px;height:300px;">
            </div>
          </div>
          <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>

        <div class="row">

			<c:forEach var="item" items="${model.listResult}">
				<div class="col-lg-4 col-md-6 mb-4">
            	<div class="card h-100">
             	 	<a href="#"><img class="card-img-top" src="${pageContext.request.contextPath}/image/${item.image }" alt="" width="320" height="240"></a>
             	 <div class="card-body">
                <h4 class="card-title">
                 	 <a href="#">${item.name}</a>
                </h4>
               		 <h5>Giá bán: ${item.sold}VNĐ</h5>
                <p class="card-text">Mô tả: ${item.description}</p>
              </div>
              <div class="card-footer">
                <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
              </div>
            </div>
          </div>
			</c:forEach>

        </div>
        <!-- /.row -->

      </div>
      <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->
</body>

</html>