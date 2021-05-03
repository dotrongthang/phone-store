<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title><dec:title default="Đăng ký tài khoản" /></title>
    
   <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link href="<c:url value='/template/login/style.css' />" rel="stylesheet" type="text/css" media="all"/>
	
	<!-- Font Icon -->
    <link href="<c:url value='/template/register/fonts/material-icon/css/material-design-iconic-font.min.css' />" rel="stylesheet" type="text/css" media="all"/>

    <!-- Main css -->
    <link href="<c:url value='/template/register/css/style.css' />" rel="stylesheet" type="text/css" media="all"/>
    
	<script src="//cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.9-1/core.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.9-1/md5.js"></script>
    
</head>
<body>
	<dec:body/>
</body>
</html>