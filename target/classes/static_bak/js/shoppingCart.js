function putGoodsInCar(gid) {
    if(isLogin == 0){
        alert("请先登录");
        return;
    }
    $.ajax(
        {
            type: "post",
            url: "/index/putCar",
            data:{
                "gid":gid
            },
            success : function(data) {
                var data = data.toString();
                if(data.toLocaleLowerCase() == "ok".toLocaleLowerCase())
                    alert("添加成功");
                else
                    alert("添加失败");
            }
        }
    );
}

function deleteGoodsforCar(gid) {
    $.ajax(
        {
            type: "post",
            url: "/index/deleteCar",
            data:{
                "gid":gid
            },
            success : function(data) {
                var data = data.toString();
                if(data.toLocaleLowerCase() == "ok".toLocaleLowerCase()) {
                    $("#" + gid).remove();
                    clearning();
                }
                else
                    alert("删除失败");
            }
        }
    );
}
function login() {
    var uname = $("#uname").val();
    var pwd = $("#pwd").val();
    $.ajax(
        {
            type: "post",
            url: "/user/login",
            data:{
                "email":uname,
                "pwd":pwd
            },
            success : function(data) {
                if(data.rtCode == 0){
                    showTitle();
                    $('.theme-popover-mask').fadeOut(100);
                    $('.theme-popover').slideUp(200);
                }else{
                    alert(data.rtMsg);
                }
            }
        }
    );
}
