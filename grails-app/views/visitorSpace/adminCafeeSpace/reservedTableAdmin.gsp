<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.joda.time.format.DateTimeFormatter" %>
<%@ page import="java.text.SimpleDateFormat" %>
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
            <li class="active"><a href="#">Бронирование<span class="sr-only">(current)</span></a></li>
            <li><g:link controller="VisitorSpace" action="setReservation">Настройка бронирования<span class="sr-only">(current)</span></g:link></li>
            <li><g:link controller="VisitorSpace" action="setupBillingSystem">Настройка оплаты</g:link></li>
            <li><g:link controller="VisitorSpace" action="editPrivateData">Редактирование личных данных</g:link></li>
          </ul>
       </div>
	  <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li><g:link action="index">Cведения о заведении</g:link></li>
              <li class="active"><g:link action="showReservedTableForAdmin">Информация о бронировании</g:link></li>
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
      <g:if test="${tableInfo.size() != 0 }">
     	<h3>Информация о бронировании</h3>
     	<div>    		
	      	<table class="table">
				<thead>
					<tr>
						<th>Имя пользователя</th>
						<th>Дата бронирования</th>
						<th>Время бронирования с</th>
						<th>Время бронирования до</th>
						<th>Зал</th>
						<th>Мест за столом</th>
					</tr>	
				</thead>
				<tbody>
					<g:each in="${tableInfo}" var="table">
						<tr>
							<td>${table.visitor.username}</td>
							<td>${new SimpleDateFormat("yyyy-MM-dd").format(table.getReservationDate()) }</td>
							<td>${table.getStartTimeLimit().toString(timeForm)}</td>
							<td>${table.getEndTimeLimit().toString(timeForm)}</td>
							<td>${table.getHall()}</td>
							<td>${table.getPlaces()}</td>
						</tr>
					</g:each>
				</tbody>
			</table>			
     	  </div>
     	</g:if>
		<g:else>
			В вашем ресторане пока нет забронированных столиков!
		</g:else> 
      </div>
		<div class="row marketing">
        </div>
      <footer class="footer">
        <p>© Olumn 2014</p>
      </footer>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="index4_files/ie10-viewport-bug-workaround.js"></script>
</body>
</html>