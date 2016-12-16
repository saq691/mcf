$(document).ready(function(){
	$('#dataList').on('change','.isContact',function(){
		$.ajax({
			type:'post',
			url:baseURL+'/copartner/isContact',
			data:{'id':this.id,'isContact':$(this).val()},
			dataType:'json',
			success:function(data){
				var skin = data.status?'auto-close':'auto-warn';
				var d=dialog({title:validateMsg.CHECK_TITLE,skin:skin,content:data.msg}).show();
				setTimeout(function(){if(data.status){window.location.reload();}d.close().remove();},1000);
				return false;
			}
		});
	}).on('click','.addRemark',function(){
		var d=dialog.getCurrent();
		if(d!=null){d.remove().close();}
		var id=$(this).prev().val();
		var content='<textarea class="textarea" id="remark" name="remark" placeholder="请输入备注">'+this.title+'</textarea>';
		d=dialog({
			align:'left',
			skin:'follow',
			content:content,
			okValue:'确定',
			ok:function(){
				var remark=$.trim($('#remark').val());
				if(remark==''||remark.length>250){
					dialog({title:validateMsg.CHECK_TITLE,skin:'auto-warn',content:'请输入备注，并不能大于250字符',quickClose:true}).show();
					return false;
				}
				$.ajax({
					type:'post',
					url:baseURL+'/copartner/addRemark',
					data:{'id':id,'remark':remark},
					dataType:'json',
					success:function(data){
						var skin = data.status?'auto-close':'auto-warn';
						var d=dialog({title:validateMsg.CHECK_TITLE,skin:skin,content:data.msg}).show();
						setTimeout(function(){if(data.status){window.location.reload();}d.close().remove();},1000);
						return false;
					}
				});
			},
			cancelValue:'取消',
			cancel:function(){}
		});
		d.show(document.getElementById(this.id));
		return false;
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
			url:baseURL+'/copartner/delete',
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
	    if(flag){window.open(baseURL+'/copartner/list.html?'+$.param(lastParams),'_self');}
	});
	$('#goBtn').click(function(){
		var lastParams={};
		var currentPage=$.trim($('#currentPage').val());
		if(currentPage!=''){lastParams['currentPage']=currentPage;}
	    var flag=isEmptyObj(lastParams);
	    if(flag){window.open(baseURL+'/copartner/list.html?'+$.param(lastParams),'_self');}
	});
});