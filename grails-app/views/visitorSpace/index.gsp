<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
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
		    <label class="sr-only">Поиск ресторана по городам</label>
		    <p class="form-control-static">Поиск ресторана по городам</p>
		  </div>
		  <div class="form-group">
		    <label for="city" class="sr-only">Город ресторана</label>
		    <g:textField class="form-control" name="city" placeholder="Город ресторана" value=""/>
		  </div>
		  <div class="form-group">
		    <label class="sr-only">по названию</label>
		    <p class="form-control-static">Поиск ресторана по названию</p>
		  </div>
		  <div class="form-group">
		    <label for="city" class="sr-only">Название ресторана</label>
		    <g:textField class="form-control" name="region" placeholder="Название ресторана"/>
		  </div>
		  <g:actionSubmit value="Начать поиск" action="searchCafee" class="btn btn-default">Начать поиск</g:actionSubmit>
		</g:form>
	  </div>
	  
	  <hr>
	  
      <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><g:link controller="VisitorSpace" action="index">Бронирование <span class="sr-only">(current)</span></g:link></li>
            <li><g:link controller="VisitorSpace" action="editPrivateData">Редактирование личных данных</g:link></li>
          </ul>
       </div>
              
	  <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="active"><g:link controller="VisitorSpace" action="index">Бронировать столик</g:link></li>
              <li><g:link controller="VisitorSpace" action="showReservedTableForVisitor">Просмотр забронированных мест</g:link></li>
<%--              <li><a href="#">Редактировать бронирование</a></li>--%>
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
	      	<table class="table">
				<thead>
					<tr>
						<th>Название ресторана</th>
						<th>Цена за место</th>
						<th>Тип принимаемой валюты</th>
					</tr>	
				</thead>
				<tbody>
					<g:each in="${availableCafee}" var="cafeeInfo">
						<tr>
							<td><g:link action="goToCafeePage" params="[cafeeName: "${cafeeInfo.cafeeName}", cafeeApiInit: "${cafeeInfo.apiInit}"]">${cafeeInfo.cafeeName}</g:link></td>
							<td>${cafeeInfo.getCity()}</td>
							<td>${cafeeInfo.getRegion()}</td>
						</tr>
					</g:each>
				</tbody>
			</table>			
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