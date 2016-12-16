<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<div class="row border-bottom">
    <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
        <c:if test="${selected eq 'index'}">
        <div class="navbar-header"><div class="wrapper-title">主页</div></div>
        </c:if>
        <c:if test="${selected eq 'news'}">
        <div class="navbar-header"><div class="wrapper-title">帮派动态</div></div>
        </c:if>
        <c:if test="${selected eq 'contactInfo'}">
        <div class="navbar-header"><div class="wrapper-title">联系信息</div></div>
        </c:if>
        <c:if test="${selected eq 'copartner'}">
        <div class="navbar-header"><div class="wrapper-title">合伙人信息</div></div>
        </c:if>
        <c:if test="${selected eq 'sysuser'}">
        <div class="navbar-header"><div class="wrapper-title">系统用户</div></div>
        </c:if>
        <ul class="navbar-top-links">
         <li><a href="${baseURL}/index.html"><i></i>欢迎使用CMS管理系统</a></li>
         <li><a href="${baseURL}/logout" class="logout"><i></i>退出</a></li>
        </ul>
    </nav>
</div>