import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_restorator_registrationindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/registration/index.gsp" }
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
invokeTag('javascript','g',34,['library':("reg_page_files/analytics")],-1)
printHtmlPart(2)
invokeTag('javascript','g',35,['library':("reg_page_files/ie-emulation-modes-warning")],-1)
printHtmlPart(8)
invokeTag('captureMeta','sitemesh',42,['gsp_sm_xmlClosingForEmptyTag':(""),'class':("os-tdn"),'http-equiv':("Content-Language"),'content':("ru")],-1)
invokeTag('captureMeta','sitemesh',42,['gsp_sm_xmlClosingForEmptyTag':(""),'class':("os-tdn"),'property':("og:locale"),'content':("ru")],-1)
printHtmlPart(9)
})
invokeTag('captureHead','sitemesh',43,[:],1)
printHtmlPart(10)
createTagBody(1, {->
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
invokeTag('textField','g',52,['id':("login"),'class':("form-control"),'name':("login"),'placeholder':("Логин"),'required':(""),'autofocus':("")],-1)
printHtmlPart(13)
invokeTag('textField','g',54,['id':("firstName"),'class':("form-control"),'name':("firstName"),'placeholder':("Ваше имя"),'required':(""),'type':("text")],-1)
printHtmlPart(14)
invokeTag('textField','g',56,['id':("lastName"),'class':("form-control"),'name':("lastName"),'placeholder':("Вашa фамилия"),'required':(""),'type':("text")],-1)
printHtmlPart(15)
invokeTag('textField','g',58,['id':("inputEmail"),'class':("form-control"),'name':("email"),'placeholder':("Адрес эл. почты"),'required':(""),'autofocus':(""),'data-translatable-string':("Email address"),'type':("email")],-1)
printHtmlPart(16)
invokeTag('passwordField','g',60,['id':("inputPassword"),'class':("form-control"),'name':("password"),'placeholder':("Пароль"),'required':(""),'data-translatable-string':("Password")],-1)
printHtmlPart(17)
invokeTag('passwordField','g',63,['id':("confirmPassword"),'class':("form-control"),'name':("controlPassword"),'placeholder':("Подтвердите пароль"),'required':(""),'data-translatable-string':("Password")],-1)
printHtmlPart(18)
expressionOut.print(false)
printHtmlPart(19)
invokeTag('textField','g',69,['id':("cafee"),'class':("form-control"),'name':("cafeeName"),'value':(""),'placeholder':("Название заведения"),'type':("text")],-1)
printHtmlPart(20)
invokeTag('textField','g',71,['id':("innName"),'class':("form-control"),'name':("inn"),'value':(""),'placeholder':("ИНН"),'type':("text")],-1)
printHtmlPart(21)
createClosureForHtmlPart(22, 3)
invokeTag('actionSubmit','g',73,['value':("Зарегестрироваться"),'action':("saveUser"),'class':("btn btn-lg btn-primary btn-block")],3)
printHtmlPart(23)
})
invokeTag('form','g',74,['class':("form-signin"),'controller':("Registration")],2)
printHtmlPart(24)
invokeTag('javascript','g',80,['library':("reg_page_files/ie10-viewport-bug-workaround")],-1)
printHtmlPart(25)
invokeTag('javascript','g',82,['library':("reg_page_files/loader")],-1)
printHtmlPart(26)
})
invokeTag('captureBody','sitemesh',1,[:],1)
printHtmlPart(27)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1428242097801L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}