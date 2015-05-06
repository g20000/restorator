<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
	<meta name="layout" content="wrapBody"/>
<title>Insert title here</title>
</head>
<body>
  <div class="container">	
      <div class="header clearfix">
        <nav>
          <ul class="nav nav-pills pull-right">
            <sec:ifNotLoggedIn>
            	<li role="presentation" class="active"><g:link controller="Registration" action="index">Зарегестрироваться</g:link></li>
            	<li role="presentation"><g:link controller="VisitorSpace" action="index">Войти</g:link></li>
            </sec:ifNotLoggedIn>
            <sec:ifLoggedIn>
            	<li role="presentation"><g:link controller="VisitorSpace" action="index"><sec:loggedInUserInfo field="username"/></g:link></li>
	            <li role="presentation"><g:link controller="Logout" action="index">Выход</g:link></li>
            </sec:ifLoggedIn>
          </ul>
        </nav>
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
					<th>Название заведения</th>
					<th>Цена за место</th>
					<th>Тип принимаемой валюты</th>
				</tr>	
			</thead>
			<tbody>
				<g:each in="${goalCafee}" var="cafeeInfo">
					<tr>
						<td><g:link action="goToCafeePage" params="[cafeeName: "${cafeeInfo.cafeeName}"]">${cafeeInfo.cafeeName}</g:link></td>
						<td>${cafeeInfo.placeCost}</td>
						<td>${cafeeInfo.currencyType}</td>
					</tr>
				</g:each>
			</tbody>
		</table>			
      	</div>
      </div>

      <div class="footer">
        <p>© Olumn 2014</p>
      </div>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <g:javascript library="start_page_bootstrap_files/ie-emulation-modes-warning"/>
</body>
</html>