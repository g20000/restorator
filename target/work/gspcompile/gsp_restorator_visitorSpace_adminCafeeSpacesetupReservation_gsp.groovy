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
printHtmlPart(2)
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
createTagBody(2, {->
invokeTag('loggedInUserInfo','sec',18,['field':("username")],-1)
})
invokeTag('link','g',18,['controller':("VisitorSpace"),'action':("index")],2)
printHtmlPart(5)
createClosureForHtmlPart(6, 2)
invokeTag('link','g',19,['controller':("Logout"),'action':("index")],2)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('img','g',23,['dir':("images"),'file':("Olumn64.png")],-1)
})
invokeTag('link','g',23,['controller':("StartPage"),'action':("index")],2)
printHtmlPart(8)
createClosureForHtmlPart(9, 2)
invokeTag('link','g',30,['controller':("VisitorSpace"),'action':("index")],2)
printHtmlPart(10)
createClosureForHtmlPart(11, 2)
invokeTag('link','g',31,['controller':("VisitorSpace"),'action':("setReservation")],2)
printHtmlPart(12)
createClosureForHtmlPart(13, 2)
invokeTag('link','g',33,['controller':("VisitorSpace"),'action':("editPrivateData")],2)
printHtmlPart(14)
createClosureForHtmlPart(15, 2)
invokeTag('link','g',41,['controller':("VisitorSpace"),'action':("tableAcounting")],2)
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
invokeTag('textField','g',56,['id':("cafee"),'class':("form-control"),'name':("cafee"),'placeholder':("Название заведения"),'value':(cafeeInfo.cafeeName),'required':(""),'autofocus':("")],-1)
printHtmlPart(18)
invokeTag('textField','g',67,['id':("totalPlaces"),'class':("form-control"),'name':("totalPlaces"),'placeholder':("Количество мест в заведении"),'value':(cafeeInfo.totalPlaces),'type':("number")],-1)
printHtmlPart(19)
invokeTag('textField','g',73,['id':("reservationPlaces"),'class':("form-control"),'name':("reservationPlaces"),'placeholder':("Доступно мест для бронирования"),'value':(cafeeInfo.totalReservationPlaces),'type':("number")],-1)
printHtmlPart(20)
invokeTag('textField','g',77,['id':("placePrice"),'class':("form-control"),'name':("placePrice"),'placeholder':("Цена за место"),'value':(cafeeInfo.placeCost),'autofocus':(""),'data-translatable-string':(""),'type':("number")],-1)
printHtmlPart(21)
invokeTag('textField','g',79,['id':("currencyType"),'class':("form-control"),'name':("currencyType"),'placeholder':("Тип принимаемой валюты"),'value':(cafeeInfo.currencyType),'autofocus':(""),'data-translatable-string':(""),'type':("string")],-1)
printHtmlPart(22)
invokeTag('checkBox','g',81,['name':("reservationAvailable"),'value':(cafeeInfo.isReservationAvailable)],-1)
printHtmlPart(23)
invokeTag('checkBox','g',83,['name':("timeLimitReservation"),'value':(cafeeInfo.reservationTimeLimit)],-1)
printHtmlPart(24)
invokeTag('checkBox','g',85,['name':("dateLimitReservation"),'value':(cafeeInfo.reservationDateLimit)],-1)
printHtmlPart(25)
invokeTag('datePicker','g',86,['name':("startDateReservation"),'value':(cafeeInfo.startDateLimit),'precision':("day")],-1)
printHtmlPart(26)
invokeTag('datePicker','g',92,['name':("endDateReservation"),'value':(cafeeInfo.endDateLimit),'precision':("day")],-1)
printHtmlPart(27)
invokeTag('timePicker','joda',97,['name':("startTimeReservation"),'value':(cafeeInfo.startTimeLimit),'precision':("hour")],-1)
printHtmlPart(28)
invokeTag('timePicker','joda',102,['name':("endTimeReservation"),'value':(cafeeInfo.endTimeLimit),'precision':("hour")],-1)
printHtmlPart(29)
createClosureForHtmlPart(30, 3)
invokeTag('actionSubmit','g',108,['value':("Подтвердить изменения"),'action':("editReservation"),'class':("btn btn-lg btn-primary btn-block")],3)
printHtmlPart(31)
})
invokeTag('form','g',108,['class':("form-signin"),'controller':("VisitorSpace")],2)
printHtmlPart(32)
})
invokeTag('captureBody','sitemesh',119,[:],1)
printHtmlPart(33)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1431470643992L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
