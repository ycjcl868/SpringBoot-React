package com.example.model;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "goods")
public class GoodsBean implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "goodsname")
    private String goodsName;
    @Column(name = "author")
    private String author;
    @Column(name = "press")
    private String press;
    @Column(name = "price")
    private Integer price;
    @Column(name = "number")
    private Integer number;
    @Column(name = "salenum")
    private Integer saleNum;
    @Column(name = "time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getSaleNum() {

        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }

    public Integer getPrice() {

        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNumber() {

        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getPress() {

        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getAuthor() {

        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGoodsName() {

        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
