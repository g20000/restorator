import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_restorator_startPageindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/startPage/index.gsp" }
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
createClosureForHtmlPart(5, 2)
invokeTag('link','g',13,['controller':("Registration"),'action':("index")],2)
printHtmlPart(6)
createClosureForHtmlPart(7, 2)
invokeTag('link','g',14,['controller':("VisitorSpace"),'action':("index")],2)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('textField','g',28,['class':("form-control"),'name':("city"),'placeholder':("Город заведения")],-1)
printHtmlPart(10)
createClosureForHtmlPart(11, 3)
invokeTag('actionSubmit','g',30,['value':("Поиск заведений"),'action':("searchCafee"),'class':("btn btn-default")],3)
printHtmlPart(12)
})
invokeTag('form','g',31,['class':("form-inline")],2)
printHtmlPart(13)
invokeTag('img','g',38,['dir':("images"),'file':("moscow3_w_200.png")],-1)
printHtmlPart(14)
invokeTag('img','g',41,['dir':("images"),'file':("piter.png")],-1)
printHtmlPart(14)
invokeTag('img','g',44,['dir':("images"),'file':("novosibirsk_web.png")],-1)
printHtmlPart(15)
invokeTag('img','g',49,['dir':("images"),'file':("novgorod_web.png")],-1)
printHtmlPart(14)
invokeTag('img','g',52,['dir':("images"),'file':("Yekaterinburg_web.png")],-1)
printHtmlPart(14)
invokeTag('img','g',55,['dir':("images"),'file':("Samara01_web.png")],-1)
printHtmlPart(16)
invokeTag('javascript','g',114,['library':("start_page_bootstrap_files/ie-emulation-modes-warning")],-1)
printHtmlPart(2)
})
invokeTag('captureBody','sitemesh',115,[:],1)
printHtmlPart(17)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1430496380192L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
