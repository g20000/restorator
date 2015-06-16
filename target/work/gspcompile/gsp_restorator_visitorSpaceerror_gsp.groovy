import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_restorator_visitorSpaceerror_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/visitorSpace/error.gsp" }
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
if(true && (error == 1)) {
printHtmlPart(16)
}
else if(true && (error == 2)) {
printHtmlPart(17)
}
else if(true && (error == 3)) {
printHtmlPart(18)
}
else if(true && (error == 4)) {
printHtmlPart(19)
}
else if(true && (error == 5)) {
printHtmlPart(20)
expressionOut.print(stDate)
printHtmlPart(21)
expressionOut.print(endDate)
printHtmlPart(22)
}
else if(true && (error == 6)) {
printHtmlPart(23)
expressionOut.print(stTime)
printHtmlPart(21)
expressionOut.print(endTime)
printHtmlPart(22)
}
else if(true && (error == 7)) {
printHtmlPart(24)
}
else if(true && (error == 8)) {
printHtmlPart(25)
}
else if(true && (error == 9)) {
printHtmlPart(26)
}
else if(true && (error == 10)) {
printHtmlPart(27)
}
else if(true && (error == 11)) {
printHtmlPart(28)
}
else if(true && (error == 12)) {
printHtmlPart(29)
}
else if(true && (error == 13)) {
printHtmlPart(30)
}
else if(true && (error == 14)) {
printHtmlPart(31)
}
else if(true && (error == 15)) {
printHtmlPart(32)
}
else if(true && (error == 16)) {
printHtmlPart(33)
}
else if(true && (error == 17)) {
printHtmlPart(34)
expressionOut.print(message)
printHtmlPart(22)
}
else if(true && (error == 21)) {
printHtmlPart(35)
}
else {
printHtmlPart(36)
}
printHtmlPart(37)
})
invokeTag('captureBody','sitemesh',132,[:],1)
printHtmlPart(38)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1434379975973L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
