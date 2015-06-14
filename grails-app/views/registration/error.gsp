<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<meta name="layout" content="wrapBody"/>
<title>Сообщение</title>
</head>
<body>
  <div class="container">	
      <div class="header clearfix">
        <nav>
          <ul class="nav nav-pills pull-right">
          	<sec:ifNotLoggedIn>
            	<li role="presentation" class="active"><g:link controller="Registration" action="index">Зарегистрироваться</g:link></li>
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
				
	  <script type="text/javascript">
		$(document).ready(function(){
			jQuery('.jumbotron').css("text-align", "left");
			jQuery('.jumbotron').css("padding-left", "20px");
			jQuery('.jumbotron').css("line-height", "0.5em");
		});
	  </script>
	  	
      <div class="jumbotron">
        <g:if test="${error == 18}">
        	<div>
		  		<p><div>В системе уже существует пользователь с подобным e-mail или логином</div></p>
		  		<p><div><a href="#" onclick="javascript:window.history.back();">Назад</a></div></p>
	  		</div> 
	  	</g:if>
	  	<g:elseif test="${error == 19}">
	  		<p><div>Извините, места для резервации закончились</div></p>
	  		<p><div><a href="#" onclick="javascript:window.history.back();">Назад</a></div></p> 
	  	</g:elseif>
	  	<g:elseif test="${error == 20}">
	  		<p><div>Регистрация успешно завершена</div></p>
	  		<p><div><a href="#" onclick="javascript:window.history.back();">Назад</a></div></p> 
	  	</g:elseif>
	  	<g:else>
	  		<p><div>Неизвестная ошибка!</div></p>
	  		<p><div><a href="#" onclick="javascript:window.history.back();">Назад</a></div></p> 
	  	</g:else>
      </div>

      <div class="footer">
        <p>© Olumn 2015</p>
      </div>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <%--<g:javascript library="start_page_bootstrap_files/ie-emulation-modes-warning"/> --%>
</body>
</html>