import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_restorator_startPageerror_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/startPage/error.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("wrapBody")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',6,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
createClosureForHtmlPart(6, 3)
invokeTag('link','g',13,['controller':("Registration"),'action':("index")],3)
printHtmlPart(7)
createClosureForHtmlPart(8, 3)
invokeTag('link','g',14,['controller':("VisitorSpace"),'action':("index")],3)
printHtmlPart(9)
})
invokeTag('ifNotLoggedIn','sec',15,[:],2)
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
createTagBody(3, {->
invokeTag('loggedInUserInfo','sec',17,['field':("username")],-1)
})
invokeTag('link','g',17,['controller':("VisitorSpace"),'action':("index")],3)
printHtmlPart(12)
createClosureForHtmlPart(13, 3)
invokeTag('link','g',18,['controller':("Logout"),'action':("index")],3)
printHtmlPart(9)
})
invokeTag('ifLoggedIn','sec',19,[:],2)
printHtmlPart(14)
createTagBody(2, {->
invokeTag('img','g',23,['dir':("images"),'file':("Olumn64.png")],-1)
})
invokeTag('link','g',23,['controller':("StartPage"),'action':("index")],2)
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(16)
invokeTag('textField','g',36,['class':("form-control"),'name':("city"),'placeholder':("Город ресторана")],-1)
printHtmlPart(17)
invokeTag('textField','g',44,['class':("form-control"),'name':("region"),'placeholder':("Регион заведения")],-1)
printHtmlPart(18)
createClosureForHtmlPart(19, 3)
invokeTag('actionSubmit','g',46,['value':("Поиск заведений"),'action':("searchCafee"),'class':("btn btn-default")],3)
printHtmlPart(20)
})
invokeTag('form','g',47,['class':("form-inline"),'controller':("StartPage")],2)
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',71,[:],1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1434494236827L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
