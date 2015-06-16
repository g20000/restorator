import org.joda.time.LocalTime
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_restorator_rootAdminSpaceuserInfo_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/rootAdminSpace/userInfo.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=ISO-8859-1")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("userSpace")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(0)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
invokeTag('loggedInUserInfo','sec',15,['field':("username")],-1)
})
invokeTag('link','g',15,['controller':("VisitorSpace"),'action':("index")],2)
printHtmlPart(5)
createClosureForHtmlPart(6, 2)
invokeTag('link','g',16,['controller':("Logout"),'action':("index")],2)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('img','g',20,['dir':("images"),'file':("Olumn64.png")],-1)
})
invokeTag('link','g',20,['controller':("StartPage"),'action':("index")],2)
printHtmlPart(8)
createClosureForHtmlPart(9, 2)
invokeTag('link','g',27,['controller':("RootAdminSpace"),'action':("index")],2)
printHtmlPart(10)
createClosureForHtmlPart(11, 2)
invokeTag('link','g',28,['controller':("RootAdminSpace"),'action':("setupBillingSystem")],2)
printHtmlPart(10)
createClosureForHtmlPart(12, 2)
invokeTag('link','g',29,['controller':("RootAdminSpace"),'action':("editPrivateData")],2)
printHtmlPart(13)
expressionOut.print(userInfo.getUsername())
printHtmlPart(14)
expressionOut.print(userInfo.getFirstName())
printHtmlPart(15)
expressionOut.print(userInfo.getLastName())
printHtmlPart(16)
expressionOut.print(userInfo.getEmail())
printHtmlPart(17)
expressionOut.print(userInfo.getEmail())
printHtmlPart(18)
if(true && (userInfo.getInn() != "")) {
printHtmlPart(19)
expressionOut.print(userInfo.getInn())
printHtmlPart(20)
}
printHtmlPart(21)
if(true && (userInfo.getIsAdminCafee())) {
printHtmlPart(22)
}
else {
printHtmlPart(23)
}
printHtmlPart(24)
if(true && (userInfo.getIsAdminCafee())) {
printHtmlPart(25)
createTagBody(3, {->
expressionOut.print(userInfo.cafee.getCafeeName())
})
invokeTag('link','g',80,['action':("goToCafeePage"),'params':([id: "${userInfo.cafee.getId()}", cafeeApiInit: "${userInfo.cafee.apiInit}"])],3)
printHtmlPart(26)
}
printHtmlPart(27)
})
invokeTag('captureBody','sitemesh',96,[:],1)
printHtmlPart(28)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1434231416954L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
