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
require(['jquery','dialog','lib/jquery-ui'],function($,diglog){
	$('#showMenu').click(function(){
		$('#navMenu').toggle();
	});
	$('.div-select').on({
		mouseover:function(){$(this).find('div').addClass('select-label-show');},
		mouseout:function(){$(this).find('div').removeClass('select-label-show');}
	}).on('click','.select-con>a',function(){
		$(this).parent().prev('input').val(this.title);
		$(this).parents('.select-con').removeClass('select-label-show');
		var $company=$('.company');
		if(this.title=='企业'){
			$company.css('display','block');
		}
		if(this.title=='个体'){
			$company.css('display','none');
		}
	}).on('click','.select-close',function(){
		$(this).parents('.select-con').removeClass('select-label-show');
	});
	$('#cityName').autocomplete({
		minLength:1,
		source:function(req,resp){
			var cityName=$.trim($('#cityName').val());
			$.ajax({
				type:'post',
				url:'cityInfo',
				data:{name:cityName},
				dataType:'json',
				success:function(data){
					var buffer=$.map(data,function(item){
						var cityName=item.shortName;
						var pinyin=item.pinyin;
						var cityId=item.id;
						return {name:cityName,spell:pinyin,cityId:cityId};
					});
					resp(buffer);
		 		 }
			});
		},
		select:function(event,ui){
			$('#cityName').val(ui.item.name);
			$('#cityId').val(ui.item.cityId);
	 		return false;
		}
	}).data("ui-autocomplete" )._renderItem=function(ul,item){
		return $('<li></li>').data('item.autocomplete',item).append('<a>'+item.name+'<span class="autocomplete-item-span">'+item.spell+'</span></a>').appendTo(ul);
	};
	$('#partnerBtn').on('click',function(){
		var cooperateType=$.trim($('#cooperateType').val());
		var cityName=$.trim($('#cityName').val());
		var name=$.trim($('#name').val());
		var contactWay=$.trim($('#contactWay').val());
		var companyScale=$.trim($('#companyScale').val());
		var mainBusiness=$.trim($('#mainBusiness').val());
		var msgd=dialog({content:'',skin:'error'});
		if(cooperateType==''){msgd.content('<i></i><span>请选择合作类型</span>').show(document.getElementById('cooperateType'));setTimeout(function(){msgd.close().remove();},2000);return false;}
		if(cityName==''){msgd.content('<i></i><span>请输入城市名称</span>').show(document.getElementById('cityName'));setTimeout(function(){msgd.close().remove();},2000);return false;}
		if(name==''){msgd.content('<i></i><span>请输入姓名</span>').show(document.getElementById('name'));setTimeout(function(){msgd.close().remove();},2000);return false;}
		if(contactWay==''){msgd.content('<i></i><span>请输入联系方式</span>').show(document.getElementById('contactWay'));setTimeout(function(){msgd.close().remove();},2000);return false;}
		if(cooperateType=='企业'){
			if(companyScale==''){msgd.content('<i></i><span>请选择公司规模</span>').show(document.getElementById('companyScale'));setTimeout(function(){msgd.close().remove();},2000);return false;}
			if(mainBusiness==''){msgd.content('<i></i><span>请输入主营业务</span>').show(document.getElementById('mainBusiness'));setTimeout(function(){msgd.close().remove();},2000);return false;}
		}
		$.ajax({
			type:'post',
			url:'toApply',
			data:{'scooperateType':cooperateType,'cityName':cityName,'cityId':$('#cityId').val(),'name':name,'contactWay':contactWay,'scompanyScale':companyScale,'mainBusiness':mainBusiness},
			dataType:'json',
			success:function(data){
				var d=dialog.getCurrent();
				if(d!=null){d.close().remove();}
				if(!data){
					var lastDialog=dialog.get('APPLY');
					if(lastDialog!=null){lastDialog.close().remove();}
					d=dialog({title:validateMsg.CHECK_TITLE,skin:'auto-warn',content:'您已经提交过了！！！'}).show();
					setTimeout(function(){d.close().remove();},3000);
				}else{
					var skin=data.status?'auto-close':'auto-warn';
					d=dialog({title:validateMsg.CHECK_TITLE,id:'APPLY',skin:skin,content:data.msg}).show();
					setTimeout(function(){if(data.status){window.location.reload();}d.close().remove();},3000);
				}
				return false;
			}
		});
	});
});