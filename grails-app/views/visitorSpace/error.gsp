<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>Сообщение</title>
</head>
<body>
	<g:if test="${error == 1}">
  		<p>Извините, бронирование в этом ресторане закрыто в данный момент</p>
  		<p><a href="#" onclick="javascript:window.history.back();">Назад</a></p> 
  	</g:if>
  	<g:elseif test="${error == 2}">
  		<p>Извините, места для резервации закончились</p>
  		<p><a href="#" onclick="javascript:window.history.back();">Назад</a></p> 
  	</g:elseif>
  	<g:elseif test="${error == 3}">
  		<p>Извините, столы с выбранным количеством мест для резервации закончились</p>
  		<p>Поищите другие столы</p>
  		<p><a href="#" onclick="javascript:window.history.back();">Назад</a></p> 
  	</g:elseif>
  	<g:elseif test="${error == 4}">
  		<p>Время начала бронирования не может быть больше или равно времени конца бронирования</p>
  		<p><a href="#" onclick="javascript:window.history.back();">Назад</a></p> 
  	</g:elseif>
  	<g:elseif test="${error == 5}">
  		<p>Вы можете забронировать место в этом ресторане в период с " ${stDate } до " ${endDate }"</p>
  		<p><a href="#" onclick="javascript:window.history.back();">Назад</a></p> 
  	</g:elseif>
  	<g:elseif test="${error == 6}">
  		<p>Вы можете забронировать место в этом ресторане с " ${stTime } до " ${endTime }"</p>
  		<p><a href="#" onclick="javascript:window.history.back();">Назад</a></p> 
  	</g:elseif>
  	<g:elseif test="${error == 7}">
  		<p>Пароли не совпадают!</p>
  		<p><a href="#" onclick="javascript:window.history.back();">Назад</a></p> 
  	</g:elseif>
  	<g:elseif test="${error == 8}">
  		<p>Данные успешно обновлены!</p>
  		<p><a href="#" onclick="javascript:window.history.back();">Назад</a></p> 
  	</g:elseif>
  	<g:elseif test="${error == 9}">
  		<p>Количество столов для бронирования не может быть больше общего количества столов!</p>
  		<p><a href="#" onclick="javascript:window.history.back();">Назад</a></p> 
  	</g:elseif>
  	<g:elseif test="${error == 10}">
  		<p>Значение начала диапазона даты не может быть больше или равна значению конца диапазона даты!</p>
  		<p><a href="#" onclick="javascript:window.history.back();">Назад</a></p> 
  	</g:elseif>
  	<g:elseif test="${error == 11}">
  		<p>Значение начала диапазона времени не может быть больше или равна значению конца диапазона времени!</p>
  		<p><a href="#" onclick="javascript:window.history.back();">Назад</a></p> 
  	</g:elseif>
  	<g:elseif test="${error == 12}">
  		<p>Настройки ресторана успешно изменены!</p>
  		<p><a href="#" onclick="javascript:window.history.back();">Назад</a></p> 
  	</g:elseif>
  	<g:else>
  		<p>Неизвестная ошибка!</p>
  		<p><a href="#" onclick="javascript:window.history.back();">Назад</a></p> 
  	</g:else>
</body>
</html>