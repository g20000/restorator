import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_restorator_layoutssign_in_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/sign_in.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',3,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("content-type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'charset':("utf-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("description"),'content':("")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("author"),'content':("")],-1)
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(5)
expressionOut.print(resource(dir: 'css', file: 'bootstrap.css'))
printHtmlPart(6)
expressionOut.print(resource(dir: 'css/reg_page_files', file: 'signing.css'))
printHtmlPart(7)
invokeTag('javascript','g',21,['library':("reg_page_files/analytics")],-1)
printHtmlPart(2)
invokeTag('javascript','g',22,['library':("reg_page_files/ie-emulation-modes-warning")],-1)
printHtmlPart(8)
invokeTag('captureMeta','sitemesh',29,['gsp_sm_xmlClosingForEmptyTag':(""),'class':("os-tdn"),'http-equiv':("Content-Language"),'content':("ru")],-1)
invokeTag('captureMeta','sitemesh',29,['gsp_sm_xmlClosingForEmptyTag':(""),'class':("os-tdn"),'property':("og:locale"),'content':("ru")],-1)
printHtmlPart(9)
})
invokeTag('captureHead','sitemesh',29,[:],1)
printHtmlPart(10)
createTagBody(1, {->
printHtmlPart(11)
invokeTag('javascript','g',51,['library':("reg_page_files/ie10-viewport-bug-workaround")],-1)
printHtmlPart(12)
invokeTag('javascript','g',53,['library':("reg_page_files/loader")],-1)
printHtmlPart(13)
})
invokeTag('captureBody','sitemesh',1,[:],1)
printHtmlPart(14)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1427145005034L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
