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
        <div>
	  		<p><div>Неверный логин и(ли) пароль!</div></p>
	  		<p><div><a href="#" onclick="window.history.back();return false;">Назад</a></div></p>
  		</div>
      </div>

      <div class="footer">
        <p>© Olumn 2015</p>
      </div>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <%--<g:javascript library="start_page_bootstrap_files/ie-emulation-modes-warning"/> --%>
</body>
</html>