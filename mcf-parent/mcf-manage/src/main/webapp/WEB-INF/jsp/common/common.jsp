<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%String baseURL=request.getContextPath();%>
<c:set var="baseURL" value="<%=baseURL%>" scope="request" />
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="renderer" content="webkit" />
<meta name="viewport" content="width=320,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<link rel="Shortcut Icon" href="${baseURL}/images/favicon.ico">
<link rel="stylesheet" type="text/css" href="${baseURL}/css/layout.css?v=${version}"/>
<link rel="stylesheet" type="text/css" href="${baseURL}/css/ui-dialog.custom.css?v=${version}"/>
<script type="text/javascript">var baseURL='${baseURL}';</script>