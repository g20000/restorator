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
createTagBody(2, {->
invokeTag('loggedInUserInfo','sec',14,['field':("username")],-1)
})
invokeTag('link','g',14,['controller':("VisitorSpace"),'action':("index")],2)
printHtmlPart(6)
createClosureForHtmlPart(7, 2)
invokeTag('link','g',15,['controller':("Logout"),'action':("index")],2)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('img','g',19,['dir':("images"),'file':("Olumn64.png")],-1)
})
invokeTag('link','g',19,['controller':("StartPage"),'action':("index")],2)
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
invokeTag('textField','g',32,['class':("form-control"),'name':("city"),'placeholder':("Город ресторана"),'value':("")],-1)
printHtmlPart(11)
invokeTag('textField','g',40,['class':("form-control"),'name':("region"),'placeholder':("Регион ресторана")],-1)
printHtmlPart(12)
createClosureForHtmlPart(13, 3)
invokeTag('actionSubmit','g',42,['value':("Начать поиск"),'action':("searchCafee"),'class':("btn btn-default")],3)
printHtmlPart(14)
})
invokeTag('form','g',43,['class':("form-inline")],2)
printHtmlPart(15)
createClosureForHtmlPart(16, 2)
invokeTag('link','g',51,['controller':("VisitorSpace"),'action':("editPrivateData")],2)
printHtmlPart(17)
createClosureForHtmlPart(18, 2)
invokeTag('link','g',60,['controller':("VisitorSpace"),'action':("showReservedTableForVisitor")],2)
printHtmlPart(19)
for( cafeeInfo in (availableCafee) ) {
printHtmlPart(20)
createTagBody(3, {->
expressionOut.print(cafeeInfo.cafeeName)
})
invokeTag('link','g',86,['action':("goToCafeePage"),'params':([cafeeName: "${cafeeInfo.cafeeName}", cafeeApiInit: "${cafeeInfo.apiInit}"])],3)
printHtmlPart(21)
expressionOut.print(cafeeInfo.placeCost)
printHtmlPart(21)
expressionOut.print(cafeeInfo.currencyType)
printHtmlPart(22)
}
printHtmlPart(23)
})
invokeTag('captureBody','sitemesh',106,[:],1)
printHtmlPart(24)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1432592060809L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
