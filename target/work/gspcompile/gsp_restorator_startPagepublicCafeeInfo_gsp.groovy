import org.joda.time.LocalTime
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
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=ISO-8859-1")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("wrapBody")],-1)
printHtmlPart(0)
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
createClosureForHtmlPart(5, 2)
invokeTag('link','g',14,['controller':("Registration"),'action':("index")],2)
printHtmlPart(6)
createClosureForHtmlPart(7, 2)
invokeTag('link','g',15,['controller':("VisitorSpace"),'action':("index")],2)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('textField','g',29,['class':("form-control"),'name':("city"),'placeholder':("Город заведения"),'value':("")],-1)
printHtmlPart(10)
createClosureForHtmlPart(11, 3)
invokeTag('actionSubmit','g',31,['value':("Поиск заведений"),'action':("searchCafee"),'class':("btn btn-default")],3)
printHtmlPart(12)
})
invokeTag('form','g',32,['class':("form-inline"),'controller':("VisitorSpace")],2)
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(14)
expressionOut.print(cafeeName.cafeeName)
printHtmlPart(15)
expressionOut.print(cafeeName.placeCost)
printHtmlPart(16)
expressionOut.print(cafeeName.currencyType)
printHtmlPart(17)
invokeTag('datePicker','g',50,['name':("reservationDate"),'value':(new Date()),'precision':("day")],-1)
printHtmlPart(18)
invokeTag('timePicker','joda',56,['name':("startTimeReservation"),'value':(new LocalTime()),'precision':("minute")],-1)
printHtmlPart(19)
invokeTag('timePicker','joda',62,['name':("endTimeReservation"),'value':(new LocalTime()),'precision':("minute")],-1)
printHtmlPart(20)
invokeTag('hiddenField','g',65,['name':("cafeeName"),'value':(cafeeName.cafeeName)],-1)
printHtmlPart(21)
createClosureForHtmlPart(22, 3)
invokeTag('actionSubmit','g',66,['value':("Забронировать"),'action':("index"),'class':("btn btn-lg btn-primary btn-block")],3)
printHtmlPart(23)
})
invokeTag('form','g',67,['class':("form-signin"),'controller':("RedirectorToVisitorSpace")],2)
printHtmlPart(24)
invokeTag('javascript','g',78,['library':("start_page_bootstrap_files/ie-emulation-modes-warning")],-1)
printHtmlPart(0)
})
invokeTag('captureBody','sitemesh',79,[:],1)
printHtmlPart(25)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1430658312844L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
