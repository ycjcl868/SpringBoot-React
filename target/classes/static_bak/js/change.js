var denomination = new Array(50,20,10,5,1);
function change() {
    var value = new Array(0,0,0,0,0);
    var money = $("#pay").val() - $("#countPrice").val();
    var i=0;
    while(money > 0 && i < 5){
        value[i] =Math.floor(money / denomination[i]);
        money = money - value[i]*denomination[i];
        i++;
    }
    var info = "找零：";
    for( i = 0;i < 5;i++){
        if(value[i] != 0){
            info += denomination[i]+"元："+value[i]+"个    ";
        }
    }
    alert(info);
    alert("欢迎下次光临");
}
function clearning() {
   $.ajax(
        {
            type:"post",
            url:"/index/countPrice",
            dataType:"json",
            success:function (data) {
                data = data.toString();
                if(data != NaN){
                    $("#change").show();
                    $("#countPrice").empty();
                    $("#countPrice").val(data);
                }
            }
        }
    )
}

function showUserInfo(){
	$.ajax(
        {
            type:"post",
            url:"/user/findInfo",
            dataType:"json",
            success:function (data) {
                $("#name").append(data.data.uname);
                $("#address").append(data.data.address);
                $("#phone").append(data.data.phone);
                $("#info").show();
                $("#showpay").show();
            }
        }
    )
}