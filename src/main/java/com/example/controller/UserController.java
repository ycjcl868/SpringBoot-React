package com.example.controller;
import com.example.model.GoodsBean;
import com.example.model.InformationBean;
import com.example.model.UserBean;
import com.example.service.InformationService;
import com.example.service.UserService;
import com.example.util.OnlineCount;
import com.example.util.ReplyBox;
import com.example.util.TitleBox;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private InformationService informationService;

    @RequestMapping("/login")
    public Object chockUser(HttpServletRequest request,@RequestParam String email, @RequestParam String pwd){
        ReplyBox replyBox = userService.checkUser(email,pwd);
        if("0".equals(replyBox.getRtCode())){
            request.getSession().setAttribute("car",new ArrayList<Integer>());
            setSessionUser(request,replyBox);
        }
        return replyBox;
    }
    @RequestMapping("/addUser")
    public Object addUser(HttpServletRequest request,@RequestParam String email,@RequestParam String pwd){
        ReplyBox replyBox = userService.addUser(email,pwd);
        if("0".equals(replyBox.getRtCode())){
            request.getSession().setAttribute("car",new ArrayList<GoodsBean>());
            setSessionUser(request,replyBox);
        }
        return replyBox;
    }
    @RequestMapping("/addInfo")
    public Object addInfo(HttpServletRequest request,@RequestParam String uname,@RequestParam String address,@RequestParam String phone){
        InformationBean informationBean = new InformationBean();
        informationBean.setAddress(address);
        informationBean.setUname(uname);
        informationBean.setPhone(phone);
        return informationService.save(informationBean);
    }
    @RequestMapping("/findInfo")
    public Object findInfo(HttpServletRequest request){
        Integer uid = getSessionUser(request).getId();
        return informationService.getInformation(uid);
    }
    @RequestMapping("/getTitle")
    public Object getTitle(HttpServletRequest request){
        TitleBox titleBox = new TitleBox();
        UserBean userBean = getSessionUser(request);
        if(userBean == null){
            titleBox.setuName("");
        }else {
            titleBox.setuName(userBean.getEmail());
        }
        titleBox.setOnlineNum(OnlineCount.onlineNum);
        return titleBox;
    }
    public UserBean getSessionUser(HttpServletRequest request){
       return (UserBean) request.getSession().getAttribute("u");
    }
    public void setSessionUser(HttpServletRequest request,ReplyBox replyBox){
        request.getSession().setAttribute("u",replyBox.getData());
    }
}
