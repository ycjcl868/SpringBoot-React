package com.example.service;

import com.example.model.InformationBean;
import com.example.repository.InformationRepository;
import com.example.util.ReplyBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformationService {
    @Autowired
    private InformationRepository informationRepository;

    public ReplyBox save(InformationBean informationBean){
        ReplyBox replyBox = new ReplyBox();
        try {
            informationRepository.save(informationBean);
            replyBox.setRtCode("0");
            replyBox.setRtMsg("保存成功");
        }catch (Exception e){
            replyBox.setRtCode("F");
            replyBox.setRtMsg("数据库异常");
        }finally {
            return replyBox;
        }
    }

    public ReplyBox getInformation(Integer userId){
        ReplyBox replyBox = new ReplyBox();
        System.out.println(userId);
        try {
            InformationBean informationBean = informationRepository.findByUid(userId);
            replyBox.setRtCode("0");
            replyBox.setData(informationBean);
        }catch (Exception e){
            replyBox.setRtCode("F");
            replyBox.setRtMsg("数据库异常");
        }finally {
            return replyBox;
        }
    }
}
