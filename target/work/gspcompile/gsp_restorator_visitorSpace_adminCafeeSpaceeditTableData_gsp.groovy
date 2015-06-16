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

class gsp_restorator_visitorSpace_adminCafeeSpaceeditTableData_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/visitorSpace/adminCafeeSpace/editTableData.gsp" }
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
invokeTag('link','g',32,['controller':("VisitorSpace"),'action':("setupBillingSystem")],2)
printHtmlPart(12)
createClosureForHtmlPart(14, 2)
invokeTag('link','g',33,['controller':("VisitorSpace"),'action':("editPrivateData")],2)
printHtmlPart(15)
createClosureForHtmlPart(16, 2)
invokeTag('link','g',40,['controller':("VisitorSpace"),'action':("setReservation")],2)
printHtmlPart(17)
createClosureForHtmlPart(18, 2)
invokeTag('link','g',41,['controller':("VisitorSpace"),'action':("tableAcounting")],2)
printHtmlPart(19)
createClosureForHtmlPart(20, 2)
invokeTag('link','g',42,['controller':("VisitorSpace"),'action':("goToHallsAndZones")],2)
printHtmlPart(21)
createTagBody(2, {->
printHtmlPart(22)
invokeTag('textField','g',55,['id':("placesInTable"),'class':("form-control"),'name':("placesInTable"),'placeholder':("Сколько мест за столом?"),'value':(tableInfo.getPlacesInTableAmount()),'type':("number"),'required':("")],-1)
printHtmlPart(23)
invokeTag('textField','g',60,['id':("availableForReservation"),'class':("form-control"),'name':("availableForReservation"),'placeholder':("Из них доступно для бронирования"),'value':(tableInfo.getTableForReservationAmount()),'autofocus':(""),'data-translatable-string':(""),'type':("number"),'required':("")],-1)
printHtmlPart(24)
invokeTag('textField','g',65,['id':("defTableAmount"),'class':("form-control"),'name':("defTableAmount"),'placeholder':("Всего столов"),'value':(tableInfo.getTableAmount()),'autofocus':(""),'data-translatable-string':(""),'type':("number"),'required':("")],-1)
printHtmlPart(25)
invokeTag('select','g',69,['name':("hallsAvailable"),'from':(halls),'optionValue':({it.hallName}),'optionKey':("hallName"),'value':(tableInfo.hall)],-1)
printHtmlPart(26)
invokeTag('textField','g',74,['id':("placePrice"),'class':("form-control"),'name':("placePrice"),'placeholder':("Цена стола"),'value':(tableInfo.getPlaceCost()),'autofocus':(""),'data-translatable-string':(""),'type':("number"),'required':("")],-1)
printHtmlPart(27)
invokeTag('textField','g',79,['id':("currencyType"),'class':("form-control"),'name':("currencyType"),'placeholder':("Тип принимаемой валюты"),'value':(tableInfo.getCurrencyType()),'autofocus':(""),'data-translatable-string':(""),'type':("string"),'required':("")],-1)
printHtmlPart(28)
invokeTag('hiddenField','g',80,['name':("id"),'value':(tableInfo.getId())],-1)
printHtmlPart(29)
createClosureForHtmlPart(30, 3)
invokeTag('actionSubmit','g',81,['value':("Добавить столик"),'action':("updateTableData"),'class':("btn btn-lg btn-primary btn-block")],3)
printHtmlPart(31)
})
invokeTag('form','g',83,['class':("form-signin"),'controller':("VisitorSpace")],2)
printHtmlPart(32)
})
invokeTag('captureBody','sitemesh',96,[:],1)
printHtmlPart(33)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1433860471597L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
