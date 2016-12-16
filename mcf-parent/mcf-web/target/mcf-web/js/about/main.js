require.config({
	baseUrl:'js',
	paths:{
		jquery:'lib/jquery',
		dialog:'lib/dialog-min'
	},
    shim: {  
        "dialog":{
            deps:["jquery"], 
            exports:"dialog"
        }
    }
});
//验证提示
var validateMsg={
	CHECK_TITLE:'提示',
	CHECK_NAME:'请输入姓名'
}
define(['jquery','dialog'],function($,diglog){
	$('#showMenu').click(function(){
		$('#navMenu').toggle();
	});
	// 发送联系信息
	$('#sendBtn').click(function(){
		var name=$.trim($('#name').val());
		var email=$.trim($('#email').val());
		var content=$.trim($('#content').val());
		var msgd=dialog({content:'',skin:'error'});
		if(name==''){msgd.content('<i></i><span>请输入姓名</span>').show(document.getElementById('name'));setTimeout(function(){msgd.close().remove();},2000);return false;}
		if(email==''){msgd.content('<i></i><span>请输入电子邮箱或者联系方式</span>').show(document.getElementById('email'));setTimeout(function(){msgd.close().remove();},2000);return false;}
		if(content==''){msgd.content('<i></i><span>请输入信息内容</span>').show(document.getElementById('content'));setTimeout(function(){msgd.close().remove();},2000);return false;}
		$.ajax({
			type:'post',
			url:'sendInfo',
			data:{'name':name,'contactWay':email,'content':content},
			dataType:'json',
			success:function(data){
				var d=dialog.getCurrent();
				if(d!=null){d.close().remove();}
				if(!data){
					var lastDialog=dialog.get('SENDINFO');
					if(lastDialog!=null){lastDialog.close().remove();}
					d=dialog({title:validateMsg.CHECK_TITLE,skin:'auto-warn',content:'您已经提交过了！！！'}).show();
					setTimeout(function(){d.close().remove();},3000);
				}else{
					var skin=data.status?'auto-close':'auto-warn';
					d=dialog({title:validateMsg.CHECK_TITLE,id:'SENDINFO',skin:skin,content:data.msg}).show();
					setTimeout(function(){if(data.status){window.location.reload();}d.close().remove();},3000);
				}
				return false;
			}
		});
	});
});