package com.lsx.impl;

import com.lsx.IProducer;

public class ProducerImpl  {
    public void sale(Float price) {
        System.out.println("卖出产品，拿到钱 " + price.toString());
    }

    public void afterSale(Float price) {
        System.out.println("提供售后，收到钱 " + price.toString());
    }
}
