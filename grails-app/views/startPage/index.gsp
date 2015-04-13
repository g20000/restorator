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
            <li role="presentation" class="active"><g:link controller="Registration" action="index">Зарегестрироваться</g:link></li>
            <li role="presentation"><g:link controller="VisitorSpace" action="index">Войти</g:link></li>
          </ul>
        </nav>
        <h3 class="text-muted">Olumn</h3>
      </div>

      <div class="jumbotron">
       <div class="imageTable">
        <div class="imageRow">	
              <div class="pictureItem">
              	<g:img dir="images" file="moscow3_w_200.png"/>
            </div>
              <div class="pictureItem">
              	<g:img dir="images" file="piter.png"/>
            </div>
              <div class="pictureItem">
              	<g:img dir="images" file="novosibirsk_web.png"/>
            </div>
        </div>
          <div class="imageRow">
           	  <div class="pictureItem">
              	<g:img dir="images" file="novgorod_web.png"/>
            </div>
              <div class="pictureItem">
              	<g:img dir="images" file="Yekaterinburg_web.png"/>
            </div>
              <div class="pictureItem">
              	<g:img dir="images" file="Samara01_web.png"/>
            </div>	
           </div>
        </div>
      </div>

      <div class="row marketing">
        <div id="popularCitiesList">
          <div class="popularCitiesListItem">
          	<ul>
            	<li>Архангельск</li>
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
                <li>Москва</li>
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
        <p>© Olumn 2014</p>
      </div>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <g:javascript library="start_page_bootstrap_files/ie-emulation-modes-warning"/>
</body>
</html>