<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.joda.time.LocalTime" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
	<meta name="layout" content="userSpace"/>
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
            <li class="active"><g:link controller="RootAdminSpace" action="index">Бронирование <span class="sr-only">(current)</span></g:link></li>
            <li><g:link controller="RootAdminSpace" action="setupBillingSystem">Настройка оплаты</g:link></li>
            <li><g:link controller="RootAdminSpace" action="editPrivateData">Редактирование личных данных</g:link></li>
          </ul>
       </div>
	  <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="active"><a href="#">Информация о пользователе</a></li>
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
      		<table class="table">
      			<tbody>
      				<tr>
		      			<td>Логин пользователя</td><td>${userInfo.getUsername()}</td>
		      		</tr>
		      		<tr>
	      				<td>Имя пользователя</td><td>${userInfo.getFirstName()}</td>
	      			</tr>
	      			<tr>
	      				<td>Фамилия пользователя</td><td>${userInfo.getLastName()}</td>
	      			</tr>
	      			<tr>
	      				<td>Еmail пользователя</td><td><a href="mailto:${userInfo.getEmail() }">${userInfo.getEmail()}</a></td>
	      			</tr>
	      			<g:if test = "${userInfo.getInn() != "" }">
		      			<tr>
		      				<td>ИНН пользователя</td><td>${userInfo.getInn()}</td>
		      			</tr>
	      			</g:if>
	      			<tr>
	      				<td>Статус пользователя</td>
		      			<g:if test = "${userInfo.getIsAdminCafee()}">
							<td>Администратор ресторана</td>
						</g:if>
						<g:else>
							<td>Пользователь</td>
						</g:else>
					</tr>
					<g:if test = "${userInfo.getIsAdminCafee()}">
						<tr>
							<td>Заведение в наличии</td>
							<td><g:link action = "goToCafeePage" params = "[id: "${userInfo.cafee.getId()}", cafeeApiInit: "${userInfo.cafee.apiInit}"]">${userInfo.cafee.getCafeeName()}</g:link></td>
						</tr>
					</g:if>
		        </tbody>      
		        <%--<g:hiddenField name="cafeeName" value="${cafeeName.cafeeName}" /> --%>
	        </table> 
       </div>
		<div class="row marketing">
        </div>
      <footer class="footer">
        <p>© Olumn 2015</p>
      </footer>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<%--    <script src="index4_files/ie10-viewport-bug-workaround.js"></script>--%>
</body>
</html>