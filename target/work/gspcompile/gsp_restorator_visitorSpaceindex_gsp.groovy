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
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("userSpace")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('loggedInUserInfo','sec',13,['field':("username")],-1)
printHtmlPart(6)
createClosureForHtmlPart(7, 2)
invokeTag('link','g',14,['controller':("Logout"),'action':("index")],2)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('textField','g',28,['class':("form-control"),'name':("city"),'placeholder':("Город заведения"),'value':("")],-1)
printHtmlPart(10)
invokeTag('textField','g',36,['class':("form-control"),'name':("region"),'placeholder':("Регион заведения")],-1)
printHtmlPart(11)
createClosureForHtmlPart(12, 3)
invokeTag('actionSubmit','g',38,['value':("Поиск заведений"),'action':("searchCafee"),'class':("btn btn-default")],3)
printHtmlPart(13)
})
invokeTag('form','g',39,['class':("form-inline")],2)
printHtmlPart(14)
createClosureForHtmlPart(15, 2)
invokeTag('link','g',45,['controller':("VisitorSpace"),'action':("editPrivateData")],2)
printHtmlPart(16)
createClosureForHtmlPart(17, 2)
invokeTag('link','g',54,['controller':("VisitorSpace"),'action':("showReservedTableForVisitor")],2)
printHtmlPart(18)
for( cafeeInfo in (availableCafee) ) {
printHtmlPart(19)
createTagBody(3, {->
expressionOut.print(cafeeInfo.cafeeName)
})
invokeTag('link','g',80,['action':("goToCafeePage"),'params':([cafeeName: "${cafeeInfo.cafeeName}"])],3)
printHtmlPart(20)
expressionOut.print(cafeeInfo.placeCost)
printHtmlPart(20)
expressionOut.print(cafeeInfo.currencyType)
printHtmlPart(21)
}
printHtmlPart(22)
})
invokeTag('captureBody','sitemesh',100,[:],1)
printHtmlPart(23)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1430866128331L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
