<%@ page contentType="text/html;charset=UTF-8" %>
<%
response.setHeader("Cache-Control","no-cache");  
response.setHeader("Cache-Control","no-store");     
response.setDateHeader("Expires", 0); 
response.setHeader("Pragma","no-cache");
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	<!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="${resource(dir:'css/start_page_bootstrap_files', file:'bootstrap.css')}" type="text/css"> 
	
    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="${resource(dir:'css/start_page_bootstrap_files', file:'jumbotron-narrow.css')}" type="text/css">
    <%--<link rel="stylesheet" href="${resource(dir:'css/navbar_template', file:'bootstrap.css')}" type="text/css">--%>
    <link rel="stylesheet" href="${resource(dir:'css/navbar_template', file:'navbar.css')}" type="text/css">
    <%--<link rel="stylesheet" href="${resource(dir:'css/visitor_files', file:'bootstrap.css')}" type="text/css">--%> 
    <link rel="stylesheet" href="${resource(dir:'css/visitor_files', file:'dashboard.css')}" type="text/css">
    <link rel="stylesheet" href="${resource(dir:'css/visitor_files', file:'main_signed.css')}" type="text/css">
    
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="http://getbootstrap.com/favicon.ico">
	<title>Ресторатор</title>
</head>
<body>
  <g:layoutBody/>
</body>
</html>