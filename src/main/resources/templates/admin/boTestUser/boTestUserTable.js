
layui.use(['layer','laydate'], function(){

});

var boTestUserConsoleGrid =new consoleGrid({table_id:"boTestUser"});
boTestUserConsoleGrid.init();
function boTestUserTableOperate(value){
return "<button type='button' class='btn btn-xs btn-default command-edit' onclick='consoleOpenWindow(\"boTestUser\",\""+zqCtxPath+"/console/bo_test_user/edit?id="+value+"\",\"编辑\")'><span class='glyphicon glyphicon-pencil'></span></button> ";
}
function boTestUserLoadParam(params){
params.query=boTestUserQueryString();
return params;
}
function boTestUserQueryString() {
var objQuery = new Object();
    objQuery.name=$('#name').val()==''?null:$('#name').val(); 
     objQuery.age=$('#age').val()==''?null:$('#age').val(); 
     objQuery.userSex=$('#userSex').val()==''?null:$('#userSex').val(); 
     objQuery.userSchoolGrade=$('#userSchoolGrade').val()==''?null:$('#userSchoolGrade').val(); 
 
var queryString = JSON.stringify(objQuery);
return queryString;
}

       function boTestUseruser_head_imgFormatter(value) 
       { 
         return '<a href="'+value+'" target="_blank" > <img style="height:50px;" src="'+value+'" alt="缩略图"> </a>';
       }
 function boTestUseruser_sexFormatter(value) 
   { 
       var showValue=''; 
       switch(value+''){
       case '1': 
       showValue = '男';
       break;
       case '0': 
       showValue = '女';
       break;
       }
    if(showValue.indexOf('不')!=-1||showValue.indexOf('否')!=-1||showValue.indexOf('禁')!=-1){    
       return '<span class="label label-warning">'+showValue+'</span>';
   }else{
       return '<span class="label label-info">'+showValue+'</span>';
   }
   }
 function boTestUseruser_school_gradeFormatter(value) 
   { 
       var showValue=''; 
       switch(value+''){
       case '1': 
       showValue = '1级';
       break;
       case '2': 
       showValue = '2级';
       break;
       case '3': 
       showValue = '3级';
       break;
       }
    if(showValue.indexOf('不')!=-1||showValue.indexOf('否')!=-1||showValue.indexOf('禁')!=-1){    
       return '<span class="label label-warning">'+showValue+'</span>';
   }else{
       return '<span class="label label-info">'+showValue+'</span>';
   }
   }
