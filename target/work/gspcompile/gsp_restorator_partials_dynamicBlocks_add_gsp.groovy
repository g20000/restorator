import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_restorator_partials_dynamicBlocks_add_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/partials/dynamicBlocks/_add.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(id)
printHtmlPart(1)
expressionOut.print(id)
printHtmlPart(2)
if(true && (!addBtnId)) {
printHtmlPart(3)
expressionOut.print(id)
printHtmlPart(4)
}
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
expressionOut.print(addBtnId ? "\$('#$addBtnId')" : "\$('#add_$id')")
printHtmlPart(7)
expressionOut.print(resource(dir: "js", file: "dynamicBlocks.js"))
printHtmlPart(8)
expressionOut.print(id)
printHtmlPart(9)
expressionOut.print(elem)
printHtmlPart(10)
expressionOut.print(min)
printHtmlPart(11)
expressionOut.print(max)
printHtmlPart(12)
expressionOut.print(onComplete)
printHtmlPart(13)
expressionOut.print(limitReachedMsg)
printHtmlPart(9)
expressionOut.print(removeBtnLabel)
printHtmlPart(14)
expressionOut.print(id)
printHtmlPart(9)
expressionOut.print(elem)
printHtmlPart(10)
expressionOut.print(min)
printHtmlPart(11)
expressionOut.print(max)
printHtmlPart(12)
expressionOut.print(onComplete)
printHtmlPart(15)
expressionOut.print(limitReachedMsg)
printHtmlPart(9)
expressionOut.print(removeBtnLabel)
printHtmlPart(16)
})
invokeTag('script','r',1,[:],1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1431467133592L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
