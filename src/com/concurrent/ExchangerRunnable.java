package com.concurrent;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class ExchangerRunnable implements Runnable{
    private Exchanger<String> exchanger;
    private String data;
    private int random;
    public ExchangerRunnable(Exchanger exchanger,String data,int random){
        this.exchanger = exchanger;
        this.data = data;
        this.random = random;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+",数据："+data);
        try {
            TimeUnit.SECONDS.sleep(random);
            String data_new = exchanger.exchange(data);
            System.out.println(Thread.currentThread().getName()+",数据："+data_new);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
