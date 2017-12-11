package com.example.service;

import com.example.model.UserBean;
import com.example.repository.UserRepository;
import com.example.util.MD5Encrypt;
import com.example.util.ReplyBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public ReplyBox addUser(String email,String pwd){
        ReplyBox replyBox = new ReplyBox();
        UserBean userBean = new UserBean();
        try {
            userBean.setPwd(MD5Encrypt.toEncryptString(pwd));
            userBean.setEmail(email);
            UserBean user = userRepository.save(userBean);
            if(user != null){
                replyBox.setRtCode("0");
                replyBox.setData(user);
            }else {
                replyBox.setRtCode("1");
                replyBox.setRtMsg("注册失败");
            }
        } catch (Exception e) {
            replyBox.setRtCode("F");
            replyBox.setRtMsg("数据库异常");
        }finally {
            return replyBox;
        }
    }

    public ReplyBox checkUser(String email,String pwd){
        ReplyBox replyBox = new ReplyBox();
        try {
            pwd = MD5Encrypt.toEncryptString(pwd);
            UserBean userBean = userRepository.findByEmail(email);
            if(userBean != null){
                if(pwd.equals(userBean.getPwd())){
                    replyBox.setRtCode("0");
                    replyBox.setData(userBean);
                }else {
                    replyBox.setRtCode("1");
                    replyBox.setRtMsg("密码错误");
                }
            }else {
                replyBox.setRtCode("2");
                replyBox.setRtMsg("用户名不存在");
            }
        } catch (Exception e) {
            replyBox.setRtCode("F");
            replyBox.setRtMsg("数据库异常");
            return replyBox;
        }finally {
            return replyBox;
        }
    }
}
