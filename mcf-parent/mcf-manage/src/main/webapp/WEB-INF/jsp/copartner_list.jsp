<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>媒超风CMS系统 - 合伙人信息</title>
    <%@include file="/WEB-INF/jsp/common/common.jsp"%>
    <meta name="keywords" content="媒超风，CMS，帮派">
    <meta name="description" content="媒超风是一个新媒体公司，专注于移动数字化营销与品牌互动传播和基于大数据算法的移动广告匹配，是一家拥有10年专业网络营销经验和技术开发团队的网络运营商；目前公司已与腾讯、新浪等上千家网络媒体结成战略合作伙伴关系。">
</head>
<body>
<div id="wrapper">
    
	<!-- header begin -->
	<%@include file="/WEB-INF/jsp/common/menu.jsp"%>
	<!-- header end -->
	
    <div id="page-wrapper" class="dashbard-1">
	    <!-- header begin -->
		<%@include file="/WEB-INF/jsp/common/header.jsp"%>
		<!-- header end -->
        <div class="wrapper wrapper-content">
	        <div class="ibox-content list-content">
	            <div class="row list-wapper">
	                <div class="col-sm-3">
	                    <div class="input-group">
	                        <input id="keywords" name="keywords" type="text" placeholder="请输入姓名/联系方式" class="input-sm form-control serach" value="${keywords}">
	                        <span class="input-group-btn"><button id="searchBtn" type="button" class="btn btn-sm">搜索</button></span>
	                    </div>
	                </div>
	            </div>
	            <!-- begin table-content -->
	            <div class="table-content">
	                <table class="table table-bordered">
	                
	                    <thead>
	                        <tr><th width="10px">&nbsp;</th><th width="80px">城市</th><th width="80px">姓名</th><th width="80px">联系方式</th><th width="15%">主营业务</th><th width="70px">是否已联系</th><th width="40px">合作类型</th><th width="10%">备注</th><th width="132px">创建时间</th><th width="132px">联系客户时间</th><th width="100px">操作</th></tr>
	                    </thead>
	                    
	                    <tbody id="dataList">
	                        <c:if test="${!empty result.items}">
	                        <c:forEach var="copartner" items="${result.items}">
	                        <tr>
	                            <td><input type="checkbox" value="${copartner.id}" class="i-checks" name="listValue"></td>
	                            <td align="center">${copartner.cityName}</td>
	                            <td align="center">${copartner.name}</td>
	                            <td align="center">${copartner.contactWay}</td>
	                            <td>${copartner.mainBusiness}</td>
	                            <td align="center"><select id="${copartner.id}" class="isContact select" name="isContact"><option value="0" <c:if test="${copartner.isContact eq 0}">selected="selected"</c:if>>否</option><option value="1" <c:if test="${copartner.isContact eq 1}">selected="selected"</c:if>>已联系</option></select></td>
	                            <td align="center">${copartner.cooperateType eq 0 ? '企业':'个体'}</td>
	                            <td>${copartner.remark}</td>
	                            <td align="center"><fmt:formatDate value="${copartner.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
	                            <td align="center"><fmt:formatDate value="${copartner.visitTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
	                            <td align="center">
	                                <input type="hidden" value="${copartner.id}" />
	                                <a href="javascript:;" class="aother addRemark" title="${copartner.remark}" id="remark-${copartner.id}">${empty copartner.remark ? '添加备注':'修改备注'}</a>
	                            </td>
	                        </tr>
	                        </c:forEach>
	                        </c:if>
	                        <c:if test="${empty result.items}">
	                        <tr class="tr-center">
	                            <td class="td-nodata" colspan="11">暂无合伙人信息......</td>
	                        </tr>
	                        </c:if>
	                    </tbody>
	                    
	                    <tfoot>
		                    <tr>
			                    <td colspan="11">
						            <div class="edit-box">
							            <ul id="editTop">
								            <li><a id="delete" href="javascript:;" class="delete">删除</a></li>
							            </ul>
						            </div>
						            <!-- begin pager -->
						            <div class="pager">
						                <ul>
						                    <li><div class="pager-jump">共<label class="omit">${result.paginator.totalCount}</label>条</div></li>
						                    <c:if test="${!empty result.paginator.slider}">
							                    <c:if test="${result.paginator.hasPrePage}"><li><a class="prev" href="${baseURL}/news/list.html?currentPage=${result.paginator.prePage}">«</a></li></c:if>
							                    <c:forEach var="slider" items="${result.paginator.slider}"><li><c:choose><c:when test="${pager.currentPage != slider}"><a href="${baseURL}/news/list.html?currentPage=${slider}">${slider}</a></c:when><c:otherwise><span class="current">${slider}</span></c:otherwise></c:choose></li></c:forEach>
							                    <c:if test="${result.paginator.hasNextPage}"><li><a class="next" href="${baseURL}/news/list.html?currentPage=${result.paginator.nextPage}">»</a></li></c:if>
							                </c:if>
						                    <li><div class="pager-jump">到第&nbsp;<input autocomplete="off" id="currentPage" name="currentPage" value="${result.paginator.page}" type="text">&nbsp;页</div><a href="javascript:;" class="btn" id="goBtn">GO</a></li>
						                </ul>
							        </div>
							        <!-- end pager -->
			                    </td>
		                    </tr>
	                    </tfoot>
	                    
	                </table>
	            </div>
	            <!-- end table-content -->
	        </div>
        </div>
    </div>
    <!-- header begin -->
	<%@include file="/WEB-INF/jsp/common/footer.jsp"%>
	<!-- header end -->
	<%@include file="/WEB-INF/jsp/common/module.jsp"%>
    <script type="text/javascript" src="${baseURL}/js/copartner.js"></script>
</div>
</body>
</html>