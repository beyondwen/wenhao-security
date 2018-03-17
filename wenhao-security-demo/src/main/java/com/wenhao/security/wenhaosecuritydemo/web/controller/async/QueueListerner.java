package com.wenhao.security.wenhaosecuritydemo.web.controller.async;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class QueueListerner implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private MokQueue mokQueue;

    @Autowired
    private DeferreadResultHolder deferreadResultHolder;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        new Thread(() -> {
            while (true) {
                if (StringUtils.isNoneBlank(mokQueue.getComplterder())) {
                    String orderNum = mokQueue.getComplterder();
                    logger.info("返回订单处理结果", orderNum);
                    deferreadResultHolder.getMap().get(orderNum).setResult("place order sucess");
                    mokQueue.setComplterder(null);
                } else {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
