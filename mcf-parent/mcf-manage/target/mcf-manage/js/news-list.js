$(document).ready(function(){
	$('#dataList').on('click','.successStick',function(){
		$.ajax({
			type:'post',
			url:baseURL+'/news/successStick',
			data:{'id':this.id},
			dataType:'json',
			success:function(data){
				var skin = data.status?'auto-close':'auto-warn';
				var d=dialog({title:validateMsg.CHECK_TITLE,skin:skin,content:data.msg}).show();
				setTimeout(function(){if(data.status){window.location.reload();}d.close().remove();},1000);
				return false;
			}
		});
	}).on('click','.cancelStick',function(){
		$.ajax({
			type:'post',
			url:baseURL+'/news/cancelStick',
			data:{'id':this.id},
			dataType:'json',
			success:function(data){
				var skin = data.status?'auto-close':'auto-warn';
				var d=dialog({title:validateMsg.CHECK_TITLE,skin:skin,content:data.msg}).show();
				setTimeout(function(){if(data.status){window.location.reload();}d.close().remove();},1000);
				return false;
			}
		});
	}).on('click','.showStatus',function(){
		$.ajax({
			type:'post',
			url:baseURL+'/news/showStatus',
			data:{'id':this.id},
			dataType:'json',
			success:function(data){
				var skin = data.status?'auto-close':'auto-warn';
				var d=dialog({title:validateMsg.CHECK_TITLE,skin:skin,content:data.msg}).show();
				setTimeout(function(){if(data.status){window.location.reload();}d.close().remove();},1000);
				return false;
			}
		});
	}).on('click','.hideStatus',function(){
		$.ajax({
			type:'post',
			url:baseURL+'/news/hideStatus',
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
			url:baseURL+'/news/delete',
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
	    if(flag){window.open(baseURL+'/news/list.html?'+$.param(lastParams),'_self');}
	});
	$('#goBtn').click(function(){
		var lastParams={};
		var currentPage=$.trim($('#currentPage').val());
		if(currentPage!=''){lastParams['currentPage']=currentPage;}
	    var flag=isEmptyObj(lastParams);
	    if(flag){window.open(baseURL+'/news/list.html?'+$.param(lastParams),'_self');}
	});
});