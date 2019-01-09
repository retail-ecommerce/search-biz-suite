
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty productRecommendation}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A ProductRecommendation" style="color: green">${userContext.localeMap['product_recommendation']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['product_recommendation.id']}</span> ${productRecommendation.id}</li>
<li><span>${userContext.localeMap['product_recommendation.name']}</span> ${productRecommendation.name}</li>
<li><span>${userContext.localeMap['product_recommendation.origin']}</span> ${productRecommendation.origin}</li>
<li><span>${userContext.localeMap['product_recommendation.remark']}</span> ${productRecommendation.remark}</li>
<li><span>${userContext.localeMap['product_recommendation.last_update_time']}</span> ${productRecommendation.lastUpdateTime}</li>

	
	</ul>
</div>



</c:if>


