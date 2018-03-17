package com.wenhao.security.wenhaosecuritydemo.web.controller.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MokQueue {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private String placeOrder;

    private String complterder;


    public String getPlaceOrder() {
        return placeOrder;
    }

    public void setPlaceOrder(String placeOrder){

        new Thread(() ->{
            try {
                logger.info("接到下单请求" + placeOrder);
                Thread.sleep(1000);
                this.complterder = placeOrder;
                logger.info("下单请求处理完毕" + placeOrder);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public String getComplterder() {
        return complterder;
    }

    public void setComplterder(String complterder) {
        this.complterder = complterder;
    }
}
