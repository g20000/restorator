import org.joda.time.LocalTime
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_restorator_visitorSpacecafeeInfo_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/visitorSpace/cafeeInfo.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=ISO-8859-1")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("userSpace")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(0)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
invokeTag('loggedInUserInfo','sec',15,['field':("username")],-1)
})
invokeTag('link','g',15,['controller':("VisitorSpace"),'action':("index")],2)
printHtmlPart(5)
createClosureForHtmlPart(6, 2)
invokeTag('link','g',16,['controller':("Logout"),'action':("index")],2)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('img','g',20,['dir':("images"),'file':("Olumn64.png")],-1)
})
invokeTag('link','g',20,['controller':("StartPage"),'action':("index")],2)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('textField','g',33,['class':("form-control"),'name':("city"),'placeholder':("Город ресторана"),'value':("")],-1)
printHtmlPart(10)
invokeTag('textField','g',41,['class':("form-control"),'name':("region"),'placeholder':("Название ресторана")],-1)
printHtmlPart(11)
createClosureForHtmlPart(12, 3)
invokeTag('actionSubmit','g',43,['value':("Поиск заведений"),'action':("searchCafee"),'class':("btn btn-default")],3)
printHtmlPart(13)
})
invokeTag('form','g',44,['class':("form-inline")],2)
printHtmlPart(14)
createClosureForHtmlPart(15, 2)
invokeTag('link','g',50,['controller':("VisitorSpace"),'action':("index")],2)
printHtmlPart(16)
createClosureForHtmlPart(17, 2)
invokeTag('link','g',51,['controller':("VisitorSpace"),'action':("editPrivateData")],2)
printHtmlPart(18)
createTagBody(2, {->
printHtmlPart(19)
expressionOut.print(cafeeName.cafeeName)
printHtmlPart(20)
if(true && (halls.size() != 0)) {
printHtmlPart(21)
invokeTag('select','g',79,['name':("hallsAvailable"),'from':(halls)],-1)
printHtmlPart(22)
}
printHtmlPart(23)
expressionOut.print(cafeeName.placeCost)
printHtmlPart(24)
expressionOut.print(cafeeName.currencyType)
printHtmlPart(25)
if(true && (tableInfo.size() != 0)) {
printHtmlPart(26)
invokeTag('select','g',90,['name':("tablePlacesAvailable"),'from':(tableInfo),'optionValue':({it.placesInTableAmount}),'optionKey':("placesInTableAmount"),'value':("")],-1)
printHtmlPart(27)
}
printHtmlPart(28)
invokeTag('datePicker','g',94,['name':("reservationDate"),'value':(new Date()),'precision':("day")],-1)
printHtmlPart(29)
invokeTag('timePicker','joda',97,['name':("startTimeReservation"),'value':(new LocalTime()),'precision':("hour")],-1)
printHtmlPart(30)
if(true && (cafeeName.endTimeLimit != null)) {
printHtmlPart(31)
invokeTag('timePicker','joda',101,['name':("endTimeReservation"),'value':(new LocalTime()),'precision':("hour")],-1)
printHtmlPart(32)
}
printHtmlPart(33)
invokeTag('hiddenField','g',106,['name':("cafeeName"),'value':(cafeeName.cafeeName)],-1)
printHtmlPart(34)
invokeTag('hiddenField','g',108,['name':("cafeeApiInit"),'value':(cafeeName.apiInit)],-1)
printHtmlPart(34)
invokeTag('hiddenField','g',109,['name':("cafeePlaceCost"),'value':(cafeeName.placeCost)],-1)
printHtmlPart(34)
invokeTag('hiddenField','g',109,['name':("tableCost"),'value':(tableInfo.placeCost)],-1)
printHtmlPart(34)
createClosureForHtmlPart(35, 3)
invokeTag('actionSubmit','g',111,['value':("Забронировать"),'action':("goToPaymentPage"),'class':("btn btn-primary")],3)
printHtmlPart(36)
})
invokeTag('form','g',111,['class':("form-signin"),'controller':("VisitorSpace")],2)
printHtmlPart(37)
})
invokeTag('captureBody','sitemesh',124,[:],1)
printHtmlPart(38)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1433962418225L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
