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
invokeTag('loggedInUserInfo','sec',14,['field':("username")],-1)
printHtmlPart(6)
createClosureForHtmlPart(7, 2)
invokeTag('link','g',15,['controller':("Logout"),'action':("index")],2)
printHtmlPart(8)
createClosureForHtmlPart(9, 2)
invokeTag('link','g',24,['controller':("VisitorSpace"),'action':("setReservation")],2)
printHtmlPart(10)
createClosureForHtmlPart(11, 2)
invokeTag('link','g',26,['controller':("VisitorSpace"),'action':("editPrivateData")],2)
printHtmlPart(12)
createClosureForHtmlPart(13, 2)
invokeTag('link','g',33,['action':("index")],2)
printHtmlPart(14)
for( table in (tableInfo) ) {
printHtmlPart(15)
expressionOut.print(table.visitor.username)
printHtmlPart(16)
expressionOut.print(table.reservationDate)
printHtmlPart(16)
expressionOut.print(table.startTimeLimit)
printHtmlPart(16)
expressionOut.print(table.endTimeLimit)
printHtmlPart(17)
}
printHtmlPart(18)
})
invokeTag('captureBody','sitemesh',82,[:],1)
printHtmlPart(19)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1430311355175L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
