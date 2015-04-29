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
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(0)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('loggedInUserInfo','sec',15,['field':("username")],-1)
printHtmlPart(6)
createClosureForHtmlPart(7, 2)
invokeTag('link','g',16,['controller':("Logout"),'action':("index")],2)
printHtmlPart(8)
createClosureForHtmlPart(9, 2)
invokeTag('link','g',25,['controller':("VisitorSpace"),'action':("editPrivateData")],2)
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
expressionOut.print(cafeeName.cafeeName)
printHtmlPart(12)
expressionOut.print(cafeeName.placeCost)
printHtmlPart(13)
expressionOut.print(cafeeName.currencyType)
printHtmlPart(14)
invokeTag('datePicker','g',52,['name':("reservationDate"),'value':(new Date()),'precision':("day")],-1)
printHtmlPart(15)
invokeTag('timePicker','joda',58,['name':("startTimeReservation"),'value':(new LocalTime()),'precision':("minute")],-1)
printHtmlPart(16)
invokeTag('timePicker','joda',64,['name':("endTimeReservation"),'value':(new LocalTime()),'precision':("minute")],-1)
printHtmlPart(17)
invokeTag('hiddenField','g',67,['name':("cafeeName"),'value':(cafeeName.cafeeName)],-1)
printHtmlPart(18)
createClosureForHtmlPart(19, 3)
invokeTag('actionSubmit','g',68,['value':("Забронировать"),'action':("makeReserve"),'class':("btn btn-lg btn-primary btn-block")],3)
printHtmlPart(20)
})
invokeTag('form','g',69,['class':("form-signin"),'controller':("VisitorSpace")],2)
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',82,[:],1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1430306715299L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
