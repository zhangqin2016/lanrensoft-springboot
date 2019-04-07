
layui.use(['layer','laydate'], function(){

});

var boContactUsConsoleGrid =new consoleGrid({table_id:"boContactUs"});
boContactUsConsoleGrid.init();
function boContactUsTableOperate(value){
return "<button type='button' class='btn btn-xs btn-default command-edit' onclick='consoleOpenWindow(\"boContactUs\",\"/console/bo_contact_us/edit?id="+value+"\",\"编辑\")'><span class='glyphicon glyphicon-pencil'></span></button> ";
}
function boContactUsLoadParam(params){
params.query=boContactUsQueryString();
return params;
}
function boContactUsQueryString() {
var objQuery = new Object();
    objQuery.linkName=$('#linkName').val()==''?null:$('#linkName').val(); 
     objQuery.linkPhone=$('#linkPhone').val()==''?null:$('#linkPhone').val(); 
     objQuery.linkSub=$('#linkSub').val()==''?null:$('#linkSub').val(); 
     objQuery.linkContent=$('#linkContent').val()==''?null:$('#linkContent').val(); 
     objQuery.linkTime=$('#linkTime').val()==''?null:$('#linkTime').val(); 
     objQuery.linkMail=$('#linkMail').val()==''?null:$('#linkMail').val(); 
     objQuery.linkState=$('#linkState').val()==''?null:$('#linkState').val(); 
 
var queryString = JSON.stringify(objQuery);
return queryString;
}

 function boContactUslink_stateFormatter(value) 
   { 
       var showValue=''; 
       switch(value+''){
       case '0': 
       showValue = '未联系';
       break;
       case '1': 
       showValue = '已联系';
       break;
       }
    if(showValue.indexOf('不')!=-1||showValue.indexOf('否')!=-1||showValue.indexOf('禁')!=-1){    
       return '<span class="label label-warning">'+showValue+'</span>';
   }else{
       return '<span class="label label-info">'+showValue+'</span>';
   }
   }
