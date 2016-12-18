<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>媒超风CMS系统 - 系统用户</title>
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
	                        <input id="keywords" name="keywords" type="text" placeholder="请输入账户名称" class="input-sm form-control serach" value="${keywords}">
	                        <span class="input-group-btn"><button id="searchBtn" type="button" class="btn btn-sm">搜索</button></span>
	                    </div>
	                </div>
	            </div>
	            <!-- begin table-content -->
	            <div class="table-content">
	                <table class="table table-bordered">
	                
	                    <thead>
	                        <tr><th width="10px">&nbsp;</th><th width="200px">ID</th><th>用户名</th><th width="70px">是否启用</th><th width="132px">创建时间</th><th width="132px">更新时间</th><th>操作</th></tr>
	                    </thead>
	                    
	                    <tbody id="dataList">
	                        <c:if test="${!empty result.items}">
	                        <c:forEach var="adminUser" items="${result.items}">
	                        <tr>
	                            <td><input type="checkbox" value="${adminUser.id}" class="i-checks" name="listValue"></td>
	                            <td>${adminUser.id}</td>
	                            <td align="center">${adminUser.username}</td>
	                            <td align="center">${adminUser.convertEnabled}</td>
	                            <td align="center"><fmt:formatDate value="${adminUser.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	                            <td align="center"><fmt:formatDate value="${adminUser.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	                            <td align="center">
		                            <c:if test="${adminUser.enabled eq 0}"><a href="javascript:;" class="disabled" id="${adminUser.id}">禁用</a></c:if>
		                            <c:if test="${adminUser.enabled eq 1}"><a href="javascript:;" class="enabled" id="${adminUser.id}">启用</a></c:if>
	                            </td>
	                        </tr>
	                        </c:forEach>
	                        </c:if>
	                        <c:if test="${empty result.items}">
	                        <tr class="tr-center">
	                            <td class="td-nodata" colspan="7">暂无系统用户信息......</td>
	                        </tr>
	                        </c:if>
	                    </tbody>
	                    
	                    <tfoot>
		                    <tr>
			                    <td colspan="7">
						            <div class="edit-box">
							            <ul id="editTop">
								            <li><a href="javascript:;" id="delete" class="delete">删除</a></li>
								            <li><a id="addAccount" href="javascript:;">新增账号</a></li>
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
	<!-- 新增账号 -->
	<div id="AccountWapper" class="m-login">
		<ul class="login-form clearfix">
			<li><input type="text" name="sysusername" id="sysusername" placeholder="请输入邮箱/用户名" value=""></li>
			<li><input type="password" name="syspassword" id="syspassword" placeholder="请输入密码" title="请输入密码"></li>
		</ul>
		<input id="addSysUserBtn" type="button" value="登录" class="btn btn-primary">
	</div>
    <!-- header begin -->
	<%@include file="/WEB-INF/jsp/common/footer.jsp"%>
	<!-- header end -->
	<%@include file="/WEB-INF/jsp/common/module.jsp"%>
	<script type="text/javascript" src="${baseURL}/js/sysuser-list.js"></script>
</div>
</body>
</html>