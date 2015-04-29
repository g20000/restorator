<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="grails.plugin.springsecurity.SpringSecurityService" %>
<%@ page import="grails.plugin.springsecurity.annotation.Secured" %>
<%@ page import="restorator.auth.Person" %>
<%@ page import="org.joda.time.LocalTime" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
	<meta name="layout" content="userSpace"/>
<title>Изменение личных данных</title>
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
        <h3 class="text-muted">Olumn</h3>
      </div>

      <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li><g:link controller="VisitorSpace" action="index">Бронирование <span class="sr-only">(current)</span></g:link></li>
            <li class="active"><g:link controller="VisitorSpace" action="setReservation">Настройка бронирования<span class="sr-only">(current)</span></g:link></li>
            <li><a href="#">Настройка оплаты<span class="sr-only">(current)</span></a></li>
            <li><g:link controller="VisitorSpace" action="editPrivateData">Редактирование личных данных</g:link></li>
          </ul>
       </div>
	  <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
               <li class="active"><a href="#">Редактирование<span class="sr-only">(current)</span></a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>	
      <div class="jumbotron">
        <h3>Редактирование информации о заведении</h3>
        <g:form class="form-signin" controller="VisitorSpace">
	        <label for="cafee" class="sr-only">Имя заведения</label>
	        <g:textField id="cafee" class="form-control" name="cafee" placeholder="Название заведения" value="${cafeeInfo.cafeeName}" required="" autofocus=""/>
	        <label for="totalPlaces" class="sr-only">Количество мест в заведении</label>
	        <g:textField id="totalPlaces" class="form-control" name="totalPlaces" placeholder="Количество мест в заведении" value="${cafeeInfo.totalPlaces}" type="number"/>
	        <label for="reservationPlaces" class="sr-only">Доступно мест для бронирования</label>
	        <g:textField id="reservationPlaces" class="form-control" name="reservationPlaces" placeholder="Доступно мест для бронирования" value="${cafeeInfo.totalReservationPlaces}" type="number"/>     
	        <label for="placePrice" class="sr-only">Цена за место</label>
	        <g:textField id="placePrice" class="form-control" name="placePrice" placeholder="Цена за место" value="${cafeeInfo.placeCost}" autofocus="" data-translatable-string="" type="number"/>
	        <label for="currencyType" class="sr-only">Тип принимаемой валюты</label>
	        <g:textField id="currencyType" class="form-control" name="currencyType" placeholder="Тип принимаемой валюты" value="${cafeeInfo.currencyType}" autofocus="" data-translatable-string="" type="string"/>
	        <label for="reservationAvailable" class="sr-only">Разрешить резервирование мест</label>
	        <div class="checkbox">
	        	<label>
	        		<g:checkBox name="reservationAvailable" value="${cafeeInfo.isReservationAvailable}"/>
	        		Разрешить резервирование мест
        		</label>
	        </div>
	        <div class="checkbox">
	        	<label>
	        		<g:checkBox name="timeLimitReservation" value="${cafeeInfo.reservationTimeLimit}"/>
	        		Ограничить резервирование мест по времени
        		</label>
	        </div>	        
	        <div class="checkbox">
	        	<label>
		        	<g:checkBox name="dateLimitReservation" value="${cafeeInfo.reservationDateLimit}"/>
		        	Ограничить резервирование мест по дате
	        	</label>
	        </div>
	        <div>
	        	<label>
	        		Начало ограничения по дате:
	        		<g:datePicker name="startDateReservation" value="${cafeeInfo.startDateLimit}" precision="day"/>
	        	</label>
	        </div>
	        <div>
	        	<label>
	        		Окончание ограничения по дате:
	        		<g:datePicker name="endDateReservation" value="${cafeeInfo.endDateLimit}" precision="day"/>
	        	</label>
	        </div>
	        <div>
	        	<label>
	        		Начало ограничения по времени:
	        		<joda:timePicker name="startTimeReservation" value="${cafeeInfo.startTimeLimit}" precision="hour"/>
	        	</label>
	        </div>
	        <div>
	        	<label>
	        		Конец ограничения по времени:
	        		<joda:timePicker name="endTimeReservation" value="${cafeeInfo.endTimeLimit}" precision="hour" />
	        	</label>
	        </div>
	        <g:actionSubmit value="Подтвердить изменения"  action="editReservation" class="btn btn-lg btn-primary btn-block">Подтвердить изменения</g:actionSubmit>
      	</g:form>	
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