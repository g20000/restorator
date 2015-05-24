<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="grails.plugin.springsecurity.SpringSecurityService" %>
<%@ page import="grails.plugin.springsecurity.annotation.Secured" %>
<%@ page import="restorator.auth.Person" %>
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
            <li class="active"><a href="#">Редактирование личных данных</a></li>
          </ul>
       </div>
	  <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="active"><a href="#">Редактирование личных данных</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>	
      <div class="jumbotron">
        <h3>Редактирование личных данных</h3>
        <g:form class="form-signin" controller="VisitorSpace">
	        <label for="login" class="sr-only">Логин</label>
	        <div class="col-xs-4">
	        	<div class="text-left">
	        		<small>Ваш логин</small>
	        	</div>
	        	<g:textField id="login" class="form-control" name="login" placeholder="Логин" value="${applicationContext.springSecurityService.principal.username}" required="" autofocus=""/>
	        	<div class="text-left">	        
		        	<small>Ваше имя</small>
		        </div>
		        <g:textField id="firstName" class="form-control" name="firstName" placeholder="Ваше имя" var = "user" value="${user.firstName}" type="text"/>
		        
		        <div class="text-left">
		        	<small>Вашa фамилия</small>
		        </div>
		        <g:textField id="lastName" class="form-control" name="lastName" placeholder="Вашa фамилия" var = "user" value="${user.lastName}" type="text"/>
		        
		        <div class="text-left">
		        	<small>Адрес эл. почты</small>
		        </div>
		        <g:textField id="inputEmail" class="form-control" name="email" placeholder="Адрес эл. почты" var = "user" value="${user.email}" autofocus="" data-translatable-string="Email address" type="email"/>
		        <div class="checkbox">
				   <label>
				   	<g:checkBox class="isChangePasswordRequired" name="isChangePasswordRequired" value="${false}"/>Требуется смена пароля
				   </label>
				</div>
				<script type="text/javascript">
					$(document).ready(function(){
						$(".passwordFields").hide();
						$('.checkbox input:checkbox').click(function() {
						    var $this = $(this);
						    if ($this.is(':checked')) {
						        $(".passwordFields").show();
						    } else {
						        $(".passwordFields").hide();
						    }
						});
					});
				</script>
				<div class="passwordFields">
			        <div class="text-left">
			        	<small>Пароль</small>
			        </div>
			        <g:passwordField id="inputPassword" class="form-control" name="password" placeholder="Пароль" var = "user" value="" data-translatable-string="Password"/>
			        
			        <div class="text-left">
			        	<small>Подтвердите пароль</small>
			        </div>
			        <g:passwordField id="confirmPassword" class="form-control" name="controlPassword" placeholder="Подтвердите пароль" var = "user" value="" data-translatable-string="Password"/>
		        </div>
		        <g:actionSubmit value="Подтвердить изменения"  action="updateUserData"/>
	        </div>
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