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
            <li><g:link controller="VisitorSpace" action="setReservation">Настройка бронирования<span class="sr-only">(current)</span></g:link></li>
            <li><g:link controller="VisitorSpace" action="setupBillingSystem">Настройка оплаты</g:link></li>
            <li class="active"><g:link controller="VisitorSpace" action="editPrivateData">Редактирование личных данных</g:link></li>
          </ul>
       </div>
	  <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
               <li class="active"><a href="#">Редактирование<span class="sr-only">(current)</span></a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>	
      <div class="jumbotron">
        <h3>Редактирование личных данных</h3>
        <g:form class="form-signin" controller="VisitorSpace">
        	<div class="col-xs-4">
		        <label for="login" class="sr-only">Логин</label>
		        <div class="text-left">
	        		<small>Ваш логин</small>
	        	</div>
		        <g:textField id="login" class="form-control" name="login" placeholder="Логин" value="${applicationContext.springSecurityService.principal.username}" required="" autofocus=""/>
		        <div class="text-left">
	        		<small>Ваше имя</small>
	        	</div>
		        <label for="firstName" class="sr-only">Ваше имя</label>
		        <g:textField id="firstName" class="form-control" name="firstName" placeholder="Ваше имя" var = "user" value="${user.firstName}" type="text"/>
		        <div class="text-left">
	        		<small>Ваша фамилия</small>
	        	</div>
		        <label for="lastName" class="sr-only">Вашa фамилия</label>
		        <g:textField id="lastName" class="form-control" name="lastName" placeholder="Вашa фамилия" var = "user" value="${user.lastName}" type="text"/>
		        <div class="text-left">
	        		<small>Адрес эл. почты</small>
	        	</div>
		        <label for="inputEmail" class="sr-only">Адрес эл. почты</label>
		        <g:textField id="inputEmail" class="form-control" name="email" placeholder="E-mail" var = "user" value="${user.email}" autofocus="" data-translatable-string="" type="email"/>
		        <div class="text-left">
	        		<small>ИНН</small>
	        	</div>
		        <label for="inputINN" class="sr-only">ИНН</label>
		        <g:textField id="inputINN" class="form-control" name="inn" placeholder="ИНН" var = "user" value="${user.inn}" autofocus="" data-translatable-string="INN" type="number"/>
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
			        <label for="inputPassword" class="sr-only">Пароль</label>
			        <div class="text-left">
		        		<small>Пароль</small>
		        	</div>
			        <g:passwordField id="inputPassword" class="form-control" name="password" placeholder="Пароль" var = "user" value="" data-translatable-string="Password"/>
			        
			        <div class="text-left">
		        		<small>Подтвердите пароль</small>
		        	</div>
			        <label for="confirmPassword" class="sr-only">Подтвердите пароль</label>
			        <g:passwordField id="confirmPassword" class="form-control" name="controlPassword" placeholder="Подтвердите пароль" var = "user" value="" data-translatable-string="Password"/>
		        </div>
	        	<g:actionSubmit value="Подтвердить изменения"  action="updateUserData"/>
	        </div>
      	</g:form>	
       </div>
		<div class="row marketing">
        </div>
      <footer class="footer">
        <p>© Olumn 2014</p>
      </footer>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="index4_files/ie10-viewport-bug-workaround.js"></script>
</body>
</html>