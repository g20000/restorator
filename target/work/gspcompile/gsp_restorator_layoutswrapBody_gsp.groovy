import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_restorator_layoutswrapBody_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/wrapBody.gsp" }
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
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("content-type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'charset':("utf-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',12,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',13,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1")],-1)
printHtmlPart(3)
expressionOut.print(resource(dir:'css/start_page_bootstrap_files', file:'bootstrap.css'))
printHtmlPart(4)
expressionOut.print(resource(dir:'css/start_page_bootstrap_files', file:'jumbotron-narrow.css'))
printHtmlPart(5)
expressionOut.print(resource(dir:'css', file:'imageTable.css'))
printHtmlPart(5)
expressionOut.print(resource(dir:'css', file:'pictureItem.css'))
printHtmlPart(5)
expressionOut.print(resource(dir:'css', file:'imageRow.css'))
printHtmlPart(5)
expressionOut.print(resource(dir:'css', file:'popularCitiesList.css'))
printHtmlPart(5)
expressionOut.print(resource(dir:'css', file:'popularCitiesListItem.css'))
printHtmlPart(6)
invokeTag('captureMeta','sitemesh',25,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("description"),'content':("")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',26,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("author"),'content':("")],-1)
printHtmlPart(7)
createTagBody(2, {->
createClosureForHtmlPart(8, 3)
invokeTag('captureTitle','sitemesh',29,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',29,[:],2)
printHtmlPart(9)
invokeTag('javascript','g',33,['library':("start_page_bootstrap_files/ie-emulation-modes-warning")],-1)
printHtmlPart(10)
})
invokeTag('captureHead','sitemesh',40,[:],1)
printHtmlPart(11)
createTagBody(1, {->
printHtmlPart(12)
invokeTag('layoutBody','g',43,[:],-1)
printHtmlPart(0)
})
invokeTag('captureBody','sitemesh',1,[:],1)
printHtmlPart(13)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1427814206782L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
