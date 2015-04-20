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
             <li role="presentation">Welcome <sec:loggedInUserInfo field="username"/></li>
	            <li role="presentation"><g:link controller="Logout" action="index">Выход</g:link></li>
          </ul>
        </nav>
        <h3 class="text-muted">Olumn</h3>
      </div>

      <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li><g:link controller="VisitorSpace" action="index">Бронирование <span class="sr-only">(current)</span></g:link></li>
            <li><g:link controller="VisitorSpace" action="setReservation">Настройка бронирования<span class="sr-only">(current)</span></g:link></li>
            <li><a href="#">Настройка оплаты<span class="sr-only">(current)</span></a></li>
            <li class="active"><a href="#">Редактирование личных данных</a></li>
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
	        <label for="login" class="sr-only">Логин</label>
	        <g:textField id="login" class="form-control" name="login" placeholder="Логин" value="${applicationContext.springSecurityService.principal.username}" required="" autofocus=""/>
	        <label for="firstName" class="sr-only">Ваше имя</label>
	        <g:textField id="firstName" class="form-control" name="firstName" placeholder="Ваше имя" var = "user" value="${user.firstName}" type="text"/>
	        <label for="lastName" class="sr-only">Вашa фамилия</label>
	        <g:textField id="lastName" class="form-control" name="lastName" placeholder="Вашa фамилия" var = "user" value="${user.lastName}" type="text"/>
	        
	        <label for="inputEmail" class="sr-only">Адрес эл. почты</label>
	        <g:textField id="inputEmail" class="form-control" name="email" placeholder="E-mail" var = "user" value="${user.email}" autofocus="" data-translatable-string="" type="email"/>
	        <label for="inputINN" class="sr-only">ИНН</label>
	        <g:textField id="inputINN" class="form-control" name="inn" placeholder="ИНН" var = "user" value="${user.inn}" autofocus="" data-translatable-string="INN" type="number"/>
	        <label for="inputPassword" class="sr-only">Пароль</label>
	        <g:passwordField id="inputPassword" class="form-control" name="password" placeholder="Пароль" var = "user" value="${user.password}" data-translatable-string="Password"/>
	        
	        <label for="confirmPassword" class="sr-only">Подтвердите пароль</label>
	        <g:passwordField id="confirmPassword" class="form-control" name="controlPassword" placeholder="Подтвердите пароль" var = "user" value="${user.password}" data-translatable-string="Password"/>
	        <g:actionSubmit value="Подтвердить изменения"  action="updateUserData" class="btn btn-lg btn-primary btn-block">Подтвердить изменения</g:actionSubmit>
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