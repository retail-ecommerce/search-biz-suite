
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty paymentMethod}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A PaymentMethod" style="color: green">${userContext.localeMap['payment_method']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['payment_method.id']}</span> ${paymentMethod.id}</li>
<li><span>${userContext.localeMap['payment_method.name']}</span> ${paymentMethod.name}</li>
<li><span>${userContext.localeMap['payment_method.number']}</span> ${paymentMethod.number}</li>
<li><span>${userContext.localeMap['payment_method.line1']}</span> ${paymentMethod.line1}</li>
<li><span>${userContext.localeMap['payment_method.line2']}</span> ${paymentMethod.line2}</li>
<li><span>${userContext.localeMap['payment_method.city']}</span> ${paymentMethod.city}</li>
<li><span>${userContext.localeMap['payment_method.expire_on']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${paymentMethod.expireOn}" /></li>

	
	</ul>
</div>



</c:if>


