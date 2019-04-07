
layui.use(['layer','laydate'], function(){

});
$(function($) {
/*开启表单验证*/
$("#sysDictionary_form").validation();
      $('input[auto_name="sysDictionary_defaultValue"]').each(function(){
       if('${sysDictionary.defaultValue!}'==this.value){ 
             $(this).attr('checked','checked');
            }
           });
 
});
/*保存*/
function saveZqForm(){
if ($("#sysDictionary_form").valid() == false) {
return false;
}
var formObject=new Object();
formObject.code=$('#code').val()==''?null:$('#code').val(); 
 formObject.value=$('#value').val()==''?null:$('#value').val(); 
 formObject.des=$('#des').val()==''?null:$('#des').val(); 
 formObject.name=$('#name').val()==''?null:$('#name').val(); 
 formObject.defaultValue=($('input[name="defaultValue"]:checked').val()==''?null:$('input[name="defaultValue"]:checked').val()); 
 formObject.id=$('#id').val()==''?null:$('#id').val(); 
 
var formObjectJson = JSON.stringify(formObject);
$.post("/console/sys_dictionary/save",
{
formObjectJson :formObjectJson,
common_token :$("#common_token").val()
}, function(data) {
layer.alert(data.message, {skin: 'layui-layer-molv',closeBtn: 0 }, function(){
parent.$("#sysDictionary").bootstrapTable("refresh");
parent.layer.closeAll();
});

});
}