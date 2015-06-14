<!DOCTYPE html>
<html xml:lang="ru" lang="ru"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="http://getbootstrap.com/favicon.ico">

    <title>Вход</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.css') }" type="text/css">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="${resource(dir: 'css/reg_page_files', file: 'signing.css') }" type="text/css">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <g:javascript library="reg_page_files/analytics"/>
<%--    <g:javascript library="reg_page_files/ie-emulation-modes-warning"/>--%>
    
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  <script>(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)})(window,document,'script','//www.google-analytics.com/analytics.js','ga');ga('create', 'UA-30526439-1', 'oneskyapp.com');ga('send', 'pageview');</script><meta class="os-tdn" http-equiv="Content-Language" content="ru"><meta class="os-tdn" property="og:locale" content="ru"><link href="index2_files/onesky-client.css" type="text/css" rel="stylesheet"><link href="index2_files/bootstrap_in-context.css" type="text/css" rel="stylesheet"><link href="index2_files/onesky-editor-theme.css" type="text/css" rel="stylesheet"></head>

  <body>

    <div class="container">

      <form class="form-signin" action='/restorator/j_spring_security_check' method='POST' id='loginForm'>
        <h2 class="form-signin-heading">Вход</h2>
        <div class="text-left">
   			<small>Логин</small>
   		</div>        
        <label for="username" class="sr-only">Логин</os-p></label>
        <input id="username" name='j_username' class="form-control" placeholder="Логин" required="" autofocus="" type="text">
        <div class="text-left">
   			<small>Пароль</small>
   		</div>
        <label for="password" class="sr-only">Пароль</label>
        <input id="password" class="form-control" name='j_password' data-translatable-string="Password" type="password">
        <div class="checkbox">
          <label data-replace-tmp-key="2c2fb6d9630510f8721fb57d8c90d50c"><os-p key="2c2fb6d9630510f8721fb57d8c90d50c"><input value="remember-me" type="checkbox" class='chk' name='_spring_security_remember_me' id='remember_me'>Запомнить меня</os-p></label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit"  id="submit" >Войти</button>
      </form>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<%--    <g:javascript library="reg_page_files/ie10-viewport-bug-workaround"/>--%>
  <script type="text/javascript">OneSkyClientConfig = {apiKey: "U9aDnPz49ouz8J2CjMcAz74GppvQBGym",project: 19540,translate: true,locale: "ru",xdReceiver: "http://www.oneskyapp.com/docs/xd_receiver.html"};</script>
<g:javascript library="reg_page_files/loader"/>

</body></html>