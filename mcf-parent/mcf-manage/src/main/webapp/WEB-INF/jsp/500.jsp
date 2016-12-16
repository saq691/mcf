<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>500错误：服务器内部错误 </title>
    <meta name="keywords" content="媒超风，CMS，帮派">
    <meta name="description" content="媒超风是一个新媒体公司，专注于移动数字化营销与品牌互动传播和基于大数据算法的移动广告匹配，是一家拥有10年专业网络营销经验和技术开发团队的网络运营商；目前公司已与腾讯、新浪等上千家网络媒体结成战略合作伙伴关系。">
	<%@include file="/WEB-INF/jsp/common/common.jsp"%>
</head>
<body>
<div class="wrap">
    <!-- header begin -->
	<%@include file="/WEB-INF/jsp/common/header.jsp"%>
	<!-- header end -->
	
	<!-- error begin -->
	<div id="error">
	   <div class="error-img error-inside"><img alt="500" src="${baseURL}/images/500.png"></div>
	   <div class="error-describe inside-describe">
	       <div class="tip-msg"><p>抱歉！服务器内部错误……</p></div>
	       <div class="reason">
               <p>可能因为：</p>
               <ul class="reason-list">
                   <li>请求超时<span><i class="gt">&gt;</i>Web服务器太忙</span></li>
                   <li>官网维护中<span><i class="gt">&gt;</i>Web服务器上的应用程序正在重新启动</span></li>
                   <li><a href="${baseURL}/index.html">返回主页</a></li>
               </ul>
           </div>
	   </div>
	</div>
	<!-- error end -->
	
	<!-- header begin -->
	<%@include file="/WEB-INF/jsp/common/footer.jsp"%>
	<!-- header end -->
</div>
</body>
</html>