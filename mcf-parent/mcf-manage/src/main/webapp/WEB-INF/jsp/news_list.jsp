<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>媒超风CMS系统 - 帮派动态</title>
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
	                        <input id="keywords" name="keywords" type="text" placeholder="请输入标签" class="input-sm form-control serach" value="${keywords}">
	                        <span class="input-group-btn"><button id="searchBtn" type="button" class="btn btn-sm">搜索</button></span>
	                    </div>
	                </div>
	            </div>
	            <!-- begin table-content -->
	            <div class="table-content">
	                <table class="table table-bordered">
	                
	                    <thead>
	                        <tr><th width="10px">&nbsp;</th><th>标题</th><th width="70px">置顶</th><th width="70px">是否显示</th><th width="132px">创建时间</th><th width="200px">操作</th></tr>
	                    </thead>
	                    
	                    <tbody id="dataList">
	                        <c:if test="${!empty result.items}">
	                        <c:forEach var="newsContent" items="${result.items}">
	                        <tr>
	                            <td><input type="checkbox" value="${newsContent.id}" class="i-checks" name="listValue"></td>
	                            <td><span class="pie">${newsContent.title}</span></td>
	                            <td align="center">${newsContent.isStick eq 0 ? '正常':'已置顶'}</td>
	                            <td align="center">${newsContent.isShow eq 0 ? '隐藏':'显示'}</td>
	                            <td align="center"><fmt:formatDate value="${newsContent.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	                            <td align="center">
	                                <c:if test="${newsContent.isStick eq 0}"><a href="javascript:;" class="aother successStick" id="${newsContent.id}">置顶</a></c:if>
		                            <c:if test="${newsContent.isStick eq 1}"><a href="javascript:;" class="disabled cancelStick" id="${newsContent.id}">取消</a></c:if>
	                                <c:if test="${newsContent.isShow eq 0}"><a href="javascript:;" class="aother showStatus" id="${newsContent.id}">显示</a></c:if>
		                            <c:if test="${newsContent.isShow eq 1}"><a href="javascript:;" class="aother hideStatus" id="${newsContent.id}">隐藏</a></c:if>
		                            <a href="${baseURL}/news/${newsContent.id}.html" class="aother update" id="${newsContent.id}">修改</a>
	                            </td>
	                        </tr>
	                        </c:forEach>
	                        </c:if>
	                        <c:if test="${empty result.items}">
	                        <tr class="tr-center">
	                            <td class="td-nodata" colspan="6">暂无帮派动态新闻......</td>
	                        </tr>
	                        </c:if>
	                    </tbody>
	                    
	                    <tfoot>
		                    <tr>
			                    <td colspan="6">
						            <div class="edit-box">
							            <ul id="editBox">
								            <li><a id="delete" href="javascript:;" class="delete">删除</a></li>
								            <li><a href="${baseURL}/news/add.html">添加</a></li>
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
	<script type="text/javascript" src="${baseURL}/js/news-list.js"></script>
</div>
</body>
</html>