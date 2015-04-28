import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import restorator.auth.Person
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_restorator_visitorSpace_adminCafeeSpaceeditPrivateData_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/visitorSpace/adminCafeeSpace/editPrivateData.gsp" }
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
invokeTag('loggedInUserInfo','sec',16,['field':("username")],-1)
printHtmlPart(5)
createClosureForHtmlPart(6, 2)
invokeTag('link','g',17,['controller':("Logout"),'action':("index")],2)
printHtmlPart(7)
createClosureForHtmlPart(8, 2)
invokeTag('link','g',25,['controller':("VisitorSpace"),'action':("index")],2)
printHtmlPart(9)
createClosureForHtmlPart(10, 2)
invokeTag('link','g',26,['controller':("VisitorSpace"),'action':("setReservation")],2)
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
invokeTag('textField','g',44,['id':("login"),'class':("form-control"),'name':("login"),'placeholder':("Логин"),'value':(applicationContext.springSecurityService.principal.username),'required':(""),'autofocus':("")],-1)
printHtmlPart(13)
invokeTag('textField','g',46,['id':("firstName"),'class':("form-control"),'name':("firstName"),'placeholder':("Ваше имя"),'var':("user"),'value':(user.firstName),'type':("text")],-1)
printHtmlPart(14)
invokeTag('textField','g',48,['id':("lastName"),'class':("form-control"),'name':("lastName"),'placeholder':("Вашa фамилия"),'var':("user"),'value':(user.lastName),'type':("text")],-1)
printHtmlPart(15)
invokeTag('textField','g',51,['id':("inputEmail"),'class':("form-control"),'name':("email"),'placeholder':("E-mail"),'var':("user"),'value':(user.email),'autofocus':(""),'data-translatable-string':(""),'type':("email")],-1)
printHtmlPart(16)
invokeTag('textField','g',53,['id':("inputINN"),'class':("form-control"),'name':("inn"),'placeholder':("ИНН"),'var':("user"),'value':(user.inn),'autofocus':(""),'data-translatable-string':("INN"),'type':("number")],-1)
printHtmlPart(17)
invokeTag('passwordField','g',55,['id':("inputPassword"),'class':("form-control"),'name':("password"),'placeholder':("Пароль"),'var':("user"),'value':(user.password),'data-translatable-string':("Password")],-1)
printHtmlPart(18)
invokeTag('passwordField','g',58,['id':("confirmPassword"),'class':("form-control"),'name':("controlPassword"),'placeholder':("Подтвердите пароль"),'var':("user"),'value':(user.password),'data-translatable-string':("Password")],-1)
printHtmlPart(19)
createClosureForHtmlPart(20, 3)
invokeTag('actionSubmit','g',59,['value':("Подтвердить изменения"),'action':("updateUserData"),'class':("btn btn-lg btn-primary btn-block")],3)
printHtmlPart(21)
})
invokeTag('form','g',60,['class':("form-signin"),'controller':("VisitorSpace")],2)
printHtmlPart(22)
})
invokeTag('captureBody','sitemesh',73,[:],1)
printHtmlPart(23)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1429570808715L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
