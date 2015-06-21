import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_restorator_visitorSpace_adminCafeeSpacebillingSystemControl_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/visitorSpace/adminCafeeSpace/billingSystemControl.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=ISO-8859-1")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("userSpace")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
invokeTag('loggedInUserInfo','sec',15,['field':("username")],-1)
})
invokeTag('link','g',15,['controller':("VisitorSpace"),'action':("index")],2)
printHtmlPart(6)
createClosureForHtmlPart(7, 2)
invokeTag('link','g',16,['controller':("Logout"),'action':("index")],2)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('img','g',20,['dir':("images"),'file':("Olumn64.png")],-1)
})
invokeTag('link','g',20,['controller':("StartPage"),'action':("index")],2)
printHtmlPart(9)
createClosureForHtmlPart(10, 2)
invokeTag('link','g',27,['controller':("VisitorSpace"),'action':("index")],2)
printHtmlPart(11)
createClosureForHtmlPart(12, 2)
invokeTag('link','g',28,['controller':("VisitorSpace"),'action':("setReservation")],2)
printHtmlPart(13)
createClosureForHtmlPart(14, 2)
invokeTag('link','g',29,['controller':("VisitorSpace"),'action':("setupBillingSystem")],2)
printHtmlPart(11)
createClosureForHtmlPart(15, 2)
invokeTag('link','g',30,['controller':("VisitorSpace"),'action':("editPrivateData")],2)
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
for( paymentSystem in (paymentSystems) ) {
printHtmlPart(18)
expressionOut.print(paymentSystem.key)
printHtmlPart(19)
invokeTag('checkBox','g',63,['name':(paymentSystem.key),'value':(paymentSystem.value)],-1)
printHtmlPart(20)
}
printHtmlPart(21)
invokeTag('actionSubmit','g',69,['value':("Подтвердить изменения"),'action':("saveSetupBillingSystems")],-1)
printHtmlPart(22)
})
invokeTag('form','g',71,['controller':("VisitorSpace")],2)
printHtmlPart(23)
})
invokeTag('captureBody','sitemesh',85,[:],1)
printHtmlPart(24)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1434895017818L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
