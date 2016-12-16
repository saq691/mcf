$(document).ready(function(){
	$('#addAccount').on('click',function(){
		var content=document.getElementById("AccountWapper");
        var d=dialog({title:'新增账号 ',id:'ADDSYSUSER',content:content,quickClose:true}).show();
	});
	$('#dataList').on('click','.enabled',function(){
		$.ajax({
			type:'post',
			url:baseURL+'/sysuser/enabled',
			data:{'id':this.id},
			dataType:'json',
			success:function(data){
				var skin = data.status?'auto-close':'auto-warn';
				var d=dialog({title:validateMsg.CHECK_TITLE,skin:skin,content:data.msg}).show();
				setTimeout(function(){if(data.status){window.location.reload();}d.close().remove();},1000);
				return false;
			}
		});
	}).on('click','.disabled',function(){
		$.ajax({
			type:'post',
			url:baseURL+'/sysuser/disabled',
			data:{'id':this.id},
			dataType:'json',
			success:function(data){
				var skin = data.status?'auto-close':'auto-warn';
				var d=dialog({title:validateMsg.CHECK_TITLE,skin:skin,content:data.msg}).show();
				setTimeout(function(){if(data.status){window.location.reload();}d.close().remove();},1000);
				return false;
			}
		});
	});
	$('#addSysUserBtn').on('click',function(){
		var sysusername=$.trim($('#sysusername').val());
		var syspassword=$.trim($('#syspassword').val());
		var msgDialog=dialog({title:validateMsg.CHECK_TITLE,skin:'auto-warn',quickClose:true});
		if(sysusername==''){msgDialog.content('请输入系统账号').show();return false;}
		if(syspassword==''){msgDialog.content('请输入账号密码').show();return false;}
		$.ajax({
			type:'post',
			url:baseURL+'/sysuser/addSysuser',
			data:{'username':sysusername,'password':syspassword},
			dataType:'json',
			success:function(data){
				var addDialog=dialog.get('ADDSYSUSER');
				if(!data){
					addDialog.close().remove();
					var d=dialog({title:validateMsg.CHECK_TITLE,skin:'auto-warn',content:'您已经提交过了！！！'}).show();
					setTimeout(function(){d.close().remove();},3000);
				}else{
					addDialog.close().remove();
					var skin=data.status?'auto-close':'auto-warn';
					var d=dialog({title:validateMsg.CHECK_TITLE,skin:skin,content:data.msg}).show();
					setTimeout(function(){if(data.status){window.location.reload();}d.close().remove();},2000);
				}
				return false;
			}
		});
	});
	$('#delete').on('click',function(){
		var temp=$('#dataList').find('input[name="listValue"]');
		var chNum=temp.filter(':checked').length;
		var ids=[];
		if(!chNum){
			dialog({title:validateMsg.CHECK_TITLE,skin:'auto-warn',content:validateMsg.CHECK_MIN_VALUE,quickClose:true}).show();
			return false;
		}
		temp.filter(':checked').each(function(){
			ids.push($(this).val());
		});
		$.ajax({
			type:'post',
			url:baseURL+'/sysuser/delete',
			data:{'ids':ids.join(",")},
			dataType:'json',
			success:function(data){
				var skin = data.status?'auto-close':'auto-warn';
				var d=dialog({title:validateMsg.CHECK_TITLE,skin:skin,content:data.msg}).show();
				setTimeout(function(){if(data.status){window.location.reload();}d.close().remove();},1000);
				return false;
			}
		});
	});
	$('#searchBtn').click(function(){
		var lastParams={};
		var keywords=$.trim($('#keywords').val());
		if(keywords!=''){lastParams['keywords']=keywords;}
	    var flag=isEmptyObj(lastParams);
	    if(flag){window.open(baseURL+'/sysuser/list.html?'+$.param(lastParams),'_self');}
	});
	$('#goBtn').click(function(){
		var lastParams={};
		var currentPage=$.trim($('#currentPage').val());
		if(currentPage!=''){lastParams['currentPage']=currentPage;}
	    var flag=isEmptyObj(lastParams);
	    if(flag){window.open(baseURL+'/sysuser/list.html?'+$.param(lastParams),'_self');}
	});
});