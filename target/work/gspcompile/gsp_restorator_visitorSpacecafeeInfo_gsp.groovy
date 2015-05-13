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
createClosureForHtmlPart(9, 2)
invokeTag('link','g',28,['controller':("VisitorSpace"),'action':("editPrivateData")],2)
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
expressionOut.print(cafeeName.cafeeName)
printHtmlPart(12)
expressionOut.print(cafeeName.placeCost)
printHtmlPart(13)
expressionOut.print(cafeeName.currencyType)
printHtmlPart(14)
invokeTag('select','g',55,['name':("tablePlacesAvailable"),'from':(tableInfo),'optionValue':({it.placesInTableAmount}),'optionKey':("placesInTableAmount"),'value':("")],-1)
printHtmlPart(15)
invokeTag('datePicker','g',61,['name':("reservationDate"),'value':(new Date()),'precision':("day")],-1)
printHtmlPart(16)
invokeTag('timePicker','joda',67,['name':("startTimeReservation"),'value':(new LocalTime()),'precision':("minute")],-1)
printHtmlPart(17)
invokeTag('timePicker','joda',73,['name':("endTimeReservation"),'value':(new LocalTime()),'precision':("minute")],-1)
printHtmlPart(18)
invokeTag('hiddenField','g',76,['name':("cafeeName"),'value':(cafeeName.cafeeName)],-1)
printHtmlPart(19)
invokeTag('hiddenField','g',77,['name':("cafeeApiInit"),'value':(cafeeName.apiInit)],-1)
printHtmlPart(19)
invokeTag('hiddenField','g',78,['name':("cafeePlaceCost"),'value':(cafeeName.placeCost)],-1)
printHtmlPart(19)
createClosureForHtmlPart(20, 3)
invokeTag('actionSubmit','g',79,['value':("Забронировать"),'action':("makeReserve"),'class':("btn btn-primary")],3)
printHtmlPart(21)
})
invokeTag('form','g',80,['class':("form-signin"),'controller':("VisitorSpace")],2)
printHtmlPart(22)
})
invokeTag('captureBody','sitemesh',93,[:],1)
printHtmlPart(23)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1431541596409L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
