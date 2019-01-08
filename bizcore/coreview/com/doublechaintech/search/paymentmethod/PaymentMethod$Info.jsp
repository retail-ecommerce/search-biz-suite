
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty paymentMethod}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A PaymentMethod">${userContext.localeMap['payment_method']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./paymentMethodManager/view/${paymentMethod.id}/"> ${paymentMethod.id}</a></li>
<li><span>${userContext.localeMap['payment_method.name']}</span> ${paymentMethod.name}</li>
<li><span>${userContext.localeMap['payment_method.number']}</span> ${paymentMethod.number}</li>
<li><span>${userContext.localeMap['payment_method.line1']}</span> ${paymentMethod.line1}</li>
<li><span>${userContext.localeMap['payment_method.line2']}</span> ${paymentMethod.line2}</li>
<li><span>${userContext.localeMap['payment_method.city']}</span> ${paymentMethod.city}</li>
<li><span>${userContext.localeMap['payment_method.expire_on']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${paymentMethod.expireOn}" /></li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




