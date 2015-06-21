import org.joda.time.format.DateTimeFormatter
import java.text.SimpleDateFormat
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_restorator_visitorSpace_adminCafeeSpacereservedTableAdmin_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/visitorSpace/adminCafeeSpace/reservedTableAdmin.gsp" }
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
createClosureForHtmlPart(10, 2)
invokeTag('link','g',30,['controller':("VisitorSpace"),'action':("setReservation")],2)
printHtmlPart(11)
createClosureForHtmlPart(12, 2)
invokeTag('link','g',31,['controller':("VisitorSpace"),'action':("setupBillingSystem")],2)
printHtmlPart(11)
createClosureForHtmlPart(13, 2)
invokeTag('link','g',32,['controller':("VisitorSpace"),'action':("editPrivateData")],2)
printHtmlPart(14)
createClosureForHtmlPart(15, 2)
invokeTag('link','g',39,['action':("index")],2)
printHtmlPart(16)
createClosureForHtmlPart(17, 2)
invokeTag('link','g',40,['action':("showReservedTableForAdmin")],2)
printHtmlPart(18)
if(true && (tableInfo.size() != 0)) {
printHtmlPart(19)
for( table in (tableInfo) ) {
printHtmlPart(20)
expressionOut.print(table.visitor.username)
printHtmlPart(21)
expressionOut.print(new SimpleDateFormat("yyyy-MM-dd").format(table.getReservationDate()))
printHtmlPart(21)
expressionOut.print(table.getStartTimeLimit().toString(timeForm))
printHtmlPart(21)
expressionOut.print(table.getEndTimeLimit().toString(timeForm))
printHtmlPart(21)
expressionOut.print(table.getHall())
printHtmlPart(21)
expressionOut.print(table.getPlaces())
printHtmlPart(22)
}
printHtmlPart(23)
}
else {
printHtmlPart(24)
}
printHtmlPart(25)
})
invokeTag('captureBody','sitemesh',97,[:],1)
printHtmlPart(26)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1434914774573L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
