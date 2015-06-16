import org.joda.time.LocalTime
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_restorator_visitorSpacepaymentSystemPage_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/visitorSpace/paymentSystemPage.gsp" }
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
createTagBody(2, {->
printHtmlPart(9)
invokeTag('textField','g',33,['class':("form-control"),'name':("city"),'placeholder':("Город ресторана"),'value':("")],-1)
printHtmlPart(10)
invokeTag('textField','g',41,['class':("form-control"),'name':("region"),'placeholder':("Регион заведения")],-1)
printHtmlPart(11)
createClosureForHtmlPart(12, 3)
invokeTag('actionSubmit','g',43,['value':("Поиск заведений"),'action':("searchCafee"),'class':("btn btn-default")],3)
printHtmlPart(13)
})
invokeTag('form','g',44,['class':("form-inline")],2)
printHtmlPart(14)
createClosureForHtmlPart(15, 2)
invokeTag('link','g',51,['controller':("VisitorSpace"),'action':("editPrivateData")],2)
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
expressionOut.print(paymentSystemName)
printHtmlPart(18)
invokeTag('hiddenField','g',76,['name':("cafeeInfo"),'value':(cafeeInfo)],-1)
printHtmlPart(19)
invokeTag('hiddenField','g',77,['name':("paymentSystemName"),'value':(paymentSystemName)],-1)
printHtmlPart(20)
invokeTag('textField','g',79,['id':("billNumber"),'class':("form-control"),'name':("billNumber"),'placeholder':("Введите номер счета"),'value':(""),'autofocus':(""),'data-translatable-string':(""),'type':("number")],-1)
printHtmlPart(21)
createClosureForHtmlPart(22, 3)
invokeTag('actionSubmit','g',80,['value':("Произвести оплату"),'action':("makePayment")],3)
printHtmlPart(23)
})
invokeTag('form','g',82,['class':("form-signin"),'controller':("VisitorSpace")],2)
printHtmlPart(24)
})
invokeTag('captureBody','sitemesh',95,[:],1)
printHtmlPart(25)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1433345626630L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
