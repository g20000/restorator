<!DOCTYPE html>
<html xml:lang="ru" lang="ru"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="http://getbootstrap.com/favicon.ico">

    <title>Регистрация</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.css') }" type="text/css">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="${resource(dir: 'css/reg_page_files', file: 'signing.css') }" type="text/css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".adminFields").hide();
			$('.checkbox input:checkbox').click(function() {
			    var $this = $(this);
			    if ($this.is(':checked')) {
			        $(".adminFields").show();
			    } else {
			        $(".adminFields").hide();
			    }
			});
		});
	</script>
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <!--<g:javascript library="reg_page_files/analytics"/>
    <g:javascript library="reg_page_files/ie-emulation-modes-warning"/>-->
    
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  <script>(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)})(window,document,'script','//www.google-analytics.com/analytics.js','ga');ga('create', 'UA-30526439-1', 'oneskyapp.com');ga('send', 'pageview');</script><meta class="os-tdn" http-equiv="Content-Language" content="ru"><meta class="os-tdn" property="og:locale" content="ru"><link href="index2_files/onesky-client.css" type="text/css" rel="stylesheet"><link href="index2_files/bootstrap_in-context.css" type="text/css" rel="stylesheet"><link href="index2_files/onesky-editor-theme.css" type="text/css" rel="stylesheet">
  </head>

  <body>

    <div class="container">

      <g:form class="form-signin" controller="Registration">
        <h2 class="form-signin-heading">Регистрация</h2>
        <label for="login" class="sr-only">Логин</label>
        <g:textField id="login" class="form-control" name="login" placeholder="Логин" required="" autofocus=""/>
        <label for="firstName" class="sr-only">Ваше имя</label>
        <g:textField id="firstName" class="form-control" name="firstName" placeholder="Ваше имя" required="" type="text"/>
        <label for="lastName" class="sr-only">Вашa фамилия</label>
        <g:textField id="lastName" class="form-control" name="lastName" placeholder="Вашa фамилия" required=""  type="text"/>        
        <label for="inputEmail" class="sr-only">Адрес эл. почты</label>
        <g:textField id="inputEmail" class="form-control" name="email" placeholder="Адрес эл. почты" required="" autofocus="" data-translatable-string="Email address" type="email"/>
        <label for="inputPassword" class="sr-only">Пароль</label>
        <g:passwordField id="inputPassword" class="form-control" name="password" placeholder="Пароль" required="" data-translatable-string="Password"/>
        
        <label for="confirmPassword" class="sr-only">Подтвердите пароль</label>
        <g:passwordField id="confirmPassword" class="form-control" name="controlPassword" placeholder="Подтвердите пароль" required="" data-translatable-string="Password"/>
		<div class="checkbox">
		   <label>
		   	<g:checkBox class="isAdminCafee" name="isAdminCafee" value="${false}"/>Зарегестриваться как администратор заведения
		   </label>
		</div>
		<div class="adminFields">
		  <label for="cafee" class="sr-only">Название заведения</label>
	      <g:textField id="cafee" class="form-control" name="cafeeName" value="" placeholder="Название заведения" type="text"/>
	      <label for="innName" class="sr-only">ИНН</label>
	      <g:textField id="innName" class="form-control" name="inn" value="" placeholder="ИНН" type="text"/>	      
	      <label for="cafeeRegion" class="sr-only">Регион</label>
	      <g:textField id="cafeeRegion" class="form-control" name="region" value="" placeholder="Регион" type="text"/>
	      <label for="cafeeCity" class="sr-only">Город</label>
	      <g:textField id="cafeeCity" class="form-control" name="city" value="" placeholder="Город" type="text"/>
		</div>
        <g:actionSubmit value="Зарегестрироваться"  action="saveUser" class="btn btn-lg btn-primary btn-block">Зарегестрироваться</g:actionSubmit>
      </g:form>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <g:javascript library="reg_page_files/ie10-viewport-bug-workaround"/>
  <script type="text/javascript">OneSkyClientConfig = {apiKey: "U9aDnPz49ouz8J2CjMcAz74GppvQBGym",project: 19540,translate: true,locale: "ru",xdReceiver: "http://www.oneskyapp.com/docs/xd_receiver.html"};</script>
<g:javascript library="reg_page_files/loader"/>

</body></html>