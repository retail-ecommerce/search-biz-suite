
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty sku}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A Sku" style="color: green">${userContext.localeMap['sku']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['sku.id']}</span> ${sku.id}</li>
<li><span>${userContext.localeMap['sku.name']}</span> ${sku.name}</li>
<li><span>${userContext.localeMap['sku.size']}</span> ${sku.size}</li>
<li><span>${userContext.localeMap['sku.active']}</span> ${sku.active}</li>
<li><span>${userContext.localeMap['sku.base_price']}</span> <fmt:formatNumber type="currency"  value="${sku.basePrice}" /></li>
<li><span>${userContext.localeMap['sku.last_update_time']}</span> ${sku.lastUpdateTime}</li>

	
	</ul>
</div>



</c:if>


