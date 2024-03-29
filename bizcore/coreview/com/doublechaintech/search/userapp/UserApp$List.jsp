<%@ page import='java.util.*,com.doublechaintech.search.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty userAppList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['user_app']}! 
		 <a href="./${ownerBeanName}Manager/addUserApp/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty userAppList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("userAppList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['user_app']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addUserApp/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'userAppList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${userAppListName};${userAppListName}CurrentPage=${page.pageNumber};${userAppListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='userAppListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['user_app.id']}</th>
</c:if>
<c:if test="${param.referName ne 'title'}">
	<th>${userContext.localeMap['user_app.title']}</th>
</c:if>
<c:if test="${param.referName ne 'secUser'}">
	<th>${userContext.localeMap['user_app.sec_user']}</th>
</c:if>
<c:if test="${param.referName ne 'appIcon'}">
	<th>${userContext.localeMap['user_app.app_icon']}</th>
</c:if>
<c:if test="${param.referName ne 'fullAccess'}">
	<th>${userContext.localeMap['user_app.full_access']}</th>
</c:if>
<c:if test="${param.referName ne 'permission'}">
	<th>${userContext.localeMap['user_app.permission']}</th>
</c:if>
<c:if test="${param.referName ne 'objectType'}">
	<th>${userContext.localeMap['user_app.object_type']}</th>
</c:if>
<c:if test="${param.referName ne 'objectId'}">
	<th>${userContext.localeMap['user_app.object_id']}</th>
</c:if>
<c:if test="${param.referName ne 'location'}">
	<th>${userContext.localeMap['user_app.location']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${userAppList}">
				<tr currentVersion='${item.version}' id="userApp-${item.id}" ><td><a class="link-action-removed" href="./userAppManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'title'}">	<td contenteditable='true' class='edit-value'  propertyToChange='title' storedCellValue='${item.title}' prefix='${ownerBeanName}Manager/updateUserApp/${result.id}/${item.id}/'>${item.title}</td>
</c:if><c:if test="${param.referName ne 'secUser'}">
	<td class="select_candidate_td"
			data-candidate-method="./userAppManager/requestCandidateSecUser/${ownerBeanName}/${item.id}/"
			data-switch-method="./userAppManager/transferToAnotherSecUser/${item.id}/"
			data-link-template="./secUserManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.secUser}">
			<a href='./secUserManager/view/${item.secUser.id}/'>${item.secUser.displayName}</a>
			</c:if>
			<c:if test="${empty  item.secUser}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'appIcon'}">	<td contenteditable='true' class='edit-value'  propertyToChange='appIcon' storedCellValue='${item.appIcon}' prefix='${ownerBeanName}Manager/updateUserApp/${result.id}/${item.id}/'>${item.appIcon}</td>
</c:if><c:if test="${param.referName ne 'fullAccess'}">	<td contenteditable='true' class='edit-value'  propertyToChange='fullAccess' storedCellValue='${item.fullAccess}' prefix='${ownerBeanName}Manager/updateUserApp/${result.id}/${item.id}/'>${item.fullAccess}</td>
</c:if><c:if test="${param.referName ne 'permission'}">	<td contenteditable='true' class='edit-value'  propertyToChange='permission' storedCellValue='${item.permission}' prefix='${ownerBeanName}Manager/updateUserApp/${result.id}/${item.id}/'>${item.permission}</td>
</c:if><c:if test="${param.referName ne 'objectType'}">	<td contenteditable='true' class='edit-value'  propertyToChange='objectType' storedCellValue='${item.objectType}' prefix='${ownerBeanName}Manager/updateUserApp/${result.id}/${item.id}/'>${item.objectType}</td>
</c:if><c:if test="${param.referName ne 'objectId'}">	<td contenteditable='true' class='edit-value'  propertyToChange='objectId' storedCellValue='${item.objectId}' prefix='${ownerBeanName}Manager/updateUserApp/${result.id}/${item.id}/'>${item.objectId}</td>
</c:if><c:if test="${param.referName ne 'location'}">	<td contenteditable='true' class='edit-value'  propertyToChange='location' storedCellValue='${item.location}' prefix='${ownerBeanName}Manager/updateUserApp/${result.id}/${item.id}/'>${item.location}</td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeUserApp/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyUserAppFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


