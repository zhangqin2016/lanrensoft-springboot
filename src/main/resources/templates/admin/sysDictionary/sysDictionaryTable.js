
layui.use(['layer','laydate'], function(){

});

var sysDictionaryConsoleGrid =new consoleGrid({table_id:"sysDictionary"});
sysDictionaryConsoleGrid.init();
function sysDictionaryTableOperate(value){
return "<button type='button' class='btn btn-xs btn-default command-edit' onclick='consoleOpenWindow(\"sysDictionary\",\"/console/sys_dictionary/edit?id="+value+"\",\"编辑\")'><span class='glyphicon glyphicon-pencil'></span></button> ";
}
function sysDictionaryLoadParam(params){
params.query=sysDictionaryQueryString();
return params;
}
function sysDictionaryQueryString() {
var objQuery = new Object();
    objQuery.code=code;
     objQuery.value=$('#value').val()==''?null:$('#value').val(); 
     objQuery.des=$('#des').val()==''?null:$('#des').val(); 
     objQuery.name=$('#name').val()==''?null:$('#name').val(); 
     objQuery.defaultValue=$('#defaultValue').val()==''?null:$('#defaultValue').val(); 
 
var queryString = JSON.stringify(objQuery);
return queryString;
}

 function sysDictionarydefault_valueFormatter(value) 
   { 
       var showValue=''; 
       switch(value+''){
       case '0': 
       showValue = '否';
       break;
       case '1': 
       showValue = '是';
       break;
       }
    if(showValue.indexOf('不')!=-1||showValue.indexOf('否')!=-1||showValue.indexOf('禁')!=-1){    
       return '<span class="label label-warning">'+showValue+'</span>';
   }else{
       return '<span class="label label-info">'+showValue+'</span>';
   }
   }
