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
        <g:if test="${error == 1}">
        	<div>
		  		<p><div>Извините, бронирование в этом ресторане закрыто в данный момент</div></p>
		  		<p><div><a href="#" onclick="window.history.back();return false;">Назад</a></div></p>
	  		</div> 
	  	</g:if>
	  	<g:elseif test="${error == 2}">
	  		<p><div>Извините, места для резервации закончились</div></p>
	  		<p><div><a href="#" onclick="window.history.back();return false;">Назад</a></div></p> 
	  	</g:elseif>
	  	<g:elseif test="${error == 3}">
	  		<p><div>Извините, столы с выбранным количеством мест для резервации закончились</div></p>
	  		<p><div>Поищите другие столы</div></p>
	  		<p><div><a href="#" onclick="window.history.back();return false;">Назад</a></div></p> 
	  	</g:elseif>
	  	<g:elseif test="${error == 4}">
	  		<p><div>Время начала бронирования не может быть больше или равно времени конца бронирования</div></p>
	  		<p><div><a href="#" onclick="window.history.back();return false;">Назад</a></div></p> 
	  	</g:elseif>
	  	<g:elseif test="${error == 5}">
	  		<p><div>Вы можете забронировать место в этом ресторане в период с " ${stDate } до " ${endDate }"</div></p>
	  		<p><div><a href="#" onclick="window.history.back();return false;">Назад</a></div></p> 
	  	</g:elseif>
	  	<g:elseif test="${error == 6}">
	  		<p><div>Вы можете забронировать место в этом ресторане с " ${stTime } до " ${endTime }"</div></p>
	  		<p><div><a href="#" onclick="window.history.back();return false;">Назад</a></div></p> 
	  	</g:elseif>
	  	<g:elseif test="${error == 7}">
	  		<p><div>Пароли не совпадают!</div></p>
	  		<p><div><a href="#" onclick="window.history.back();return false;">Назад</a></div></p> 
	  	</g:elseif>
	  	<g:elseif test="${error == 8}">
	  		<p><div>Данные успешно обновлены!</div></p>
	  		<p><div><a href="#" onclick="window.history.back();return false;">Назад</a></div></p> 
	  	</g:elseif>
	  	<g:elseif test="${error == 9}">
	  		<p><div>Количество столов для бронирования не может быть больше общего количества столов!</div></p>
	  		<p><div><a href="#" onclick="window.history.back();return false;">Назад</a></div></p> 
	  	</g:elseif>
	  	<g:elseif test="${error == 10}">
	  		<p><div>Значение начала диапазона даты не может быть больше или равна значению конца диапазона даты!</div></p>
	  		<p><div><a href="#" onclick="window.history.back();return false;">Назад</a></div></p> 
	  	</g:elseif>
	  	<g:elseif test="${error == 11}">
	  		<p><div>Значение начала диапазона времени не может быть больше или равна значению конца диапазона времени!</div></p>
	  		<p><div><a href="#" onclick="window.history.back();return false;">Назад</a></div></p> 
	  	</g:elseif>
	  	<g:elseif test="${error == 12}">
	  		<p><div>Настройки ресторана успешно изменены!</div></p>
	  		<p><div><a href="#" onclick="window.history.back();return false;">Назад</a></div></p> 
	  	</g:elseif>
	  	<g:elseif test="${error == 13}">
	  		<p><div>Отказано в оплате!</div></p>
	  		<p><div>Недостаточно средств на счету!</div></p>
	  		<p><div><a href="#" onclick="window.history.back();return false;">Назад</a></div></p> 
	  	</g:elseif>
	  	<g:elseif test="${error == 14}">
	  		<p><div>Ошибка системы оплаты!</div></p>
	  		<p><div>Свяжитесь с вашим банком!</div></p>
	  		<p><div><a href="#" onclick="window.history.back();return false;">Назад</a></div></p> 
	  	</g:elseif>
	  	<g:elseif test="${error == 15}">
	  		<p><div>Ошибка заполнения полей!</div></p>
	  		<p><div>Проверьте правильность заполнения полей!</div></p>
	  		<p><div>Проверьте полноту заполнения полей!</div></p>
	  		<p><div><a href="#" onclick="window.history.back();return false;">Назад</a></div></p> 
	  	</g:elseif>
	  	<g:elseif test="${error == 16}">
	  		<p><div>Извините, это временная ошибка!</div></p>
	  		<p><div>Она будет исправлена в ближайшее время!</div></p>
	  		<p><div><a href="#" onclick="window.history.back();return false;">Назад</a></div></p> 
	  	</g:elseif>
	  	<g:elseif test="${error == 17}">
	  		<p><div>"${message }"</div></p>
	  		<p><div><a href="#" onclick="window.history.back();return false;">Назад</a></div></p> 
	  	</g:elseif>
	  	<g:elseif test="${error == 21}">
	  		<p><div>Данный столик недоступен!</div></p>
	  		<p><div>Выберите другие параметры!</div></p>
	  		<p><div><a href="#" onclick="window.history.back();return false;">Назад</a></div></p> 
	  	</g:elseif>
	  	<g:else>
	  		<p><div>Неизвестная ошибка!</div></p>
	  		<p><div><a href="#" onclick="window.history.back();return false;">Назад</a></div></p> 
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