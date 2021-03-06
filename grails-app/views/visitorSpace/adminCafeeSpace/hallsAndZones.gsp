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
               <li><g:link controller="VisitorSpace" action="setReservation">Редактирование<span class="sr-only">(current)</span></g:link></li>
               <li><g:link controller="VisitorSpace" action="tableAcounting">Учет столов</g:link></li>
               <li class = "active"><g:link controller="VisitorSpace" action="goToHallsAndZones">Залы и зоны</g:link></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>
            	
      <div class="jumbotron">
        <h3>Залы и зоны</h3>
        <g:if test="${halls.size() != 0}">
	        <div>
		      	<table class="table">
		      		<thead>
	      			  <tr>
	      			  	<td>Название зала/зоны</td>
	      			  	<td></td>
	      			  	<td></td>
	      			  </tr>
		      		</thead>
					<tbody>
						<g:each in="${halls}">
							<tr>
							  <td>${it.hallName}</td>
							  <td><g:link controller="VisitorSpace" action="editHall" params="[id: "${it.getId()}"]">Редактировать зал/зону</g:link></td>
							  <td><g:link controller="VisitorSpace" action="deleteHall" params="[hallName: "${it.hallName}"]">Удалить зал/зону</g:link></td>	
							</tr>
						</g:each>
					</tbody>
				</table>			
	     	</div>
     	</g:if>
     	<g:else>
     		<p>Нет информации о залах и зонах!</p>
     	</g:else>
		<g:form class="form-signin" controller="VisitorSpace">
		<div class="col-xs-4">
			<div class="text-left">
       			<small>Введите название зоны или зала</small>
       		</div>
	        <label for="hall" class="sr-only">Введите название зоны или зала</label>
	        <g:textField id="hall" class="form-control" name="hall" placeholder="Введите название зоны или зала" value="" type="text" required=""/>	    
	        <g:actionSubmit value="Добавить зал/зону"  action="addHall"/>
	    </div>    
      	</g:form>	
       </div>
		<div class="row marketing">
        </div>
      <footer class="footer">
        <p>© Olumn 2015</p>
      </footer>

    </div> <!-- /container -->
</body>
</html>