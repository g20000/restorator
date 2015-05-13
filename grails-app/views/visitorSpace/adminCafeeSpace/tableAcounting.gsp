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
            <li><a href="#">Настройка оплаты<span class="sr-only">(current)</span></a></li>
            <li><g:link controller="VisitorSpace" action="editPrivateData">Редактирование личных данных</g:link></li>
          </ul>
       </div>
	  <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
               <li><g:link controller="VisitorSpace" action="setReservation">Редактирование<span class="sr-only">(current)</span></g:link></li>
               <li class="active"><a href="#">Учет столов<span class="sr-only">(current)</span></a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>	
      <div class="jumbotron">
        <h3>Учет столов</h3>
        <div>
	      	<table class="table">
				<thead>
					<tr>
						<th>Мест за столом</th>
						<th>Из них доступно для бронирования</th>
						<th>Всего столов</th>
						<th></th>
					</tr>	
				</thead>
				<tbody>
					<g:each in="${tableInfo}" var="table">
						<tr>
							<td>${table.placesInTableAmount}</td>
							<td>${table.tableForReservationAmount}</td>
							<td>${table.tableAmount}</td>
							<td><g:link controller="VisitorSpace" action="deleteTableAdmin" params="[placesInTable: "${table.placesInTableAmount}", tablesForReservation: "${table.tableForReservationAmount}", totalTables: "${table.tableAmount}"]">Удалить столик</g:link></td>
						</tr>
					</g:each>
				</tbody>
			</table>			
     	</div>
		<g:form class="form-signin" controller="VisitorSpace">
	        <label for="placesInTable" class="sr-only">Сколько мест за столом?</label>
	        <g:textField id="placesInTable" class="form-control" name="placesInTable" placeholder="Сколько мест за столом?" value="" type="number"/>     
	        <label for="availableForReservation" class="sr-only">Из них доступно для бронирования</label>
	        <g:textField id="availableForReservation" class="form-control" name="availableForReservation" placeholder="Из них доступно для бронирования" value="" autofocus="" data-translatable-string="" type="number"/>
	        <label for="defTableAmount" class="sr-only">Всего столов</label>
	        <g:textField id="defTableAmount" class="form-control" name="defTableAmount" placeholder="Всего столов" value="" autofocus="" data-translatable-string="" type="number"/>
	        <g:actionSubmit value="Добавить столик"  action="addTable" class="btn btn-lg btn-primary btn-block">Подтвердить изменения</g:actionSubmit>
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