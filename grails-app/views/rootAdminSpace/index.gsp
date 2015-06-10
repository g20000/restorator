<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
	<meta name="layout" content="userSpace"/>
    <!-- Custom styles for this template -->
	<title>Ресторатор</title>
</head>
<body>
  <div class="container">	
      <div class="header clearfix">
        <nav>
          <ul class="nav nav-pills pull-right">
	            <li role="presentation">Добро пожаловать в личный кабинет, </li>
	            <li role="presentation"><g:link controller="VisitorSpace" action="index"><sec:loggedInUserInfo field="username"/></g:link></li>
	            <li role="presentation"><g:link controller="Logout" action="index">Выход</g:link></li>
          </ul>
        </nav>
        <div class="img-rounded">
            <g:link controller="StartPage" action="index"><g:img dir="images" file="Olumn64.png"/></g:link>
        </div>
        <h3 class="text-muted">Olumn</h3>
      </div>

      <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><g:link controller="RootAdminSpace" action="index">Просмотр данных <span class="sr-only">(current)</span></g:link></li>
            <li><g:link controller="RootAdminSpace" action="setupBillingSystem">Настройка оплаты</g:link></li>
            <li><g:link controller="RootAdminSpace" action="editPrivateData">Редактирование личных данных</g:link></li>
          </ul>
       </div>
	  <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="active"><g:link action="index">Мои рестораны</g:link></li>
              <li><g:link action="showReservedTableForAdmin">Пользователи</g:link></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>
      <script type="text/javascript">
		$(document).ready(function(){
			jQuery('.jumbotron').css("text-align", "left");
			jQuery('.jumbotron').css("padding-left", "20px");
			jQuery('.jumbotron').css("line-height", "0.5em");
		});
	  </script>
      <div class="jumbotron">
     	<h3>Информация о заведении</h3>
     	<div>     	
	   		<table class="table">
	    		<thead>
					<tr>
						<th>Название ресторана</th>
						<th>Город</th>
						<th>Регион</th>
					</tr>	
				</thead>
				<tbody>
					<g:each in="${availableCafee}" var="cafeeInfo">
						<tr>
							<td><g:link controller="RootAdminSpace" action="goToCafeePage" params="[cafeeName: "${cafeeInfo.cafeeName}", cafeeApiInit: "${cafeeInfo.apiInit}"]">${cafeeInfo.cafeeName}</g:link></td>
							<td>${cafeeInfo.getCity()}</td>
							<td>${cafeeInfo.getRegion()}</td>
						</tr>
					</g:each>
				</tbody>
	    	</table>	      	
     	</div> 
      </div>
		<div class="row marketing">
        </div>
      <footer class="footer">
        <p>© Olumn 2014</p>
      </footer>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<%--    <script src="index4_files/ie10-viewport-bug-workaround.js"></script>--%>
</body>
</html>