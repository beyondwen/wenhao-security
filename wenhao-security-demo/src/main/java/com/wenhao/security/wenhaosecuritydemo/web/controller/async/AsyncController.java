package com.wenhao.security.wenhaosecuritydemo.web.controller.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;


@RestController
public class AsyncController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MokQueue mokQueue;

    @Autowired
    private DeferreadResultHolder deferreadResultHolder;

    @RequestMapping("/order")
    public DeferredResult<String> order() throws Exception {
        logger.info("主线程开始");
        String orderNumber = UUIDUtils.getUUID();
        mokQueue.setPlaceOrder(orderNumber);

        DeferredResult<String> deferreadResult = new DeferredResult<>();
        deferreadResultHolder.getMap().put(orderNumber,deferreadResult);

        /*Callable<String> result = new Callable<String>() {
            @Override
            public String call() throws Exception {
                logger.info("副线程开始");
                Thread.sleep(1000);
                logger.info("副线程返回");
                return "success";
            }
        };*/
        logger.info("主线程返回");
        return deferreadResult;
    }
}
