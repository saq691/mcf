var cData={flag:false,MAX_CHECK_VALUE:1};
$(document).ready(function(){
	
});
//验证提示
var validateMsg={
	CHECK_TITLE:'提示',
	CHECK_MIN_VALUE:'您还没有选择呢，请勾选！',
	CHECK_MAX_UPDATE_VALUE:'别逗，修改数据时只能选择一条哦！'
}
function isEmptyObj(obj){
	for(var name in obj){
		return true;
	}
	return false;
}