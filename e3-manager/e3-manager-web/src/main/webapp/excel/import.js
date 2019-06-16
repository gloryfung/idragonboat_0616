  /*导入数据*/
function importUsers(){
	debugger;
	//var clientid = $("#clientid").val();
	var FormDatas=new FormData($("#form-article-add")[0]);
	var fileName=$("#file").val();
	if(fileName == '') {
          layer.msg('请选择文件！',{
          	icon:MSG_CHECK,
          	time:MSG_TIME
          }); 
          return false;
      }
	//验证文件格式
       var fileType = (fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length)).toLowerCase();
	if (fileType != 'xlsx') {
		debugger;
		    layer.msg('文件格式不正确！',{
		     icon:MSG_CHECK,
		     time:MSG_TIME
		 });
		return false;
	} 
	$.ajax({
		type:'post',
		url:'',
		async : false,
		cache : false,
		contentType : false,
		processData : false,
		data:FormDatas,
		success: function(data){
			if(data == "error"){
				layer.msg("文件导入失败，请重新上传！", {
					icon: OPER_SB,
					shade: [0.3, '#393D49'], // 透明度  颜色
					time:5000
					});
				return false;
			}else{
				layer.msg("文件导入成功！", {
					icon: OPER_CG,
					shade: [0.3, '#393D49'], // 透明度  颜色
					time:5000
					});
				window.location.reload();
				return false;
			}
		},
		error : function(data){
			console.log(data.msg);
		}
	});
}
