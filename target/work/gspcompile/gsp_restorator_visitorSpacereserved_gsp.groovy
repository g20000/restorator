import org.joda.time.format.DateTimeFormatter
import java.text.SimpleDateFormat
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
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=ISO-8859-1")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("userSpace")],-1)
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(0)
})
invokeTag('captureHead','sitemesh',10,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
invokeTag('loggedInUserInfo','sec',17,['field':("username")],-1)
})
invokeTag('link','g',17,['controller':("VisitorSpace"),'action':("index")],2)
printHtmlPart(6)
createClosureForHtmlPart(7, 2)
invokeTag('link','g',18,['controller':("Logout"),'action':("index")],2)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('img','g',22,['dir':("images"),'file':("Olumn64.png")],-1)
})
invokeTag('link','g',22,['controller':("StartPage"),'action':("index")],2)
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
invokeTag('textField','g',35,['class':("form-control"),'name':("city"),'placeholder':("Город заведения"),'value':("")],-1)
printHtmlPart(11)
invokeTag('textField','g',43,['class':("form-control"),'name':("region"),'placeholder':("Название ресторана")],-1)
printHtmlPart(12)
createClosureForHtmlPart(13, 3)
invokeTag('actionSubmit','g',45,['value':("Поиск заведений"),'action':("searchCafee"),'class':("btn btn-default")],3)
printHtmlPart(14)
})
invokeTag('form','g',46,['class':("form-inline")],2)
printHtmlPart(15)
createClosureForHtmlPart(16, 2)
invokeTag('link','g',54,['controller':("VisitorSpace"),'action':("editPrivateData")],2)
printHtmlPart(17)
createClosureForHtmlPart(18, 2)
invokeTag('link','g',61,['controller':("VisitorSpace"),'action':("index")],2)
printHtmlPart(19)
createClosureForHtmlPart(20, 2)
invokeTag('link','g',62,['controller':("VisitorSpace"),'action':("showReservedTableForVisitor")],2)
printHtmlPart(21)
if(true && (tableInfo.size() != 0)) {
printHtmlPart(22)
for( table in (tableInfo) ) {
printHtmlPart(23)
expressionOut.print(table.cafeeName.cafeeName)
printHtmlPart(24)
expressionOut.print(new SimpleDateFormat("yyyy-MM-dd").format(table.reservationDate))
printHtmlPart(24)
expressionOut.print(table.startTimeLimit.toString(timeForm))
printHtmlPart(25)
if(true && (table.endTimeLimit != null)) {
printHtmlPart(26)
expressionOut.print(table.endTimeLimit.toString(timeForm))
printHtmlPart(27)
}
else {
printHtmlPart(28)
}
printHtmlPart(29)
expressionOut.print(table.hall)
printHtmlPart(24)
expressionOut.print(table.places)
printHtmlPart(30)
createClosureForHtmlPart(31, 4)
invokeTag('link','g',109,['action':("deleteReservedTable"),'params':([cafeeName: "${table.cafeeName.cafeeName}", cafeeAPI: "${table.cafeeName.apiInit}",
								date: "${table.reservationDate}", startTime: "${table.startTimeLimit}", endTime: "${table.endTimeLimit}",
								placesAmount: "${table.places}", cost: "${table.cost}", hall: "${table.hall}"])],4)
printHtmlPart(32)
}
printHtmlPart(33)
}
else {
printHtmlPart(34)
}
printHtmlPart(35)
})
invokeTag('captureBody','sitemesh',130,[:],1)
printHtmlPart(36)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1434214329475L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
