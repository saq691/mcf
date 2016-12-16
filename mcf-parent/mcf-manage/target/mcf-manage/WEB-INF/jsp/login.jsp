<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>媒超风CMS系统 - 登录中心</title>
    <%@include file="/WEB-INF/jsp/common/common.jsp"%>
    <meta name="keywords" content="媒超风，CMS，帮派">
    <meta name="description" content="媒超风是一个新媒体公司，专注于移动数字化营销与品牌互动传播和基于大数据算法的移动广告匹配，是一家拥有10年专业网络营销经验和技术开发团队的网络运营商；目前公司已与腾讯、新浪等上千家网络媒体结成战略合作伙伴关系。">
</head>
<body class="gray-bg">
    <div class="middle-box text-center center">
	    <h3>欢迎使用媒超风CMS系统</h3>
	    <form class="form" method="post" action="${baseURL}/toLogin">
	        <div class="form-group">
	            <input type="text" name="username" class="form-control" placeholder="用户名" required="true" value="${loginModel.username}" />
	        </div>
	        <div class="form-group group-mt">
	            <input type="password" name="password" class="form-control" placeholder="密码" required="true" />
	        </div>
	        <div id="loginMsg" class="login-msg">${toLoginMessage}</div>
	        <button type="submit" class="btn btn-primary">登 录</button>
	    </form>
    </div>
</body>
</html>