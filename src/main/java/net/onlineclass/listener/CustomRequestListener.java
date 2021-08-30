package net.onlineclass.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class CustomRequestListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("Request Listener Init -------------");
//        ServletRequestListener.super.requestInitialized(sre);
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("Request Destroyed Init -------------");
//        ServletRequestListener.super.requestDestroyed(sre);
    }
}
