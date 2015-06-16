import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import restorator.auth.Person
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_restorator_rootAdminSpaceeditPrivateData_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/rootAdminSpace/editPrivateData.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=ISO-8859-1")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("userSpace")],-1)
printHtmlPart(0)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(0)
})
invokeTag('captureHead','sitemesh',10,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
invokeTag('loggedInUserInfo','sec',17,['field':("username")],-1)
})
invokeTag('link','g',17,['controller':("VisitorSpace"),'action':("index")],2)
printHtmlPart(5)
createClosureForHtmlPart(6, 2)
invokeTag('link','g',18,['controller':("Logout"),'action':("index")],2)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('img','g',22,['dir':("images"),'file':("Olumn64.png")],-1)
})
invokeTag('link','g',22,['controller':("StartPage"),'action':("index")],2)
printHtmlPart(8)
createClosureForHtmlPart(9, 2)
invokeTag('link','g',29,['controller':("VisitorSpace"),'action':("index")],2)
printHtmlPart(10)
createClosureForHtmlPart(11, 2)
invokeTag('link','g',30,['controller':("VisitorSpace"),'action':("setupBillingSystem")],2)
printHtmlPart(12)
createClosureForHtmlPart(13, 2)
invokeTag('link','g',31,['controller':("VisitorSpace"),'action':("editPrivateData")],2)
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(15)
invokeTag('textField','g',51,['id':("login"),'class':("form-control"),'name':("login"),'placeholder':("Логин"),'value':(applicationContext.springSecurityService.principal.username),'required':(""),'autofocus':("")],-1)
printHtmlPart(16)
invokeTag('textField','g',55,['id':("firstName"),'class':("form-control"),'name':("firstName"),'placeholder':("Ваше имя"),'var':("user"),'value':(user.firstName),'type':("text")],-1)
printHtmlPart(17)
invokeTag('textField','g',60,['id':("lastName"),'class':("form-control"),'name':("lastName"),'placeholder':("Вашa фамилия"),'var':("user"),'value':(user.lastName),'type':("text")],-1)
printHtmlPart(18)
invokeTag('textField','g',65,['id':("inputEmail"),'class':("form-control"),'name':("email"),'placeholder':("Адрес эл. почты"),'var':("user"),'value':(user.email),'autofocus':(""),'data-translatable-string':("Email address"),'type':("email")],-1)
printHtmlPart(19)
invokeTag('checkBox','g',68,['class':("isChangePasswordRequired"),'name':("isChangePasswordRequired"),'value':(false)],-1)
printHtmlPart(20)
invokeTag('passwordField','g',88,['id':("inputPassword"),'class':("form-control"),'name':("password"),'placeholder':("Пароль"),'var':("user"),'value':(""),'data-translatable-string':("Password")],-1)
printHtmlPart(21)
invokeTag('passwordField','g',93,['id':("confirmPassword"),'class':("form-control"),'name':("controlPassword"),'placeholder':("Подтвердите пароль"),'var':("user"),'value':(""),'data-translatable-string':("Password")],-1)
printHtmlPart(22)
invokeTag('actionSubmit','g',95,['value':("Подтвердить изменения"),'action':("updateUserData")],-1)
printHtmlPart(23)
})
invokeTag('form','g',97,['class':("form-signin"),'controller':("VisitorSpace")],2)
printHtmlPart(24)
})
invokeTag('captureBody','sitemesh',110,[:],1)
printHtmlPart(25)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1434372739457L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
