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
		  <g:actionSubmit value="Поиск ресторана" action="searchCafee" class="btn btn-default">Поиск ресторанов</g:actionSubmit>
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
       	<g:if test="${goalCafee.size() != 0 }">   	
      	<table class="table">
			<thead>
				<tr>
					<th>Название ресторана</th>
					<th>Город рестарана</th>
					<th>Регион ресторана</th>
				</tr>	
			</thead>
			<tbody>
				<g:each in="${goalCafee}" var="cafeeInfo">
					<tr>
						<td><g:link action="goToCafeePage" params="[cafeeName: "${cafeeInfo.cafeeName}", cafeeApiInit: "${cafeeInfo.apiInit}"]">${cafeeInfo.cafeeName}</g:link></td>
						<td>${cafeeInfo.city}</td>
						<td>${cafeeInfo.region}</td>
					</tr>
				</g:each>
			</tbody>
		</table>
		</g:if>
		<g:else>
			Не найдено ресторанов по вашему запросу!
		</g:else>			
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