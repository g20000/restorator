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
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("wrapBody")],-1)
printHtmlPart(0)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(0)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
createClosureForHtmlPart(6, 3)
invokeTag('link','g',14,['controller':("Registration"),'action':("index")],3)
printHtmlPart(7)
createClosureForHtmlPart(8, 3)
invokeTag('link','g',15,['controller':("VisitorSpace"),'action':("index")],3)
printHtmlPart(9)
})
invokeTag('ifNotLoggedIn','sec',16,[:],2)
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
createTagBody(3, {->
invokeTag('loggedInUserInfo','sec',18,['field':("username")],-1)
})
invokeTag('link','g',18,['controller':("VisitorSpace"),'action':("index")],3)
printHtmlPart(12)
createClosureForHtmlPart(13, 3)
invokeTag('link','g',19,['controller':("Logout"),'action':("index")],3)
printHtmlPart(9)
})
invokeTag('ifLoggedIn','sec',20,[:],2)
printHtmlPart(14)
createTagBody(2, {->
invokeTag('img','g',24,['dir':("images"),'file':("Olumn64.png")],-1)
})
invokeTag('link','g',24,['controller':("StartPage"),'action':("index")],2)
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(16)
invokeTag('textField','g',37,['class':("form-control"),'name':("city"),'placeholder':("Город заведения"),'value':("")],-1)
printHtmlPart(17)
invokeTag('textField','g',45,['class':("form-control"),'name':("region"),'placeholder':("Регион заведения")],-1)
printHtmlPart(18)
createClosureForHtmlPart(19, 3)
invokeTag('actionSubmit','g',47,['value':("Поиск заведений"),'action':("searchCafee"),'class':("btn btn-default")],3)
printHtmlPart(20)
})
invokeTag('form','g',48,['class':("form-inline")],2)
printHtmlPart(21)
createTagBody(2, {->
printHtmlPart(22)
expressionOut.print(cafeeName.cafeeName)
printHtmlPart(23)
expressionOut.print(cafeeName.placeCost)
printHtmlPart(24)
expressionOut.print(cafeeName.currencyType)
printHtmlPart(25)
invokeTag('datePicker','g',66,['name':("reservationDate"),'value':(new Date()),'precision':("day")],-1)
printHtmlPart(26)
invokeTag('timePicker','joda',72,['name':("startTimeReservation"),'value':(new LocalTime()),'precision':("minute")],-1)
printHtmlPart(27)
invokeTag('timePicker','joda',78,['name':("endTimeReservation"),'value':(new LocalTime()),'precision':("minute")],-1)
printHtmlPart(28)
invokeTag('hiddenField','g',81,['name':("cafeeName"),'value':(cafeeName.cafeeName)],-1)
printHtmlPart(29)
createClosureForHtmlPart(30, 3)
invokeTag('actionSubmit','g',82,['value':("Забронировать"),'action':("index"),'class':("btn btn-lg btn-primary btn-block")],3)
printHtmlPart(31)
})
invokeTag('form','g',83,['class':("form-signin"),'controller':("RedirectorToVisitorSpace")],2)
printHtmlPart(32)
invokeTag('javascript','g',94,['library':("start_page_bootstrap_files/ie-emulation-modes-warning")],-1)
printHtmlPart(0)
})
invokeTag('captureBody','sitemesh',95,[:],1)
printHtmlPart(33)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1430935573791L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
