i = 0;
j = 0;
count = 0;
MM = 4;
SS = 59;
MS = 9;
totle = (MM+1)*600;
d = 180*(MM+1);
MM = "0" + MM;
function showTime(){
	totle = totle - 1;
	if(totle==0){
		clearInterval(s);
		clearInterval(t1);
		clearInterval(t2);
		$(".pie2").css("-o-transform","rotate(" + d + "deg)");
		$(".pie2").css("-moz-transform","rotate(" + d + "deg)");
		$(".pie2").css("-webkit-transform","rotate(" + d + "deg)");
	}else{
		if(totle>0 && MS>0){
			MS = MS - 1;
			if(MS < 10){MS = "0" + MS};
		};
		if(MS==0 && SS>0){
			MS = 10;
			SS = SS - 1;
			if(SS < 10){SS = "0" + SS};
		};
		if(SS==0 && MM>0){
			SS = 60;
			MM = MM - 1;
			if(MM < 10){MM = "0" + MM};
		};
	};
	$(".time span").html(MM + ":" + SS + ":" + MS);
};
s = setInterval("showTime()",100);

function start1(){
	i = i + 0.6;
	count = count + 1;
	if(count==300){
		count = 0;
		clearInterval(t1);
		t2 = setInterval("start2()",100);
	};
	$(".pie1").css("-o-transform","rotate(" + i + "deg)");
	$(".pie1").css("-moz-transform","rotate(" + i + "deg)");
	$(".pie1").css("-webkit-transform","rotate(" + i + "deg)");
};
function start2(){
	j = j + 0.6;
	count = count + 1;
	if(count==300){
		count = 0;
		clearInterval(t2);
		t1 = setInterval("start1()",100);
	};
	$(".pie2").css("-o-transform","rotate(" + j + "deg)");
	$(".pie2").css("-moz-transform","rotate(" + j + "deg)");
	$(".pie2").css("-webkit-transform","rotate(" + j + "deg)");
};
t1 = setInterval("start1()",100);