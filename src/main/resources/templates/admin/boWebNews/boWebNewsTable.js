
layui.use(['layer','laydate'], function(){

});

var boWebNewsConsoleGrid =new consoleGrid({table_id:"boWebNews"});
boWebNewsConsoleGrid.init();
function boWebNewsTableOperate(value){
return "<button type='button' class='btn btn-xs btn-default command-edit' onclick='consoleOpenWindow(\"boWebNews\",\"/console/bo_web_news/edit?id="+value+"\",\"编辑\")'><span class='glyphicon glyphicon-pencil'></span></button> ";
}
function boWebNewsLoadParam(params){
params.query=boWebNewsQueryString();
return params;
}
function boWebNewsQueryString() {
var objQuery = new Object();
    objQuery.publish=$('#publish').val()==''?null:$('#publish').val(); 
     objQuery.author=$('#author').val()==''?null:$('#author').val(); 
     objQuery.source=$('#source').val()==''?null:$('#source').val(); 
     objQuery.title=$('#title').val()==''?null:$('#title').val(); 
     objQuery.newsType=$('#newsType').val()==''?null:$('#newsType').val(); 
     objQuery.keyword=$('#keyword').val()==''?null:$('#keyword').val(); 
 
var queryString = JSON.stringify(objQuery);
return queryString;
}

 function boWebNewspublishFormatter(value) 
   { 
       var showValue=''; 
       switch(value+''){
       case '0': 
       showValue = '未发布';
       break;
       case '1': 
       showValue = '已发布';
       break;
       }
    if(showValue.indexOf('不')!=-1||showValue.indexOf('否')!=-1||showValue.indexOf('禁')!=-1){    
       return '<span class="label label-warning">'+showValue+'</span>';
   }else{
       return '<span class="label label-info">'+showValue+'</span>';
   }
   }
       function boWebNewscoverFormatter(value) 
       { 
         return '<a href="'+value+'" target="_blank" > <img style="height:50px;" src="'+value+'" alt="缩略图"> </a>';
       }
 function boWebNewsnews_typeFormatter(value) 
   { 
       var showValue=''; 
       switch(value+''){
       case '1': 
       showValue = '普通新闻';
       break;
       case '2': 
       showValue = '项目简介';
       break;
       case '3': 
       showValue = '成果展示';
       break;
       case '4': 
       showValue = '建设进展';
       break;
       }
    if(showValue.indexOf('不')!=-1||showValue.indexOf('否')!=-1||showValue.indexOf('禁')!=-1){    
       return '<span class="label label-warning">'+showValue+'</span>';
   }else{
       return '<span class="label label-info">'+showValue+'</span>';
   }
   }
