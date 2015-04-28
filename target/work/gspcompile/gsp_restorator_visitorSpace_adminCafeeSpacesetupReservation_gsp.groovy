import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import restorator.auth.Person
import org.joda.time.LocalTime
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_restorator_visitorSpace_adminCafeeSpacesetupReservation_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/visitorSpace/adminCafeeSpace/setupReservation.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=ISO-8859-1")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("userSpace")],-1)
printHtmlPart(0)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',10,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(0)
})
invokeTag('captureHead','sitemesh',11,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('loggedInUserInfo','sec',17,['field':("username")],-1)
printHtmlPart(5)
createClosureForHtmlPart(6, 2)
invokeTag('link','g',18,['controller':("Logout"),'action':("index")],2)
printHtmlPart(7)
createClosureForHtmlPart(8, 2)
invokeTag('link','g',26,['controller':("VisitorSpace"),'action':("index")],2)
printHtmlPart(9)
createClosureForHtmlPart(10, 2)
invokeTag('link','g',27,['controller':("VisitorSpace"),'action':("setReservation")],2)
printHtmlPart(11)
createClosureForHtmlPart(12, 2)
invokeTag('link','g',29,['controller':("VisitorSpace"),'action':("editPrivateData")],2)
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(14)
invokeTag('textField','g',45,['id':("cafee"),'class':("form-control"),'name':("cafee"),'placeholder':("Название заведения"),'value':(cafeeInfo.cafeeName),'required':(""),'autofocus':("")],-1)
printHtmlPart(15)
invokeTag('textField','g',47,['id':("totalPlaces"),'class':("form-control"),'name':("totalPlaces"),'placeholder':("Количество мест в заведении"),'value':(cafeeInfo.totalPlaces),'type':("number")],-1)
printHtmlPart(16)
invokeTag('textField','g',49,['id':("reservationPlaces"),'class':("form-control"),'name':("reservationPlaces"),'placeholder':("Доступно мест для бронирования"),'value':(cafeeInfo.totalReservationPlaces),'type':("number")],-1)
printHtmlPart(17)
invokeTag('textField','g',51,['id':("placePrice"),'class':("form-control"),'name':("placePrice"),'placeholder':("Цена за место"),'value':(cafeeInfo.placeCost),'autofocus':(""),'data-translatable-string':(""),'type':("number")],-1)
printHtmlPart(18)
invokeTag('textField','g',53,['id':("currencyType"),'class':("form-control"),'name':("currencyType"),'placeholder':("Тип принимаемой валюты"),'value':(cafeeInfo.currencyType),'autofocus':(""),'data-translatable-string':(""),'type':("string")],-1)
printHtmlPart(19)
invokeTag('checkBox','g',57,['name':("reservationAvailable"),'value':(cafeeInfo.isReservationAvailable)],-1)
printHtmlPart(20)
invokeTag('checkBox','g',63,['name':("timeLimitReservation"),'value':(cafeeInfo.reservationTimeLimit)],-1)
printHtmlPart(21)
invokeTag('checkBox','g',69,['name':("dateLimitReservation"),'value':(cafeeInfo.reservationDateLimit)],-1)
printHtmlPart(22)
invokeTag('datePicker','g',76,['name':("startDateReservation"),'value':(new Date()),'precision':("day")],-1)
printHtmlPart(23)
invokeTag('datePicker','g',82,['name':("endDateReservation"),'value':(new Date()),'precision':("day")],-1)
printHtmlPart(24)
invokeTag('timePicker','joda',88,['name':("startTimeReservation"),'value':(new LocalTime()),'precision':("minute")],-1)
printHtmlPart(25)
invokeTag('timePicker','joda',94,['name':("endTimeReservation"),'value':(new LocalTime()),'precision':("minute")],-1)
printHtmlPart(26)
createClosureForHtmlPart(27, 3)
invokeTag('actionSubmit','g',97,['value':("Подтвердить изменения"),'action':("editReservation"),'class':("btn btn-lg btn-primary btn-block")],3)
printHtmlPart(28)
})
invokeTag('form','g',98,['class':("form-signin"),'controller':("VisitorSpace")],2)
printHtmlPart(29)
})
invokeTag('captureBody','sitemesh',111,[:],1)
printHtmlPart(30)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1430173509595L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
