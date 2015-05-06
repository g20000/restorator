import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_restorator_layoutsuserSpace_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/userSpace.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)

response.setHeader("Cache-Control","no-cache");  
response.setHeader("Cache-Control","no-store");     
response.setDateHeader("Expires", 0); 
response.setHeader("Pragma","no-cache");

printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1")],-1)
printHtmlPart(3)
expressionOut.print(resource(dir:'css/start_page_bootstrap_files', file:'bootstrap.css'))
printHtmlPart(4)
expressionOut.print(resource(dir:'css/start_page_bootstrap_files', file:'jumbotron-narrow.css'))
printHtmlPart(5)
expressionOut.print(resource(dir:'css/navbar_template', file:'navbar.css'))
printHtmlPart(6)
expressionOut.print(resource(dir:'css/visitor_files', file:'dashboard.css'))
printHtmlPart(7)
expressionOut.print(resource(dir:'css/visitor_files', file:'main_signed.css'))
printHtmlPart(8)
invokeTag('captureMeta','sitemesh',21,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("description"),'content':("")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',22,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("author"),'content':("")],-1)
printHtmlPart(9)
createTagBody(2, {->
createClosureForHtmlPart(10, 3)
invokeTag('captureTitle','sitemesh',24,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',25,[:],2)
printHtmlPart(0)
})
invokeTag('captureHead','sitemesh',25,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(11)
invokeTag('layoutBody','g',26,[:],-1)
printHtmlPart(0)
})
invokeTag('captureBody','sitemesh',26,[:],1)
printHtmlPart(12)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1430866128268L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
