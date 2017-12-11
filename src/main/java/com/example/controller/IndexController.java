package com.example.controller;
import com.example.service.GoodsService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api")
public class IndexController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/findPopular")
    public Object getPopularGoods(@RequestParam String pageSize){
       return goodsService.getPopularGoods(pageSize);
    }

    @RequestMapping(value = "/goods", method = RequestMethod.GET)
    public Object getMostNewGoods(@RequestParam String pageSize){
        return goodsService.getMostNewGoods(pageSize);
    }


    @RequestMapping("/findByKey")
    public Object getGoodsByKey(@RequestParam String key,@RequestParam String pageSize){
        System.out.println("Hahaha");
        return goodsService.getGoodsForKey(key, pageSize);
    }

    @RequestMapping("/findByPrice")
    public Object getGoodsByPrice(@RequestParam String min,@RequestParam String max,@RequestParam String pageSize){
        return goodsService.getGoodsForPrice(min, max, pageSize);
    }
    @RequestMapping("/putCar")
    public Object putGoodsForCar(HttpServletRequest request,@RequestParam String gid){
        List<Integer> list = (List<Integer>) request.getSession().getAttribute("car");
        list = goodsService.putCar(list,gid);
        request.getSession().setAttribute("car",list);
        return "ok";
    }
    @RequestMapping("/deleteCar")
    public Object deleteGoodsForCar(HttpServletRequest request,@RequestParam String gid){
        List<Integer> list = (List<Integer>) request.getSession().getAttribute("car");
        list = goodsService.deleteCar(list,gid);
        request.getSession().setAttribute("car",list);
        return "ok";
    }
    @RequestMapping("/countPrice")
    public Object countAllPrice(HttpServletRequest request){
        List<Integer> list = (List<Integer>) request.getSession().getAttribute("car");
        return goodsService.countAllPrice(list);
    }
    @RequestMapping("/showCar")
    public Object showShoppingCar(HttpServletRequest request){
        List<Integer> list = (List<Integer>) request.getSession().getAttribute("car");
        return goodsService.showShoppingCar(list);
    }
}
