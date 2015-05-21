<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>Сообщение</title>
</head>
<body>
	<g:if test="${error == 1}">
  		<p>Извините, кафе закрыто для регистрации в данный момент</p>
  	</g:if>
  	<g:elseif test="${error == 2}">
  		<p>Извините, места для резервации закончились</p>
  	</g:elseif>
  	<g:elseif test="${error == 3}">
  		<p>Извините, столы с выбранным количеством мест для резервации закончились</p>
  		<p>Поищите другие столы</p>
  	</g:elseif>
  	<g:elseif test="${error == 4}">
  		<p>Время начала бронирования не может быть больше или равно времени конца бронирования</p>
  	</g:elseif>
  	<g:elseif test="${error == 5}">
  		<p>Вы можете забронировать место в этом ресторане в период с " ${stDate } до " ${endDate }"</p>
  	</g:elseif>
  	<g:elseif test="${error == 6}">
  		<p>Вы можете забронировать место в этом ресторане с " ${stTime } до " ${endTime }"</p>
  	</g:elseif>
  	<g:elseif test="${error == 7}">
  		<p>Пароли не совпадают!</p>
  	</g:elseif>
  	<g:elseif test="${error == 8}">
  		<p>Данные успешно обновлены!</p>
  	</g:elseif>
  	<g:elseif test="${error == 9}">
  		<p>Количество столов для бронирования не может быть больше общего количества столов!</p>
  	</g:elseif>
  	<g:elseif test="${error == 10}">
  		<p>Значение начала диапазона даты не может быть больше или равна значению конца диапазона даты!</p>
  	</g:elseif>
  	<g:elseif test="${error == 11}">
  		<p>Значение начала диапазона времени не может быть больше или равна значению конца диапазона времени!</p>
  	</g:elseif>
  	<g:elseif test="${error == 12}">
  		<p>Настройки кафе успешно изменены!</p>
  	</g:elseif>
</body>
</html>