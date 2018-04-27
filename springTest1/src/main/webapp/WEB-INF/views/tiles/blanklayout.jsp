<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="CoreUI - Open Source Bootstrap Admin Template">
  <meta name="author" content="Łukasz Holeczek">
  <meta name="keyword" content="Bootstrap,Admin,Template,Open,Source,AngularJS,Angular,Angular2,Angular 2,Angular4,Angular 4,jQuery,CSS,HTML,RWD,Dashboard,React,React.js,Vue,Vue.js">
  <link rel="shortcut icon" href="resources/img/favicon.png">

  <!-- Bootstrap and necessary plugins -->
  <script src="${pageContext.request.contextPath}/scripts/jquery-3.3.1.min.js"></script>
  <script src="${pageContext.request.contextPath}/scripts/popper.min.js"></script>
  <script src="${pageContext.request.contextPath}/scripts/bootstrap.js"></script>
  <script src="${pageContext.request.contextPath}/scripts/pace.min.js"></script>

  <!-- Plugins and scripts required by all views -->
  <script src="${pageContext.request.contextPath}/scripts/charts.js"></script>

  <!-- CoreUI main scripts -->
  <script src="${pageContext.request.contextPath}/scripts/app.js"></script>

  <title>예담 학원 관리 시스템</title>

  <!-- Icons -->
  <link href="${pageContext.request.contextPath}/resources/css/flag-icon.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/css/fontawesome.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/css/simple-line-icons.css" rel="stylesheet">
  
  <!-- Main styles for this application -->
  <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
</head>


<body class="app header-fixed sidebar-fixed aside-menu-fixed aside-menu-hidden">


     			    <tiles:insertAttribute name="content" />
    		
 
  

</body>
</html>