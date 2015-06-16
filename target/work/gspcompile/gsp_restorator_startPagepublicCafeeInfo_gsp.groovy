import org.joda.time.LocalTime
import org.joda.time.DateTimeZone
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_restorator_startPagepublicCafeeInfo_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/startPage/publicCafeeInfo.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("wrapBody")],-1)
printHtmlPart(2)
invokeTag('javascript','g',7,['library':("jquery")],-1)
printHtmlPart(0)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(0)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
createClosureForHtmlPart(6, 3)
invokeTag('link','g',16,['controller':("Registration"),'action':("index")],3)
printHtmlPart(7)
createClosureForHtmlPart(8, 3)
invokeTag('link','g',17,['controller':("VisitorSpace"),'action':("index")],3)
printHtmlPart(9)
})
invokeTag('ifNotLoggedIn','sec',18,[:],2)
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
createTagBody(3, {->
invokeTag('loggedInUserInfo','sec',20,['field':("username")],-1)
})
invokeTag('link','g',20,['controller':("VisitorSpace"),'action':("index")],3)
printHtmlPart(12)
createClosureForHtmlPart(13, 3)
invokeTag('link','g',21,['controller':("Logout"),'action':("index")],3)
printHtmlPart(9)
})
invokeTag('ifLoggedIn','sec',22,[:],2)
printHtmlPart(14)
createTagBody(2, {->
invokeTag('img','g',26,['dir':("images"),'file':("Olumn64.png")],-1)
})
invokeTag('link','g',26,['controller':("StartPage"),'action':("index")],2)
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(16)
invokeTag('textField','g',39,['class':("form-control"),'name':("city"),'placeholder':("Город ресторана"),'value':("")],-1)
printHtmlPart(17)
invokeTag('textField','g',47,['class':("form-control"),'name':("region"),'placeholder':("Регион ресторана")],-1)
printHtmlPart(18)
createClosureForHtmlPart(19, 3)
invokeTag('actionSubmit','g',49,['value':("Начать поиск"),'action':("searchCafee"),'class':("btn btn-default")],3)
printHtmlPart(20)
})
invokeTag('form','g',50,['class':("form-inline")],2)
printHtmlPart(21)
createTagBody(2, {->
printHtmlPart(22)
expressionOut.print(cafeeName.cafeeName)
printHtmlPart(23)
if(true && (halls.size() != 0)) {
printHtmlPart(24)
invokeTag('select','g',68,['name':("hallsAvailable"),'from':(halls),'onchange':("hallChanged(this.value, ${cafeeName.getId()});")],-1)
printHtmlPart(25)
expressionOut.print(createLink(controller: 'startPage', action: 'hallChanged'))
printHtmlPart(26)
}
printHtmlPart(27)
expressionOut.print(cafeeName.currencyType)
printHtmlPart(28)
if(true && (tableInfo.size() != 0)) {
printHtmlPart(29)
invokeTag('select','g',84,['name':("tablePlacesAvailable"),'from':(tableInfo.unique()),'optionValue':({it.placesInTableAmount}),'optionKey':("placesInTableAmount"),'value':("")],-1)
printHtmlPart(30)
}
printHtmlPart(31)
invokeTag('datePicker','g',88,['name':("reservationDate"),'value':(new Date()),'precision':("day")],-1)
printHtmlPart(32)
invokeTag('timePicker','joda',91,['name':("startTimeReservation"),'value':(new LocalTime()),'precision':("hour")],-1)
printHtmlPart(33)
if(true && (cafeeName.endTimeLimit != null)) {
printHtmlPart(34)
invokeTag('timePicker','joda',94,['name':("endTimeReservation"),'value':(new LocalTime()),'precision':("hour")],-1)
printHtmlPart(35)
}
printHtmlPart(36)
invokeTag('hiddenField','g',98,['name':("cafeeName"),'value':(cafeeName.cafeeName)],-1)
printHtmlPart(37)
invokeTag('hiddenField','g',99,['name':("cafeeApiInit"),'value':(cafeeName.apiInit)],-1)
printHtmlPart(37)
invokeTag('hiddenField','g',101,['name':("cafeePlaceCost"),'value':(cafeeName.placeCost)],-1)
printHtmlPart(37)
invokeTag('hiddenField','g',102,['name':("tableCost"),'value':(tableInfo.placeCost)],-1)
printHtmlPart(37)
createClosureForHtmlPart(38, 3)
invokeTag('actionSubmit','g',103,['value':("Забронировать"),'action':("index"),'class':("btn btn-primary")],3)
printHtmlPart(39)
})
invokeTag('form','g',104,['class':("form-signin"),'controller':("RedirectToVisitorSpace")],2)
printHtmlPart(40)
})
invokeTag('captureBody','sitemesh',107,[:],1)
printHtmlPart(41)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1434321848746L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
