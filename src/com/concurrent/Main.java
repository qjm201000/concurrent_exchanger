package com.concurrent;

import java.util.concurrent.Exchanger;

public class Main {
    public static void main(String[] args) {
        //交换机
        Exchanger exchanger = new Exchanger();

        ExchangerRunnable exchangerRunnable = new ExchangerRunnable(exchanger,"aa",3);
        ExchangerRunnable exchangerRunnable1 = new ExchangerRunnable(exchanger,"bb",10);

        new Thread(exchangerRunnable).start();
        new Thread(exchangerRunnable1).start();
    }
}
