import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_restorator_visitorSpace_adminCafeeSpaceindexAdmin_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/visitorSpace/adminCafeeSpace/indexAdmin.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=ISO-8859-1")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("userSpace")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
invokeTag('loggedInUserInfo','sec',15,['field':("username")],-1)
})
invokeTag('link','g',15,['controller':("VisitorSpace"),'action':("index")],2)
printHtmlPart(6)
createClosureForHtmlPart(7, 2)
invokeTag('link','g',16,['controller':("Logout"),'action':("index")],2)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('img','g',20,['dir':("images"),'file':("Olumn64.png")],-1)
})
invokeTag('link','g',20,['controller':("StartPage"),'action':("index")],2)
printHtmlPart(9)
createClosureForHtmlPart(10, 2)
invokeTag('link','g',27,['controller':("VisitorSpace"),'action':("index")],2)
printHtmlPart(11)
createClosureForHtmlPart(12, 2)
invokeTag('link','g',28,['controller':("VisitorSpace"),'action':("setReservation")],2)
printHtmlPart(11)
createClosureForHtmlPart(13, 2)
invokeTag('link','g',29,['controller':("VisitorSpace"),'action':("setupBillingSystem")],2)
printHtmlPart(11)
createClosureForHtmlPart(14, 2)
invokeTag('link','g',30,['controller':("VisitorSpace"),'action':("editPrivateData")],2)
printHtmlPart(15)
createClosureForHtmlPart(16, 2)
invokeTag('link','g',37,['action':("index")],2)
printHtmlPart(17)
createClosureForHtmlPart(18, 2)
invokeTag('link','g',38,['action':("showReservedTableForAdmin")],2)
printHtmlPart(19)
for( cafeeInfo in (placeinfo) ) {
printHtmlPart(20)
expressionOut.print(cafeeInfo.cafeeName)
printHtmlPart(21)
expressionOut.print(cafeeInfo.totalPlaces)
printHtmlPart(22)
expressionOut.print(cafeeInfo.totalReservationPlaces)
printHtmlPart(23)
expressionOut.print(cafeeInfo.currencyType)
printHtmlPart(24)
if(true && (cafeeInfo.isReservationAvailable)) {
printHtmlPart(25)
if(true && (cafeeInfo.reservationTimeLimit)) {
printHtmlPart(26)
}
printHtmlPart(27)
if(true && (cafeeInfo.reservationDateLimit)) {
printHtmlPart(28)
}
printHtmlPart(29)
if(true && (cafeeInfo.reservationTimeLimit)) {
printHtmlPart(30)
expressionOut.print(cafeeInfo.startTimeLimit)
printHtmlPart(31)
expressionOut.print(cafeeInfo.endTimeLimit)
printHtmlPart(32)
}
printHtmlPart(29)
if(true && (cafeeInfo.reservationDateLimit)) {
printHtmlPart(33)
expressionOut.print(cafeeInfo.startDateLimit)
printHtmlPart(34)
expressionOut.print(cafeeInfo.endDateLimit)
printHtmlPart(32)
}
printHtmlPart(35)
}
else {
printHtmlPart(36)
}
printHtmlPart(37)
}
printHtmlPart(38)
})
invokeTag('captureBody','sitemesh',122,[:],1)
printHtmlPart(39)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1434217914538L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
