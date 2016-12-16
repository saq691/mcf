<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar-default navbar-static-side" role="navigation">
    <div class="sidebar-collapse">
        <div class="nav-header">
            <div class="profile-element">
             <span class="text-xs"><img alt="image" class="img-circle" src="${baseURL}/images/head.png" /></span>
                <p class="text-xs">${user.username eq 'admin' ? '超级管理员':user.username}，欢迎您！！！</p>
            </div>
            <div class="logo-element">&nbsp;</div>
        </div>
        <ul class="nav" id="side-menu">
            <li><a <c:if test="${selected eq 'index'}">class="selected"</c:if> href="${baseURL}/index.html"><i class="i-home"></i><span class="nav-label">主页</span></a></li>
            <li><a <c:if test="${selected eq 'news'}">class="selected"</c:if> href="${baseURL}/news/list.html"><i class="i-dynamic"></i><span class="nav-label">帮派动态</span></a></li>
            <li><a <c:if test="${selected eq 'contactInfo'}">class="selected"</c:if> href="${baseURL}/contactInfo/list.html"><i class="i-contact"></i><span class="nav-label">联系信息</span></a></li>
            <li><a <c:if test="${selected eq 'copartner'}">class="selected"</c:if> href="${baseURL}/copartner/list.html"><i class="i-partner"></i><span class="nav-label">合伙人信息</span></a></li>
            <li><a <c:if test="${selected eq 'sysuser'}">class="selected"</c:if> href="${baseURL}/sysuser/list.html"><i class="i-system"></i><span class="nav-label">系统用户</span></a></li>
        </ul>
    </div>
</nav>