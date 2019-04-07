
layui.use(['layer','laydate'], function(){

});

var boBannerConsoleGrid =new consoleGrid({table_id:"boBanner"});
boBannerConsoleGrid.init();
function boBannerTableOperate(value){
return "<button type='button' class='btn btn-xs btn-default command-edit' onclick='consoleOpenWindow(\"boBanner\",\"/console/bo_banner/edit?id="+value+"\",\"编辑\")'><span class='glyphicon glyphicon-pencil'></span></button> ";
}
function boBannerLoadParam(params){
params.query=boBannerQueryString();
return params;
}
function boBannerQueryString() {
var objQuery = new Object();
    objQuery.title=$('#title').val()==''?null:$('#title').val(); 
     objQuery.target=$('#target').val()==''?null:$('#target').val(); 
     objQuery.targetType=$('#targetType').val()==''?null:$('#targetType').val(); 
     objQuery.type=$('#type').val()==''?null:$('#type').val(); 
     objQuery.sort=$('#sort').val()==''?null:$('#sort').val(); 
     objQuery.status=$('#status').val()==''?null:$('#status').val(); 
 
var queryString = JSON.stringify(objQuery);
return queryString;
}

       function boBannerbanner_imgFormatter(value) 
       { 
         return '<a href="'+value+'" target="_blank" > <img style="height:50px;" src="'+value+'" alt="缩略图"> </a>';
       }
 function boBannertarget_typeFormatter(value) 
   { 
       var showValue=''; 
       switch(value+''){
       case '1': 
       showValue = '网页';
       break;
       }
    if(showValue.indexOf('不')!=-1||showValue.indexOf('否')!=-1||showValue.indexOf('禁')!=-1){    
       return '<span class="label label-warning">'+showValue+'</span>';
   }else{
       return '<span class="label label-info">'+showValue+'</span>';
   }
   }
 function boBannertypeFormatter(value) 
   { 
       var showValue=''; 
       switch(value+''){
       case '1': 
       showValue = '官网首页轮播';
       break;
       }
    if(showValue.indexOf('不')!=-1||showValue.indexOf('否')!=-1||showValue.indexOf('禁')!=-1){    
       return '<span class="label label-warning">'+showValue+'</span>';
   }else{
       return '<span class="label label-info">'+showValue+'</span>';
   }
   }
 function boBannerstatusFormatter(value) 
   { 
       var showValue=''; 
       switch(value+''){
       case '1': 
       showValue = '可用';
       break;
       case '0': 
       showValue = '不可用';
       break;
       }
    if(showValue.indexOf('不')!=-1||showValue.indexOf('否')!=-1||showValue.indexOf('禁')!=-1){    
       return '<span class="label label-warning">'+showValue+'</span>';
   }else{
       return '<span class="label label-info">'+showValue+'</span>';
   }
   }
