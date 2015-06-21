import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import restorator.auth.Person
import org.joda.time.LocalTime
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_restorator_visitorSpace_adminCafeeSpaceeditHallsAndZones_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/visitorSpace/adminCafeeSpace/editHallsAndZones.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=ISO-8859-1")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("userSpace")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',10,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(0)
})
invokeTag('captureHead','sitemesh',11,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
invokeTag('loggedInUserInfo','sec',18,['field':("username")],-1)
})
invokeTag('link','g',18,['controller':("VisitorSpace"),'action':("index")],2)
printHtmlPart(5)
createClosureForHtmlPart(6, 2)
invokeTag('link','g',19,['controller':("Logout"),'action':("index")],2)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('img','g',23,['dir':("images"),'file':("Olumn64.png")],-1)
})
invokeTag('link','g',23,['controller':("StartPage"),'action':("index")],2)
printHtmlPart(8)
createClosureForHtmlPart(9, 2)
invokeTag('link','g',30,['controller':("VisitorSpace"),'action':("index")],2)
printHtmlPart(10)
createClosureForHtmlPart(11, 2)
invokeTag('link','g',31,['controller':("VisitorSpace"),'action':("setReservation")],2)
printHtmlPart(12)
createClosureForHtmlPart(13, 2)
invokeTag('link','g',32,['controller':("VisitorSpace"),'action':("setupBillingSystem")],2)
printHtmlPart(12)
createClosureForHtmlPart(14, 2)
invokeTag('link','g',33,['controller':("VisitorSpace"),'action':("editPrivateData")],2)
printHtmlPart(15)
createClosureForHtmlPart(16, 2)
invokeTag('link','g',40,['controller':("VisitorSpace"),'action':("setReservation")],2)
printHtmlPart(17)
createClosureForHtmlPart(18, 2)
invokeTag('link','g',41,['controller':("VisitorSpace"),'action':("tableAcounting")],2)
printHtmlPart(19)
createClosureForHtmlPart(20, 2)
invokeTag('link','g',42,['controller':("VisitorSpace"),'action':("goToHallsAndZones")],2)
printHtmlPart(21)
createTagBody(2, {->
printHtmlPart(22)
invokeTag('textField','g',56,['id':("hall"),'class':("form-control"),'name':("hall"),'placeholder':("Введите название зоны или зала"),'value':(hall.getHallName()),'type':("text"),'required':("")],-1)
printHtmlPart(23)
invokeTag('hiddenField','g',57,['name':("id"),'value':(hall.getId())],-1)
printHtmlPart(24)
invokeTag('actionSubmit','g',58,['value':("Обновить зал/зону"),'action':("updateHall")],-1)
printHtmlPart(25)
})
invokeTag('form','g',60,['class':("form-signin"),'controller':("VisitorSpace")],2)
printHtmlPart(26)
})
invokeTag('captureBody','sitemesh',69,[:],1)
printHtmlPart(27)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1434461727677L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
