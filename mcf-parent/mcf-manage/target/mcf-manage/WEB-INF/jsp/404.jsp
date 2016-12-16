<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>404错误：你访问的页面丢失了 </title>
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
	   <div class="error-img"><img alt="404" src="${baseURL}/images/404.png"></div>
	   <div class="error-describe">
	       <div class="tip-msg"><p>抱歉！页面无法访问……</p></div>
	       <div class="reason">
               <p>可能因为：</p>
               <ul class="reason-list">
                   <li>网址有错误<span><i class="gt">&gt;</i>请检查地址是否完整或存在多余字符</span></li>
                   <li>网址已失效<span><i class="gt">&gt;</i>可能页面已删除，活动已下线等</span></li>
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