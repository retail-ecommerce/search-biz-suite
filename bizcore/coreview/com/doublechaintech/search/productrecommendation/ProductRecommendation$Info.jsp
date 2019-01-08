
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty productRecommendation}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A ProductRecommendation">${userContext.localeMap['product_recommendation']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./productRecommendationManager/view/${productRecommendation.id}/"> ${productRecommendation.id}</a></li>
<li><span>${userContext.localeMap['product_recommendation.display_name']}</span> ${productRecommendation.displayName}</li>
<li><span>${userContext.localeMap['product_recommendation.origin']}</span> ${productRecommendation.origin}</li>
<li><span>${userContext.localeMap['product_recommendation.remark']}</span> ${productRecommendation.remark}</li>
<li><span>${userContext.localeMap['product_recommendation.last_update_time']}</span> ${productRecommendation.lastUpdateTime}</li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




