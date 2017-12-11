package com.example.util;

/**
 * Created by NewDarker on 2017/11/30.
 */
public class ReplyBox {
   private String rtCode;
   private String rtMsg;
   private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getRtMsg() {
        return rtMsg;
    }

    public void setRtMsg(String rtMsg) {
        this.rtMsg = rtMsg;
    }

    public String getRtCode() {

        return rtCode;
    }

    public void setRtCode(String rtCode) {
        this.rtCode = rtCode;
    }
}
