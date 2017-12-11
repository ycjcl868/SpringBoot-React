package com.example.util;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
public class OnlineCount implements HttpSessionListener {
    public static volatile Integer onlineNum = 0;
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        onlineNum += 1;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        onlineNum -= 1;
    }
}
