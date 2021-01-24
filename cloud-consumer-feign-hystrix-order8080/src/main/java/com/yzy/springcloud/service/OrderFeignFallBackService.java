package com.yzy.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class OrderFeignFallBackService implements OrderFeignService{

    @Override
    public String paymentInfo_OK(Integer id) {
        return "---------PaymentFallBackService fall back-paymentInfo_OK.,,";
    }
    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "---------PaymentFallBackService fall back-paymentInfo_TimeOut.,,";
    }

}
