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
	            <li role="presentation">Welcome <sec:loggedInUserInfo field="username"/></li>
	            <li role="presentation"><g:link controller="Logout" action="index">Выход</g:link></li>
          </ul>
        </nav>
        <h3 class="text-muted"><g:link controller="StartPage" action="index">Olumn</g:link></h3>
      </div>

      <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="#">Состояние бронирования<span class="sr-only">(current)</span></a></li>
            <li><g:link controller="VisitorSpace" action="setReservation">Настройка бронирования<span class="sr-only">(current)</span></g:link></li>
            <li><a href="#">Настройка оплаты<span class="sr-only">(current)</span></a></li>
            <li><g:link controller="VisitorSpace" action="editPrivateData">Редактирование личных данных</g:link></li>
          </ul>
       </div>
	  <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li><g:link action="index">Cведения о заведении</g:link></li>
              <li class="active"><a href="#">Информация о бронировании</a></li>
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
     	<h3>Информация о бронировании</h3>
     	<div>
	      	<table class="table">
				<thead>
					<tr>
						<th>Имя пользователя</th>
						<th>Дата бронирования</th>
						<th>Время бронирования с</th>
						<th>Время бронирования до</th>
					</tr>	
				</thead>
				<tbody>
					<g:each in="${tableInfo}" var="table">
						<tr>
							<td>${table.visitor.username}</td>
							<td>${table.reservationDate}</td>
							<td>${table.startTimeLimit}</td>
							<td>${table.endTimeLimit}</td>
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
    <script src="index4_files/ie10-viewport-bug-workaround.js"></script>
</body>
</html>