<%@ page import='java.util.*,com.doublechaintech.search.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty shippingAddressList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['shipping_address']}! 
		 <a href="./${ownerBeanName}Manager/addShippingAddress/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty shippingAddressList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("shippingAddressList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['shipping_address']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addShippingAddress/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'shippingAddressList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${shippingAddressListName};${shippingAddressListName}CurrentPage=${page.pageNumber};${shippingAddressListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='shippingAddressListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['shipping_address.id']}</th>
</c:if>
<c:if test="${param.referName ne 'name'}">
	<th>${userContext.localeMap['shipping_address.name']}</th>
</c:if>
<c:if test="${param.referName ne 'line1'}">
	<th>${userContext.localeMap['shipping_address.line1']}</th>
</c:if>
<c:if test="${param.referName ne 'line2'}">
	<th>${userContext.localeMap['shipping_address.line2']}</th>
</c:if>
<c:if test="${param.referName ne 'city'}">
	<th>${userContext.localeMap['shipping_address.city']}</th>
</c:if>
<c:if test="${param.referName ne 'state'}">
	<th>${userContext.localeMap['shipping_address.state']}</th>
</c:if>
<c:if test="${param.referName ne 'zipCode'}">
	<th>${userContext.localeMap['shipping_address.zip_code']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${shippingAddressList}">
				<tr currentVersion='${item.version}' id="shippingAddress-${item.id}" ><td><a class="link-action-removed" href="./shippingAddressManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'name'}">	<td contenteditable='true' class='edit-value'  propertyToChange='name' storedCellValue='${item.name}' prefix='${ownerBeanName}Manager/updateShippingAddress/${result.id}/${item.id}/'>${item.name}</td>
</c:if><c:if test="${param.referName ne 'line1'}">	<td contenteditable='true' class='edit-value'  propertyToChange='line1' storedCellValue='${item.line1}' prefix='${ownerBeanName}Manager/updateShippingAddress/${result.id}/${item.id}/'>${item.line1}</td>
</c:if><c:if test="${param.referName ne 'line2'}">	<td contenteditable='true' class='edit-value'  propertyToChange='line2' storedCellValue='${item.line2}' prefix='${ownerBeanName}Manager/updateShippingAddress/${result.id}/${item.id}/'>${item.line2}</td>
</c:if><c:if test="${param.referName ne 'city'}">	<td contenteditable='true' class='edit-value'  propertyToChange='city' storedCellValue='${item.city}' prefix='${ownerBeanName}Manager/updateShippingAddress/${result.id}/${item.id}/'>${item.city}</td>
</c:if><c:if test="${param.referName ne 'state'}">	<td contenteditable='true' class='edit-value'  propertyToChange='state' storedCellValue='${item.state}' prefix='${ownerBeanName}Manager/updateShippingAddress/${result.id}/${item.id}/'>${item.state}</td>
</c:if><c:if test="${param.referName ne 'zipCode'}">	<td contenteditable='true' class='edit-value'  propertyToChange='zipCode' storedCellValue='${item.zipCode}' prefix='${ownerBeanName}Manager/updateShippingAddress/${result.id}/${item.id}/'>${item.zipCode}</td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeShippingAddress/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyShippingAddressFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


