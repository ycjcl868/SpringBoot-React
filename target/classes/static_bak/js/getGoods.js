/**
 * Created by NewDarker on 2017/11/15.
 */
var key;
var min,max;
var pageSize_price = 0;
var pageSize_key = 0;
var pageSize_popular = 0;
var pageSize_moseNew = 0;
var isLogin = 0;
function find(select){
	if(select == 1){
		$("#ns").show();
		$("#ps").hide();
	}else{
		$("#ps").show();
		$("#ns").hide();
	}
}
function showDiv(select){
	switch(select){
		case 1:{
			var tkey = $("#key").val();
			if(tkey == NaN || tkey == ""){
				alert("搜索关键字不能为空");
				return;
			}
			if(key != tkey){
			    pageSize_key=0;
			    key = tkey;
            }
            $("#s_search").empty();
            $("#popular").hide();
            $("#mostNew").hide();
            $("#car").hide();
            $("#search").show();
			getGoodsForKey(key,pageSize_key++);
			break;
		}
		case 2:{
			var tmin = $("#min").val();
			var tmax = $("#max").val();
			if(tmin== NaN || tmin == "" || tmax== NaN || tmax == ""){
				alert("搜索关键字不能为空");
			    return;
			}
			if(min != tmin || max != tmax){
			    pageSize_price=0;
			    min = tmin;
			    max = tmax;
            }
            $("#s_search").empty();
            $("#popular").hide();
            $("#mostNew").hide();
            $("#car").hide();
            $("#search").show();
			getGoodsForPrice(min,max,pageSize_price++);
			break;
		}
		case 3:{
			getPopular(pageSize_popular++);
			break;
		}
		case 4:{
			getMostNew(pageSize_moseNew++);
			break;
		}
		case 5:{
            if(isLogin == 0){
                alert("请先登录");
                return;
            }
            $("#popular").hide();
            $("#mostNew").hide();
            $("#search").hide();
            $("#car").show();
            showCar();
			break;
		}
	}
}
function showTitle(){
    $.ajax(
        {
            type:"post",
            url:"/user/getTitle",
            dataType:"json",
            success:function (data) {
                var uName = data.uName;
                $("#onlineNum").empty();
                $("#onlineNum").append(data.onlineNum);
                if(uName == NaN || uName == ""){
                    $("#username").hide();
                   // $("#nouser").append("<a class=\"btn btn-primary btn-large theme-login\" href=\"javascript:;\">登录</a>|<a class='btn btn-primary btn-large theme-login'>注册</a>");
                    $("#nouser").show();
                 }else{
                    isLogin = 1;
                 	$("#nouser").hide();
                 	$("#username").append(uName);
                 	$("#username").show();
                 }
            }
        }
    )
}
function getPopular(pageSize) {
    $.ajax(
        {
            type: "post",
            url: "/index/findPopular",
            dataType:"json",
            data:{
                "pageSize":pageSize
            },
            success : function(data) {
               var data = data.data;
               var root = $("#s_popular");
               showGoods(root,data);
               addPage($("#p_popular"),data.length,3);
            },
            error : function () {
                alert("失败")
            }
        }
    );
}
function getMostNew(pageSize) {
    $.ajax(
        {
            type: "post",
            url: "/index/findMostNew",
            dataType:"json",
            data:{
                "pageSize":pageSize
            },
            success : function(data) {
               var data = data.data;
               var root = $("#s_mostNew");
               showGoods(root,data);
               addPage($("#p_mostNew"),data.length,4);
            },
            error:function () {
                alert("失败")
            }
        }
    );
}
function getGoodsForKey(key,pageSize) {
    $.ajax(
        {
            type:"post",
            url:"/index/findByKey",
            dataType:"json",
            data:{
                "key":key,
                "pageSize":pageSize
            },
            success:function (data) {
			    var data = data.data;
                var root = $("#s_search");
                showGoods(root,data);
                addPage($("#p_search"),data.length,1);
            }
        }
    )
}
function getGoodsForPrice(min,max,pageSize) {
    $.ajax(
        {
            type:"post",
            url:"/index/findByPrice",
            dataType:"json",
            data:{
                "min":min,
                "max":max,
                "pageSize":pageSize
            },
            success:function (data) {
 				var data = data.data;
                var root = $("#s_search");
                showGoods(root,data);
                addPage($("#p_search"),data.length,2);
            }
        }
    )
}
function showCar(){
	$.ajax(
        {
            type:"post",
            url:"/index/showCar",
            dataType:"json",
            success:function (data) {
                var root = $("#s_car");
                root.empty();
                if(data.length > 0){
                    $.each(data,function(i,item) {
                        root.append("<tr id='"+item.id+"'><td><img src=\"../image/book.png\"></td><td>"+item.goodsName+"</td><td>"+item.author+
                            "</td><td>"+item.press+"</td><td>￥："+item.price+"</td>" +
                            "<td><button onclick='deleteGoodsforCar("+item.id+")'>删除该商品</button></td></tr>");
                    })
                    clearning();
                }else{
                    root.append("<h2 align='center'>购物车快饿死了，快去<a style='color: red' href=\"../index.html\">添加</a>吧</h2>");
                }
            }
        }
    )
}
function showGoods(root,data) {
    $.each(data,function(i,item) {
        root.append("<tr><td><img src=\"../image/book.png\"></td><td>"+item.goodsName+"</td><td>"+item.author+
            "</td><td>"+item.press+"</td><td>￥："+item.price+"</td>" +
            "<td><button onclick='putGoodsInCar("+item.id+")'>加入购物车</button></td></tr>");
    })
}
function addPage(root,flag,index){
    root.empty();
	if(flag > 0){
		root.append("<button onclick='nextPage("+index+")'>查看更多商品</button>");
	}else{
		root.append("没有更多了");
	}
}
function nextPage(index) {
    switch (index){
        case 1:{
            getGoodsForKey(key,pageSize_key++);
            break;
        }
        case 2:{
            getGoodsForPrice(min,max,pageSize_price++);
            break;
        }
        case 3:{
            getPopular(pageSize_popular++);
            break;
        }
        case 4:{
            getMostNew(pageSize_moseNew++);
            break;
        }
    }
}
function init() {
    showTitle();
    showDiv(3)
    showDiv(4)
}

