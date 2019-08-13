package com.lsx;

import com.lsx.impl.ProducerImpl;

public class Consumer {

    private ProducerImpl producer;

    public void setProducer(ProducerImpl producer) {
        this.producer = producer;
    }

    public  void buy(Float money ) {
        producer.sale(money);
    }
}
