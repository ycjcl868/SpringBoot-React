package com.example.repository;

import com.example.model.GoodsBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends JpaRepository<GoodsBean,Integer> {

    Page<GoodsBean> findAll(Pageable pageable);

    Page<GoodsBean> findByPriceBetween(Integer min,Integer max,Pageable pageable);

    Page<GoodsBean> findByGoodsNameLike(String goodsName,Pageable pageable);

    @Query("select goods.price from GoodsBean goods where goods.id = ?1")
    Integer findGoodsBeansPrice(Integer gid);
}
