package com.example.service;

import com.example.model.GoodsBean;
import com.example.repository.GoodsRepository;
import com.example.util.ReplyBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsService {
   @Autowired
   private GoodsRepository goodsRepository;
   public ReplyBox getPopularGoods(String pageSize){
       ReplyBox replyBox = new ReplyBox();
       try {
           Sort sort = new Sort(Sort.Direction.DESC,"saleNum");
           Pageable pageable = new PageRequest(Integer.parseInt(pageSize),6,sort);
           Page<GoodsBean> page = goodsRepository.findAll(pageable);
           replyBox.setRtCode("0");
           replyBox.setData(page.getContent());
       }catch (Exception e){
           replyBox.setRtCode("F");
           replyBox.setRtMsg("数据库异常");
       }finally {
           return replyBox;
       }
   }

   public ReplyBox getMostNewGoods(String pageSize){
       ReplyBox replyBox = new ReplyBox();
       try {
           Sort sort = new Sort(Sort.Direction.DESC,"time");
           Pageable pageable = new PageRequest(Integer.parseInt(pageSize),6,sort);
           Page<GoodsBean> page = goodsRepository.findAll(pageable);
           replyBox.setRtCode("0");
           replyBox.setData(page.getContent());
       }catch (Exception e){
           replyBox.setRtCode("F");
           replyBox.setRtMsg("数据库异常");
       }finally {
           return replyBox;
       }

    }

   public ReplyBox getGoodsForPrice(String min,String max,String pageSize){
       ReplyBox replyBox = new ReplyBox();
       try {
           Pageable pageable = new PageRequest(Integer.parseInt(pageSize),6);
           Page<GoodsBean> page = goodsRepository.findByPriceBetween(Integer.parseInt(min),Integer.parseInt(max),pageable);
           replyBox.setRtCode("0");
           replyBox.setData(page.getContent());
       }catch (Exception e){
           replyBox.setRtCode("F");
           replyBox.setRtMsg("数据库异常");
       }finally {
           return replyBox;
       }
   }

   public ReplyBox getGoodsForKey(String key,String pageSize){
       ReplyBox replyBox = new ReplyBox();
       key = "%"+key+"%";
       try {
           Pageable pageable = new PageRequest(Integer.parseInt(pageSize),6);
           Page<GoodsBean> page = goodsRepository.findByGoodsNameLike(key,pageable);
           replyBox.setRtCode("0");
           replyBox.setData(page.getContent());
       }catch (Exception e){
           replyBox.setRtCode("F");
           replyBox.setRtMsg("数据库异常");
       }finally {
           return replyBox;
       }
   }
   public List<Integer> putCar(List<Integer> list,String gid){
      list.add(Integer.parseInt(gid));
      return list;
   }
   public List<Integer> deleteCar(List<Integer> list,String gid){
       list.remove((Integer)Integer.parseInt(gid));
       return list;
   }
   @Transactional
   public Integer countAllPrice(List<Integer> list){
       int allPrice = 0;
       int num = list.size();
       for(int i = 0;i < num;i++){
           allPrice += goodsRepository.findGoodsBeansPrice(list.get(i));
       }
       return allPrice;
   }
   @Transactional
   public List<GoodsBean> showShoppingCar(List<Integer> list){
       List<GoodsBean> goods = new ArrayList<GoodsBean>();
       int num = list.size();
       for(int i = 0;i < num;i++){
          goods.add(goodsRepository.findOne(list.get(i)));
       }
       return goods;
   }
}
