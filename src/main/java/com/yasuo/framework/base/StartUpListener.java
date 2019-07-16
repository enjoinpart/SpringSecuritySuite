package com.yasuo.framework.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author ：liming
 * @date ：2019/7/16 13:23
 * @description：
 */

@WebListener
@Slf4j
public class StartUpListener implements ServletContextListener {

    @Value("${spring.profiles.active}")
    private String name;

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        log.info("======当前环境为=======:" + name);
        System.out.println("======当前环境为=======:" + name);
        System.out.println("======当前环境为=======:" + name);
        System.out.println("======当前环境为=======:" + name);
        System.out.println("======当前环境为=======:" + name);
        System.out.println("======当前环境为=======:" + name);
        System.out.println("======当前环境为=======:" + name);

    }
}
