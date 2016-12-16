<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>媒超风CMS系统 - 首页</title>
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
            <!--  -->
	        <div class="main-inner">
	            <div class="main-row">
	                <div class="col-lg-3">
	                    <div class="ibox e-margins">
	                        <div class="ibox-title">
	                            <h5>今日访问量</h5>
	                        </div>
	                        <div class="ibox-content">
	                            <h1 class="no-margins">1,200</h1>
	                        </div>
	                    </div>
	                </div>
	                <div class="col-lg-3">
	                    <div class="ibox e-margins">
	                        <div class="ibox-title">
	                            <h5>浏览总记录</h5>
	                        </div>
	                        <div class="ibox-content">
	                            <h1 class="no-margins">886,200</h1>
	                        </div>
	                    </div>
	                </div>
	                <div class="col-lg-3">
	                    <div class="ibox e-margins">
	                        <div class="ibox-title">
	                            <h5>帮派动态总记录</h5>
	                        </div>
	                        <div class="ibox-content">
	                            <h1 class="no-margins">${totalRecords}</h1>
	                        </div>
	                    </div>
	                </div>
	            </div>
		        <!--  -->
		        <div class="sidebard-panel">
			        <div class="sidebard-inner">
			            <h4>最新动态</h4>
			            <c:if test="${!empty news}">
			            <c:forEach var="news" items="${news}">
			            <div class="feed-element">
			                <a href="javascript:;" class="pull-left" title="${news.title}"><i class="dot">&nbsp;</i><strong>${news.title}</strong></a>
			                <small class="text-muted">${news.createTime}</small>
			            </div>
			            </c:forEach>
			            </c:if>
			        </div>
		        </div>
		        <!--  -->
	        </div>
	        <!--  -->
        </div>
    </div>
    <!-- header begin -->
	<%@include file="/WEB-INF/jsp/common/footer.jsp"%>
	<!-- header end -->
	<%@include file="/WEB-INF/jsp/common/module.jsp"%>
</div>
</body>
</html>