
layui.use(['layer','laydate'], function(){

});

var boWebImageConsoleGrid =new consoleGrid({table_id:"boWebImage"});
boWebImageConsoleGrid.init();
function boWebImageTableOperate(value){
return "<button type='button' class='btn btn-xs btn-default command-edit' onclick='consoleOpenWindow(\"boWebImage\",\"/console/bo_web_image/edit?id="+value+"\",\"编辑\")'><span class='glyphicon glyphicon-pencil'></span></button> ";
}
function boWebImageLoadParam(params){
params.query=boWebImageQueryString();
return params;
}
function boWebImageQueryString() {
var objQuery = new Object();
    objQuery.imageTitle=$('#imageTitle').val()==''?null:$('#imageTitle').val(); 
     objQuery.imageDes=$('#imageDes').val()==''?null:$('#imageDes').val(); 
 
var queryString = JSON.stringify(objQuery);
return queryString;
}

       function boWebImageimage_urlFormatter(value) 
       { 
         return '<a href="'+value+'" target="_blank" > <img style="height:50px;" src="'+value+'" alt="缩略图"> </a>';
       }
