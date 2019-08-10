package com.damo.bootmall.serlvet;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class CustomListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("context initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("context destroyed");
    }
}
