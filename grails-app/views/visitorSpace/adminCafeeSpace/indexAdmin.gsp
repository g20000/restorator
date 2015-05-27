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
            <li class="active"><a href="#">Состояние бронирования<span class="sr-only">(current)</span></a></li>
            <li><g:link controller="VisitorSpace" action="setReservation">Настройка бронирования<span class="sr-only">(current)</span></g:link></li>
            <li><g:link controller="VisitorSpace" action="setupBillingSystem">Настройка оплаты</g:link></li>
            <li><g:link controller="VisitorSpace" action="editPrivateData">Редактирование личных данных</g:link></li>
          </ul>
       </div>
	  <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="active"><a href="#">Cведения о заведении</a></li>
              <li><g:link action="showReservedTableForAdmin">Информация о бронировании</g:link></li>
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
      	<g:each in="${placeinfo}" var="cafeeInfo">
      		<table class="table">
	      		<tbody>
	      			<tr>
			      		<td>Название заведения</td><td>${cafeeInfo.cafeeName}</td>
			      	</tr>
			      	<tr>
			      		<td>Мест в заведении</td><td>${cafeeInfo.totalPlaces}</td>
			      	</tr>
			      	<tr>
			      		<td>Доступно мест для бронирования</td><td>${cafeeInfo.totalReservationPlaces}</td>
			      	</tr>
			      	<tr>
			      		<td>Цена за место</td><td>${cafeeInfo.placeCost}</td>
			      	</tr>
			      	<tr>
			      		<td>Тип принимаемой валюты</td><td>${cafeeInfo.currencyType}</td>
			      	</tr>
		      	
			      	<g:if test="${cafeeInfo.isReservationAvailable}">
			      		<tr>
			      			<td>Бронирование</td><td>включено</td>
			      		</tr>
			      		<g:if test="${cafeeInfo.reservationTimeLimit}">
			      			<tr>
					      		<td>Ограничение бронирования по времени</td><td>включено</td>
					      	</tr>
			      		</g:if>
			      		<g:if test="${cafeeInfo.reservationDateLimit}">
				      		<tr>
					      		<td>Ограничение бронирования по дате</td><td>включено</td>
					      	</tr>
				      	</g:if>
				      	<g:if test="${cafeeInfo.reservationTimeLimit}">
				      		<tr>
					      		<td>Начало ограничения бронирования по времени</td><td>${cafeeInfo.startTimeLimit}</td>
					      	</tr>
					      	<tr>
					      		<td>Конец ограничения бронирования по времени</td><td>${cafeeInfo.endTimeLimit}</td>
					      	</tr>
				      	</g:if>
				      	<g:if test="${cafeeInfo.reservationDateLimit}">		      	
					      	<tr>
					      		<td>Начало ограничения бронирования по дате</td><td>${cafeeInfo.startDateLimit}</td>
					      	</tr>
					      	<tr>
					      		<td>Конец ограничения бронирования по дате</td><td>${cafeeInfo.endDateLimit}</td>
					      	</tr>
				      	</g:if>
			      	</g:if>
			      	<g:else>
				    	<tr>
			      			<td>Бронирование</td><td>отключено</td>
			      		</tr>
				    </g:else>
		    </tbody>
	      	</table>	      	
      	</g:each>
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