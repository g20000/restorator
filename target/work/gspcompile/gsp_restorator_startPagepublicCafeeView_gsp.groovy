import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_restorator_startPagepublicCafeeView_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/startPage/publicCafeeView.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=ISO-8859-1")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("wrapBody")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(2)
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
if(true && (goalCafee.size() != 0)) {
printHtmlPart(22)
for( cafeeInfo in (goalCafee) ) {
printHtmlPart(23)
createTagBody(4, {->
expressionOut.print(cafeeInfo.cafeeName)
})
invokeTag('link','g',71,['action':("goToCafeePage"),'params':([cafeeName: "${cafeeInfo.cafeeName}", cafeeApiInit: "${cafeeInfo.apiInit}"])],4)
printHtmlPart(24)
expressionOut.print(cafeeInfo.placeCost)
printHtmlPart(24)
expressionOut.print(cafeeInfo.currencyType)
printHtmlPart(25)
}
printHtmlPart(26)
}
else {
printHtmlPart(27)
}
printHtmlPart(28)
invokeTag('javascript','g',93,['library':("start_page_bootstrap_files/ie-emulation-modes-warning")],-1)
printHtmlPart(2)
})
invokeTag('captureBody','sitemesh',94,[:],1)
printHtmlPart(29)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1432580976455L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
