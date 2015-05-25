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
	  
	  <div>
	  	<g:form class="form-inline">
		  <div class="form-group">
		    <label class="sr-only">Поиск заведения по городам</label>
		    <p class="form-control-static">Поиск заведения по городам</p>
		  </div>
		  <div class="form-group">
		    <label for="city" class="sr-only">Город заведения</label>
		    <g:textField class="form-control" name="city" placeholder="Город заведения" value=""/>
		  </div>
		  <div class="form-group">
		    <label class="sr-only">по регионам</label>
		    <p class="form-control-static">Поиск заведения по регионам</p>
		  </div>
		  <div class="form-group">
		    <label for="city" class="sr-only">Регион заведения</label>
		    <g:textField class="form-control" name="region" placeholder="Регион заведения"/>
		  </div>
		  <g:actionSubmit value="Поиск заведений" action="searchCafee" class="btn btn-default">Поиск заведений</g:actionSubmit>
		</g:form>
	  </div>
	  
	  <hr>
	  
      <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="#">Бронирование<span class="sr-only">(current)</span></a></li>
            <li><g:link controller="VisitorSpace" action="editPrivateData">Редактирование личных данных</g:link></li>
          </ul>
       </div>
	  <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li><g:link controller="VisitorSpace" action="index">Бронировать столик</g:link></li>
              <li class="active"><a href="#">Просмотр забронированных мест</a></li>
              <li><a href="#">Редактировать бронирование</a></li>
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
      	<div>
      		<g:if test="${tableInfo.size() != 0}">
		      	<table class="table">
					<thead>
						<tr>
							<th>Название заведения</th>
							<th>Дата бронирования</th>
							<th>Время бронирования с</th>
							<th>Время бронирования до</th>
							<th>Зал</th>
							<th>Мест за столиком</th>
							<th>Оплачено</th>
							<th></th>
						</tr>	
					</thead>
					<tbody>
						<g:each in="${tableInfo}" var="table">
							<tr>
								<td>${table.cafeeName.cafeeName}</td>
								<td>${table.reservationDate}</td>
								<td>${table.startTimeLimit}</td>
								<td>
									<g:if test="${table.endTimeLimit != null}">
										${table.endTimeLimit}
									</g:if>
									<g:else>
										<p>-</p>
									</g:else>	
								</td>
								<td>${table.hall}</td>
								<td>${table.places}</td>
								<td>${table.cost}</td>
								<td><g:link action="deleteReservedTable" params="[cafeeName: "${table.cafeeName.cafeeName}", cafeeAPI: "${table.cafeeName.apiInit}",
								date: "${table.reservationDate }", startTime: "${table.startTimeLimit }", endTime: "${table.endTimeLimit }",
								placesAmount: "${table.places }", cost: "${table.cost }", hall: "${table.hall}"]">Отменить бронирование</g:link></td>
							</tr>
						</g:each>
					</tbody>
				</table>
			</g:if>
			<g:else>
				У вас не забронированного ни одного столика!
			</g:else>
      	</div> 
       </div>
		<div class="row marketing">
        </div>
      <footer class="footer">
        <p>© Olumn 2015</p>
      </footer>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="index4_files/ie10-viewport-bug-workaround.js"></script>
</body>
</html>