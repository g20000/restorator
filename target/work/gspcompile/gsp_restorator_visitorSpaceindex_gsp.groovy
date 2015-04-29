import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_restorator_visitorSpaceindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/visitorSpace/index.gsp" }
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
invokeTag('link','g',24,['controller':("VisitorSpace"),'action':("editPrivateData")],2)
printHtmlPart(10)
createClosureForHtmlPart(11, 2)
invokeTag('link','g',32,['controller':("VisitorSpace"),'action':("showReservedTableForVisitor")],2)
printHtmlPart(12)
for( cafeeInfo in (availableCafee) ) {
printHtmlPart(13)
createTagBody(3, {->
expressionOut.print(cafeeInfo.cafeeName)
})
invokeTag('link','g',58,['action':("goToCafeePage"),'params':([cafeeName: "${cafeeInfo.cafeeName}"])],3)
printHtmlPart(14)
expressionOut.print(cafeeInfo.placeCost)
printHtmlPart(14)
expressionOut.print(cafeeInfo.currencyType)
printHtmlPart(15)
}
printHtmlPart(16)
})
invokeTag('captureBody','sitemesh',78,[:],1)
printHtmlPart(17)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1430311480226L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
