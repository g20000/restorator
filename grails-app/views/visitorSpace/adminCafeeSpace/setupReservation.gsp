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
            <li><g:link controller="VisitorSpace" action="index">Бронирование <span class="sr-only">(current)</span></g:link></li>
            <li class="active"><g:link controller="VisitorSpace" action="setReservation">Настройка бронирования<span class="sr-only">(current)</span></g:link></li>
            <li><g:link controller="VisitorSpace" action="setupBillingSystem">Настройка оплаты</g:link></li>
            <li><g:link controller="VisitorSpace" action="editPrivateData">Редактирование личных данных</g:link></li>
          </ul>
       </div>
	  <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
               <li class="active"><g:link controller="VisitorSpace" action="setReservation">Редактирование<span class="sr-only">(current)</span></g:link></li>
               <li><g:link controller="VisitorSpace" action="tableAcounting">Учет столов<span class="sr-only">(current)</span></g:link></li>
               <li><g:link controller="VisitorSpace" action="goToHallsAndZones">Залы и зоны</g:link></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>	
      <div class="jumbotron">
        <h3>Редактирование информации о заведении</h3>
        <g:form class="form-signin" controller="VisitorSpace">		
			<div class="cafeeFields">
				<script type="text/javascript">
				    $(document).ready(function(){
						$("#textFields").css("margin-right", "40px");
						$("#textFields").height($("#settersTimeAndChb").height());					
					});
			    </script>
				<div class="col-xs-4" id="textFields">
					<div class="text-left">
	        			<small>Имя заведения</small>
	        		</div>			        
			        <label for="cafee" class="sr-only">Имя заведения</label>
			        <g:textField id="cafee" class="form-control" name="cafee" placeholder="Название заведения" value="${cafeeInfo.cafeeName}" required="" autofocus=""/>
			        <div class="text-left">
	        			<small>Тип принимаемой валюты</small>
	        		</div>
			        <label for="currencyType" class="sr-only">Тип принимаемой валюты</label>
			        <g:textField id="currencyType" class="form-control" name="currencyType" placeholder="Тип принимаемой валюты" value="${cafeeInfo.currencyType}" autofocus="" data-translatable-string="" type="string"/>
			        <g:if test="${cafeeInfo.availablePaymentSystems.isEmpty()}">
			        	<div>
			        		<small>Для возможности бронирования</small>
			        		<small>вам необходимо выбрaть как минимум одну систему оплаты!</small>
			        	</div>
			        </g:if>
			        <g:if test="${tableAvailable.isEmpty()}">
			        	<div>
			        		<small>Для возможности бронирования</small>
			        		<small>вам необходимо иметь столы для бронирования</small>
			        		<small>в вашем заведении!</small>
			        	</div>
			        </g:if>
			    </div>
			    <div class="text-left" id="settersTimeAndChb">
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
			    </div>
	        </div>
	         <g:if test="${(!tableAvailable.isEmpty()) && (!cafeeInfo.availablePaymentSystems.isEmpty())}">
	        	<div class="col-xs-4" id="subButton">
	        		<g:actionSubmit value="Подтвердить изменения"  action="editReservation"/>
	            </div>
	        </g:if>
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