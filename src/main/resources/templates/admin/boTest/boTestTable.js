
layui.use(['layer','laydate'], function(){

});

var boTestConsoleGrid =new consoleGrid({table_id:"boTest"});
boTestConsoleGrid.init();
function boTestTableOperate(value){
return "<button type='button' class='btn btn-xs btn-default command-edit' onclick='consoleOpenWindow(\"boTest\",\"/console/bo_test/edit?id="+value+"\",\"编辑\")'><span class='glyphicon glyphicon-pencil'></span></button> ";
}
function boTestLoadParam(params){
params.query=boTestQueryString();
return params;
}
function boTestQueryString() {
var objQuery = new Object();
    objQuery.name=$('#name').val()==''?null:$('#name').val(); 
     objQuery.birthday=$('#birthday').val()==''?null:$('#birthday').val(); 
     objQuery.age=$('#age').val()==''?null:$('#age').val(); 
     objQuery.sex=$('#sex').val()==''?null:$('#sex').val(); 
 
var queryString = JSON.stringify(objQuery);
return queryString;
}

       function boTestimg_urlFormatter(value) 
       { 
         return '<a href="'+value+'" target="_blank" > <img style="height:50px;" src="'+value+'" alt="缩略图"> </a>';
       }
  
    componentSelectInit(      
            {                        
                    ctxPath:'',       
           tableName:"sys_dictionary",        
           showValueField:"name",             
           valueField:"value",                 
    selectId:"sex"  ,      
           where:" where code ='sex' "     
                              }              
                              ,function(){   
  });                         
 