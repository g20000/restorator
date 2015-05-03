<%@ page contentType="text/html;charset=UTF-8" %>
<%
response.setHeader("Cache-Control","no-cache");  
response.setHeader("Cache-Control","no-store");     
response.setDateHeader("Expires", 0); 
response.setHeader("Pragma","no-cache");
%>
<!DOCTYPE html>
<html lang="en"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="${resource(dir:'css/start_page_bootstrap_files', file:'bootstrap.css')}" type="text/css">
	
    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="${resource(dir:'css/start_page_bootstrap_files', file:'jumbotron-narrow.css')}" type="text/css">
    <link rel="stylesheet" href="${resource(dir:'css', file:'imageTable.css')}" type="text/css">
    <link rel="stylesheet" href="${resource(dir:'css', file:'pictureItem.css')}" type="text/css">
    <link rel="stylesheet" href="${resource(dir:'css', file:'imageRow.css')}" type="text/css">
    <link rel="stylesheet" href="${resource(dir:'css', file:'popularCitiesList.css')}" type="text/css">
    <link rel="stylesheet" href="${resource(dir:'css', file:'popularCitiesListItem.css')}" type="text/css">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="http://getbootstrap.com/favicon.ico">

    <title>Ресторатор</title>
    
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <!--<g:javascript library="start_page_bootstrap_files/ie-emulation-modes-warning"/>-->

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
   	<g:layoutBody/>
</body></html>