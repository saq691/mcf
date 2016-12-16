<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>媒超风CMS系统 - 帮派动态</title>
    <%@include file="/WEB-INF/jsp/common/common.jsp"%>
    <meta name="keywords" content="媒超风，CMS，帮派">
    <meta name="description" content="媒超风是一个新媒体公司，专注于移动数字化营销与品牌互动传播和基于大数据算法的移动广告匹配，是一家拥有10年专业网络营销经验和技术开发团队的网络运营商；目前公司已与腾讯、新浪等上千家网络媒体结成战略合作伙伴关系。">
    <link rel="stylesheet" type="text/css" href="${baseURL}/js/kindeditor/themes/default/default.css" />
</head>
<body>
<div id="wrapper">
    
    <!-- header begin -->
	<%@include file="/WEB-INF/jsp/common/menu.jsp"%>
	<!-- header end -->
	
    <div id="page-wrapper">
	    <!-- header begin -->
		<%@include file="/WEB-INF/jsp/common/header.jsp"%>
		<!-- header end -->
        <div class="wrapper wrapper-content">
	        <div class="ibox-content content-mb">
	            <form action="${baseURL}/news/saveUpdate" method="post">
	                <input type="hidden" name="id" value="${newsContent.id}">
	                <div class="form-group">
	                    <label class="col-sm-2 control-label">标题</label>
	                    <div class="col-sm-10">
	                        <input type="text" class="form-control" name="title" value="${newsContent.title}">
	                        <span class="help-block m-b-none">请输入标题</span>
	                    </div>
	                </div>
	                <div class="hr-line-dashed"></div>
	                <div class="form-group">
	                    <label class="col-sm-2 control-label">来源</label>
	                    <div class="col-sm-10">
	                        <input type="text" class="form-control" name="source" value="${newsContent.source}">
	                        <span class="help-block m-b-none">请输入来源，例如：央视网、腾讯网、天天快报等</span>
	                    </div>
	                </div>
	                <div class="hr-line-dashed"></div>
	                <div class="form-group">
	                    <label class="col-sm-2 control-label">作者</label>
	                    <div class="col-sm-10">
	                        <input type="text" class="form-control" name="author" value="${newsContent.author}">
	                        <span class="help-block m-b-none">请输入作者，例如：帮派、编者等</span>
	                    </div>
	                </div>
	                <div class="hr-line-dashed"></div>
	                <div class="form-group">
	                    <label class="col-sm-2 control-label">摘要</label>
	                    <div class="col-sm-10">
	                        <textarea name="digest" rows="8" cols="120" class="text-digest">${newsContent.digest}</textarea>
	                        <span class="help-block m-b-none">请输入摘要</span>
	                    </div>
	                </div>
	                <div class="hr-line-dashed"></div>
	                <div class="form-group">
	                    <label class="col-sm-2 control-label">内容</label>
	                    <div class="col-sm-10">
	                        <textarea id="myConXheditor" name="content" rows="8" cols="120" style="width:780px;height:360px;">${newsContent.content}</textarea>
	                        <span class="help-block m-b-none">请输入内容</span>
	                    </div>
	                </div>
	                <div class="hr-line-dashed"></div>
	                <div class="form-group">
	                    <div class="col-sm-4 col-sm-offset">
	                        <button class="btn" type="submit">保存内容</button>
	                        <button class="btn btn-white" type="reset">取消</button>
	                    </div>
	                </div>
	            </form>
	        </div>
        </div>
    </div>
    <!-- header begin -->
	<%@include file="/WEB-INF/jsp/common/footer.jsp"%>
	<!-- header end -->
	<%@include file="/WEB-INF/jsp/common/module.jsp"%>
	<script charset="utf-8" src="${baseURL}/js/kindeditor/kindeditor-all.js"></script>
    <script charset="utf-8" src="${baseURL}/js/kindeditor/lang/zh-CN.js"></script>
    <script type="text/javascript">
    KindEditor.ready(function (K) {
        var editor = K.create('#myConXheditor', {
            resizeType: 1,
            shadowMode: false,
            allowPreviewEmoticons: false, 
            allowImageUpload: true,
            allowImageRemote: false,
            allowFlashUpload: false,
            uploadJson:baseURL+'/upload/toImage',
			items:['fontname','fontsize','|','forecolor','hilitecolor','bold','italic','underline','removeformat','|','justifyleft','justifycenter','justifyright','insertorderedlist','insertunorderedlist','|','emoticons','image','link'],
            afterCreate: function () {
                $(this.edit.iframe.get(0).contentWindow.document).keydown(function (e) {
                    if ((e.ctrlKey || e.metaKey) && e.which == 13 && !e.shiftKey && !e.altKey) {
                        $("#myConXheditor").parent().submit();
                    }
                });
            },
            afterChange: function () {
                this.sync();
            }
        });
    });
    </script>
</div>
</body>
</html>