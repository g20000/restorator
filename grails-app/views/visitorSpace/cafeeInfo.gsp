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
              <li class="active"><a href="#">Информация о заведении</a></li>
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
      	<g:form class="form-signin" controller="VisitorSpace">
      		<p>Название заведения: ${cafeeName.cafeeName}</p>
      		<g:if test="${halls.size() != 0}">
	        	<div>
	      			<label>
	      				Выберите желаемый зал:
	      				<g:select name="hallsAvailable" from="${halls}"/>
	      			</label>
      			</div>
	        </g:if>
      		<p>Цена за место: ${cafeeName.placeCost}</p>
      		<p>Тип принимаемой валюты: ${cafeeName.currencyType}</p>
      		<g:if test="${tableInfo.size() != 0}">
	      		<div>
	      			<label>
	      				Выберите подходящее для вас количество мест:
	      				<g:select name="tablePlacesAvailable" from="${tableInfo}" optionValue="${{it.placesInTableAmount}}" optionKey="placesInTableAmount" value=""/>
	      			</label>
	      		</div>
      		</g:if>
      		<div>
	        	<label>
	        		Выберите день бронирования:
	        		<g:datePicker name="reservationDate" value="${new Date()}" precision="day"/>
	        	</label>
	        </div>
	        <div>
	        	<label>
	        		Забронировать с:
	        		<joda:timePicker name="startTimeReservation" value="${new LocalTime()}" precision="minute"/>
	        	</label>
	        </div>
	        <g:if test="${cafeeName.endTimeLimit != null}">
		        <div>
		        	<label>
		        		до:
		        		<joda:timePicker name="endTimeReservation" value="${new LocalTime()}" precision="minute" />
		        	</label>
		        </div>
	        </g:if>      
	        <%--<g:hiddenField name="cafeeName" value="${cafeeName.cafeeName}" /> --%>
	        <g:hiddenField name="cafeeName" value="${cafeeName.cafeeName}" />
	        <g:hiddenField name="cafeeApiInit" value="${cafeeName.apiInit}" />
	        <g:hiddenField name="cafeePlaceCost" value="${cafeeName.placeCost}" />
	        <g:actionSubmit value="Забронировать"  action="makeReserve" class="btn btn-primary">Забронировать</g:actionSubmit>
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