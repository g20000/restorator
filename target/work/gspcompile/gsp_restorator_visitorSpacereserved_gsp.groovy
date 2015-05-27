import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_restorator_visitorSpacereserved_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/visitorSpace/reserved.gsp" }
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
createTagBody(2, {->
printHtmlPart(10)
invokeTag('textField','g',33,['class':("form-control"),'name':("city"),'placeholder':("Город заведения"),'value':("")],-1)
printHtmlPart(11)
invokeTag('textField','g',41,['class':("form-control"),'name':("region"),'placeholder':("Регион заведения")],-1)
printHtmlPart(12)
createClosureForHtmlPart(13, 3)
invokeTag('actionSubmit','g',43,['value':("Поиск заведений"),'action':("searchCafee"),'class':("btn btn-default")],3)
printHtmlPart(14)
})
invokeTag('form','g',44,['class':("form-inline")],2)
printHtmlPart(15)
createClosureForHtmlPart(16, 2)
invokeTag('link','g',52,['controller':("VisitorSpace"),'action':("editPrivateData")],2)
printHtmlPart(17)
createClosureForHtmlPart(18, 2)
invokeTag('link','g',59,['controller':("VisitorSpace"),'action':("index")],2)
printHtmlPart(19)
if(true && (tableInfo.size() != 0)) {
printHtmlPart(20)
for( table in (tableInfo) ) {
printHtmlPart(21)
expressionOut.print(table.cafeeName.cafeeName)
printHtmlPart(22)
expressionOut.print(table.reservationDate)
printHtmlPart(22)
expressionOut.print(table.startTimeLimit)
printHtmlPart(23)
if(true && (table.endTimeLimit != null)) {
printHtmlPart(24)
expressionOut.print(table.endTimeLimit)
printHtmlPart(25)
}
else {
printHtmlPart(26)
}
printHtmlPart(27)
expressionOut.print(table.hall)
printHtmlPart(22)
expressionOut.print(table.places)
printHtmlPart(22)
expressionOut.print(table.cost)
printHtmlPart(22)
createClosureForHtmlPart(28, 4)
invokeTag('link','g',108,['action':("deleteReservedTable"),'params':([cafeeName: "${table.cafeeName.cafeeName}", cafeeAPI: "${table.cafeeName.apiInit}",
								date: "${table.reservationDate}", startTime: "${table.startTimeLimit}", endTime: "${table.endTimeLimit}",
								placesAmount: "${table.places}", cost: "${table.cost}", hall: "${table.hall}"])],4)
printHtmlPart(29)
}
printHtmlPart(30)
}
else {
printHtmlPart(31)
}
printHtmlPart(32)
})
invokeTag('captureBody','sitemesh',130,[:],1)
printHtmlPart(33)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1432584785105L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
