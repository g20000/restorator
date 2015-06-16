import restorator.Region
import restorator.City
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
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("content-type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'charset':("utf-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("description"),'content':("")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("author"),'content':("")],-1)
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',13,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',13,[:],2)
printHtmlPart(5)
expressionOut.print(resource(dir: 'css', file: 'bootstrap.css'))
printHtmlPart(6)
expressionOut.print(resource(dir: 'css/reg_page_files', file: 'signing.css'))
printHtmlPart(7)
invokeTag('javascript','g',20,['library':("jquery")],-1)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
expressionOut.print(remoteFunction(controller:"region", action:"ajaxGetCities", params:"'id=' + zopt.value", onComplete:"updateCity(e)"))
printHtmlPart(10)
})
invokeTag('javascript','g',72,[:],2)
printHtmlPart(11)
invokeTag('captureMeta','sitemesh',75,['gsp_sm_xmlClosingForEmptyTag':(""),'class':("os-tdn"),'http-equiv':("Content-Language"),'content':("ru")],-1)
invokeTag('captureMeta','sitemesh',75,['gsp_sm_xmlClosingForEmptyTag':(""),'class':("os-tdn"),'property':("og:locale"),'content':("ru")],-1)
printHtmlPart(12)
})
invokeTag('captureHead','sitemesh',75,[:],1)
printHtmlPart(13)
createTagBody(1, {->
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(15)
invokeTag('textField','g',88,['id':("login"),'class':("form-control"),'name':("login"),'placeholder':("Логин"),'required':(""),'autofocus':("")],-1)
printHtmlPart(16)
invokeTag('textField','g',93,['id':("firstName"),'class':("form-control"),'name':("firstName"),'placeholder':("Ваше имя"),'required':(""),'type':("text")],-1)
printHtmlPart(17)
invokeTag('textField','g',98,['id':("lastName"),'class':("form-control"),'name':("lastName"),'placeholder':("Вашa фамилия"),'required':(""),'type':("text")],-1)
printHtmlPart(18)
invokeTag('textField','g',103,['id':("inputEmail"),'class':("form-control"),'name':("email"),'placeholder':("Адрес эл. почты"),'required':(""),'autofocus':(""),'data-translatable-string':("Email address"),'type':("email")],-1)
printHtmlPart(19)
invokeTag('passwordField','g',108,['id':("inputPassword"),'class':("form-control"),'name':("password"),'placeholder':("Пароль"),'required':(""),'data-translatable-string':("Password")],-1)
printHtmlPart(20)
invokeTag('passwordField','g',113,['id':("confirmPassword"),'class':("form-control"),'name':("controlPassword"),'placeholder':("Подтвердите пароль"),'required':(""),'data-translatable-string':("Password")],-1)
printHtmlPart(21)
invokeTag('checkBox','g',114,['class':("isAdminCafee"),'name':("isAdminCafee"),'value':(false)],-1)
printHtmlPart(22)
invokeTag('textField','g',124,['id':("cafee"),'class':("form-control"),'name':("cafeeName"),'value':(""),'placeholder':("Название заведения"),'type':("text")],-1)
printHtmlPart(23)
invokeTag('textField','g',129,['id':("innName"),'class':("form-control"),'name':("inn"),'value':(""),'placeholder':("ИНН"),'type':("text")],-1)
printHtmlPart(24)
invokeTag('select','g',133,['optionKey':("id"),'name':("region.id"),'id':("region"),'from':(region),'noSelection':([null:'Выберите регион']),'optionValue':({it.getRegionName()}),'onchange':("categoryChanged(this.value);")],-1)
printHtmlPart(25)
expressionOut.print(createLink(controller: 'region', action: 'categoryChanged'))
printHtmlPart(26)
createClosureForHtmlPart(27, 3)
invokeTag('actionSubmit','g',143,['value':("Зарегистрироваться"),'action':("saveUser"),'class':("btn btn-lg btn-primary btn-block")],3)
printHtmlPart(28)
})
invokeTag('form','g',143,['class':("form-signin"),'controller':("Registration")],2)
printHtmlPart(29)
invokeTag('javascript','g',150,['library':("reg_page_files/ie10-viewport-bug-workaround")],-1)
printHtmlPart(30)
invokeTag('javascript','g',151,['library':("reg_page_files/loader")],-1)
printHtmlPart(31)
})
invokeTag('captureBody','sitemesh',151,[:],1)
printHtmlPart(32)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1434285891949L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
