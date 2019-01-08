<%@ page import='java.util.*,com.doublechaintech.search.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty paymentMethodList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['payment_method']}! 
		 <a href="./${ownerBeanName}Manager/addPaymentMethod/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty paymentMethodList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("paymentMethodList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("rowsPerPage",list.getRowsPerPage()); 
 	
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//pageContext.setAttribute("accessible",list.isAccessible()); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['payment_method']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addPaymentMethod/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'paymentMethodList' eq action.actionGroup}">
		<a class="btn btn-${action.actionLevel} btn-sm" href="${action.managerBeanName}/${action.actionPath}">${userContext.localeMap[action.localeKey]}</a>
		</c:if>
	</c:forEach>
	</div><!--end of div class="btn-group" -->
	
		 
		 
		 
		 </div>
 </div>
    
    
<div class="table-responsive">


<c:set var="currentPageNumber" value="1"/>	



<nav aria-label="Page navigation example">
  <ul class="pagination">
<c:forEach var="page" items="${pages}"> 
<c:set var="classType" value=""/>
<c:if test='${page.selected}' >
<c:set var="classType" value="active"/>
<c:set var="currentPageNumber" value="${page.pageNumber}"/>
</c:if>


	<li class="page-item ${classType}">
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${paymentMethodListName};${paymentMethodListName}CurrentPage=${page.pageNumber};${paymentMethodListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='paymentMethodListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['payment_method.id']}</th>
</c:if>
<c:if test="${param.referName ne 'name'}">
	<th>${userContext.localeMap['payment_method.name']}</th>
</c:if>
<c:if test="${param.referName ne 'number'}">
	<th>${userContext.localeMap['payment_method.number']}</th>
</c:if>
<c:if test="${param.referName ne 'line1'}">
	<th>${userContext.localeMap['payment_method.line1']}</th>
</c:if>
<c:if test="${param.referName ne 'line2'}">
	<th>${userContext.localeMap['payment_method.line2']}</th>
</c:if>
<c:if test="${param.referName ne 'city'}">
	<th>${userContext.localeMap['payment_method.city']}</th>
</c:if>
<c:if test="${param.referName ne 'expireOn'}">
	<th>${userContext.localeMap['payment_method.expire_on']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${paymentMethodList}">
				<tr currentVersion='${item.version}' id="paymentMethod-${item.id}" ><td><a class="link-action-removed" href="./paymentMethodManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'name'}">	<td contenteditable='true' class='edit-value'  propertyToChange='name' storedCellValue='${item.name}' prefix='${ownerBeanName}Manager/updatePaymentMethod/${result.id}/${item.id}/'>${item.name}</td>
</c:if><c:if test="${param.referName ne 'number'}">	<td contenteditable='true' class='edit-value'  propertyToChange='number' storedCellValue='${item.number}' prefix='${ownerBeanName}Manager/updatePaymentMethod/${result.id}/${item.id}/'>${item.number}</td>
</c:if><c:if test="${param.referName ne 'line1'}">	<td contenteditable='true' class='edit-value'  propertyToChange='line1' storedCellValue='${item.line1}' prefix='${ownerBeanName}Manager/updatePaymentMethod/${result.id}/${item.id}/'>${item.line1}</td>
</c:if><c:if test="${param.referName ne 'line2'}">	<td contenteditable='true' class='edit-value'  propertyToChange='line2' storedCellValue='${item.line2}' prefix='${ownerBeanName}Manager/updatePaymentMethod/${result.id}/${item.id}/'>${item.line2}</td>
</c:if><c:if test="${param.referName ne 'city'}">	<td contenteditable='true' class='edit-value'  propertyToChange='city' storedCellValue='${item.city}' prefix='${ownerBeanName}Manager/updatePaymentMethod/${result.id}/${item.id}/'>${item.city}</td>
</c:if><c:if test="${param.referName ne 'expireOn'}">	<td contenteditable='true' class='edit-value'  propertyToChange='expireOn' storedCellValue='${item.expireOn}' prefix='${ownerBeanName}Manager/updatePaymentMethod/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd" value="${item.expireOn}" /></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removePaymentMethod/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyPaymentMethodFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


