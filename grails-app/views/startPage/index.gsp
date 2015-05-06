<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
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
		    <label class="sr-only">Поиск заведения по городам</label>
		    <p class="form-control-static">Поиск заведения по городам</p>
		  </div>
		  <div class="form-group">
		    <label for="city" class="sr-only">Город заведения</label>
		    <g:textField class="form-control" name="city" placeholder="Город заведения"/>
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
		
      <div class="jumbotron">
       <div class="imageTable">
        <div class="imageRow">	
              <div class="pictureItem">
              	<g:link action="searchCafee" params="[city: "Москва"]"><g:img dir="images" file="moscow3_w_200.png"/></g:link>
            </div>
              <div class="pictureItem">
              	<g:link action="searchCafee" params="[city: "Санкт Петербург"]"><g:img dir="images" file="piter.png"/></g:link>
            </div>
              <div class="pictureItem">
              	<g:link action="searchCafee" params="[city: "Новосибирск"]"><g:img dir="images" file="novosibirsk_web.png"/></g:link>
            </div>
        </div>
          <div class="imageRow">
           	  <div class="pictureItem">
              	<g:link action="searchCafee" params="[city: "Нижний Новгород"]"><g:img dir="images" file="novgorod_web.png"/></g:link>
            </div>
              <div class="pictureItem">
              	<g:link action="searchCafee" params="[city: "Екатеринбург"]"><g:img dir="images" file="Yekaterinburg_web.png"/></g:link>
            </div>
              <div class="pictureItem">
              	<g:link action="searchCafee" params="[city: "Самара"]"><g:img dir="images" file="Samara01_web.png"/></g:link>
            </div>	
           </div>
        </div>
      </div>

      <div class="row marketing">
        <div id="popularCitiesList">
          <div class="popularCitiesListItem">
          	<ul>
            	<li><g:link action="searchCafee" params="[city: "Нижний Новгород"]">Архангельск</g:link></li>
                <li>Белгород</li>
                <li>Брянск</li>
                <li>Владимир</li>
                <li>Геленджик</li>
                <li>Дмитров</li>
            </ul>
          </div>
          <div class="popularCitiesListItem">
          	<ul>
            	<li>Екатеринбург</li>
                <li>Зарайск</li>
                <li>Звенигород</li>
                <li>Ижевск</li>
                <li>Йошкар-Ола</li>
                <li>Казань</li>
            </ul
          ></div>
          <div class="popularCitiesListItem">
          	<ul>
            	<li>Киров</li>
                <li>Липецк</li>
                <li>Лазаревское</li>
                <li><g:link action="searchCafee" params="[city: "Москва"]">Москва</g:link></li>
                <li>Мурманск</li>
                <li>Нижний Новгород</li>
            </ul
          ></div>
          <div class="popularCitiesListItem">
          	<ul>
            	<li>Новосибирск</li>
                <li>Новороссийск</li>
                <li>Омск</li>
                <li>Петрозаводск</li>
                <li>Самара</li>
                <li>Санкт-Петербург</li>
            </ul>
          </div>
        </div>
      </div>

      <div class="footer">
        <p>© Olumn 2015</p>
      </div>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <g:javascript library="start_page_bootstrap_files/ie-emulation-modes-warning"/>
</body>
</html>